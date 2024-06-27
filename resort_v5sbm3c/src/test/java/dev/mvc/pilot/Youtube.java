package dev.mvc.pilot;

import dev.mvc.tool.Tool;

public class Youtube {

  public static void main(String[] args) {
    String url="<iframe width=\"1280\" height=\"720\" src=\"https://www.youtube.com/embed/AkZ-fn5hqBo\" title=\"[안녕첫차] 허위매물 잡다 허위딜러 돼 버리기 사기꾼 봐주는 척 속여버리기\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";
    Tool.youtubeResize(url, 640);

  }

}
