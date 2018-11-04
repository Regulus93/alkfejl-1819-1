package elte.nevjegy.nevjegy.controller;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.repository.UserRepository;
import elte.nevjegy.nevjegy.service.BusinessCardCollectorService;
import javafx.scene.layout.Background;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.security.Principal;
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

    //TODO: User own feedback it or user role is admin
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
    public ResponseEntity collectBusinessCard(@RequestParam int bcId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(auth.getName()).get();
        BusinessCard collectedBc = businessCardCollectorService.collectBusinessCard(
                bcId, user);
        if(collectedBc != null){
            return ResponseEntity.ok(collectedBc);
        } else {
            return ResponseEntity.badRequest().body("Already collected or invalid BC!");
        }

    }

    @PostMapping("user/dropBC")
    public ResponseEntity dropBusinessCard(@RequestParam int bcId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUserName(auth.getName()).get();
        BusinessCard droppedBusinessCard = businessCardCollectorService.dropBusinessCard(
                bcId, user);

        if(droppedBusinessCard != null){
            return ResponseEntity.ok(droppedBusinessCard);
        } else {
            return ResponseEntity.badRequest().body("Not collected or invalid BC!");
        }
    }

    @PostMapping("user/addFeedback")
    public void addFeedback(
            @RequestBody Feedback feedback,
            @RequestParam int bcId, Principal principal) {

        if (feedback.getRateValue() == null) throw new InvalidParameterException("Rate value must be not null");
        businessCardCollectorService.addFeedback(bcId, feedback, principal.getName());
    }

    //TODO: User own feedback it or user role is admin
    @PostMapping("user/removeFeedback")
    public void removeFeedback(@RequestParam int id){
        businessCardCollectorService.removeFeedback(id);
    }
}
