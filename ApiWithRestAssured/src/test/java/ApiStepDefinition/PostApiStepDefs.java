package ApiStepDefinition;

import Core.ApiCall;
import Core.FileHandleHelper;
import Core.HeaderFormatHelper;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import repository.remoteRepo.requestRepo.UserPostRequestModelClass;
import repository.remoteRepo.responseRepo.CreatedUserApiPostResponseModel;


import static Core.CoreConstrainHelper.base_url;
import static Core.FilePathHelper.postApiPath;

public class PostApiStepDefs {

    String url;

    private String requestModel;

    private final Gson gson = new Gson();

    Response userPostApiResponse;

    UserPostRequestModelClass userPostRequestModelClass;

    @Given("user has the api {string}")
    public void userHasTheApiPath(String path) {
        url = base_url + path;
    }

    @When("user hits {string} and {string}")
    public void userHitsNameAndJob(String name, String job) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(postApiPath);
        userPostRequestModelClass = new Gson().fromJson(requestBody.toJSONString(), UserPostRequestModelClass.class);
        userPostRequestModelClass.setName(name);
        userPostRequestModelClass.setJob(job);
        requestModel = gson.toJson(userPostRequestModelClass);
    }

    @And("calls the api with body")
    public void callsTheApiWithBody() {
        userPostApiResponse = ApiCall.postCall(HeaderFormatHelper.commonHeaders(), requestModel, url);
        System.out.println(userPostApiResponse.body().asString());
    }

    @Then("it will return created data")
    public void itWillReturnCreatedData() {
        CreatedUserApiPostResponseModel createdUserApiPostResponseModel = gson.fromJson(userPostApiResponse.getBody().asString(), CreatedUserApiPostResponseModel.class);
        System.out.println(createdUserApiPostResponseModel.getCreatedAt());

    }
}
