package com.jpabook.jpashop.springjpa.api;


import com.jpabook.jpashop.springjpa.domain.Member;
import com.jpabook.jpashop.springjpa.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;


    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(
            @RequestBody @Valid Member member
    ) {
        System.out.println(member.getName());
        Long id = memberService.join(member);

        return new CreateMemberResponse(id);
    }

    @Data
    private class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }


}
