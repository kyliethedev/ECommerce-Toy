package com.kyliethedev.ecommercetoy.domain.item;

import com.kyliethedev.ecommercetoy.web.dto.Item.ItemSaveRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Long saveItem(ItemSaveRequestDto requestDto);
    List<Item> findByName(String name);
}
