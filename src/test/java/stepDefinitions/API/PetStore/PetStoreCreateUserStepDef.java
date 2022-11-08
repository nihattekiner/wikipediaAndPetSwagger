package stepDefinitions.API.PetStore;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.petStoreSwagger.createUser.PetStoreCreateUserPojo;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;

public class PetStoreCreateUserStepDef {

    PetStoreStepDef petStoreStepDef = new PetStoreStepDef();

    Response response;

    @When("user creates a user named {string}")
    public void userCreatesAUserNamed(String userName) {
        petStoreStepDef.connectedToURL();
        PetStoreCreateUserPojo createUserPojo = new PetStoreCreateUserPojo(
                Integer.parseInt(ConfigurationReader.getProperty("PET_STORE_CREATE_USER_RESPONSE_BODY_ID")),
                userName,
                ConfigurationReader.getProperty("PET_STORE_CREATE_USER_RESPONSE_BODY_FIRSTNAME"),
                ConfigurationReader.getProperty("PET_STORE_CREATE_USER_RESPONSE_BODY_LASTNAME"),
                ConfigurationReader.getProperty("PET_STORE_CREATE_USER_RESPONSE_BODY_EMAIL"),
                ConfigurationReader.getProperty("PET_STORE_CREATE_USER_RESPONSE_BODY_PASSWORD"),
                ConfigurationReader.getProperty("PET_STORE_CREATE_USER_RESPONSE_BODY_PHONE"),
                Integer.parseInt(ConfigurationReader.getProperty("PET_STORE_CREATE_USER_RESPONSE_BODY_USERSTATUS"))
        );

                response = given().
                        contentType(ContentType.JSON).
                        spec(petStoreStepDef.spec).
                        given().log().all().
                        body(createUserPojo).
                        post(ConfigurationReader.getProperty("PET_STORE_CREATE_USER_PATH"));

                response.prettyPrint();
    }

    @Then("verify that user {string} has been created")
    public void verifyThatUserHasBeenCreated(String userName) {
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(ConfigurationReader.getProperty("PET_STORE_CREATE_USER_RESPONSE_BODY_ID"),
                jsonPath.getString("message"));
        Assert.assertEquals(200,jsonPath.getInt("code"));
    }
}
