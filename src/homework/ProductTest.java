package homework;

public class ProductTest {
    public static void main(String[] args) {
        Category category1 = new Category(1, "Men clothes");
        Category category2 = new Category(2,  "Women clothes");

        Product product1 = new Product(1, "Men T-shirt", 60000, category1);
        Product product2 = new Product(2, "Women T-shirt", 60000, category2);

        product1.display();
        System.out.print("\n");
        product2.display();
    }
}
