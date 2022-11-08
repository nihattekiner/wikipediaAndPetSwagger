package stepDefinitions.API.PetStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.petStoreSwagger.addPet.PetStoreAddPetCategoryPojo;
import pojos.petStoreSwagger.addPet.PetStoreAddPetPojo;
import pojos.petStoreSwagger.addPet.PetStoreAddPetTagsPojo;
import utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetStoreAddPetStepDef {

    PetStoreStepDef petStoreStepDef = new PetStoreStepDef(); // For URL

    List<String> photoUrlsList = new ArrayList<>(); // For response body

    List<PetStoreAddPetTagsPojo> addPetTagsList = new ArrayList<>(); // For response body

    Response response;

    @When("user posts pet {string}")
    public void userPostsPet(String petName) {
        petStoreStepDef.connectedToURL();

        PetStoreAddPetTagsPojo addPet_tagsPojo = new PetStoreAddPetTagsPojo(16161,"id16161");
        addPetTagsList.add(addPet_tagsPojo);

        PetStoreAddPetCategoryPojo addPet_categoryPojo = new PetStoreAddPetCategoryPojo(17171,"id17171");

        photoUrlsList.add("photoUrl1");
        photoUrlsList.add("photoUrl2");
        photoUrlsList.add("PhotoUrl3");

        PetStoreAddPetPojo petStoreAddPetPojo = new PetStoreAddPetPojo(
                Integer.parseInt(ConfigurationReader.getProperty("PET_STORE_ADD_PET_REQUEST_BODY_ID")),
                addPet_categoryPojo,
                petName,
                photoUrlsList,
                addPetTagsList,
                "statusActive"
        );

        response = given().
                contentType(ContentType.JSON).
                spec(petStoreStepDef.spec).
                given().log().all().
                body(petStoreAddPetPojo).
                post(ConfigurationReader.getProperty("PET_STORE_ADD_PET_PATH"));

        response.prettyPrint();
    }

    @Then("verify that pet {string} has been created")
    public void verifyThatPetHasBeenCreated(String petName) {
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(petName,jsonPath.getString("name"));
    }
}
