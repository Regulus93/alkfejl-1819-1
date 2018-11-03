package elte.nevjegy.nevjegy.controller;

import com.sun.tools.sjavac.PubApiExtractor;
import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.repository.UserRepository;
import elte.nevjegy.nevjegy.service.BusinessCardCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/BCC")
public class BusinessCardCollectorController {

    @Autowired
    BusinessCardCollectorService businessCardCollectorService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/GetAllBC")
    public List getAllBc() {
        return businessCardCollectorService.getAllBc();
    }

    @GetMapping("/GetBCById")
    public BusinessCard getBcById(
            @RequestParam int bcId) {
        return businessCardCollectorService.getBcById(bcId);
    }

    @GetMapping("/GetFeedbacks/{bcId}")
    public List getFeedbacks(@PathVariable("bcId") int bcId) {
        return businessCardCollectorService.getFeedbacks(bcId);
    }

    @PostMapping("/user/CreateBC")
    public int createBusinessCard(
            @RequestBody BusinessCard businessCard) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        businessCard.setOwner(userRepository.findByUserName(auth.getPrincipal().toString()).get());
        return businessCardCollectorService.createBusinessCard(businessCard);
    }

    @PutMapping("/user/UpdateBC")
    public int updateBusinessCard(
            @RequestBody BusinessCard businessCard) {
        return businessCardCollectorService.updateBusinessCard(businessCard);
    }

    @DeleteMapping("/user/DeleteBC")
    public void deleteBusinessCard(
            @RequestBody int bcId) {
        businessCardCollectorService.deleteBusinessCard(bcId);
    }

    @PostMapping("/user/CollectBC")
    public void collectBusinessCard(
            @RequestParam User user,
            @RequestBody int bcId) {
        businessCardCollectorService.collectBusinessCard(bcId, user);
    }

    @PostMapping("/user/addFeedback")
    public void addFeedback(
            @RequestParam Feedback feedback,
            @RequestBody int bcId) {

        if(feedback.getRateValue() != null) throw new InvalidParameterException("Rate value must be not null");
        businessCardCollectorService.addFeedback(bcId, feedback);
    }
}
