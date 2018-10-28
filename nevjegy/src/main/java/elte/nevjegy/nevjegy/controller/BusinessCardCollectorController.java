package elte.nevjegy.nevjegy.controller;

import elte.nevjegy.nevjegy.entity.BusinessCard;
import elte.nevjegy.nevjegy.entity.Feedback;
import elte.nevjegy.nevjegy.entity.User;
import elte.nevjegy.nevjegy.service.BusinessCardCollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BCC")
public class BusinessCardCollectorController {

    @Autowired
    BusinessCardCollectorService businessCardCollectorService;

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
            @RequestBody BusinessCard businessCard){
        return businessCardCollectorService.createBusinessCard(businessCard);
    }

    @PutMapping("/user/UpdateBC")
    public int updateBusinessCard(
            @RequestBody BusinessCard businessCard){
        return businessCardCollectorService.updateBusinessCard(businessCard);
    }

    @DeleteMapping("/user/DeleteBC")
    public void deleteBusinessCard(
            @RequestBody int bcId){
        businessCardCollectorService.deleteBusinessCard(bcId);
    }

    @PostMapping("/user/CollectBC")
    public void collectBusinessCard(
            @RequestParam User user,
            @RequestBody int bcId){
        businessCardCollectorService.collectBusinessCard(bcId, user);
    }

    @PostMapping("/user/addFeedback")
    public void collectBusinessCard(
            @RequestParam Feedback feedback,
            @RequestBody int bcId){
        businessCardCollectorService.addFeedback(bcId, feedback);
    }
}
