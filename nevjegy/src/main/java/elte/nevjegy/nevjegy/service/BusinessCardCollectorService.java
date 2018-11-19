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

    public BusinessCard createBusinessCard(BusinessCard businessCard) throws Exception {
        return businessCardCollectorDao.createUpdateBusinessCard(businessCard);
    }

    public BusinessCard updateBusinessCard(BusinessCard businessCard) throws Exception {
        return businessCardCollectorDao.createUpdateBusinessCard(businessCard);
    }

    public BusinessCard deleteBusinessCard(int bcId)throws Exception  {
        return businessCardCollectorDao.deleteBusinessCard(bcId);
    }

    public BusinessCard collectBusinessCard(int bcId)throws Exception  {
        return businessCardCollectorDao.collectBusinessCard(bcId);
    }

    public BusinessCard dropBusinessCard(int bcId)throws Exception  {
        return businessCardCollectorDao.dropBusinessCard(bcId);
    }

    public Feedback addFeedback(int bcId, Feedback feedback)throws Exception  {
        return businessCardCollectorDao.addFeedback(bcId, feedback);
    }

    public Feedback removeFeedback(int id) throws Exception {
        return businessCardCollectorDao.removeFeedback(id);
    }

}
