package edu.auburn;

public class PurchaseModel {
   public int mPurchaseID, mProductID, mCustomerID, mQuantity;
   public String mDate, mTime;
   public double mPrice, mTax, mTotalCost;

   public String toString() {
      StringBuilder sb = new StringBuilder("(");
      sb.append(mProductID).append(",");
      sb.append(mPurchaseID).append(",");
      sb.append(mCustomerID).append(",");
      sb.append("\"").append(mDate).append(",").append("\"").append(",");
      sb.append(mPrice).append(",");
      sb.append(mQuantity).append(",");
      sb.append(mTax).append(",");
      sb.append(mTotalCost).append(")");
      return sb.toString();
   }
}
