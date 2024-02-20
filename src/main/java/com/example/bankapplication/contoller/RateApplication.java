package com.example.bankapplication.contoller;

import com.example.bankapplication.entity.RateBA;
import com.example.bankapplication.service.RateBAService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/vBank")
public class RateApplication {

    private final RateBAService rateBAService;

    @GetMapping("/getRate")
    public ResponseEntity<RateBA> getRateBA(@RequestParam("id") Long id){
        System.out.println(rateBAService.getRateBA(id));
        return ResponseEntity.ok( rateBAService.getRateBA(id));
    }

    @GetMapping("/getRateAll")
    public ResponseEntity<List<RateBA>> getRateBAAll(){
        System.out.println(rateBAService.getAllRateBA());
        return ResponseEntity.ok(rateBAService.getAllRateBA());
    }
    @PostMapping("/createRate")
    public ResponseEntity<Void>createRateBA(@RequestBody RateBA rateBA){
        System.out.println("create");
        rateBAService.createRateBA(rateBA);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/updateRate/{id}")
    public ResponseEntity<RateBA> updateRateBA(@PathVariable("id") Long id, @RequestParam Double percent){
        System.out.println(rateBAService.updateRateBA(id,percent));
       return ResponseEntity.ok(rateBAService.updateRateBA(id,percent));
    }


    @DeleteMapping("/deleteRate/{id}")
    public ResponseEntity<Void> deleteRateBA(@PathVariable("id") Long id){
        System.out.println("delete");
        rateBAService.deleteRateBA(id);
        return ResponseEntity.noContent().build();
    }


}
