package com.kyliethedev.ecommercetoy.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyliethedev.ecommercetoy.domain.item.ItemRepository;
import com.kyliethedev.ecommercetoy.web.dto.Item.ItemSaveRequestDto;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ItemRepository itemRepository;

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
        itemRepository.deleteAll();
    }

    @Test
    public void itemSave() {
        //given
        String name = "name";
        int price = 1000;
        int stockQuantity = 5;
        String artist = "artist";
        String etc = "etc";

        ItemSaveRequestDto requestDto = ItemSaveRequestDto.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();

        String url = "http://localhost:" + port + "/api/v1/item";

        //when
//        mockMvc.perform(post(url)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(requestDto))
//                .andDo(print())
//                .andExpect(status().isOk()));

        //then
    }
}
