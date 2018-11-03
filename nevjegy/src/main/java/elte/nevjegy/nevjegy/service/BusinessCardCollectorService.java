package elte.nevjegy.nevjegy.service;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.model.BusinessCardCollectorDao;
import elte.nevjegy.nevjegy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessCardCollectorService {

    @Autowired
    private UserRepository userRepository;

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

    public int createBusinessCard(BusinessCard businessCard){
        return businessCardCollectorDao.createUpdateBusinessCard(businessCard);
    }

    public int updateBusinessCard(BusinessCard businessCard){
        return businessCardCollectorDao.createUpdateBusinessCard(businessCard);
    }

    public void deleteBusinessCard(int bcId){

        businessCardCollectorDao.deleteBusinessCard(bcId);
    }

    public void collectBusinessCard(int bcId, User user){
        businessCardCollectorDao.collectBusinessCard(bcId, user);
    }

    public void addFeedback(int bcId, Feedback feedback){
        businessCardCollectorDao.addFeedBack(bcId, feedback);
    }

    public void deleteBusinessCardAdmin(int bcId) {
        businessCardCollectorDao.deleteBusinessCardAdmin(bcId);
    }
}
