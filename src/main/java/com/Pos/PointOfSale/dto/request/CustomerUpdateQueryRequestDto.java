package com.Pos.PointOfSale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerUpdateQueryRequestDto {
    private String customerName;
    private String nic;
}
