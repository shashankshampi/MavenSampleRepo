package validator;

import com.example.Service.pojo.response.userDetailResponse.Datum;
import com.example.Service.pojo.response.userPostDetailsResponse.GetUserPostListResponse;
import com.example.Utils.StatusCode;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

public class ResponseValidator {
    private static final Logger logger = Logger.getLogger(ResponseValidator.class.getName());

    public void validateUserDetails(Response response, Datum getUserDetailList, SoftAssert softAssert){
        logger.info("validating user details aginst his posts..");
        softAssert.assertEquals(response.getStatusCode(), StatusCode.OK.getStatus());
        GetUserPostListResponse getUserPostListResponse = response.as(GetUserPostListResponse.class);

        for (int i = 0; i < getUserPostListResponse.getData().size(); i++) {

            softAssert.assertEquals(getUserPostListResponse.getData().get(i).getOwner().getId(),getUserDetailList.getId(),"Validating getId()");
            softAssert.assertEquals(getUserPostListResponse.getData().get(i).getOwner().getTitle(),getUserDetailList.getTitle(),"Validating getTitle()");
            softAssert.assertEquals(getUserPostListResponse.getData().get(i).getOwner().getFirstName(),getUserDetailList.getFirstName(),"Validating getFirstName()");
            softAssert.assertEquals(getUserPostListResponse.getData().get(i).getOwner().getLastName(),getUserDetailList.getLastName(),"Validating getLastName()");
            softAssert.assertEquals(getUserPostListResponse.getData().get(i).getOwner().getPicture(),getUserDetailList.getPicture(),"Validating getPicture()");
        }
    }
}
