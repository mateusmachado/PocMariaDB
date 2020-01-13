package br.com.lojasrenner.api.v1.controller;

import java.net.URI;

import br.com.lojasrenner.service.PriceService;
import br.com.lojasrenner.infrastructure.entity.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PriceController {
    @Autowired
    private PriceService priceService;
 
    @PostMapping("/price")
    public ResponseEntity<Void> createPrice() {
        priceService.createPrice();
      
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }
    
    @GetMapping("/price/{productId}")
    public Price retrievePrice(@PathVariable Integer productId) {
        return priceService.retrievePrice(productId);
       
    }

}
