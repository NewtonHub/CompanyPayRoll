/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.newton.companypayroll;

/**
 *
 * @author tnewton
 */
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.commons.lang3.Validate;

public class PayRoll {
     public static void main(String[] args) {
        
        
       Scanner scan = new Scanner(System.in);
       Employee employee = new Employee();         
       
       employee.name = "";
       employee.hourlyRate  = -1;
       employee.hoursWorkedPerWeek = -1 ;
       employee.numberOfWeeksWorked = -1;
       
       System.out.print("employee name:  "); 
       
       while(employee.name.equals(""))
       {
            try
            {
                 Validate.notEmpty(employee.name = scan.nextLine(), "you must enter a name"); 
            }
            catch(IllegalArgumentException iae)
            {
                System.out.print("you must enter a name: " );
            }
       }
       
       System.out.print("Enter hourly rate:  ");         
       
        while (employee.hourlyRate < 0)        
        {
            try
            {               
               employee.hourlyRate = scan.nextDouble();               
            }
            catch (InputMismatchException ime)
            {               
                System.out.print("Please enter a number:  "); 
                employee.hourlyRate = -1; 
                scan.next();                  
            }          
        }       
       
       System.out.print("Enter hours worked per week:  ");  
       
       while (employee.hoursWorkedPerWeek < 0)        
        {
            try
            {               
               employee.hoursWorkedPerWeek = scan.nextInt();               
            }
            catch (InputMismatchException ime)
            {               
                System.out.print("Please enter a number:  "); 
                employee.hoursWorkedPerWeek = -1; 
                scan.next();                  
            }          
        }       
                 
       
        System.out.print("Enter number of weeks:  ");
        while (employee.numberOfWeeksWorked < 0)        
        {
            try
            {               
               employee.numberOfWeeksWorked = scan.nextInt();               
            }
            catch (InputMismatchException ime)
            {               
                System.out.print("Please enter a number:  "); 
                employee.numberOfWeeksWorked = -1; 
                scan.next();                  
            }          
        }      
         
        
        System.out.println("employee: "+ employee.name);
        System.out.println("Hourly Rate: "+ employee.hourlyRate);
        System.out.println("Hours per week: "+ employee.hoursWorkedPerWeek );
        
        if(employee.hoursWorkedPerWeek > 40)
        {
            employee.payAmount = employee.hourlyRate * 40 + (employee.hourlyRate * 1.5) * (employee.hoursWorkedPerWeek - 40);
        }else{        
        employee.payAmount = employee.hourlyRate * employee.hoursWorkedPerWeek * employee.numberOfWeeksWorked;
        }
        
        System.out.println("Amount to pay: " + employee.payAmount);    
          
        
    } 
    
    
}
