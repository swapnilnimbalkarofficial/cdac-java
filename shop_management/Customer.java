package shop_management;

import java.util.ArrayList;

public class Customer {

    private static int idGenerator = 2000;

    private int id;
    private String name;
    private long contactNumber;

    private ArrayList<Product> products = new ArrayList<>();

    public Customer(String name, long contactNumber) {
        this.id = idGenerator++;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {

        for (Product product : products) {

            if (product.getId() == productId) {
                products.remove(product);
                return;
            }
        }

        throw new RuntimeException("Product not found");
    }

    public void displayAllProduct() {

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public int calculateBill() {

        int total = 0;

        for (Product product : products) {
            total = total + product.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name
                + ", contactNumber=" + contactNumber + "]";
    }
}
