package stepDefinitions.API.PetStore;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.json.Json;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;

public class PetStoreGetStepDef {

    PetStoreStepDef petStoreStepDef = new PetStoreStepDef();

    Response response;

    @When("user gets pet {string}")
    public void userGetsPet(String petName) {
        petStoreStepDef.connectedToURL();

        response = given().
                contentType(ContentType.JSON).
                spec(petStoreStepDef.spec).
                given().log().all().
                get(ConfigurationReader.getProperty("PET_STORE_GET_PET_PATH")+
                        ConfigurationReader.getProperty("PET_STORE_GET_PET_QUERYPARAM_ID"));

        response.prettyPrint();
    }

    @Then("verify that pet {string} has been gotten")
    public void verifyThatPetHasBeenGotten(String petName) {
        JsonPath json = response.jsonPath();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(petName,json.getString("name"));
    }
}
