package org.solvd.com.dao.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DiscountsList {

    @JsonProperty("discounts")
    private List<Discounts> discountsList = new ArrayList<>();

    public List<Discounts> getDiscountsList() {
        return discountsList;
    }

    public void setDiscountsList(List<Discounts> discountsList) {
        this.discountsList = discountsList;
    }
}
