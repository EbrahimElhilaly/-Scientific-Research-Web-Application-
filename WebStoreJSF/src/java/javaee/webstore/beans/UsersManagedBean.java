/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.webstore.beans;

import java.util.ArrayList;
import javaee.webstore.controller.services.UserServices;
import javaee.webstore.jdbc.users.User;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author helali
 */
@Named(value = "UsersManagedBean")
@SessionScoped
public class UsersManagedBean {

    private ArrayList<User> usersList = new ArrayList();
    private User user = new User();
    
    public UsersManagedBean() {
        usersList = UserServices.getAllUsers();
        
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public ArrayList<User> getUsersList() {
        return usersList;
    }
    
    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }
    
    public void deleteUser(int userId) {
        
        UserServices.deleteUser(userId);
        
        usersList = UserServices.getAllUsers();
        
    }
    
    public void editUser(int userId) {
        
        user = UserServices.getUserById(userId);
        
    }
    
    public void save() {
        
        if (user.getUserId() != 0) {
            
            UserServices.updateUser(user);
            
        } else {
            
            UserServices.insertUser(user);
            
        }        
        
        usersList = UserServices.getAllUsers();
    }
    
    
    public void createUser(){
    
        user = new User();
    
    }
    
}
