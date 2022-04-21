/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.webstore.jdbc.users;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */

@Entity
@Table(name = "USERS", schema = "EBOOK")
public class User implements Serializable {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy =GenerationType.AUTO , generator = "USERS_SEQ")
    @SequenceGenerator(name="USERS_SEQ", sequenceName = "USERS_SEQ")
    private int userId;
    
    @Column(name = "USER_NAME")
    private String userName;
    
    @Column(name = "USER_EMAIL")
    private String userEmail;
    
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    public User() {
    }

    
    public User(int userId, String userName, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(int userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    

    
}
