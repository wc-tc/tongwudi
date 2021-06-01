package com.tongwudi.algorithm.controller;


import com.tongwudi.algorithm.BeanDTO.shuZuAndOrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simpl")
public class SimplController {
    @RequestMapping("/erfen")
    public Integer erFen(@RequestBody shuZuAndOrderDTO agg){
         int low=0;
         int high=agg.getArr().length-1;
         int mid;
         while (low<= high){
            mid =(low+high)/2;
            if(agg.getAge()==agg.getArr()[mid]){
                return mid;
            }
            if(agg.getAge()>agg.getArr()[mid]){
                low=mid+1;
            }
            if(agg.getAge()<agg.getArr()[mid]){
                high=mid-1;
            }

         }
         return -1;
    }
}
