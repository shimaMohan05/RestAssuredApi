package restAssuredAssignmentproj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class NewUserPostTest {
  @Test(priority=1)
  public void toAddNewUserHashMap() 
  {
	  HashMap<String,Object>map=new HashMap<>();
  map.put("name","Shima Mohan");
  map.put("job", "QA");
  given()
  .contentType("application/json")
  .body(map)
  .when()
  .post("https://reqres.in/api/users")
  .then()
  .statusCode(201)
  .log().body().log().status();
	  }
  @Test(priority=1)
  public void toAddNewUserPojo() 
  {
	 PojoDemo p=new PojoDemo();
	 p.setName("Vinod");
	 p.setJob("TestEngineer");
  given()
  .contentType("application/json")
  .body(p)
  .when()
  .post("https://reqres.in/api/users")
  .then()
  .statusCode(201)
  .log().body().log().status();
	  }

}

