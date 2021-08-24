package com.kyliethedev.ecommercetoy.web.dto.Member;

import com.kyliethedev.ecommercetoy.domain.Address;
import com.kyliethedev.ecommercetoy.domain.Member.Member;
import com.kyliethedev.ecommercetoy.domain.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class MemberSignUpRequestDto {
    private String name;
    private Address address;

    @Builder
    public MemberSignUpRequestDto(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .address(address)
                .build();
    }
}
