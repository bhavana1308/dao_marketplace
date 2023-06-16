package org.solvd.com.dao.jaxb;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "discountsList")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiscountsList {

    @XmlElement(name = "discount")
    private List<Discounts> discountsList = new ArrayList<>();

    public List<Discounts> getDiscountsList() {
        return discountsList;
    }

    public void setDiscountsList(List<Discounts> discountsList) {
        this.discountsList = discountsList;
    }
}
