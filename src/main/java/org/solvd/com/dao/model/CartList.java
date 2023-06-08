package org.solvd.com.dao.model;

public class CartList {

    private int cartId;
    private int buyerId;
    private int productId;
    private int quantity;

    public CartList(int cartId, int buyerId, int productId, int quantity) {
        this.cartId = cartId;
        this.buyerId = buyerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartList() {

    }

    public CartList(int cartId) {
        this.cartId = cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartList{" +
                "cartId=" + cartId +
                ", buyerId=" + buyerId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
