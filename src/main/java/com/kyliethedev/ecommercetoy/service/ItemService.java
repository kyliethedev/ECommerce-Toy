package com.kyliethedev.ecommercetoy.service;

import com.kyliethedev.ecommercetoy.domain.item.Item;
import com.kyliethedev.ecommercetoy.domain.item.ItemRepository;
import com.kyliethedev.ecommercetoy.web.dto.Item.ItemSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public Long saveItem(ItemSaveRequestDto requestDto) {
        return itemRepository.saveItem(requestDto);
    }

    public List<Item> findByName(String name) {
        return itemRepository.findByName(name);
    }
}
