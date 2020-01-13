package br.com.lojasrenner.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.lojasrenner.infrastructure.entity.Price;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer>{

}
