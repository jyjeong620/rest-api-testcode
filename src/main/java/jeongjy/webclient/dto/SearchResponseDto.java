package jeongjy.webclient.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class SearchResponseDto {

  private double elapsedTime;
  private String query;
  private List<LiveSearchResponseDto> data;


  @Getter
  public static class LiveSearchResponseDto {

    private String contentsID;
    private String title;
    private float reviewPoint;      // 별점
    private int freeVol;            // 무료 수
    private int discountRate;           // 할인(냥)
    private int likeCount;          // 좋아요 (클립)
    private int viewCount;          // 조회수 (눈모양)
    private Author authors;

    @Getter
    private static class Author {
      private String writer;
      private String painter;
    }
  }

}
