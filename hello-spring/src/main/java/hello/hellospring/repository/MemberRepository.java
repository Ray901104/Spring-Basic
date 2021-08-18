package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 저장
    Optional<Member> findById(long id);
    Optional<Member> findByName(String name);
//    Optional<Member> findById(Long id);
    List<Member> findAll();//모든 회원 리스트 조회

}
