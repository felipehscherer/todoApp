/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Samsung
 */
public class TaskController {
    
    /**
    * Método responsavel por salvar uma task no bd
    * @param task
    */
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject, name, description, " 
                + "completed, notes, deadLine, createAt, updateAt) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            // vai executar setando todas as novas info
            statement.execute();
        } catch(SQLException ex){
            throw new RuntimeException("Error saving task", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }	
    }
    
    public void update(Task task){
        String sql = "UPDATE tasks SET "
                + "idProject = ?, name = ?, description = ?, notes = ?, "
                + "completed = ?, deadline = ?, createAt = ?, updateAt = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelece a conexão com o bd
            connection = ConnectionFactory.getConnection();
            //Prepara a query
            statement = connection.prepareStatement(sql);
            
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateAt().getTime()));
            statement.setDate(8, new Date(task.getUpdateAt().getTime()));
            statement.setInt(9, task.getId());
            
            statement.execute();
        } catch (SQLException ex){
            throw new RuntimeException("Error updating task", ex);
        } finally {
            // fecha a conexão
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    /**
    * Método responsavel por remover um taskId do bd
    * @param taskId
    */
    public void removeById(int taskId){
        String sql = "DELETE FROM tasks WHERE ID = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            // pega a conexão com o bd
            connection = ConnectionFactory.getConnection(); 
            // objeto que ajuda a preparar o comando sql que vai ser executado pela conexão
            statement = connection.prepareStatement(sql); 
            
            // responsavel por setar o id
            statement.setInt(1, taskId); 
            statement.execute();
            
        }catch(SQLException ex){
            throw new RuntimeException("Error when deleting task", ex);
        } finally {
            // fecha a conexão
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Task> getAll(int idProject){
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Task> tasks = new ArrayList<Task>();
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //seta o valor no filtro de busca
            statement.setInt(1, idProject);
            //valor retornando pela execução da query
            resultSet = statement.executeQuery(); 
            
            //Enquanto houver valor a ser recebido
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreateAt(resultSet.getDate("createAt"));
                task.setUpdateAt(resultSet.getDate("updateAt"));
                tasks.add(task);
                
                
            }
        } catch (SQLException ex){
            throw new RuntimeException("Error when searching for task", ex);
        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        //retorna a lista
        return tasks;
    }
}