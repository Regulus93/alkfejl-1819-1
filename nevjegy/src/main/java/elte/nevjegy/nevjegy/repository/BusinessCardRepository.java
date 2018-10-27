package elte.nevjegy.nevjegy.repository;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessCardRepository extends CrudRepository<BusinessCard, Integer> {

    @Override
    List<BusinessCard> findAll();
}
