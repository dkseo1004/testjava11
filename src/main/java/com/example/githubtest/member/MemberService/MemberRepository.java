package com.example.githubtest.member.MemberService;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.githubtest.member.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
	Optional<Member> findByName(String name);
}
