package elte.nevjegy.nevjegy.service;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.model.BusinessCardCollectorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessCardCollectorService {

    @Autowired
    private BusinessCardCollectorDao businessCardCollectorDao;

    public List getAllBc() {
        return businessCardCollectorDao.getAllBc();
    }

    public BusinessCard getBcById(int bcId) {
        return businessCardCollectorDao.getBcById(bcId);
    }

    public List getFeedbacks(int bcId) {
        return businessCardCollectorDao.getFeedbacks(bcId);
    }

    public BusinessCard createBusinessCard(BusinessCard businessCard) {
        return businessCardCollectorDao.createUpdateBusinessCard(businessCard);
    }

    public BusinessCard updateBusinessCard(BusinessCard businessCard) {
        return businessCardCollectorDao.createUpdateBusinessCard(businessCard);
    }

    public BusinessCard deleteBusinessCard(int bcId) {
        return businessCardCollectorDao.deleteBusinessCard(bcId);
    }

    public BusinessCard collectBusinessCard(int bcId) {
        return businessCardCollectorDao.collectBusinessCard(bcId);
    }

    public BusinessCard dropBusinessCard(int bcId) {
        return businessCardCollectorDao.dropBusinessCard(bcId);
    }

    public Feedback addFeedback(int bcId, Feedback feedback) {
        return businessCardCollectorDao.addFeedback(bcId, feedback);
    }

    public Feedback removeFeedback(int id) {
        return businessCardCollectorDao.removeFeedback(id);
    }

}
