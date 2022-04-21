package javaee.webstore.jdb.testH;
// Generated Feb 9, 2022 8:42:09 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Products generated by hbm2java
 */
public class Products  implements java.io.Serializable {


     private BigDecimal productId;
     private ProductsDetails productsDetails;
     private String productName;
     private Set softwares = new HashSet(0);

    public Products() {
    }

	
    public Products(BigDecimal productId) {
        this.productId = productId;
    }
    public Products(BigDecimal productId, ProductsDetails productsDetails, String productName, Set softwares) {
       this.productId = productId;
       this.productsDetails = productsDetails;
       this.productName = productName;
       this.softwares = softwares;
    }
   
    public BigDecimal getProductId() {
        return this.productId;
    }
    
    public void setProductId(BigDecimal productId) {
        this.productId = productId;
    }
    public ProductsDetails getProductsDetails() {
        return this.productsDetails;
    }
    
    public void setProductsDetails(ProductsDetails productsDetails) {
        this.productsDetails = productsDetails;
    }
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Set getSoftwares() {
        return this.softwares;
    }
    
    public void setSoftwares(Set softwares) {
        this.softwares = softwares;
    }




}


