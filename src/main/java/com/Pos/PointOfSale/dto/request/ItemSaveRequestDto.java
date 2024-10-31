package com.Pos.PointOfSale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemSaveRequestDto {
    private String itemName;
    private String measuringUnit;// frontend eken yawaddi String widihata yawala entity eken tma enumwidihat change wenne
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;

}
