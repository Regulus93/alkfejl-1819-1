package elte.nevjegy.nevjegy.controller;

import elte.nevjegy.nevjegy.entity.BusinessCard;
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

    @GetMapping("/public/GetFeedbacks/{bcId}")
    public List getFeedbacks(@PathVariable("bcId") int bcId) {
        return businessCardCollectorService.getFeedbacks(bcId);
    }

    @PostMapping("/CreateBC")
    public int createBusinessCard(
            @RequestBody BusinessCard businessCard){
        return businessCardCollectorService.createBusinessCard(businessCard);
    }
}
