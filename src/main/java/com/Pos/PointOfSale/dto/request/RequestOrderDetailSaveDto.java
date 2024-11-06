package com.Pos.PointOfSale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailSaveDto {

    private String itemName;
    private Double balanceQty;
    private Double amount;
    private int items;//meketh id witharai yawanne

}
