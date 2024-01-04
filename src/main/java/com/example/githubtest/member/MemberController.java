package com.example.githubtest.member;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/member")
	public List<Member>  getMember(){
		return  service.getMember();
	}

	@GetMapping("/member/{id}")
	public ResponseEntity<Member> getMemberById(@PathVariable String id) {
		Member member = service.getOneMember(id);

		if (member != null) {
			return new ResponseEntity<>(member, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
