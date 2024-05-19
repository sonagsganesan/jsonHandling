package org.example;

public class CalculateAverageAge  {

    public double averageAge(Integer[] age)
    {

        double averageEmployeeAge = 0;
        int number_of_employees = age.length;
        int sum =0;
        for(int employeeAge : age)
            sum+= employeeAge;
        averageEmployeeAge = (double) sum /number_of_employees;
        return averageEmployeeAge;
    }
}
