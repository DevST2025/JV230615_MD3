package homework;

public class Product {
    private int productId ;
    private String productName;
    private double productPrice;

    private Category category;

    public Product() {
    }

    public Product(int productId, String productName, double productPrice, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
    }

    public void display() {
        System.out.println( "ProductID: " + productId + "\n" +
                "ProductName: " + productName + "\n" +
                "ProductPrice: " + productPrice + "\n"+
                "Category: " + category.getCategoryName());
    }
}
