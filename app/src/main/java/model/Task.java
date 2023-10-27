/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author @felipenhaa
 */
public class Task {
    private int id;
    private int idProject;
    private String name;
    private String description;
    private boolean isCompleted;
    private String notes;
    private Date deadline;
    private Date createAt;
    private Date updateAt;
    
    /**
    *Contrutor padrão da classe Task
    * @param id
    * @param idProject
    * @param name
    * @param description
    * @param isCompleted
    * @param notes
    * @param deadline
    * @param createAt
    * @param updateAt
     */
    public Task(int id, int idProject, String name, String description, boolean isCompleted, String notes, Date deadline, Date createAt, Date updateAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.notes = notes;
        this.deadline = deadline;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    
    public Task(){
        this.createAt = new Date();
        this.updateAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", isCompleted=" + isCompleted + ", notes=" + notes + ", deadline=" + deadline + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    
    
    
}
