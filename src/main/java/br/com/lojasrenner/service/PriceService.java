package br.com.lojasrenner.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.lojasrenner.infrastructure.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lojasrenner.infrastructure.entity.Price;

@Component
public class PriceService {

    @Autowired
    private PriceRepository repository;

    public List<Price> createPrice() {
        List<Price> prices = new ArrayList<Price>();
        List<Price> savedPrices = new ArrayList<Price>();

        prices.add(new Price(2, "camiseta", "", "", new BigDecimal(12), new BigDecimal(22), new BigDecimal(32), new BigDecimal(42), true, new BigDecimal(2233)));
        prices.add(new Price(3, "camiseta", "", "", new BigDecimal(13), new BigDecimal(23), new BigDecimal(33), new BigDecimal(43), true, new BigDecimal(4321)));
        prices.add(new Price(4, "camiseta", "", "", new BigDecimal(14), new BigDecimal(24), new BigDecimal(34), new BigDecimal(44), true, new BigDecimal(1234)));
        Iterable<Price> itrPrice=repository.saveAll(prices);
        itrPrice.forEach(savedPrices::add);

        return savedPrices;
    }

    public Price retrievePrice(Integer productId) {
       return repository.findById(productId).orElse(new Price());
  
    }
 
}
