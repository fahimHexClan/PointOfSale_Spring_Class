package com.Pos.PointOfSale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetailsEntity {
    @Id
    @Column(name = "order_details_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Column(name = "balance_qty", length = 100, nullable = false)
    private Double balanceQty;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "order_Id",nullable = false)
    private OrderEntity orders;

    @ManyToOne
    @JoinColumn(name = "item_Id",nullable = false)
    private ItemEntity items;

}
