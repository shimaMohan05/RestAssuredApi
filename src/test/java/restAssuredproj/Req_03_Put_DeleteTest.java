package restAssuredproj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Req_03_Put_DeleteTest {
  @Test(priority=1)
  public void toPutReq() {
	  PojoDemo p=new PojoDemo();
	  p.setName("Sandya");
	  p.setJob("qc");
	  given()
	  .contentType("application/json")
	  .body(p)
	  .when()
	  .put("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
	  .log().body();
  }
  @Test(priority=2)
  public void toPatchReq() {
	  PojoDemo p=new PojoDemo();
	  p.setName("Sandeep");
	  p.setJob(null);
	  given()
	  .contentType("application/json")
	  .body(p)
	  .when()
	  .put("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
	  .log().body();
  }
  @Test(priority=3)
  public void toDeleteReq() {
	  given ()
.when()
.delete("https://reqres.in/api/users/2")
.then()
.statusCode(204);}
}
