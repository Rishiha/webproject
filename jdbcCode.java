package com.mobNodb.Employee;


import java.sql.SQLException;

import java.sql.*;
import java.util.Scanner;
public class EmployeeDatabase extends Object {
    
    private static Connection connection=null;
    private static Scanner scanner= new Scanner(System.in);
    public static void main (String[]args){
        EmployeeDatabase employeedatabase = new EmployeeDatabase();
        try {
            Class.forName("com.Mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:Mysql://localhost:3306/mobNodb";
            String username = "root";
            String password = "2001";
            
            connection = DriverManager.getConnection(dbURL,username,password);
            System.out.println("Enter choice");
            System.out.println("1.Insert record");
            int choice = Integer.parseInt (scanner.nextLine ());
            
            
            switch(choice){
                case 1:
                    try{
                    employeedatabase.insertRecords();}
                    catch(Exception e){
                        throw new RuntimeException(e.fillInStackTrace());
                    }
                    break;
                default:
                    break;
            }
        }catch(Exception e){
            throw new RuntimeException(e.fillInStackTrace());
            
        }
    
    }
    private void insertRecords() throws SQLException{
        System.out.println("inside insert record()");
       
        String sql = " insert into Employee(eName,OrgId,OrgName,Gender,Designation,Phone)values('Raj',9625,'Male','SalesMan',7864567763)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
       int rows= preparedStatement.executeUpdate();
       if (rows>0){
           System.out.println("Record inserted succesfully");
       }
        
        
    }
    }
    

