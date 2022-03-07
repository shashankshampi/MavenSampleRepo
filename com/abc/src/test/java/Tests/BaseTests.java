package Tests;

import com.example.Service.ServiceHelper;
import com.example.Utils.ApiRequest;
import com.example.Utils.CommonHelpers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import validator.ResponseValidator;

public class BaseTests {

    protected SoftAssert softAssert;
    protected ApiRequest apiRequest;
    protected ResponseValidator responseValidator;
    protected CommonHelpers commonHelpers;
    protected ServiceHelper serviceHelper;

    @BeforeMethod
    public void intiBefore(){
         softAssert = new SoftAssert();
         apiRequest = new ApiRequest();
    }

    @BeforeSuite
    public void initSuits(){
        responseValidator = new ResponseValidator();
        commonHelpers = new CommonHelpers();
        serviceHelper = new ServiceHelper();
    }
}
