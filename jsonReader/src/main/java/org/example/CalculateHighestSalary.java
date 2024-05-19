package org.example;

public class CalculateHighestSalary {

    public int highestSalary(Integer[] salaries)
    {
        int highestSalary = Integer.MIN_VALUE;

        for(int salary : salaries)
            highestSalary = Math.max(salary,highestSalary);

        return highestSalary;
    }
}
