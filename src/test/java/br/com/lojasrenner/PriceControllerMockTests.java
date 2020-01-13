package br.com.lojasrenner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.lojasrenner.infrastructure.entity.Price;
import br.com.lojasrenner.infrastructure.repository.PriceRepository;
import br.com.lojasrenner.service.PriceService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerMockTests {

    @Autowired
    private PriceService priceService;
    
    @MockBean
    private PriceRepository priceRepository;
 
    @Test
    public void testRetrievePriceWithMockRepository() throws Exception {
  
        Optional<Price> optPrice = Optional.of( new Price(1, "camiseta", "", "", new BigDecimal(10), new BigDecimal(10), new BigDecimal(10), new BigDecimal(10), true, new BigDecimal(10)));
        when(priceRepository.findById(1)).thenReturn(optPrice);

        assertTrue(priceService.retrievePrice(1).getDescription().contains("camiseta"));
    }
 
}

