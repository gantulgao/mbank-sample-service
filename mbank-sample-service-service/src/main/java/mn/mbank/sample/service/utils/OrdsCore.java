package mn.mbank.sample.service.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrdsCore {

    private final RestTemplate rest;

    public String getOrds(String ords_url, HttpMethod method, String body) {

        HttpHeaders header = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity(body, header);
        log.debug("URL:{}", ords_url);
        ResponseEntity<String> res = this.rest.exchange(ords_url, method, entity, String.class);
        log.debug("Raw res:{}", res);
        return (String)res.getBody();

    }

}
