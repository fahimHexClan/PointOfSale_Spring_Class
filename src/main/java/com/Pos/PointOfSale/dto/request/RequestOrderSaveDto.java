package com.Pos.PointOfSale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDto {
    private int customer;//api meke id eka wthrai ne ganne
    private Date date;
    private double total;
    private List<RequestOrderDetailSaveDto> orderDetails;
}

