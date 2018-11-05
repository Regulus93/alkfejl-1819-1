package elte.nevjegy.nevjegy.repository;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessCardRepository extends CrudRepository<BusinessCard, Integer> {

    @Override
    List<BusinessCard> findAll();

    Optional<BusinessCard> findById(int integer);
}
