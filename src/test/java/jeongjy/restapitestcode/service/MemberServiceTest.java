package jeongjy.restapitestcode.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;
import jeongjy.restapitestcode.dto.Member;
import jeongjy.restapitestcode.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

  @Mock
  MemberRepository memberRepository;

  @InjectMocks
  MemberService memberService;


  @DisplayName("중복되는 회원이 있을경우 Exception 반환한다")
  @Test
  void duplicateMember() {
    final Member member = new Member();
    member.setName("jeongjy");
    member.setPassword("1234");

    Mockito.when(this.memberRepository.findByName(member.getName())).thenReturn(Optional.of(member));

    assertThatThrownBy(() -> this.memberService.join(member)).isInstanceOf(
        IllegalStateException.class);
  }

}