package org.solvd.com.dao.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.List;

@JsonRootName(value = "DiscountsList")
public class DiscountsList {

    @JsonProperty("discounts")
    private List<Discount> discountsList = new ArrayList<>();

    public List<Discount> getDiscountsList() {
        return discountsList;
    }

    public void setDiscountsList(List<Discount> discountsList) {
        this.discountsList = discountsList;
    }
}
