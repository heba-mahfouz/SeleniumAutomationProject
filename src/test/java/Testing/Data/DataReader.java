package Testing.Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

//Read jason to string
public class DataReader {

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        System.out.println("File Path: " + filePath);
        File file = new File(filePath);
        String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
    }

}
