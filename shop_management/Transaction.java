package shop_management;

import java.time.LocalDateTime;

public class Transaction {

    private static int idGenerator = 3000;

    private int id;
    private int customerId;
    private int productId;
    private TransactionType transactionType;
    private LocalDateTime timestamp;

    public Transaction(int customerId, int productId,
                       TransactionType transactionType) {

        this.id = idGenerator++;
        this.customerId = customerId;
        this.productId = productId;
        this.transactionType = transactionType;
        this.timestamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id
                + ", customerId=" + customerId
                + ", productId=" + productId
                + ", type=" + transactionType
                + ", time=" + timestamp + "]";
    }
}
