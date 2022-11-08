package stepDefinitions.API.PetStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.petStoreSwagger.updateUser.PetStoreUpdateUserPojo;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;

public class PetStoreUpdateUserStepDef {

    PetStoreStepDef petStoreStepDef = new PetStoreStepDef();

    Response response;

    @When("user updates his user name {string} and his id {string}")
    public void userUpdatesHisUserNameAndHisId(String userName, String id) {
        petStoreStepDef.connectedToURL();

        PetStoreUpdateUserPojo petStoreUpdateUserPojo = new PetStoreUpdateUserPojo(
                Integer.parseInt(id),
                userName,
                ConfigurationReader.getProperty("PET_STORE_UPDATE_USER_RESPONSE_BODY_LASTNAME"),
                ConfigurationReader.getProperty("PET_STORE_UPDATE_USER_RESPONSE_BODY_LASTNAME"),
                ConfigurationReader.getProperty("PET_STORE_UPDATE_USER_RESPONSE_BODY_EMAIL"),
                ConfigurationReader.getProperty("PET_STORE_UPDATE_USER_RESPONSE_BODY_PASSWORD"),
                ConfigurationReader.getProperty("PET_STORE_UPDATE_USER_RESPONSE_BODY_PHONE"),
                Integer.parseInt(ConfigurationReader.getProperty("PET_STORE_UPDATE_USER_RESPONSE_BODY_USERSTATUS"))
        );

        response = given().
                contentType(ContentType.JSON).
                spec(petStoreStepDef.spec).
                given().log().all().
                body(petStoreUpdateUserPojo).
                put(ConfigurationReader.getProperty("PET_STORE_CREATE_USER_PATH") +
                        ConfigurationReader.getProperty("PET_STORE_UPDATE_USER_PATH_QUERYPARAM_ID"));

        response.prettyPrint();
    }

    @And("verify that the response message is {string}")
    public void verifyThatTheResponseMessageIs(String id) {
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(id, jsonPath.getString("message"));
        Assert.assertEquals(200, response.getStatusCode());
    }
}
