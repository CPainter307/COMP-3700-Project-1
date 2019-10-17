package edu.auburn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPurchaseController {

   public AddPurchaseView view;
   public SQLiteDataAdapter adapter;

   public AddPurchaseController(AddPurchaseView view, SQLiteDataAdapter adapter)   {
      this.view = view;
      this.adapter = adapter;
   
      this.view.btnAdd.addActionListener(new AddButtonListerner());
      this.view.btnCancel.addActionListener(new CancelButtonListerner());
   
   }

   class AddButtonListerner implements ActionListener {
   
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
         PurchaseModel purchase = new PurchaseModel();
      
         String id = AddPurchaseController.this.view.txtPurchaseID.getText();
      
         if (id.length() == 0) {
            JOptionPane.showMessageDialog(null, "PurchaseID cannot be null!");
            return;
         }
      
         try {
            purchase.mPurchaseID = Integer.parseInt(id);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "PurchaseID is invalid!");
            return;
         }
        
         String id2 = AddPurchaseController.this.view.txtProductID.getText();
      
         if (id2.length() == 0) {
            JOptionPane.showMessageDialog(null, "ProductID cannot be null!");
            return;
         }
      
         try {
            purchase.mProductID = Integer.parseInt(id2);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ProductID is invalid!");
            return;
         }
      
         String id3 = AddPurchaseController.this.view.txtCustomerID.getText();
      
         if (id3.length() == 0) {
            JOptionPane.showMessageDialog(null, "CustomerID cannot be null!");
            return;
         }
      
         try {
            purchase.mCustomerID = Integer.parseInt(id3);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
            return;
         }
      
         String date = AddPurchaseController.this.view.txtDate.getText();
         if (date.length() == 0) {
            JOptionPane.showMessageDialog(null, "Purchase date cannot be empty!");
            return;
         }
      
         purchase.mDate = date;
      
         String time = AddPurchaseController.this.view.txtTime.getText();
         try {
            purchase.mTime = Double.parseDouble(time);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Time is invalid!");
            return;
         }
        
         
         String quantity = AddPurchaseController.this.view.txtQuantity.getText();
         try {
            purchase.mQuantity = Integer.parseIngeger(quantity);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantity is invalid!");
            return;
         }
         
         
         String price = AddPurchaseController.this.view.txtPrice.getText();
         try {
            purchase.mPrice = Double.parseDouble(price);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price is invalid!");
            return;
         }
         
         
         String tax = AddPurchaseController.this.view.txtTax.getText();
         try {
            purchase.mTax = Double.parseDouble(tax);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Tax is invalid!");
            return;
         }
         
         
         String totalCost = AddPurchaseController.this.view.txtTotalCost.getText();
         try {
            purchase.mTotalCost = Double.parseDouble(totalCost);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Total cost is invalid!");
            return;
         }
      
         switch (adapter.savePurchase(purchase)) {
            case SQLiteDataAdapter.PURCHASE_DUPLICATE_ERROR:
               JOptionPane.showMessageDialog(null, "Purchase NOT added successfully! Duplicate purchase ID!");
            default:
               JOptionPane.showMessageDialog(null, "Purchase added successfully!" + purchase);
         }
      }
   }

   class CancelButtonListerner implements ActionListener {
   
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
         JOptionPane.showMessageDialog(null, "You click on Cancel button!!!");
      }
   }

}