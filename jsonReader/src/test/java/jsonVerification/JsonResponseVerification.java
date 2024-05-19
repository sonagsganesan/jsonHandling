package jsonVerification;


import org.example.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonResponseVerification {

    JsonToArray jsonToArrayExample;
    CalculateAverageAge calculateAverageAge;
    CalculateHighestSalary calculateHighestSalary;
    NoOfEmployee noOfEmployee;
    EmployeesName employeesName;

    @BeforeClass
    public void before()
    {
        jsonToArrayExample = new JsonToArray();
        calculateAverageAge = new CalculateAverageAge();
        calculateHighestSalary = new CalculateHighestSalary();
        noOfEmployee = new NoOfEmployee();
        employeesName = new EmployeesName();
    }

    @Test(description = "Validate the Json response")
    public void validateCalculateAverageSalary()
    {
        // Sample JSON string
        String jsonString = "{\"employees\": [{\"name\": \"John Doe\",\"age\": 32,\"department\": \"Engineering\",\"salary\": 80000},{\"name\": \"Jane Smith\",\"age\": 27,\"department\": \"Engineering\",\"salary\": 65000},{\"name\": \"Michael Johnson\",\"age\": 45,\"department\": \"Sales\",\"salary\": 90000},{\"name\": \"Emily Davis\",\"age\": 29,\"department\": \"Engineering\",\"salary\": 75000},{\"name\": \"David Wilson\",\"age\": 38,\"department\": \"Marketing\",\"salary\": 72000},{\"name\": \"Sarah Thompson\",\"age\": 31,\"department\": \"Sales\",\"salary\": 85000}]}";
        jsonToArrayExample.jsonExtract(jsonString);
        DecimalFormat decfor = new DecimalFormat("0.00");
        double actualAverageAge = calculateAverageAge.averageAge(jsonToArrayExample.agesArray);
        System.out.println("Average Salary of the Employee: "+actualAverageAge);
        Assert.assertEquals(decfor.format(actualAverageAge),decfor.format(33.6666));
        System.out.println("============================================================");
    }

    @Test(description = "Validate the Json response")
    public void validateHighestSalary()
    {
        // Sample JSON string
        String jsonString = "{\"employees\": [{\"name\": \"John Doe\",\"age\": 32,\"department\": \"Engineering\",\"salary\": 80000},{\"name\": \"Jane Smith\",\"age\": 27,\"department\": \"Engineering\",\"salary\": 65000},{\"name\": \"Michael Johnson\",\"age\": 45,\"department\": \"Sales\",\"salary\": 90000},{\"name\": \"Emily Davis\",\"age\": 29,\"department\": \"Engineering\",\"salary\": 75000},{\"name\": \"David Wilson\",\"age\": 38,\"department\": \"Marketing\",\"salary\": 72000},{\"name\": \"Sarah Thompson\",\"age\": 31,\"department\": \"Sales\",\"salary\": 85000}]}";
        jsonToArrayExample.jsonExtract(jsonString);
        int highestSalary = calculateHighestSalary.highestSalary(jsonToArrayExample.salariesArray);
        System.out.println("Highest Salary of the Employee: "+highestSalary);
        Assert.assertEquals(highestSalary,90000);
        System.out.println("============================================================");
    }

    @Test(description = "Validate the Json response")
    public void validateNumberOfEmployee()
    {
        // Sample JSON string
        String jsonString = "{\"employees\": [{\"name\": \"John Doe\",\"age\": 32,\"department\": \"Engineering\",\"salary\": 80000},{\"name\": \"Jane Smith\",\"age\": 27,\"department\": \"Engineering\",\"salary\": 65000},{\"name\": \"Michael Johnson\",\"age\": 45,\"department\": \"Sales\",\"salary\": 90000},{\"name\": \"Emily Davis\",\"age\": 29,\"department\": \"Engineering\",\"salary\": 75000},{\"name\": \"David Wilson\",\"age\": 38,\"department\": \"Marketing\",\"salary\": 72000},{\"name\": \"Sarah Thompson\",\"age\": 31,\"department\": \"Sales\",\"salary\": 85000}]}";
        jsonToArrayExample.jsonExtract(jsonString);
        HashMap<String,Integer> countOfEmployee = noOfEmployee.countOfEmployee(jsonToArrayExample.employeesArray);
        Assert.assertEquals(countOfEmployee.get("Engineering").intValue(),3);
        Assert.assertEquals(countOfEmployee.get("Sales").intValue(),2);
        Assert.assertEquals(countOfEmployee.get("Marketing").intValue(),1);
    }

    @Test(description = "Validate the Json response")
    public void validateNameOfEmployee()
    {
        // Sample JSON string
        String jsonString = "{\"employees\": [{\"name\": \"John Doe\",\"age\": 32,\"department\": \"Engineering\",\"salary\": 80000},{\"name\": \"Jane Smith\",\"age\": 27,\"department\": \"Engineering\",\"salary\": 65000},{\"name\": \"Michael Johnson\",\"age\": 45,\"department\": \"Sales\",\"salary\": 90000},{\"name\": \"Emily Davis\",\"age\": 29,\"department\": \"Engineering\",\"salary\": 75000},{\"name\": \"David Wilson\",\"age\": 38,\"department\": \"Marketing\",\"salary\": 72000},{\"name\": \"Sarah Thompson\",\"age\": 31,\"department\": \"Sales\",\"salary\": 85000}]}";
        jsonToArrayExample.jsonExtract(jsonString);
        HashMap<String, List<String>> countOfEmployee = employeesName.employeeNameList(jsonToArrayExample.employeesArray);
        for(Map.Entry<String,List<String>> entry: countOfEmployee.entrySet())
        {
            System.out.println("Department: " + entry.getKey() + ", Employee Count: " + entry.getValue().size());
            System.out.println("Department:" + entry.getKey() + ":" +entry.getValue().toString());

        }

        assert countOfEmployee.get("Engineering").size() == 3 : "Incorrect count for Engineering department";
        assert countOfEmployee.get("Marketing").size() == 1 : "Incorrect count for Marketing department";
        assert countOfEmployee.get("Sales").size() == 2 : "Incorrect count for Sales department";

        int totalEmployees = countOfEmployee.values().stream().mapToInt(List::size).sum();
        assert totalEmployees == jsonToArrayExample.employeesArray.size() : "Total employee count doesn't match";
    }
}
