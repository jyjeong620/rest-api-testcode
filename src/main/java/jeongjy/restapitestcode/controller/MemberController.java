package jeongjy.restapitestcode.controller;


import javax.validation.Valid;
import jeongjy.restapitestcode.dto.Member;
import jeongjy.restapitestcode.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/join")
  public String join(final String name, final String password) {

    final Member member = new Member();
    member.setName(name);
    member.setPassword(password);

    return this.memberService.join(member);
  }

  @GetMapping("/login")
  public Boolean login(@RequestBody @Valid final Member member) {

    log.info("name : " + member.getName());
    log.info("pwd : " + member.getPassword());
    return this.memberService.login(member);
  }
}
