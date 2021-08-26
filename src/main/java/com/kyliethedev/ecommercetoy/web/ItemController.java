package com.kyliethedev.ecommercetoy.web;

import com.kyliethedev.ecommercetoy.service.ItemService;
import com.kyliethedev.ecommercetoy.web.dto.Item.ItemSaveRequestDto;
import com.kyliethedev.ecommercetoy.web.dto.Member.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/api/v1/item")
    @ResponseBody
    public Long itemSave(@RequestBody ItemSaveRequestDto requestDto) {
        return itemService.saveItem(requestDto);
    }
}
