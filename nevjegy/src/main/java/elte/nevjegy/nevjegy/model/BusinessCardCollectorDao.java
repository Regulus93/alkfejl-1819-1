package elte.nevjegy.nevjegy.model;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.enumtype.UserRole;
import elte.nevjegy.nevjegy.repository.BusinessCardRepository;
import elte.nevjegy.nevjegy.repository.FeedbackRepository;
import elte.nevjegy.nevjegy.repository.UserRepository;
import elte.nevjegy.nevjegy.security.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BusinessCardCollectorDao {

    @Autowired
    private Session session;

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

    public BusinessCard createUpdateBusinessCard(BusinessCard businessCard) throws Exception {
        try {
            User currentUser = session.getUser();


            Optional<BusinessCard> businessCardOptional = businessCardRepository.findById(businessCard.getId());

            boolean isAdmin = currentUser.getRole() == UserRole.ROLE_ADMIN;
            boolean isCreate = !businessCardOptional.isPresent();

            if (isCreate) {
                businessCard.setOwner(currentUser);
                return businessCardRepository.save(businessCard);
            } else if (isAdmin
                    || businessCardOptional.get().getOwner().equals(currentUser)) {
                businessCard.setOwner(businessCardOptional.get().getOwner());
                return businessCardRepository.save(businessCard);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("User not found!");
        }
    }

    public BusinessCard deleteBusinessCard(int bcId) throws Exception {

        BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
        User owner = bc.getOwner();

        try {
            User currentUser = session.getUser();

            boolean isAdmin = currentUser.getRole() == UserRole.ROLE_ADMIN;

            if (owner.equals(currentUser) || isAdmin) {
                List<Feedback> feedbacks = bc.getFeedbacks();
                feedbackRepository.deleteAll(feedbacks);

                List<User> users = bc.getUser();
                for (User u : users) {
                    List<BusinessCard> userCards = u.getBusinessCard();
                    userCards.remove(bc);
                    userRepository.save(u);
                }

                businessCardRepository.deleteById(bcId);

                return bc;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("Not logged in!");
        }
    }

    public BusinessCard collectBusinessCard(int bcId) throws Exception {

        try {
            User currentUser = session.getUser();
            BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
            List<BusinessCard> cards = currentUser.getBusinessCard();

            if (!cards.contains(bc)) {
                cards.add(bc);
                currentUser.setBusinessCard(cards);
                userRepository.save(currentUser);
                return bc;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("Not logged in!");
        }
    }

    public BusinessCard dropBusinessCard(int bcId) throws Exception {
        try {
            User currentUser = session.getUser();
            BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
            List<BusinessCard> cards = currentUser.getBusinessCard();

            if (cards.contains(bc)) {
                cards.remove(bc);
                currentUser.setBusinessCard(cards);
                userRepository.save(currentUser);
                return bc;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("Not logged in!");
        }
    }

    public Feedback addFeedback(int bcId, Feedback feedback) throws Exception {
        try {
            User currentUser = session.getUser();
            BusinessCard bc = businessCardRepository.findById(bcId).orElseThrow(() -> new RuntimeException("No Business Card found with the given id!"));
            User u = userRepository.findByUserName(currentUser.getUserName()).get();
            feedback.setUser(u);
            feedback.setBusinessCard(bc);
            return feedbackRepository.save(feedback);
        } catch (Exception e) {
            throw new Exception("Not logged in!");
        }
    }

    public Feedback removeFeedback(int id) throws Exception {
        try {
            Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("No Feedback found with the given id!"));
            User owner = feedback.getUser();

            User currentUser = session.getUser();

            boolean isAdmin = currentUser.getRole() == UserRole.ROLE_ADMIN;

            if (owner.equals(currentUser) || isAdmin) {
                feedbackRepository.deleteById(id);
                return feedback;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception("Not logged in!");
        }
    }
}
