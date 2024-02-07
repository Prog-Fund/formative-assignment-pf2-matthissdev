
public class Product {
    private String productName ;
    private int productCode = 5000;  // valid values 1000 - 5000 inclusive - default value is 5000
    private double unitCost;  //valid values are any positive number - default to 1
    private boolean inCurrentProductLine;   // no validation required. Default

//Constructor
    public Product(String productName, int productCode, double unitCost, boolean inCurrentProductLine) {
        setProductName(productName);
        setProductCode(productCode);
        this.unitCost = unitCost;
        this.inCurrentProductLine = inCurrentProductLine;
    }
    //getters

    public String getProductName(){
        return productName;
    }

    public int getProductCode() {
        return productCode;
    }
    public double getUnitCost(){
        return unitCost;
    }

    public boolean isInCurrentProductLine() {
        return inCurrentProductLine;
    }


    //setters
    public void setProductName(String productName) {
        if (productName != null) {
            if (productName.length() <= 20)
                this.productName = productName;
            else {
                this.productName = productName.substring(0,20);
            }
        }
    }
    public void setProductCode(int productCode) {
        if ((productCode >= 900) && (productCode <= 5000)) {
            this.productCode = productCode;
        }
    }


    public void setUnitCost(double unitCost) {
        if ((unitCost > 0) && (unitCost <= 99999)){
            this.unitCost = unitCost;
        }

    }
    public void setInCurrentProductLine(boolean inCurrentProductLine) {
        this.inCurrentProductLine = inCurrentProductLine;
    }
    @Override
    public String toString() {
        return "Product description: " + productName +
                ", Product code: " + productCode +
                ", Unit cost: " + unitCost +
                ", Currently in  product line: " + inCurrentProductLine;
    }
}

