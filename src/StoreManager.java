package edu.auburn;

public class StoreManager {

   public static void main(String[] args) {
      System.out.println("Hello class!");
      SQLiteDataAdapter adapter = new SQLiteDataAdapter();
      adapter.connect();
      ProductModel product = adapter.loadProduct(3);
      CustomerModel customer = adapter.loadCustomer(3);
      PurchaseModel purchase = adapter.loadPurchase(3);
   
      System.out.println("Loaded product: " + product);
      System.out.println("Loaded customer: " + customer);
      System.out.println("Loaded purchase: " + purchase);
      
   
      AddProductView apView = new AddProductView();
      AddProductController apCtr = new AddProductController(apView, adapter);
      
      AddCustomerView acView = new AddCustomerView();
      AddCustomerController acCtr = new AddCustomerController(acView, adapter);
      
      AddPurchaseView aprView = new AddPurchaseView();
      AddPurchaseController aprCtr = new AddPurchaseController();
   
      apView.setVisible(true);
      acView.setVisible(true);
      aprView.setVisible(true);
   
   }
}
