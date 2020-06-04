public class Producto{
    private String Product_Name;
    private int Supplier_ID;
    private int Category_ID;
    private String Quantityper_Unit;
    private double Unit_Price;
    private short Units_In_Stock;
    private short Units_On_Order;
    private short Reorder_Level;
    private byte New_Discontinued;

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public int getSupplier_ID() {
        return Supplier_ID;
    }

    public void setSupplier_ID(int supplier_ID) {
        Supplier_ID = supplier_ID;
    }

    public int getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(int category_ID) {
        Category_ID = category_ID;
    }

    public String getQuantityper_Unit() {
        return Quantityper_Unit;
    }

    public void setQuantityper_Unit(String quantityper_Unit) {
        Quantityper_Unit = quantityper_Unit;
    }

    public double getUnit_Price() {
        return Unit_Price;
    }

    public void setUnit_Price(double unit_Price) {
        Unit_Price = unit_Price;
    }

    public short getUnits_In_Stock() {
        return Units_In_Stock;
    }

    public void setUnits_In_Stock(short units_In_Stock) {
        Units_In_Stock = units_In_Stock;
    }

    public short getUnits_On_Order() {
        return Units_On_Order;
    }

    public void setUnits_On_Order(short units_On_Order) {
        Units_On_Order = units_On_Order;
    }

    public short getReorder_Level() {
        return Reorder_Level;
    }

    public void setReorder_Level(short reorder_Level) {
        Reorder_Level = reorder_Level;
    }

    public byte getNew_Discontinued() {
        return New_Discontinued;
    }

    public void setNew_Discontinued(byte new_Discontinued) {
        New_Discontinued = new_Discontinued;
    }
}