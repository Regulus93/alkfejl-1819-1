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

    @GetMapping("getAllBC")
    public ResponseEntity getAllBc() {
        return ResponseEntity.ok(businessCardCollectorService.getAllBc());
    }

    @GetMapping("getBCById")
    public ResponseEntity<BusinessCard> getBcById(
            @RequestParam int bcId) {
        return ResponseEntity.ok(businessCardCollectorService.getBcById(bcId));
    }

    @GetMapping("getFeedbacks/{bcId}")
    public ResponseEntity getFeedbacks(@PathVariable("bcId") int bcId) {
        return ResponseEntity.ok(businessCardCollectorService.getFeedbacks(bcId));
    }

    @PostMapping("user/createBC")
    public ResponseEntity createBusinessCard(
            @RequestBody BusinessCard businessCard) {
        BusinessCard createdBc = businessCardCollectorService.createBusinessCard(businessCard);

        if(createdBc != null){
            return ResponseEntity.ok(createdBc);
        } else {
            return ResponseEntity.badRequest().body("Error during create BusinessCard.");
        }
    }

    @PutMapping("user/updateBC")
    public ResponseEntity updateBusinessCard(
            @RequestBody BusinessCard businessCard) {

        BusinessCard updatedBc = businessCardCollectorService.updateBusinessCard(businessCard);

        if(updatedBc != null){
            return ResponseEntity.ok(updatedBc);
        } else {
            return ResponseEntity.badRequest().body("Error during update BusinessCard.");
        }
    }

    @DeleteMapping("user/deleteBC")
    public ResponseEntity deleteBusinessCard(
            @RequestParam int bcId) {
        BusinessCard deletedBusinessCard = businessCardCollectorService.deleteBusinessCard(bcId);

        if(deletedBusinessCard != null){
            return ResponseEntity.ok(deletedBusinessCard);
        } else {
            return ResponseEntity.badRequest().body("Error during delete BusinessCard.");
        }
    }

    @PostMapping("user/collectBC")
    public ResponseEntity collectBusinessCard(@RequestParam int bcId) {
        BusinessCard collectedBc = businessCardCollectorService.collectBusinessCard(bcId);
        if(collectedBc != null){
            return ResponseEntity.ok(collectedBc);
        } else {
            return ResponseEntity.badRequest().body("Already collected or invalid BC!");
        }

    }

    @PostMapping("user/dropBC")
    public ResponseEntity dropBusinessCard(@RequestParam int bcId){
        BusinessCard droppedBusinessCard = businessCardCollectorService.dropBusinessCard(bcId);

        if(droppedBusinessCard != null){
            return ResponseEntity.ok(droppedBusinessCard);
        } else {
            return ResponseEntity.badRequest().body("Not collected or invalid BC!");
        }
    }

    @PostMapping("user/addFeedback")
    public ResponseEntity addFeedback(
            @RequestBody Feedback feedback,
            @RequestParam int bcId, Principal principal) {

        if (feedback.getRateValue() == null) throw new InvalidParameterException("Rate value must be not null");
        return ResponseEntity.ok(businessCardCollectorService.addFeedback(bcId, feedback));
    }

    @PostMapping("user/removeFeedback")
    public ResponseEntity removeFeedback(@RequestParam int id){
        Feedback removedFeedback = businessCardCollectorService.removeFeedback(id);
        if(removedFeedback != null){
            return ResponseEntity.ok(removedFeedback);
        } else {
            return ResponseEntity.badRequest().body("Error during remove feedback.");
        }
    }
}
