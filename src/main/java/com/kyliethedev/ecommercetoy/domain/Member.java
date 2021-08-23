package com.kyliethedev.ecommercetoy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    // Setter
    public void setId(long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(Address address) { this.address = address; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}
