package org.solvd.com.dao.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

@JsonRootName(value = "Cart List")
public class CartList {

    @JsonProperty("cartId")
    private int cartId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("createdDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdDate;

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


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "CartList{" +
                "\n" + "cartId=" + cartId + "\n" +
                " quantity=" + quantity + "\n" +
                "createdDate=" + createdDate +
                '}';
    }
}
