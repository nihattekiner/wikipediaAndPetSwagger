package stepDefinitions.API.PetStore;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;

public class PetStoreDeletePetStepDef {

    PetStoreStepDef petStoreStepDef = new PetStoreStepDef();

    Response response;

    @When("user deletes pet {string}")
    public void userDeletesPet(String petName) {
        petStoreStepDef.connectedToURL();

        response = given().
                contentType(ContentType.JSON).
                spec(petStoreStepDef.spec).
                given().log().all().
                delete(ConfigurationReader.getProperty("PET_STORE_DELETE_PET_PATH")+
                        ConfigurationReader.getProperty("PET_STORE_DELETE_PET_QUERYPARAM_ID"));

        response.prettyPrint();
    }

    @Then("verify that pet {string} has been deleted")
    public void verifyThatPetHasBeenDeleted(String petName) {
        Assert.assertEquals(200,response.getStatusCode());
    }
}

