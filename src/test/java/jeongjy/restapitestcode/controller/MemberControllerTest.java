package jeongjy.restapitestcode.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jeongjy.restapitestcode.dto.Member;
import jeongjy.restapitestcode.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  MemberRepository memberRepository;

  @BeforeEach
  void beforeEach(){
    final Member member = new Member();
    member.setName("testName");
    member.setPassword("testPW");

    this.memberRepository.save(member);
  }


  @DisplayName("회원가입 성공시 id 반환")
  @Test
  void join() throws Exception {
    //given
    final Member member = new Member();
    member.setName("jeongjy");
    member.setPassword("12345");

    //when then
    this.mockMvc.perform(post("/join")
            .header("content-type", "application/json")
            .content(this.objectMapper.writeValueAsString(member)))
        .andExpect(status().isOk())
        ;
  }

  @DisplayName("로그인 성공시 true 반환")
  @Test
  void successLogin() throws Exception {
    //given
    final Member member = new Member();
    member.setName("testName");
    member.setPassword("testPW");

    //when then
    this.mockMvc.perform(get("/login")
            .header("content-type", "application/json")
            .content(this.objectMapper.writeValueAsString(member)))
        .andExpect(status().isOk())
        .andDo(print());
  }

  @DisplayName("로그인 실패시시 true 반환")
  @Test
  void failLogin() throws Exception {
    //given
    final Member member = new Member();
    member.setName("testName");
    member.setPassword("testPWdd");

    //when then
    this.mockMvc.perform(get("/login")
            .header("content-type", "application/json")
            .content(this.objectMapper.writeValueAsString(member)))
        .andExpect(status().isBadRequest())
        .andDo(print());
  }

}