/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Samsung
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";
    
    // método de conexão do bd
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch(Exception ex){
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    
    //método responsavel por fechar o bd
    // @param connection
    public static void closeConnection(Connection connection){
        try{
            if(connection != null)// verifica se a conexão existe
                connection.close();
        } catch(Exception ex){
            throw new RuntimeException("Error closing database");
        }  
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try{
            if(connection != null)
                connection.close();
            
            if(statement != null)
                statement.close();
            
        } catch(Exception ex){
            throw new RuntimeException("Error closing database");
        }  
    }
    
        public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try{
            if(connection != null)
                connection.close();
            
            if(statement != null)
                statement.close();
            
            if(resultSet != null)
                resultSet.close();
            
        } catch(Exception ex){
            throw new RuntimeException("Error closing database");
        }  
    }
    
}
