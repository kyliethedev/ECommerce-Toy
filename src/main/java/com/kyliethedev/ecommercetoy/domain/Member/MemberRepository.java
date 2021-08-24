package com.kyliethedev.ecommercetoy.domain.Member;

import com.kyliethedev.ecommercetoy.domain.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m ORDER BY m.id DESC")
    List<Member> findAllDesc();
}
