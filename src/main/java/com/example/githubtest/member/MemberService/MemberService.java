package com.example.githubtest.member.MemberService;

import org.springframework.stereotype.Service;

import com.example.githubtest.member.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository repository;

	public Member addMember(Member member) {
		Member save = repository.save(member);
		return  save;
	}
}
