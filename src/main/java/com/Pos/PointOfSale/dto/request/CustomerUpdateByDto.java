package com.Pos.PointOfSale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerUpdateByDto {
    private String customerName;
    private double customerSalary;
    private String nic;
}
