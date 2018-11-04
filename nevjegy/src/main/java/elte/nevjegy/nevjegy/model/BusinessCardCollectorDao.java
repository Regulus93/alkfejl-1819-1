package elte.nevjegy.nevjegy.model;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.repository.BusinessCardRepository;
import elte.nevjegy.nevjegy.repository.FeedbackRepository;
import elte.nevjegy.nevjegy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BusinessCardCollectorDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

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
        BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));

        List<Feedback> feedbacks = bc.getFeedbacks();
        feedbackRepository.deleteAll(feedbacks);

        List<User> users = bc.getUser();
        for (User u : users){
            List<BusinessCard> userCards = u.getBusinessCard();
            userCards.remove(bc);
            userRepository.save(u);
        }

        businessCardRepository.deleteById(bcId);
    }

    public BusinessCard collectBusinessCard(int bcId, User user) {
        BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
        List<BusinessCard> cards = user.getBusinessCard();

        if(!cards.contains(bc)){
            cards.add(bc);
            user.setBusinessCard(cards);
            userRepository.save(user);
            return bc;
        } else {
            return null;
        }

    }

    public BusinessCard dropBusinessCard(int bcId, User user) {
        BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
        List<BusinessCard> cards = user.getBusinessCard();

        if(cards.contains(bc)){
            cards.remove(bc);
            user.setBusinessCard(cards);
            userRepository.save(user);
            return bc;
        } else {
            return null;
        }

    }

    public void addFeedback(int bcId, Feedback feedback, String username) {
        BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User u = userRepository.findByUserName(username).get();
        feedback.setUser(u);
        feedback.setBusinessCard(bc);
        feedbackRepository.save(feedback);
    }

    public void removeFeedback(int id){
        feedbackRepository.deleteById(id);
    }
}
