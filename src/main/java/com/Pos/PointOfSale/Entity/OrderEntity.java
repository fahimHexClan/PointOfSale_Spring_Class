package com.Pos.PointOfSale.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "orders")


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {
    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;//customer entity eken dana mapby ethule thiyana eken thma  meken referance ekata hadanna onaa
    //Baeldung website eken apping gena kiyala thiyanawa
    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date;
}
