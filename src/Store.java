
public class Store {

    private Product[] products;
    private int total = 0;  //dual purpose. 1) number of items stored in array, 2) next available index location

    public Store(int numberItems) {
        products = new Product[numberItems];
    }

    private boolean isFull() {
        return total == products.length;
    }

    private boolean isEmpty() {
        return total == 0;
    }

    public boolean add(Product product) {
        if (isFull()) {
            return false;
        } else {
            products[total] = product;
            total++;
            return true;
        }
    }

    public String listProducts() {
        if (isEmpty()) {
            return "No products in the store";
        } else {
            String listOfProducts = "";
            for (int i = 0; i < total; i++) {
                listOfProducts += i + ": " + products[i] + "\n";
            }
            return listOfProducts;
        }
    }

    public Product cheapestProduct() {
        if (!isEmpty()) {
            Product cheapestProduct = products[0];
            for (int i = 1; i < total; i++) {
                if (products[i].getUnitCost() < cheapestProduct.getUnitCost())
                    cheapestProduct = products[i];
            }
            return cheapestProduct;
        } else {
            return null;
        }
    }

    public String listCurrentProducts() {
        if (isEmpty()) {
            return "No Products in the store";
        } else {
            String listOfProducts = "";
            for (int i = 0; i < total; i++) {
                if (products[i].isInCurrentProductLine())
                    listOfProducts += i + ": " + products[i] + "\n";
            }
            if (listOfProducts.equals("")){
                return "No Products are in our current product line";
            }
            else{
                return listOfProducts;
            }
        }
    }

    public double averageProductPrice() {
        if (!isEmpty()) {
            double totalPrice = 0;
            for (int i = 0; i < total; i++) {
                totalPrice += products[i].getUnitCost();
            }
            return totalPrice / total;
        } else {
            return -1;
        }

    }

    public String listProductsAboveAPrice(double price) {
        if (isEmpty()) {
            return "No Products in the store";
        } else {
            String str = "";
            for (int i = 0; i < total; i++) {
                if (products[i].getUnitCost() > price)
                    str += i + ": " + products[i] + "\n";
            }
            if (str.equals("")) {
                return "No products are more expensive than: " + price;
            } else {
                return str;
            }
        }
    }
}
