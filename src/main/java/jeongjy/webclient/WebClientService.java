package jeongjy.webclient;


import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import jeongjy.webclient.dto.SearchResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

//@RequiredArgsConstructor
@Service
public class WebClientService {

  private WebClient webClient;

  private void init(){
    final HttpClient httpClient = HttpClient.create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
        .responseTimeout(Duration.ofMillis(5000))
        .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
            .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));


    this.webClient =  WebClient.builder()
//        .baseUrl("http://localhost:9000")
//        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//        .clientConnector(new ReactorClientHttpConnector(httpClient))
        .build();
  }

  public ResponseEntity searchCall() {
    this.init();

    final SearchResponseDto block1 = this.webClient.get()
        .uri("http://localhost:9000/api/v1/search/live?query=ehtnf")
        .header("X-Client-Platform", "ios/13.3")
        .header("X-Client-Agent", "chakra-api/1.0.0")
        .retrieve()
        .bodyToMono(SearchResponseDto.class)
        .block();


    return ResponseEntity.ok(block1);
  }
}
