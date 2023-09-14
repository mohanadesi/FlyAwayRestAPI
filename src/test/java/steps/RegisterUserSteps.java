package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
//import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class RegisterUserSteps {

    private Response response;
    private Map<String, List<String>> userDetails;

    @Given("a user with the following registration details")
    public void aUserWithTheFollowingRegistrationDetails(Map<String, List<String>> userData) {
        userDetails = userData;
        System.out.println(userDetails);
    }

    @When("I send a POST request to the registration endpoint")
    public void iSendAPostRequestToTheRegistrationEndpoint() {
        String registrationEndpoint = "http://localhost:8081/FlyAway/signupaction?"; // Replace with your API endpoint
        response = RestAssured
            .given()
            .contentType(ContentType.JSON)
            .body(userDetails)
            .when()
            .post(registrationEndpoint);
        System.out.println("posting successful");
    }

    @Then("the registration should be successful")
    public void theRegistrationShouldBeSuccessful() {
        Assert.assertEquals(201, response.getStatusCode()); // Adjust the expected status code if needed
    }

    @Then("the response should contain the user details")
    public void theResponseShouldContainTheUserDetails() {
    	String responseBody = response.getBody().asString();

        // Iterate through the list of strings and check if each one is contained in the response body
        for (List<String> values : userDetails.values()) {
            for (String value : values) {
                Assert.assertTrue(responseBody.contains(value));
    }
}
    }
    }
