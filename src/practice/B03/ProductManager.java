package practice.B03;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>(); // or LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(int id, double price) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setPrice(price);
                System.out.println("Product updated: " + product);
                return;
            }
        }
        System.out.println("Product not found with ID: " + id);
    }

    public void deleteProduct(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                System.out.println("Product deleted: " + product);
                return;
            }
        }
        System.out.println("Product not found with ID: " + id);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products to display.");
            return;
        }
        System.out.println("Product list:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProduct(String name) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                searchResults.add(product);
            }
        }
        if (searchResults.isEmpty()) {
            System.out.println("No products found with name: " + name);
            return;
        }
        System.out.println("Search results for name: " + name);
        for (Product product : searchResults) {
            System.out.println(product);
        }
    }

    public void sortProductsByPrice(boolean ascending) {
        Comparator<Product> priceComparator = Comparator.comparingDouble(Product::getPrice);
        if (!ascending) {
            priceComparator = priceComparator.reversed();
        }
        products.sort(priceComparator);
        System.out.println("Product list sorted by price (ascending=" + ascending + "):");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
