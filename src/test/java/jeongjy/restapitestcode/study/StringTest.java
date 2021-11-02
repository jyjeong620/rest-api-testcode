package jeongjy.restapitestcode.study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  /*
   * “1,2”을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
   */
  @Test
  @DisplayName("Split 예제")
  void SplitTest(){
    //given
    final String data = "1,2";

    //when
    final String[] splitData = data.split(",");

    //then
    assertThat(splitData).contains("1","2");
  }

  /*
   * “1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
   */
  @Test
  @DisplayName("Split 예제 2")
  void SplitTest2(){
    //given
    final String data = "1";

    //when
    final String[] splitData = data.split(",");

    //then
    assertThat(splitData).containsExactly("1");
  }

  /*
   * “(1,2)” 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 “1,2"를 반환하도록 구현한다.
   */
  @Test
  void eraseParenthesis(){
    //given
    final String data = "(1,2)";

    //when
    final String eraseData = data.substring(1, data.length() - 1);

    //then
    assertThat(eraseData).isEqualTo("1,2");
  }
}
