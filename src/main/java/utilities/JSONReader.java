package utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReader {

	public Map<String, String> getJsonData(String jsonFileName, String tcName){
		
		Map<String, String> map = new HashMap<String, String>();
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Map<String, String>> data = mapper.readValue(new File("./src/test/java/data/"+jsonFileName+".json"), 
					new TypeReference<Map<String, Map<String, String>>>() {
			});
			map = data.get(tcName);
			System.out.println(map);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	
}
