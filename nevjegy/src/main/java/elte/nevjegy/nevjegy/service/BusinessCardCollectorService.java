package elte.nevjegy.nevjegy.service;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.model.BusinessCardCollectorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessCardCollectorService {

    @Autowired
    BusinessCardCollectorDao businessCardCollectorDao;

    public List getAllBc() {
        return businessCardCollectorDao.getAllBc();
    }

    public List getFeedbacks(int bcId) {
        return businessCardCollectorDao.getFeedbacks(bcId);
    }

    public int createBusinessCard(BusinessCard businessCard){
        return businessCardCollectorDao.createUpdateBusinessCard(businessCard);
    }
}
