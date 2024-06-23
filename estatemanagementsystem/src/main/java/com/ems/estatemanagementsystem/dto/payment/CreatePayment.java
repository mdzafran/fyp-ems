package com.ems.estatemanagementsystem.dto.payment;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreatePayment {
        @SerializedName("items")
        Object[] items;

        @SerializedName("amount")
        Long amount;

        public Object[] getItems() {
            return items;
        }

        public Long getAmount() {
            return amount;
        }
}
