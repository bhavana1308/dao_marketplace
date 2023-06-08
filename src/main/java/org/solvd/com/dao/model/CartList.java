package org.solvd.com.dao.model;

public class CartList {

    private int cartId;
    private int quantity;

    public CartList(int cartId, int quantity) {
        this.cartId = cartId;
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
                ", quantity=" + quantity +
                '}';
    }
}
