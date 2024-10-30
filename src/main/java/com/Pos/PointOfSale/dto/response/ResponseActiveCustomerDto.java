package com.Pos.PointOfSale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseActiveCustomerDto {
    private String customerName;
    private ArrayList<String> contactNumbers;

}
