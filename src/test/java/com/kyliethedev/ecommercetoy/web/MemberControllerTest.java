package com.kyliethedev.ecommercetoy.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyliethedev.ecommercetoy.domain.Address;
import com.kyliethedev.ecommercetoy.domain.Member.Member;
import com.kyliethedev.ecommercetoy.domain.Member.MemberRepository;
import com.kyliethedev.ecommercetoy.web.dto.Member.MemberSignUpRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        memberRepository.deleteAll();
    }

    @Test
    public void memberSignUp() throws Exception {
        //given
        String name = "test";
        String city = "seoul";
        String street = "olympic-ro";
        String zipcode = "12345";

        Address address = Address.builder()
                .city(city)
                .street(street)
                .zipcode(zipcode)
                .build();

        MemberSignUpRequestDto requestDto = MemberSignUpRequestDto.builder()
                .name(name)
                .address(address)
                .build();

        String url = "http://localhost:" + port + "/api/v1/member";

        //when
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andDo(print())
                .andExpect(status().isOk());

        //then
        List<Member> members = memberRepository.findAll();
        assertThat(members.get(0).getName()).isEqualTo(name);
        assertThat(members.get(0).getAddress().getCity()).isEqualTo(city);
        assertThat(members.get(0).getAddress().getStreet()).isEqualTo(street);
        assertThat(members.get(0).getAddress().getZipcode()).isEqualTo(zipcode);
    }
}
