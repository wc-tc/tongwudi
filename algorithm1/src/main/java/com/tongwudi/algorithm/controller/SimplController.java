package com.tongwudi.algorithm.controller;


import com.alibaba.fastjson.JSON;
import com.tongwudi.algorithm.BeanDTO.*;
import com.tongwudi.algorithm.Tool.TongWuDiTool;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/simpl")
public class SimplController {
    @RequestMapping("/erfen")
    public Integer erFen(@RequestBody ShuZuAndOrderDTO agg){
         int log=0;
         int last=agg.getAge()-1;
         int mid;
         while (log<=last){
          }
         return -1;
    }
    @RequestMapping("/xuanZhe")
    public  Integer[] xuanZhe(@RequestBody XuanZheDTO xuanZheDTO){
        long startTime=System.nanoTime(); //获取开始时间
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
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
        return newArr;
    }
    /**
     * 用分而治之D&C的思想去用java实现递归数组快排
     *
     */
    @RequestMapping("/kuaiPai")
    public  Integer[] kuaiPai(@RequestBody KuaiPaiDTO kuaiPaiDTO){
        long startTime=System.nanoTime(); //获取开始时间
        if(kuaiPaiDTO==null){
            return null;
        }
        Integer[] integers = TongWuDiTool.simpleDiGuiKuaiPai(kuaiPaiDTO.getArr());
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
        return integers;
    }
    /**
     * 用分而治之D&C的思想去用java实现递归数组快排
     *
     */
    @RequestMapping("/Test1")
    public  String  kuaiPai1(String syncData){

//        System.out.println(    testDto.getSyncData());
        System.out.println(syncData);
//        BillingSyncToOdooId billingSyncToOdooId = new BillingSyncToOdooId();
//        billingSyncToOdooId.setAmount(new BigDecimal(5));
//        billingSyncToOdooId.setCurrency("CNY");
//        billingSyncToOdooId.setPartner_id("669");
//        billingSyncToOdooId.setPartner_type("supplier");
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        billingSyncToOdooId.setDate(sdf.format(d));
//        billingSyncToOdooId.setBank_name("中国银行");
//        billingSyncToOdooId.setBank_no("123456789000");
//        billingSyncToOdooId.setBillingMasterId("55555555555555");
//        String s = JSON.toJSONString(billingSyncToOdooId);
        return null;
    }

}
