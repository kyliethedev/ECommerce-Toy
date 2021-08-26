package com.kyliethedev.ecommercetoy.domain.item;

import com.kyliethedev.ecommercetoy.web.dto.Item.ItemSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ItemRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ItemRepository repository;

    public void saveItem(ItemSaveRequestDto requestDto) {
        if (requestDto.getId() == null) {
            em.persist(requestDto);
        }
        else {
            em.merge(requestDto);
        }
    }

    public List<Item> findByName(String name) {
        return em.createQuery("SELECT i FROM item i WHERE i.name = :name")
                .setParameter("name", name)
                .getResultList();
    }
}
