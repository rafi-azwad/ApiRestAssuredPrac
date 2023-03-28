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
import repository.remoteRepo.requestRepo.UserPutRequestModelClass;
import repository.remoteRepo.responseRepo.PutUserApiResponseModel;

import static Core.CoreConstrainHelper.base_url;
import static Core.FilePathHelper.putApiPath;

public class PutApiStepDefs {
    String url;

    UserPutRequestModelClass userPutRequestModelClass;

    private Gson gson = new Gson();

    private String requestModel;

    Response putApiResponse;

    @Given("user got the api {string}")
    public void userGotTheApiPath(String path) {
        url = base_url + path;
    }

    @When("user hits {string}")
    public void userHitsJob(String job) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(putApiPath);
        userPutRequestModelClass = new Gson().fromJson(requestBody.toJSONString(), UserPutRequestModelClass.class);
        userPutRequestModelClass.getJob(job);
        requestModel = gson.toJson(userPutRequestModelClass);
    }

    @And("calls the api with changed body")
    public void callsTheApiWithChangedBody() {
        putApiResponse = ApiCall.putCall(HeaderFormatHelper.commonHeaders(), requestModel, url);
        System.out.println(putApiResponse.body().asString());
    }

    @Then("it will return updated data")
    public void itWillReturnUpdatedData() {
        PutUserApiResponseModel putUserApiResponseModel = gson.fromJson(putApiResponse.getBody().asString(), PutUserApiResponseModel.class);
        System.out.println(putUserApiResponseModel.getUpdatedAt());
    }
}
