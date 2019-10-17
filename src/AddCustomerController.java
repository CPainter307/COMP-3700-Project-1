package edu.auburn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerController {

   public AddCustomerView view;
   public SQLiteDataAdapter adapter;

   public AddCustomerController(AddCustomerView view, SQLiteDataAdapter adapter)   {
      this.view = view;
      this.adapter = adapter;
   
      this.view.btnAdd.addActionListener(new AddButtonListerner());
      this.view.btnCancel.addActionListener(new CancelButtonListerner());
   
   }

   class AddButtonListerner implements ActionListener {
   
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
         CustomerModel customer = new CustomerModel();
      
         String id = AddCustomerController.this.view.txtCustomerID.getText();
      
         if (id.length() == 0) {
            JOptionPane.showMessageDialog(null, "CustomerID cannot be null!");
            return;
         }
      
         try {
            customer.mCustomerID = Integer.parseInt(id);
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
            return;
         }
      
         String name = AddCustomerController.this.view.txtName.getText();
         if (name.length() == 0) {
            JOptionPane.showMessageDialog(null, "Customer name cannot be empty!");
            return;
         }
      
         customer.mName = name;
      
         String phone = AddCustomerController.this.view.txtName.getText();
         if (phone.length() == 0) {
            JOptionPane.showMessageDialog(null, "Customer phone # cannot be empty!");
            return;
         }
       
         customer.mPhone = phone;
        
         
         String address = AddCustomerController.this.view.txtName.getText();
         if (address.length() == 0) {
            JOptionPane.showMessageDialog(null, "Customer address cannot be empty!");
            return;
         }      
         
         customer.mAddress = address;   
      
         switch (adapter.saveCustomer(customer)) {
            case SQLiteDataAdapter.CUSTOMER_DUPLICATE_ERROR:
               JOptionPane.showMessageDialog(null, "Customer NOT added successfully! Duplicate customer ID!");
            default:
               JOptionPane.showMessageDialog(null, "Customer added successfully!" + customer);
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