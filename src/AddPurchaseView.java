package edu.auburn;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPurchaseView extends JFrame {
   public JButton btnAdd = new JButton("Add");
   public JButton btnCancel = new JButton("Cancel");
   public JTextField txtPurchaseID = new JTextField(20);
   public JTextField txtProductID = new JTextField(20);
   public JTextField txtCustomerID = new JTextField(20);
   public JTextField txtDate = new JTextField(20);
   public JTextField txtTime = new JTextField(20);
   public JTextField txtQuantity = new JTextField(20);
   public JTextField txtPrice = new JTextField(20);
   public JTextField txtTax = new JTextField(20);
   public JTextField txtTotalCost = new JTextField(20);

   public AddPurchaseView() {
      this.setTitle("Add Purchase");
      this.setSize(600, 400);
      this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), 3));
      String[] var10000 = new String[]{"PurchaseID", "ProductID", "CustomerID", "Date", "Time", "Quantity", "Price", "Tax", "Total"};
      JPanel line1 = new JPanel(new FlowLayout());
      line1.add(new JLabel("PurchaseID "));
      line1.add(this.txtPurchaseID);
      this.getContentPane().add(line1);
      JPanel line2 = new JPanel(new FlowLayout());
      line2.add(new JLabel("ProductID "));
      line2.add(this.txtProductID);
      this.getContentPane().add(line2);
      JPanel line3 = new JPanel(new FlowLayout());
      line3.add(new JLabel("CutsomerID "));
      line3.add(this.txtCustomerID);
      this.getContentPane().add(line3);
      JPanel line4 = new JPanel(new FlowLayout());
      line4.add(new JLabel("Date "));
      line4.add(this.txtDate);
      this.getContentPane().add(line4);
      JPanel line5 = new JPanel(new FlowLayout());
      line5.add(new JLabel("Time "));
      line5.add(this.txtTime);
      this.getContentPane().add(line5);
      JPanel line6 = new JPanel(new FlowLayout());
      line6.add(new JLabel("Quantity "));
      line6.add(this.txtQuantity);
      this.getContentPane().add(line6);
      JPanel line7 = new JPanel(new FlowLayout());
      line7.add(new JLabel("Price "));
      line7.add(this.txtPrice);
      this.getContentPane().add(line7);
      JPanel line8 = new JPanel(new FlowLayout());
      line8.add(new JLabel("Tax "));
      line8.add(this.txtTax);
      this.getContentPane().add(line8);
      JPanel line9 = new JPanel(new FlowLayout());
      line9.add(new JLabel("Total Cost "));
      line9.add(this.txtTotalCost);
      this.getContentPane().add(line9);
      JPanel panelButtons = new JPanel(new FlowLayout());
      panelButtons.add(this.btnAdd);
      panelButtons.add(this.btnCancel);
      this.getContentPane().add(panelButtons);
   }
}
