package fileLoader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// Use the Jackson library to deserialize the JSON files in this class
public class Loader {

	// Load the board data from the JSON file into a list of map
	public static List<Map<String, Object>> loadBoard(String filepath) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.readValue(new File(filepath), new TypeReference<List<Map<String, Object>>>() {
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Load the rolls data from the JSON file into a list of integers
	public static List<Integer> loadRolls(String filepath) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.readValue(new File(filepath), new TypeReference<List<Integer>>() {
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
