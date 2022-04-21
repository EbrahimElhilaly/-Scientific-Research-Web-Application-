/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.webstore.jdbc.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javaee.webstore.jdbc.books.Book;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */

@Entity
@Table(name = "CATEGORY", schema = "EBOOK")
public class Category implements Serializable {
    
    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy =GenerationType.AUTO , generator = "CATEGORY_SEQ")
    @SequenceGenerator(name="CATEGORY_SEQ", sequenceName = "CATEGORY_SEQ")
    private int categoryId;
    
    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "category")
    private Collection<Book> booksList = new ArrayList();
    
    
    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(Collection<Book> booksList) {
        this.booksList = booksList;
    }
    
    
}
