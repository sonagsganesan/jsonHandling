package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;

public class EmployeesName {

    public HashMap<String, List<String>> employeeNameList(JsonArray employeesArray)
    {

        HashMap<String,List<String>> departmentCount = new HashMap<>();
        for (JsonElement element : employeesArray) {
            JsonObject employee = element.getAsJsonObject();
            String department = employee.get("department").getAsString();
            String employeeName = employee.get("name").getAsString();
            if(departmentCount.containsKey(department))
            {
                departmentCount.get(department).add(employeeName);
            }
            else {
                List<String> name = new ArrayList<>();
                name.add(employeeName);
                departmentCount.put(department,name);
            }
        }

//        for(Map.Entry<String,List<String>> entry: departmentCount.entrySet())
//        {
//            System.out.println("Department: " + entry.getKey() + ", Employee Count: " + entry.getValue().size());
//            System.out.println("Department:" + entry.getKey() + ":" +entry.getValue().toString());
//        }

        return departmentCount;

    }
}
