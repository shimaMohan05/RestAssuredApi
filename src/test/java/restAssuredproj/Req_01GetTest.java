package restAssuredproj;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Req_01GetTest {
/*  @Test
  public void toGetReq() {//this s old technique
	  //https://reqres.in/api/users/2
	 Response res= RestAssured.get("https://reqres.in/api/users/2");
	System.out.println("status code is "+res.statusCode()); 
	Assert.assertEquals(res.statusCode(), 200,"Fail: if status code is not matching");
	String id=res.sessionId();
	System.out.println("session id is "+id);//it is null because we used dummy api
	System.out.println("test passed");
	String statusLine = res.statusLine();
	System.out.println("Status line is: "+statusLine);
	 
  }*/
	 @Test(priority =1,enabled=false)
	  public void toGetReq()
	  {
		 given()
		 .when().get("https://reqres.in/api/users/2")
		 .then()
		 .statusCode(200)
		 .log().body();
	  }
	 @Test(priority =2,enabled=false)
	  public void toGetReqforList()
	  {
		 given()

	  .when().get("https://reqres.in/api/users?page=2")
	  .then()
	  .statusCode(200)
	  .body("data.id[1]", equalTo(8))
	  .body("data.first_name[5]",equalTo("Rachel"))
	  .log().body();
		  }
			
	//hasItem(),contains() 
	 @Test(priority =2)
	  public void toGetReqforListMethods()
	  {
		 given()

	  .when().get("https://reqres.in/api/users?page=2")
	  .then()
	  .statusCode(200)
	  //.body("data.id",hasItems(7,8,9,10,11,12))//it will pass
	 // .body("data.id",hasItems(7,8,9,11,12,10))//it will also pass order is not a factor//contains will fail.
	  .body("data.id",hasItems(7,8,9))//it will pass all elements not mandatory//contains will fail
	  //.body("data.id",hasItems(7,8,9,14,15,16))//fail due to some ids are not original//contains will fail
	  .body("data.id",contains(7,8,9,10,11,12));//pass
		 
	  
	  
		  }
	 
	
}

