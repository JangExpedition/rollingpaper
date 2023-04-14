package com.kh.rollingpaper.member.model.service;

import java.util.List;

import com.kh.rollingpaper.member.model.dto.Member;

public interface MemberService {

	Member selectOneMember(String name);

	List<Member> selectAllMember(Member loginMember);

	int insertMember(Member member);

	int updateMember(Member member);

	Member selectOneMemberByNo(int no);

}
