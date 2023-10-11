package practice.B03;

public class ProductManagementProgram {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        productManager.addProduct(new Product(1, "Product A", 10.99));
        productManager.addProduct(new Product(2, "Product B", 5.99));
        productManager.addProduct(new Product(3, "Product C", 15.99));
        productManager.addProduct(new Product(4, "Product D", 7.99));

        productManager.displayProducts();

        productManager.updateProduct(2, 8.99);
        productManager.deleteProduct(3);

        productManager.searchProduct("Product A");
        productManager.searchProduct("Product E");

        productManager.sortProductsByPrice(true);
        productManager.sortProductsByPrice(false);
    }
}
