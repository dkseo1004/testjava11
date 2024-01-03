package com.example.githubtest.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.githubtest.member.MemberService.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;

	@PostMapping("/member")
	public Member addMember(@RequestBody Member member){
		Member result = service.addMember(member);
		return  result;
	}
}
