package org.solvd.com.dao.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "buyers")
@XmlAccessorType(XmlAccessType.FIELD)
public class BuyersList {

    @XmlElement(name = "buyer")
    private List<Buyer> buyersList = new ArrayList<>();

    public List<Buyer> getBuyersList() {
        return buyersList;
    }

    public void setBuyersList(List<Buyer> buyersList) {
        this.buyersList = buyersList;
    }
}
