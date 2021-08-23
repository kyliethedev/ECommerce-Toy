package com.kyliethedev.ecommercetoy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    // Setter
    private void setId(Long id) { this.id = id; }
    private void setOrder(Order order) { this.order = order; }
    private void setAddress(Address address) { this.address = address; }
    private void setStatus(DeliveryStatus status) { this.status = status; }
}
