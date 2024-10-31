package com.Pos.PointOfSale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseCustomerFilterDto {
    private int customerId;
    private String customerAddress;
    private double customerSalary;

}
