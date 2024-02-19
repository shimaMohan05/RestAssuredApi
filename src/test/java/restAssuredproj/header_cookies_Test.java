package restAssuredproj;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class header_cookies_Test {
  @Test(priority=1)
  public void toGetHeader() {
	  given()
	  .when().get("https://www.google.com")
	  .then()
	  .log().headers()
	  .statusCode(200);
	  
  }
  @Test(priority=2)
  public void tocheckHeader() {
	 Response res = given()
	  .when().get("https://www.google.com");
	 String actHeader = res.getHeader("Content-Type");
	 Assert.assertEquals(actHeader, "text/html; charset=ISO-8859-1","failed");
	 System.out.println("exact header fetched");
	  
	  
	  
  }
  @Test(priority=3)
  public void toGetCookies() {
	 Response res = given()
	  .when().get("https://www.google.com");
	 Map<String, String> cookies = res.getCookies();
	 String cookie = res.getCookie("AEC");
	 Assert.assertFalse(cookie.contains("Ae3NU9NMx6p"));//.assertFalse(cookie,cookie.contains("Ae3NU9NMx6p"),"failed");
	 
	  
  }
}
