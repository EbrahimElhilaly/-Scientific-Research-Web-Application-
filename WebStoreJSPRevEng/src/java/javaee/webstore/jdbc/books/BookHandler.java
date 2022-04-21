/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.webstore.jdbc.books;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaee.webstore.jdbc.category.CategoryHandler;
import javaee.webstore.jdbc.dbconnection.DBConnectionFactory;
import javaee.webstore.jdbc.users.UserHandler;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Administrator
 */
public class BookHandler {
    
     public static Session openSession(){
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        return session;
    
    }
    
    public static void closeSession(Session session) {
        session.close();
        session.getSessionFactory().close();
    }
    
    public static int insertBook(Book book){
    
        Session session = openSession();
        session.beginTransaction();
        
        session.save(book);
        
        session.getTransaction().commit();

        closeSession(session);
        
        return 1;
        
    }
    
    public static int updateBook(Book book) {
        Session session = openSession();
        session.beginTransaction();

        session.update(book);
        
        session.getTransaction().commit();
        closeSession(session);
        return 1;
    }
    
    public static Book getBookById(int bookId) {
        Session session = openSession();

        Book book = (Book) session.get(Book.class, bookId);

        closeSession(session);

        return book;
    }
  
    public static int deleteBook(int bookId){
        
        Session session = openSession();
        session.beginTransaction();

        session.delete(getBookById(bookId));
        
        session.getTransaction().commit();
        closeSession(session);
        
        return 1;
    }
    
    public static ArrayList<Book> getAllBooks() {
       
        Session session = openSession();
        Criteria userCriteria = session.createCriteria(Book.class);

        ArrayList<Book> BooksList = (ArrayList<Book>) userCriteria.list();

        closeSession(session);
        return BooksList;
    }
    
    //--------------------------------------------------------------------------
    
    
    public static ArrayList<Book> getAllBooksJdbc() throws IOException {

        Connection conn = DBConnectionFactory.getConnection();

        ArrayList<Book> booksList = new ArrayList();
        String sql = "SELECT BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, "
                + " BOOK_DESCRIPTION, BOOK_ISBN, BOOK_IMAGE, BOOK_PRICE,"
                + " BOOK_PUBLISH_DATE, LAST_UPDATE_TIME, CATEGORY_ID"
                + " FROM BOOK"
                + " ORDER BY BOOK_ID ASC";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int bookId = rs.getInt("BOOK_ID");
                String bookTitle = rs.getString("BOOK_TITLE");
                String bookAuthor = rs.getString("BOOK_AUTHOR");
                String bookDescription = rs.getString("BOOK_DESCRIPTION");
                String bookISBN = rs.getString("BOOK_ISBN");
                
                
                InputStream in = rs.getBinaryStream("BOOK_IMAGE");
                 byte[] bookImage = new byte[0];
              if(in != null){  
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int next = in.read();
                while (next > -1) {
                    bos.write(next);
                    next = in.read();
                }
                bos.flush();
                bookImage = bos.toByteArray();
                    System.out.println("boook image length : "+ bookImage.length);
                bos.close();
              }
                
                double bookPrice = rs.getDouble("BOOK_PRICE");
                Date bookPublishDate = rs.getDate("BOOK_PUBLISH_DATE");
                Date bookLastUpdateTime = rs.getDate("LAST_UPDATE_TIME");
                int bookCategoryId = rs.getInt("CATEGORY_ID");

                Book book = new Book(bookId, bookTitle, bookAuthor, bookDescription, bookImage, bookISBN, bookPrice, bookPublishDate, bookLastUpdateTime, CategoryHandler.getCategoryById(bookCategoryId));
                booksList.add(book);
            }

            pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return booksList;
    }

   public static Book getBookByIdJdbc(int bookId) throws IOException {

     Connection conn = DBConnectionFactory.getConnection();

      Book book = null;
        String sql = "SELECT BOOK_ID, BOOK_TITLE, BOOK_AUTHOR, "
                + " BOOK_DESCRIPTION, BOOK_ISBN, BOOK_IMAGE, BOOK_PRICE,"
                + " BOOK_PUBLISH_DATE, LAST_UPDATE_TIME, CATEGORY_ID"
                + " FROM BOOK"
                + " WHERE BOOK_ID = ?";
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
              pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
               
                String bookTitle = rs.getString("BOOK_TITLE");
                String bookAuthor = rs.getString("BOOK_AUTHOR");
                String bookDescription = rs.getString("BOOK_DESCRIPTION");
                String bookISBN = rs.getString("BOOK_ISBN");
                
                
                InputStream in = rs.getBinaryStream("BOOK_IMAGE");
                 byte[] bookImage = new byte[0];
              if(in != null){  
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int next = in.read();
                while (next > -1) {
                    bos.write(next);
                    next = in.read();
                }
                bos.flush();
                bookImage = bos.toByteArray();
                    System.out.println("boook image length : "+ bookImage.length);
                bos.close();
              }
                
                double bookPrice = rs.getDouble("BOOK_PRICE");
                Date bookPublishDate = rs.getDate("BOOK_PUBLISH_DATE");
                Date bookLastUpdateTime = rs.getDate("LAST_UPDATE_TIME");
                int bookCategoryId = rs.getInt("CATEGORY_ID");
                    System.out.println("Book description : "+bookDescription);
                 book = new Book(bookId, bookTitle, bookAuthor, bookDescription, bookImage, bookISBN, bookPrice, bookPublishDate, bookLastUpdateTime, CategoryHandler.getCategoryById(bookCategoryId));
               
            }

				pstmt.close();
            //  conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return book;
    }
    
   //-----------TEST------------------------------------------------------------
   
   public static void main(String[] args) {
        
       
        ArrayList<Book> bookList = getAllBooks();
        for (Book item : bookList) {
          
            String bookTitle = item.getBookTitle();
            
            
            System.out.println("book title: "+bookTitle);
        } // GET ALL

       
        
    }    
    
}
