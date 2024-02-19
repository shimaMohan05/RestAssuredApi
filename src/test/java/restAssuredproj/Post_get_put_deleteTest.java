package restAssuredproj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Post_get_put_deleteTest {
	String id;
  @Test(priority=1)
  public void createUser() {
	  PojoDemo p=new PojoDemo();
	  p.setName("Arun");
	  p.setJob("techlead");
	   id=  given()
	  .contentType("application/json")
	  .body(p)
	  .when().post("https://reqres.in/api/users")
	  .jsonPath().get("id");
	  
	System.out.println("created id is: "+id);
	  
	  
  }
  @Test(priority=2)
  public void getUser() {
	  given()
	  .when()
	  .get("https://reqres.in/api/users/"+id)
	  .then()
	  .log().body();
	  //.statusCode(200);
	  System.out.println("get id is: "+id);
	  
  }
  @Test(priority=3)
  public void updateUser() {
	  PojoDemo p=new PojoDemo();
	  p.setName("Varun");
	  p.setJob("testlead");
	   given()
	  .contentType("application/json")
	  .body(p)
	  .when().post("https://reqres.in/api/users/"+id)
	  .then()
	  .log().body();
	 System.out.println("updated id is : " +id);
  }
  @Test(priority=4)
  public void deleteUser() {
	  
	  given()
	  .when()
	  .delete("https://reqres.in/api/users/"+id)
	  .then()
	  .statusCode(204);
	  System.out.println("deleted user id : "+id);
  }
}
