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

    @GetMapping("/public/GetAllBC")
    public List getAllBc() {
        return businessCardCollectorService.getAllBc();
    }

    @GetMapping("/public/GetBCById")
    public BusinessCard getBcById(
            @RequestParam int bcId) {
        return businessCardCollectorService.getBcById(bcId);
    }

    @GetMapping("/public/GetFeedbacks/{bcId}")
    public List getFeedbacks(@PathVariable("bcId") int bcId) {
        return businessCardCollectorService.getFeedbacks(bcId);
    }

    @PostMapping("/CreateBC")
    public int createBusinessCard(
            @RequestBody BusinessCard businessCard){
        return businessCardCollectorService.createBusinessCard(businessCard);
    }

    @PutMapping("/UpdateBC")
    public int updateBusinessCard(
            @RequestBody BusinessCard businessCard){
        return businessCardCollectorService.updateBusinessCard(businessCard);
    }

    @DeleteMapping("/DeleteBC")
    public void deleteBusinessCard(
            @RequestBody int bcId){
        businessCardCollectorService.deleteBusinessCard(bcId);
    }

    @PostMapping("/CollectBC")
    public void collectBusinessCard(
            @RequestParam User user,
            @RequestBody int bcId){
        businessCardCollectorService.collectBusinessCard(bcId, user);
    }

    @PostMapping("/addFeedback")
    public void collectBusinessCard(
            @RequestParam Feedback feedback,
            @RequestBody int bcId){
        businessCardCollectorService.addFeedback(bcId, feedback);
    }
}
