/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.webstore.jdbc.users;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaee.webstore.jdbc.dbconnection.DBConnectionFactory;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Administrator
 */
public class UserHandler {
    
    
    public static org.hibernate.Session openSession(){
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        org.hibernate.Session session = sessionFactory.openSession();
        return session;
    
    }
    
    public static void closeSession(org.hibernate.Session session) {
        session.close();
        session.getSessionFactory().close();
    }
    
    public static int insertUser(User user){
    
        org.hibernate.Session session = openSession();
        session.beginTransaction();
        
        session.save(user);
        
        session.getTransaction().commit();

        closeSession(session);
        
        return 1;
        
    }
    
    public static int updateUser(User user) {
        org.hibernate.Session session = openSession();
        session.beginTransaction();

        session.update(user);
        
        session.getTransaction().commit();
        closeSession(session);
        return 1;
    }
    
    public static User getUserById(int userId) {
        org.hibernate.Session session = openSession();

        User user = (User) session.get(User.class, userId);

        closeSession(session);

        return user;
    }
  
    public static int deleteUser(int userId){
        
        org.hibernate.Session session = openSession();
        session.beginTransaction();

        session.delete(getUserById(userId));
        
        session.getTransaction().commit();
        closeSession(session);
        
        return 1;
    }
    
    public static ArrayList<User> getAllUsers() {
       
        org.hibernate.Session session = openSession();
        Criteria userCriteria = session.createCriteria(User.class);

        ArrayList<User> usersList = (ArrayList<User>) userCriteria.list();

        closeSession(session);
        return usersList;
    }
    
    
  //----------------------------------------------------------------------------  
    

    public static boolean checkLogin(String userName, String password){
        if(userName.equals("ahmed") && password.equals("ahmed123")){
            return true;
        }else{
            return false;
        }
    }
    
  //----------------------------------------------------------------------------  
    public static ArrayList<User> getAllUsersJdbc() {
            
     return null;
 }
    public static ArrayList<User> getAllUsersJDBC() {

        Connection conn = DBConnectionFactory.getConnection();

        ArrayList<User> usersList = new ArrayList();
        String sql = "SELECT USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL"
                + " FROM USERS"
                + " ORDER BY USER_ID ASC";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("USER_ID");
                String userName = rs.getString("USER_NAME");
                String userPassword = rs.getString("USER_PASSWORD");
                String userEmail = rs.getString("USER_EMAIL");

                User user = new User(userId, userName, userEmail, userPassword);
                usersList.add(user);
            }

            pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usersList;
    }

    public static int insertUserJdbc(User user) {
        Connection conn = DBConnectionFactory.getConnection();

        String sql = "INSERT INTO USERS"
                + " (USER_NAME, USER_PASSWORD, USER_EMAIL)"
                + " VALUES(?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setString(3, user.getUserEmail());
            pstmt.executeUpdate();
                conn.commit();
            pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

        return 1;
    }

    public static int updateUserJdbc(User user) {
        Connection conn = DBConnectionFactory.getConnection();

        String sql = "UPDATE USERS"
                + "  SET USER_NAME = ?"
                + " ,USER_PASSWORD = ?"
                + " ,USER_EMAIL = ?"
                + " WHERE USER_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setInt(4, user.getUserId());

            pstmt.executeUpdate();
                conn.commit();
            pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

        return 1;
    }

    public static User getUserByIdJdbc(int userId) {
        Connection conn = DBConnectionFactory.getConnection();

        User user = null;
        String sql = "SELECT USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL"
                + " FROM USERS"
                + " WHERE USER_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                String userName = rs.getString("USER_NAME");
                String userPassword = rs.getString("USER_PASSWORD");
                String userEmail = rs.getString("USER_EMAIL");

                user = new User(userId, userName, userEmail, userPassword);

            }

            pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;

    }

    public static int deleteUserJdbc(int userId) {
        Connection conn = DBConnectionFactory.getConnection();

        String sql = "DELETE USERS"
                + " WHERE USER_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            pstmt.executeUpdate();
                conn.commit();
            pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

        return 1;
    }
//------------------------------------------------------------------------------
    public static void main(String[] args) {
        
       User user = new User("Ahmad", "Ahmad@live.com", "123");
       
        insertUser(user); // INSERT
        System.out.println("User Inserted");
        
        user.setUserEmail("Ahmad_Saladin@gmail.com");
        
        updateUser(user); // UPDATE
        System.out.println("User Updated");
        
        ArrayList<User> userList = getAllUsers();
        for (User item : userList) {
           int id = item.getUserId();
            String userName = item.getUserName();
            String userEmail = item.getUserEmail();
            String userPassword = item.getUserPassword();
            
            System.out.println("id: "+ id +" Name: "+userName+ " Email: "+ userEmail+" Password: "+userPassword);
        } // GET ALL

        //get User by id = 70
        
        User user2 = getUserById(70);
        System.out.println("User By Id is: " + user2.getUserName());
        
        //delete user
        
        deleteUser(70);
        
        System.out.println("User deleted whose id is 70");
        
    }    
}