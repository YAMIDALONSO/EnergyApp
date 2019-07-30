package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import models.HouseApplianceConstant;
import models.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static views.WindowEnergySaver.TITLE;

public class JSONManager {

    private static final File USERS_FILE = new File("./files/JSONUsers.json");

    private static final String USERS = "users";
    private static final String NAME = "nombre";
    private static final String PASSWORD = "contraseña";
    private static final String HOUSEAPPLIANCE = "houseappliance";
    private static final String HOUSE_APPLIANCE_NAME = "houseapplianceName";

    public ArrayList<User> readUserList() throws FileNotFoundException, IOException, ParseException {
        ArrayList<User> userList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(USERS_FILE));
        JSONObject energySaver = (JSONObject) root.get(TITLE);
        JSONArray users = (JSONArray) energySaver.get(USERS);
        for (int i = 0; i < users.size(); i++) {
            JSONObject user = (JSONObject) users.get(i);
            JSONArray device = (JSONArray) user.get(HOUSEAPPLIANCE);
            userList.add(new User((String) user.get(NAME), (String) user.get(PASSWORD), getAvailableIn(device)));
        }
        return userList;
    }

    private ArrayList<HouseApplianceConstant> getAvailableIn(JSONArray device) {
        ArrayList<HouseApplianceConstant> availableIn = new ArrayList<>();
        for (int i = 0; i < device.size(); i++) {
            JSONObject available = (JSONObject) device.get(i);
            availableIn.add((HouseApplianceConstant.valueOf((String) available.get(HOUSE_APPLIANCE_NAME))));
        }
        return availableIn;
    }

    private LocalDate getDate(String date) {
        return LocalDate.parse(date);
    }

    public void writeJson(ArrayList<User> users) throws FileNotFoundException, IOException {
        JSONObject root = new JSONObject();
        JSONObject energy = new JSONObject();
        JSONArray userList = new JSONArray();
        for (User u : users) {
            JSONObject user = new JSONObject();
            user.put(NAME, u.getName());
            user.put(PASSWORD, u.getPassword());
            JSONArray electrodomestics = new JSONArray();
            for (HouseApplianceConstant dt : u.getHouseAppliances()) {
                JSONObject houseAppliance = new JSONObject();
                houseAppliance.put(HOUSE_APPLIANCE_NAME, dt.toString());
                electrodomestics.add(houseAppliance);
            }
            user.put(HOUSEAPPLIANCE, electrodomestics);
            userList.add(user);
        }

        energy.put(USERS, userList);
        root.put(TITLE, energy);

        FileWriter outputStream = new FileWriter(USERS_FILE);
        outputStream.write(root.toJSONString());
        outputStream.close();

    }
}
