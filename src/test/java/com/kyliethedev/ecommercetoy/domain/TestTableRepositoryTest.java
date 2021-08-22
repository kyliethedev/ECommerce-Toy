package com.kyliethedev.ecommercetoy.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestTableRepositoryTest {

    @Autowired
    TestTableRepository testTableRepository;

    @AfterEach
    public void cleanUp() { testTableRepository.deleteAll(); };

    @Test
    public void getTestTable() {
        //given
        int id = 1;
        String name = "홍길동";

        testTableRepository.save(TestTable.builder()
                .id(id)
                .name(name)
                .build());

        //when
        List<TestTable> list = testTableRepository.findAll();

        //then
        TestTable testTable = list.get(0);
        assertThat(testTable.getId()).isEqualTo(id);
        assertThat(testTable.getName()).isEqualTo(name);
    }
}
