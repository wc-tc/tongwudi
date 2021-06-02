package com.tongwudi.algorithm.controller;


import com.tongwudi.algorithm.BeanDTO.shuZuAndOrderDTO;
import com.tongwudi.algorithm.BeanDTO.xuanZheDTO;
import com.tongwudi.algorithm.Tool.TongWuDiTool;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simpl")
public class SimplController {
    @RequestMapping("/erfen")
    public Integer erFen(@RequestBody shuZuAndOrderDTO agg){
         int log=0;
         int last=agg.getAge()-1;
         int mid;
         while (log<=last){
             mid=(log+last)/2;
             if(agg.getAge()==agg.getArr()[mid]){
                 return mid;
             }
             if(agg.getAge()>agg.getArr()[mid]){
                 log=mid+1;
             }
             if(agg.getAge()<agg.getArr()[mid]){
                 last=mid-1;
             }
         }
         return -1;
    }
    @RequestMapping("/xuanZhe")
    public  Integer[] xuanZhe(@RequestBody xuanZheDTO xuanZheDTO){
        if(xuanZheDTO==null){
            return null;
        }
        if(xuanZheDTO.getArr()==null){
            return xuanZheDTO.getArr();
        }
        Integer [] newArr=new Integer[xuanZheDTO.getArr().length];
        for (int i = 0; i <xuanZheDTO.getArr().length; i++) {
            int i1 = TongWuDiTool.arrMinIndex(xuanZheDTO.getArr());
            newArr[i]=xuanZheDTO.getArr()[i1];
            xuanZheDTO.getArr()[i1]=Integer.MAX_VALUE;
        }
        return newArr;
    }

}
