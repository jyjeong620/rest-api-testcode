package jeongjy.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebClientController {

  private final WebClientService webClientService;

  @GetMapping("/web/test")
  public ResponseEntity WebClientCall() {

    return this.webClientService.searchCall();
  }
}
