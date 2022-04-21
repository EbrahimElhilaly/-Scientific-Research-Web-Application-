/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.webstore.jdbc.books;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import javaee.webstore.jdbc.category.Category;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Administrator
 */

@Entity
@Table(name = "BOOK" , schema = "EBOOK")
public class Book implements Serializable {
    @Id
    @Column(name="BOOK_ID")
    @GeneratedValue(strategy =GenerationType.AUTO , generator = "BOOK_SEQ")
    @SequenceGenerator(name="BOOK_SEQ", sequenceName = "BOOK_SEQ")
    private int bookId;
    
    @Column(name = "BOOK_TITLE")
    private String bookTitle;
    
    @Column(name = "BOOK_AUTHOR")
    private String bookAuthor;
    
    @Column(name = "BOOK_DESCRIPTION")
    private String bookDescription;
    
    @Column(name = "BOOK_IMAGE")
    private byte[] bookImage;
    
    @Column(name = "BOOK_ISBN")
    private String bookISBN;
    
    @Column(name = "BOOK_PRICE")
    private double bookPrice;
    
    @Column(name = "BOOK_PUBLISH_DATE")
    private Date publishDate;
    
    @Column(name = "LAST_UPDATE_TIME")
    private Date lastUpdateTime;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    @Transient
    private String base64Image;

    public Book() {
    }

    public Book(int bookId, String bookTitle, String bookAuthor, String bookDescription, byte[] bookImage, String bookISBN, double bookPrice, Date publishDate, Date lastUpdateTime, Category category) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.bookImage = bookImage;
        this.bookISBN = bookISBN;
        this.bookPrice = bookPrice;
        this.publishDate = publishDate;
        this.lastUpdateTime = lastUpdateTime;
        this.category = category;
    }

    public Book(int bookId, String bookTitle, String bookAuthor, String bookDescription, String bookISBN, double bookPrice, Date publishDate, Date lastUpdateTime, Category category) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.bookISBN = bookISBN;
        this.bookPrice = bookPrice;
        this.publishDate = publishDate;
        this.lastUpdateTime = lastUpdateTime;
        this.category = category;
    }

    public Book(String bookTitle, String bookAuthor, String bookDescription, String bookISBN, double bookPrice, Date publishDate, Date lastUpdateTime, Category category) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.bookISBN = bookISBN;
        this.bookPrice = bookPrice;
        this.publishDate = publishDate;
        this.lastUpdateTime = lastUpdateTime;
        this.category = category;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public byte[] getBookImage() {
        return bookImage;
    }

    public void setBookImage(byte[] bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBase64Image() {
           this.base64Image = Base64.getEncoder().encodeToString(this.bookImage);
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
  
   
     
  
  
  
  
}