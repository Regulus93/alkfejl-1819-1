package elte.nevjegy.nevjegy.model;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.repository.BusinessCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BusinessCardCollectorDao {

    @Autowired
    private BusinessCardRepository businessCardRepository;

    public List getAllBc() {
        return businessCardRepository.findAll();
    }

    public List<Feedback> getFeedbacks(int bcId) {
        return businessCardRepository.findById(bcId).orElseGet(BusinessCard::new).getFeedbacks();
    }

    public int createUpdateBusinessCard(BusinessCard businessCard){
        return businessCardRepository.save(businessCard).getId();
    }
}
