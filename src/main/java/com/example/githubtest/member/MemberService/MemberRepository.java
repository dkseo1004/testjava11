package com.example.githubtest.member.MemberService;

import org.springframework.data.repository.CrudRepository;

import com.example.githubtest.member.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
}
