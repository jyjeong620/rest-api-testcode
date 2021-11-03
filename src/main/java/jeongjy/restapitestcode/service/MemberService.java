package jeongjy.restapitestcode.service;

import java.util.Optional;
import jeongjy.restapitestcode.dto.Member;
import jeongjy.restapitestcode.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public Long join(final Member member) {
    this.memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

    this.memberRepository.save(member);
    return member.getId();
  }

  public Boolean login(final Member member) {
    final Optional<Member> byNameMember = this.memberRepository.findByName(member.getName());
    return byNameMember.map(value -> value.getPassword().equals(member.getPassword()))
        .orElse(false);

  }
}
