package com.kyliethedev.ecommercetoy.web;

import com.kyliethedev.ecommercetoy.service.MemberService;
import com.kyliethedev.ecommercetoy.web.dto.Member.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/v1/member")
    @ResponseBody
    public Long signUp(@RequestBody MemberSignUpRequestDto requestDto) {
        return memberService.signUp(requestDto);
    }
}
