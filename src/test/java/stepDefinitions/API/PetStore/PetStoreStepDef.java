package stepDefinitions.API.PetStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigurationReader;

public class PetStoreStepDef {

    RequestSpecification spec;

    @Given("Connected to URL")
    public void connectedToURL() {
        spec = new RequestSpecBuilder().setBaseUri
                (ConfigurationReader.getProperty("PET_STORE_SWAGGER_URL")).build();
    }
}
