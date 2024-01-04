package com.example.githubtest.member.MemberService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.githubtest.member.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository repository;

	public Member addMember(Member member) {
		Member save = repository.save(member);
		return save;
	}

	public List<Member> getMember() {
		return (List<Member>)repository.findAll();
	}


	public Member getOneMember(String id) {

		return repository.findById(id).orElseThrow(IllegalAccessError::new);
	}
}
