import Utilities.TokenInitialise;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetCall {


@BeforeMethod
  public void beforeMethod(){
    RestAssured.baseURI = "https://restful-booker.herokuapp.com";
  }

  @Test(priority = 1)
  public void verifyGetBookingIds() {
    //RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    RequestSpecification requestSpecification = RestAssured.given();
    Response res = requestSpecification.get("/booking/");
    res.body().prettyPrint();
  }

  @Test(priority = 2)
  public void verifyGetBooking() {
    //RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    RequestSpecification requestSpecification = RestAssured.given();
    Response res = requestSpecification.get("/booking/1");
    res.body().prettyPrint();

  }

  @Test(priority = 3)

  public void verifyCreateBooking() {
  File reqjsonfile = new File("/Users/ashwajitthukral/AshwajitThukral/Tools/RestAssuredTests/src/test/resources/requestjson/CreateBooking.json");

    //RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    RequestSpecification requestSpecification = RestAssured.given();

    Response res = requestSpecification.contentType("application/json").body(reqjsonfile).headers(
        TokenInitialise.getAuth()).post("/booking");

    ResponseBody responseBody = res.body();
    int statusCode = res.statusCode();
    System.out.println(statusCode);
    responseBody.prettyPrint();
  }

  @Test(priority = 4)
  public void verifyUpdateBooking() {

   // RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    RequestSpecification requestSpecification = RestAssured.given();
    Response res = requestSpecification.body("{\n"
        + "    \"firstname\" : \"James\",\n"
        + "    \"lastname\" : \"Brown\",\n"
        + "    \"totalprice\" : 122,\n"
        + "    \"depositpaid\" : true,\n"
        + "    \"bookingdates\" : {\n"
        + "        \"checkin\" : \"2018-01-01\",\n"
        + "        \"checkout\" : \"2019-01-01\"\n"
        + "    },\n"
        + "    \"additionalneeds\" : \"Breakfast\"\n"
        + "}").contentType("application/json").headers(TokenInitialise.getAuth()).put("/booking/1");

    ResponseBody responseBody = res.body();
    int statuscode = res.statusCode();
    System.out.println(statuscode);
    res.body().prettyPrint();

  }

  @Test(priority = 5)
  public void verifyPartialUpdateBooking() {

    //RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    RequestSpecification requestSpecification = RestAssured.given();
    Response res = requestSpecification.body("{\n"
        + "    \"firstname\" : \"James\",\n"
        + "    \"lastname\" : \"Brown\"\n"
        + "}").headers(TokenInitialise.getAuth()).patch("/booking/1");

    ResponseBody responseBody = res.body();
    res.body().prettyPrint();

  }


  @Test(priority = 6)
  public void verifyDeleteBooking() {
    RestAssured.baseURI = "https://restful-booker.herokuapp.com";

    RequestSpecification requestSpecification = RestAssured.given();
    Response res = requestSpecification.headers(TokenInitialise.getAuth()).delete("/booking/1");

    int statusCode = res.statusCode();
    ResponseBody responseBody = res.body();
    System.out.println(statusCode);

  }

}

