package restAssuredproj;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import io.restassured.mapper.ObjectMapper;

public class Searilization_deserialization_Test {
  
  
  @Test(priority=1)
  public void searilizationTest() throws JsonProcessingException {
	  PojoDemo p=new PojoDemo();
	  p.setName("jay");
	  p.setJob("QA");
	  ObjectMapper om=new ObjectMapper();
	  String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(p);
	  System.out.println(json);
	  
  }
  @Test(priority=2)
  public void desearilizationTest() throws JsonMappingException, JsonProcessingException {
	  String Json="{\n"
	  		+ "  \"name\" : \"jay\",\n"
	  		+ "  \"job\" : \"QA\"\n"
	  		+ "}";
	  ObjectMapper om=new ObjectMapper();
	  PojoDemo p1 = om.readValue(Json,PojoDemo.class );
	  System.out.println(p1.getName()+ " : "+ p1.getJob());
  }
}
