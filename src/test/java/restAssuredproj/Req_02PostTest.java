package restAssuredproj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Req_02PostTest {
  @Test(priority =1)
  public void toPostReqHashMap() {
	  //request payload
	  HashMap<String,Object>map=new HashMap<String,Object>();
	  map.put("name","shima");
	  map.put("job", "qa");
	  
	  given()
	  .contentType("application/json")
	  .body(map)
	  .when().post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201)
	  .log().body();
  }

@Test(priority=2)
public void toPostReqPojo() {
	  PojoDemo p=new PojoDemo();
	   p.setName("Jyothi");
	   p.setJob("Test Engineer");
	  
	  given()
	  .contentType("application/json")
	  .body(p)
	  .when().post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201)
	  .log().body();
}
}