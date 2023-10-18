package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class json_reader {
   public String firstname,lastname,email,password;

    public void Json_reader() throws IOException, ParseException {
        String userDir = System.getProperty("user.dir");
        String csv_file_path = userDir + "\\src\\main\\java\\data\\Userdata.json";
        File src=new File(csv_file_path);

        JSONParser jsonParser=new JSONParser();
        JSONArray jsonArray= (JSONArray) jsonParser.parse(new FileReader(src));

        for(Object jsonobject :jsonArray)
        {
            JSONObject person= (JSONObject) jsonobject;
            firstname= (String) person.get("firstname");
            lastname= (String) person.get("lastname");
            email= (String) person.get("email");
            password= (String) person.get("password");
        }
    }
}
