package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class JsonToArray {

    String[] namesArray;
    public Integer[] agesArray;
    String[] departmentsArray;
    public Integer[] salariesArray;
    public JsonArray employeesArray;
    public void jsonExtract(String jsonString  ) {

        // Parse JSON string to JsonObject
        JsonObject jsonObject = new Gson().fromJson(jsonString, JsonObject.class);

        // Extract employees array
        employeesArray = jsonObject.getAsJsonArray("employees");

        // Extracting values into arrays
        List<String> namesList = new ArrayList<>();
        List<Integer> agesList = new ArrayList<>();
        List<String> departmentsList = new ArrayList<>();
        List<Integer> salariesList = new ArrayList<>();

        for (JsonElement element : employeesArray) {
            JsonObject employee = element.getAsJsonObject();
            namesList.add(employee.get("name").getAsString());
            agesList.add(employee.get("age").getAsInt());
            departmentsList.add(employee.get("department").getAsString());
            salariesList.add(employee.get("salary").getAsInt());
        }

        // Convert lists to arrays
        namesArray = namesList.toArray(new String[0]);
        agesArray = agesList.toArray(new Integer[0]);
        departmentsArray = departmentsList.toArray(new String[0]);
        salariesArray = salariesList.toArray(new Integer[0]);

    }
}
