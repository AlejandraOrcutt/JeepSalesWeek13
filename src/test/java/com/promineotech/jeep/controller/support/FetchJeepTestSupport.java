package com.promineotech.jeep.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import org.springframework.http.HttpMethod;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
    "classpath:flyway/migrations/V1.1__Jeep_Data.sql"
  }, 
  config = @SqlConfig(encoding = "utf-8")
)

public class FetchJeepTestSupport {

  @Autowired
  private TestRestTemplate restTemplate;

  @LocalServerPort
  private int serverPort;
  

  protected TestRestTemplate getRestTemplate() {
    return restTemplate;
    
  }

  @Test
  protected void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
    // Given: a valid model, trim and URI
    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
    String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
    
    // When: a connection is made to the URI
    ResponseEntity<List<Jeep>> response = 
        restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Jeep>>() {});
    
    // Then: a success (OK - 200) status code is returned
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    
    // And: the actual list returned is the same as the expected list
    List<Jeep> expected = buildExpected();
    assertThat(response.getBody()).isEqualTo(expected);
  }

  protected String getBaseUri() {
    return "http://localhost:" + serverPort + "/jeeps";
  }

  protected List<Jeep> buildExpected() {
    return null;
    // Method to build the expected list of Jeeps
    
  }
}