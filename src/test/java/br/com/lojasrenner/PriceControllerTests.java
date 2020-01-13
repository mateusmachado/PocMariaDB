package br.com.lojasrenner;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTests {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testCreatePrice() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/price"), HttpMethod.POST, entity, String.class);
       
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        
        assertTrue(actual.contains("/price"));
    }    

    @Test
    public void testRetrievePrice() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/price/1"), HttpMethod.GET, entity, String.class);

        String expected = "{\"productId\":1,\"description\":\"camisa\"}";
        
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
 
}

