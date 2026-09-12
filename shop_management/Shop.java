package shop_management;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Shop {

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {

        Product product = getProductById(productId);

        if (product != null) {
            products.remove(product);
            System.out.println("Product removed successfully");
        } else {
            System.out.println("Product not found");
        }
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(int customerId) {

        Customer customer = getCustomer(customerId);

        if (customer != null) {
            customers.remove(customer);
            System.out.println("Customer removed successfully");
        } else {
            System.out.println("Customer not found");
        }
    }

    public Customer getCustomer(int customerId) {

        for (Customer customer : customers) {

            if (customer.getId() == customerId) {
                return customer;
            }
        }

        return null;
    }

    public Product getProductById(int productId) {

        for (Product product : products) {

            if (product.getId() == productId) {
                return product;
            }
        }

        return null;
    }

    public void recordPurchase(int customerId, int productId) {

        Customer customer = getCustomer(customerId);
        Product product = getProductById(productId);

        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }

        if (product == null) {
            System.out.println("Product not found");
            return;
        }

        customer.addProduct(product);

        Transaction transaction = new Transaction(
                customerId,
                productId,
                TransactionType.PURCHASE
        );

        transactions.add(transaction);
        logTransaction(transaction.toString());

        System.out.println("Purchase successful");
    }

    public void recordReturn(int customerId, int productId) {

        Customer customer = getCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }

        try {

            customer.removeProduct(productId);

            Transaction transaction = new Transaction(
                    customerId,
                    productId,
                    TransactionType.RETURN
            );

            transactions.add(transaction);
            logTransaction(transaction.toString());

            System.out.println("Return successful");

        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
    }

    public void displayAllCustomers() {

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void displayAllProducts() {

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Transaction getPurchase(int customerId, int productId) {

        for (Transaction transaction : transactions) {

            if (transaction.getCustomerId() == customerId
                    && transaction.getProductId() == productId
                    && transaction.getTransactionType() == TransactionType.PURCHASE) {

                return transaction;
            }
        }

        return null;
    }

    public Transaction getReturn(int customerId, int productId) {

        for (Transaction transaction : transactions) {

            if (transaction.getCustomerId() == customerId
                    && transaction.getProductId() == productId
                    && transaction.getTransactionType() == TransactionType.RETURN) {

                return transaction;
            }
        }

        return null;
    }

    public void logTransaction(String message) {

        String filePath = "./file.txt";

        try (FileOutputStream fout = new FileOutputStream(filePath, true)) {

            fout.write((message + "\n").getBytes());

        } catch (IOException e) {

            System.out.println("Unable to write file");
        }
    }
}
