package org.solvd.com.dao.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CartList {

    @XmlElement
    private int cartId;

    @XmlElement
    private int quantity;

    @XmlElement
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
                "cartId=" + cartId +
                ", quantity=" + quantity +
                '}';
    }
}
