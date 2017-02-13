/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textSearch;

import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 * @author hpollmann2
 */
public class StreetExtractor {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(StreetExtractor.class);
    
    public StreetExtractor() {
    }
    
    public List<Address> find(String searchStr) {
        searchStr += " Lincoln, Nebraska";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> entity = new HttpEntity<>(searchStr, headers);
        
        String authURL = ("https://us-extract.api.smartystreets.com?auth-id=a1286f97-cfa5-8f6e-81f7-1d159632c85a&auth-token=LpHJEMzaEt3XtTOEL3EU");
        UriComponents build = UriComponentsBuilder.fromHttpUrl(authURL).build();
        ResponseEntity<ExtractResponse> response = null;
        
        try {
            response = restTemplate.postForEntity(build.toUri(), entity, ExtractResponse.class);
        } catch (RestClientException e) {
            LOGGER.warn(e.getMessage());
        }
        
        return response.getBody().getAddresses();
    }
    
}
