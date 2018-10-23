package elte.nevjegy.nevjegy.model;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
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

    public BusinessCard getBcById(int bcId) {
        return businessCardRepository.findById(bcId)
                .orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
    }

    public List<Feedback> getFeedbacks(int bcId) {
        return businessCardRepository.findById(bcId)
                .orElseThrow(() -> new RuntimeException("No Business Card found with the given id!")).getFeedbacks();
    }

    public int createUpdateBusinessCard(BusinessCard businessCard) {
        return businessCardRepository.save(businessCard).getId();
    }

    public void deleteBusinessCard(int bcId) {
        businessCardRepository.deleteById(bcId);
    }

    public void collectBusinessCard(int bcId, User user) {
        BusinessCard bc = businessCardRepository.findById(bcId).orElse(null);
        if (bc != null) {
            user.getBusinessCard().add(bc);
        }
    }

    public void addFeedBack(int bcId, Feedback feedback) {
        BusinessCard bc = businessCardRepository.findById(bcId).orElse(null);
        if (bc != null) {
            bc.getFeedbacks().add(feedback);
        }
    }
}
