package com.bharath.lms.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.lms.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
