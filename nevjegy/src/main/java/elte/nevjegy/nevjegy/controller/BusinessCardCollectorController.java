package elte.nevjegy.nevjegy.controller;

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

    @GetMapping("getAllBC")
    public List getAllBc() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal().toString());
        return businessCardCollectorService.getAllBc();
    }

    @GetMapping("getBCById")
    public BusinessCard getBcById(
            @RequestParam int bcId) {
        return businessCardCollectorService.getBcById(bcId);
    }

    @GetMapping("getFeedbacks/{bcId}")
    public List getFeedbacks(@PathVariable("bcId") int bcId) {
        return businessCardCollectorService.getFeedbacks(bcId);
    }

    @PostMapping("user/createBC")
    public int createBusinessCard(
            @RequestBody BusinessCard businessCard) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        businessCard.setOwner(userRepository.findById(1).get());
        return businessCardCollectorService.createBusinessCard(businessCard);
    }

    @PutMapping("user/updateBC")
    public int updateBusinessCard(
            @RequestBody BusinessCard businessCard) {
        return businessCardCollectorService.updateBusinessCard(businessCard);
    }

    @DeleteMapping("user/deleteBC")
    public void deleteBusinessCard(
            @RequestParam int bcId) {
        businessCardCollectorService.deleteBusinessCard(bcId);
    }

    @PostMapping("user/collectBC")
    public void collectBusinessCard(@RequestParam int bcId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        businessCardCollectorService.collectBusinessCard(
                bcId, userRepository.findByUserName(auth.getPrincipal().toString()).get());
    }

    @PostMapping("user/addFeedback")
    public void addFeedback(
            @RequestBody Feedback feedback,
            @RequestParam int bcId) {

        if (feedback.getRateValue() == null) throw new InvalidParameterException("Rate value must be not null");
        businessCardCollectorService.addFeedback(bcId, feedback);
    }
}
