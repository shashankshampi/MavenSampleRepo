package Tests;

import com.example.Service.Constants;
import com.example.Service.pojo.response.userDetailResponse.GetUserDetailListResponse;
import com.example.Utils.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.logging.Logger;

/**
 * @author shashank.sanket
 * SAMPLE CODE FOR TEST
 */


public class TestUserDetails extends BaseTests {

    private static final Logger logger = Logger.getLogger(TestUserDetails.class.getName());

    @Test(groups = {"regression"}, description = "Test to validate set of user comments")
    public void T1() {
        String userId;
        apiRequest.setup(Constants.url);
        Response response = apiRequest.getRequest(Constants.GET_USER_LIST_URI, serviceHelper.createHeader(Constants.INITIAL_CONSTANT_USER));

        if (response.getStatusCode() == StatusCode.OK.getStatus()) {
            GetUserDetailListResponse getUserDetailListResponse = response.as(GetUserDetailListResponse.class);

            for (int i = 0; i < getUserDetailListResponse.getData().size(); i++) {
                userId = getUserDetailListResponse.getData().get(i).getId();
                logger.info("Test for UserId: " + userId);
                Response UserPostsDetailsResponse = apiRequest.getRequest(commonHelpers.getUriParsed(Constants.GET_USER_POSTS_URI, userId), serviceHelper.createHeader(Constants.INITIAL_CONSTANT_USER));
                if (UserPostsDetailsResponse.getStatusCode() == StatusCode.OK.getStatus()) {
                    responseValidator.validateUserDetails(UserPostsDetailsResponse, getUserDetailListResponse.getData().get(i), softAssert);
                } else {
                    softAssert.fail("Expected status code was not found");
                }
            }
        } else {
            softAssert.fail("Expected status code was not found");
        }

        softAssert.assertAll();

    }

}

