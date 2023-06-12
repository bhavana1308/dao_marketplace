package org.solvd.com.dao.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "discountsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiscountsList {

    @XmlElement(name = "discount")
    private List<Discounts> discountsList = null;

    public List<Discounts> getDiscountsList() {
        return discountsList;
    }

    public void setDiscountsList(List<Discounts> discountsList) {
        this.discountsList = discountsList;
    }
}
