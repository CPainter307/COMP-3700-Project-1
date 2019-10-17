package edu.auburn;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataAdapter {

   public static final int PRODUCT_SAVED_OK = 0;
   public static final int PRODUCT_DUPLICATE_ERROR = 1;
   
   public static final int CUSTOMER_SAVED_OK = 0;
   public static final int CUSTOMER_DUPLICATE_ERROR = 1;
   
   public static final int PURCHASE_SAVED_OK = 0;
   public static final int PURCHASE_DUPLICATE_ERROR = 1;

   Connection conn = null;

   public void connect() {
      try {
         // db parameters
         String url = "jdbc:sqlite:C:/Users/ttn0007/Documents/store.db";
         // create a connection to the database
         conn = DriverManager.getConnection(url);
      
         System.out.println("Connection to SQLite has been established.");
      
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }

   public ProductModel loadProduct(int productID) {
      ProductModel product = new ProductModel();
   
      try {
         String sql = "SELECT ProductId, Name, Price, Quantity FROM Products WHERE ProductId = " + productID;
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         product.mProductID = rs.getInt("ProductId");
         product.mName = rs.getString("Name");
         product.mPrice = rs.getDouble("Price");
         product.mQuantity = rs.getDouble("Quantity");
      
      
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return product;
   }
   
   
   public int saveProduct(ProductModel product) {
      try {
         String sql = "INSERT INTO Products(ProductId, Name, Price, Quantity) VALUES " + product;
         System.out.println(sql);
         Statement stmt = conn.createStatement();
         stmt.executeUpdate(sql);
      
      } catch (Exception e) {
         String msg = e.getMessage();
         System.out.println(msg);
         if (msg.contains("UNIQUE constraint failed"))
            return PRODUCT_DUPLICATE_ERROR;
      }
      
   
      return PRODUCT_SAVED_OK;
   }
   
   public CustomerModel loadCustomer(int customerID) {
      CustomerModel customer = new CustomerModel();
      
      try {
         String sql = "SELECT CustomerID, Name, Phone Number, Address FROM Customers WHERE CustomerId = " + customerID;
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         customer.mCustomerID = rs.getInt("CustomerID");
         customer.mName = rs.getString("Name");
         customer.mAddress = rs.getString("Address");
         customer.mPhone = rs.getString("Phone");
         
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return customer;
   
   }
   
      
   public int saveCustomer(CustomerModel customer) {
      try {
         String sql = "INSERT INTO Customer(CustomerId, Name, Address, Phone) VALUES " + customer;
         System.out.println(sql);
         Statement stmt = conn.createStatement();
         stmt.executeUpdate(sql);
      
      } catch (Exception e) {
         String msg = e.getMessage();
         System.out.println(msg);
         if (msg.contains("UNIQUE constraint failed"))
            return CUSTOMER_DUPLICATE_ERROR;
      }
      
   
      return CUSTOMER_SAVED_OK;
   }
   
   public PurchaseModel loadPurchase (int purchaseID) {
      PurchaseModel purchase = new PurchaseModel();
   
      try {
         String sql = "SELECT PurchaseID, ProductID, CustomerID, Date, Time, Quantity, Price, Tax, Total Cost FROM Purchases WHERE PurchaseID = " + purchaseID;
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         purchase.mPurchaseID = rs.getInt("PurchaseID");
         purchase.mProductID = rs.getInt("ProductID");
         purchase.mCustomerID = rs.getInt("CustomerID");
         purchase.mDate = rs.getString("Date");
         purchase.mTime = rs.getDouble("Time");
         purchase.mQuantity = rs.getInt("Quantity");
         purchase.mPrice = rs.getDouble("Price");
         purchase.mTax = rs.getDouble("Tax");
         purchase.mTotalCost = rs.getDouble("Total Cost");
      
      
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      return purchase;
   }
   
   public int savePurchase(PurchaseModel purchase) {
      try {
         String sql = "INSERT INTO Purchase(PurchaseID, ProductID, CustomerID, Date, Time, Quantity, Price, Tax, Total Cost) VALUES " + purchase;
         System.out.println(sql);
         Statement stmt = conn.createStatement();
         stmt.executeUpdate(sql);
      
      } catch (Exception e) {
         String msg = e.getMessage();
         System.out.println(msg);
         if (msg.contains("UNIQUE constraint failed"))
            return PURCHASE_DUPLICATE_ERROR;
      }
      
   
      return PURCHASE_SAVED_OK;
   }
   
}
