package elte.nevjegy.nevjegy.model;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.enumtype.UserRole;
import elte.nevjegy.nevjegy.repository.BusinessCardRepository;
import elte.nevjegy.nevjegy.repository.FeedbackRepository;
import elte.nevjegy.nevjegy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public BusinessCard createUpdateBusinessCard(BusinessCard businessCard) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findByUserName(auth.getName()).get();

        Optional<BusinessCard> businessCardOptional = businessCardRepository.findById(businessCard.getId());

        boolean isAdmin = currentUser.getRole() == UserRole.ROLE_ADMIN;
        boolean isCreate = !businessCardOptional.isPresent();

        if(isCreate){
            businessCard.setOwner(currentUser);
            return businessCardRepository.save(businessCard);
        } else if (isAdmin
                    || businessCardOptional.get().getOwner().equals(currentUser)) {
            businessCard.setOwner(businessCardOptional.get().getOwner());
            return businessCardRepository.save(businessCard);
        } else {
            return null;
        }
    }

    public BusinessCard deleteBusinessCard(int bcId) {
        BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
        User owner = bc.getOwner();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findByUserName(auth.getName()).get();

        boolean isAdmin = currentUser.getRole() == UserRole.ROLE_ADMIN;

        if(owner.equals(currentUser) || isAdmin){
            List<Feedback> feedbacks = bc.getFeedbacks();
            feedbackRepository.deleteAll(feedbacks);

            List<User> users = bc.getUser();
            for (User u : users){
                List<BusinessCard> userCards = u.getBusinessCard();
                userCards.remove(bc);
                userRepository.save(u);
            }

            businessCardRepository.deleteById(bcId);

            return bc;
        } else {
            return null;
        }

    }

    public BusinessCard collectBusinessCard(int bcId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(auth.getName()).get();
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

    public BusinessCard dropBusinessCard(int bcId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(auth.getName()).get();
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

    public Feedback addFeedback(int bcId, Feedback feedback) {
        BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User u = userRepository.findByUserName(auth.getName()).get();
        feedback.setUser(u);
        feedback.setBusinessCard(bc);
        return feedbackRepository.save(feedback);
    }

    public Feedback removeFeedback(int id){
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("No Feedback found with the given id!"));
        User owner = feedback.getUser();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findByUserName(auth.getName()).get();

        boolean isAdmin = currentUser.getRole() == UserRole.ROLE_ADMIN;

        if(owner.equals(currentUser) || isAdmin){
            feedbackRepository.deleteById(id);
            return feedback;
        } else {
            return null;
        }
    }
}
