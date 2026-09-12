package shop_management;

import java.util.Scanner;

public class ShopMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop();

        int choice;

        do {

            System.out.println("\n===== SHOP MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Add Customer");
            System.out.println("4. Remove Customer");
            System.out.println("5. Display All Products");
            System.out.println("6. Display All Customers");
            System.out.println("7. Purchase Product");
            System.out.println("8. Return Product");
            System.out.println("9. Display Customer Products");
            System.out.println("10. Calculate Customer Bill");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter product name: ");
                    String productName = sc.next();

                    System.out.print("Enter product price: ");
                    int price = sc.nextInt();

                    Product product = new Product(productName, price);
                    shop.addProduct(product);

                    System.out.println("Product added successfully");
                    System.out.println("Product ID: " + product.getId());
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int productId = sc.nextInt();

                    shop.removeProduct(productId);
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    String customerName = sc.next();

                    System.out.print("Enter contact number: ");
                    long contactNumber = sc.nextLong();

                    Customer customer = new Customer(customerName, contactNumber);
                    shop.addCustomer(customer);

                    System.out.println("Customer added successfully");
                    System.out.println("Customer ID: " + customer.getId());
                    break;

                case 4:
                    System.out.print("Enter customer ID: ");
                    int customerId = sc.nextInt();

                    shop.removeCustomer(customerId);
                    break;

                case 5:
                    System.out.println("\n----- ALL PRODUCTS -----");
                    shop.displayAllProducts();
                    break;

                case 6:
                    System.out.println("\n----- ALL CUSTOMERS -----");
                    shop.displayAllCustomers();
                    break;

                case 7:
                    System.out.print("Enter customer ID: ");
                    int purchaseCustomerId = sc.nextInt();

                    System.out.print("Enter product ID: ");
                    int purchaseProductId = sc.nextInt();

                    shop.recordPurchase(
                            purchaseCustomerId,
                            purchaseProductId
                    );
                    break;

                case 8:
                    System.out.print("Enter customer ID: ");
                    int returnCustomerId = sc.nextInt();

                    System.out.print("Enter product ID: ");
                    int returnProductId = sc.nextInt();

                    shop.recordReturn(
                            returnCustomerId,
                            returnProductId
                    );
                    break;

                case 9:
                    System.out.print("Enter customer ID: ");
                    int displayCustomerId = sc.nextInt();

                    Customer currentCustomer =
                            shop.getCustomer(displayCustomerId);

                    if (currentCustomer != null) {
                        System.out.println("----- PURCHASED PRODUCTS -----");
                        currentCustomer.displayAllProduct();
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;

                case 10:
                    System.out.print("Enter customer ID: ");
                    int billCustomerId = sc.nextInt();

                    Customer billCustomer =
                            shop.getCustomer(billCustomerId);

                    if (billCustomer != null) {
                        int total = billCustomer.calculateBill();
                        System.out.println("Total Bill = " + total);
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using Shop Management System");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
