/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.webstore.jdbc.category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaee.webstore.jdbc.dbconnection.DBConnectionFactory;
import javaee.webstore.jdbc.users.User;
import javaee.webstore.jdbc.users.UserHandler;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class CategoryHandler {
     
     public static Session openSession(){
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        return session;
    
    }
    
    public static void closeSession(Session session) {
        session.close();
        session.getSessionFactory().close();
    }
    
    public static int insertCategory(Category category){
    
        Session session = openSession();
        session.beginTransaction();
        
        session.save(category);
        
        session.getTransaction().commit();

        closeSession(session);
        
        return 1;
        
    }
    
    public static int updateCategory(Category category) {
        Session session = openSession();
        session.beginTransaction();

        session.update(category);
        
        session.getTransaction().commit();
        closeSession(session);
        return 1;
    }
    
    public static Category getCategoryById(int categoryId) {
        Session session = openSession();

        Category category = (Category) session.get(Category.class, categoryId);

        closeSession(session);

        return category;
    }
  
    public static int deleteCategory(int categoryId){
        
        Session session = openSession();
        session.beginTransaction();

        session.delete(getCategoryById(categoryId));
        
        session.getTransaction().commit();
        closeSession(session);
        
        return 1;
    }
    
    public static ArrayList<Category> getAllCategories() {
       
        Session session = openSession();
        Criteria userCriteria = session.createCriteria(Category.class);

        ArrayList<Category> CategoriesList = (ArrayList<Category>) userCriteria.list();

        closeSession(session);
        return CategoriesList;
    }
    
    
//------------------------------------------------------------------------------
    public static ArrayList<Category> getAllCategoriesJdbc(){

        Connection conn = DBConnectionFactory.getConnection();

        ArrayList<Category> categoriesList = new ArrayList();
        String sql = "SELECT CATEGORY_ID, CATEGORY_NAME"
                + " FROM CATEGORY"
                + " ORDER BY CATEGORY_ID ASC";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int categoryId = rs.getInt("CATEGORY_ID");
                String categoryName = rs.getString("CATEGORY_NAME");

                Category category = new Category(categoryId, categoryName);
                categoriesList.add(category);
            }

            pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categoriesList;
    }

    public static int createNewCategoryJdbc(Category category) {
        Connection conn = DBConnectionFactory.getConnection();

        String sql = "INSERT INTO CATEGORY"
                + " (CATEGORY_NAME)"
                + " VALUES(?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getCategoryName());

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

    public static int updateCategoryJdbc(Category category) {
        Connection conn = DBConnectionFactory.getConnection();

        String sql = "UPDATE CATEGORY"
                + "  SET CATEGORY_NAME = ?"
                + " WHERE CATEGORY_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category.getCategoryName());
            pstmt.setInt(2, category.getCategoryId());

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

    public static Category getCategoryByIdJdbc(int categoryId) {
        Connection conn = DBConnectionFactory.getConnection();

        Category category = null;
        String sql = "SELECT CATEGORY_ID, CATEGORY_NAME"
                + " FROM CATEGORY"
                + " WHERE CATEGORY_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, categoryId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                String categoryName = rs.getString("CATEGORY_NAME");
                category = new Category(categoryId, categoryName);

            }

            pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return category;

    }

    public static int deleteCategoryJdbc(int categoryId) {
        Connection conn = DBConnectionFactory.getConnection();

        String sql = "DELETE CATEGORY"
                + " WHERE CATEGORY_ID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, categoryId);

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
}
