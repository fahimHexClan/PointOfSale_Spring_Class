package com.Pos.PointOfSale.Entity;

import com.Pos.PointOfSale.Entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "item")


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemEntity {
    @Id
    @Column(name = "item_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "mesuring_unit", length = 100, nullable = false)
    private MeasuringUnitType measuringUnit;// a enum eke thiyana data tika meyata use wenawa

    @Column(name = "balance_qty", length = 100, nullable = false)
    private Double balanceQty;

    @Column(name = "supplier_price", length = 100, nullable = false)
    private Double supplierPrice;

    @Column(name = "selling_price", length = 100, nullable = false)
    private Double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private Boolean activeState;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetailsEntity> orderDetails;

}
