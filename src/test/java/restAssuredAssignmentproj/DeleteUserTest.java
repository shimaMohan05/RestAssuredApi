package restAssuredAssignmentproj;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class DeleteUserTest {
  @Test
  public void toDeleteUser() {
	  given()
	  .when()
	  .delete("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(204).log().status();
	  
  }
}
