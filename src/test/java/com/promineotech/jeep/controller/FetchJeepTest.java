package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import lombok.Getter;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class FetchJeepTest extends FetchJeepTestSupport {
  
//  @Autowired
//  @Getter
//  private TestRestTemplate restTemplate;
//
//  @LocalServerPort
//  private int serverPort;

  @Test
  
 public void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
   // given a valid model, trim and URI
    JeepModel model   = JeepModel.WRANGLER;
    String trim ="Sport";
    String uri = String.format("%s?model=%s&trim=%s",getBaseUri(), model, trim);
    
    
   // when: a connection is made to the URI
    
    ResponseEntity<Jeep>  response = 
        // ****
        getRestTemplate().getForEntity(uri, Jeep.class );
    
 //**or could be this?*** getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Jeep>>() {});

      
      
   // then: a success (OK- 200) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
 
   // And: the actual list returned is the same as the expected list
    List<Jeep> expected = buildExpected();
    System.out.println(expected);
    assertThat(response.getBody()).isEqualTo(expected);
}
    
 
    
  }




