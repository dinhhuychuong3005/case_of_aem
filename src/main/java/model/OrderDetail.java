package model;

public class OrderDetail {
    private int orderId;
    private int productId;
    private int quantityOd;
    private double total;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, int productId, int quantityOd, double total) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantityOd = quantityOd;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityOd() {
        return quantityOd;
    }

    public void setQuantityOd(int quantityOd) {
        this.quantityOd = quantityOd;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", quantityOd=" + quantityOd +
                ", total=" + total +
                '}';
    }
}
