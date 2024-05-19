package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class NoOfEmployee {

    public HashMap<String,Integer> countOfEmployee(JsonArray employeesArray)
    {

        HashMap<String,Integer> departmentCount = new HashMap<>();
        for (JsonElement element : employeesArray) {
            JsonObject employee = element.getAsJsonObject();
            String department = employee.get("department").getAsString();
            if(departmentCount.containsKey(department))
            {
                departmentCount.put(department,departmentCount.get(department)+1);
            }
            else {
                departmentCount.put(department,1);}
        }

//        for(Map.Entry<String, Integer> entry: departmentCount.entrySet())
//        {
//            System.out.println("Department:" + entry.getKey() + ":" +entry.getValue());
//        }

        return departmentCount;

    }
}
