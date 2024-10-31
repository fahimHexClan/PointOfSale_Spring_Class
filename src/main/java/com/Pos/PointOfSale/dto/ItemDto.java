package com.Pos.PointOfSale.dto;

import com.Pos.PointOfSale.Entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto {
    private int itemId;
    private String itemName;
    private MeasuringUnitType measuringUnit;// a enum eke thiyana data tika meyata use wenawa
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;

}
