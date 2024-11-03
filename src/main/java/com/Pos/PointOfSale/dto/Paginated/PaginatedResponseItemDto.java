package com.Pos.PointOfSale.dto.Paginated;

import com.Pos.PointOfSale.Entity.enums.MeasuringUnitType;
import com.Pos.PointOfSale.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseItemDto {// paginated kiynne websites wela pages kadaia thiyanne anna ewage pages use karanna
    private List<ItemDto> List;
   private long dataCount;


}
