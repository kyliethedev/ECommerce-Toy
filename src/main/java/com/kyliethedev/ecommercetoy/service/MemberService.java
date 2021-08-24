package com.kyliethedev.ecommercetoy.service;

import com.kyliethedev.ecommercetoy.domain.Member.Member;
import com.kyliethedev.ecommercetoy.domain.Member.MemberRepository;
import com.kyliethedev.ecommercetoy.web.dto.Member.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    //Sign Up
    public Long signUp(MemberSignUpRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }
}
