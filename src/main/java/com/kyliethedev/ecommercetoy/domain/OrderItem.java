package com.kyliethedev.ecommercetoy.domain;

import com.kyliethedev.ecommercetoy.domain.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "ORDER_ITEM")
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;
    private int count;

    // Setter
    public void setId(Long id) { this.id = id; }
    public void setItem(Item item) { this.item = item; }
    public void setOrder(Order order) { this.order = order; }
    public void setOrderPrice(int orderPrice) { this.orderPrice = orderPrice; }
    public void setCount(int count) { this.count = count; }
}
