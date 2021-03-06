package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return
     */
    public long join(Member member){

        //중복 회원은 가입 불가
        validateDuplicateMember(member);//중복회원 검증

        memberRepository.save(member);
        return member.getId();
    }//join

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }//validateDuplicateMember

    /**
     * 전체 회원조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }//findMembers

    public Optional<Member> findOne(long memberId){
        return memberRepository.findById(memberId);
    }//findOne
}//class