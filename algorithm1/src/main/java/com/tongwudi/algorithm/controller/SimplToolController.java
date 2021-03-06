package com.tongwudi.algorithm.controller;

import com.alibaba.excel.EasyExcel;

import com.alibaba.fastjson.JSON;
import com.tongwudi.algorithm.Tool.DemoDataListener;
import com.tongwudi.algorithm.Tool.SendSimpleMail;
import com.tongwudi.algorithm.bean.SimpleDetail;
import com.tongwudi.algorithm.bean.SimpleEasyExcel;


import com.tongwudi.algorithm.bean.SimpleEmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;

import java.util.Map;

@RequestMapping("/simpleEasyExcel")
@RestController
public class SimplToolController  {

  private   final  String  HEADERS = "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnRfaWQiOiIwMDAwMDAiLCJ1c2VyX25hbWUiOiJzdW53YXlhZG1pbiIsInJlYWxfbmFtZSI6IueuoeeQhuWRmCIsImF2YXRhciI6Imh0dHBzOi8vZ3cuYWxpcGF5b2JqZWN0cy5jb20vem9zL3Jtc3BvcnRhbC9CaWF6ZmFueG1hbU5Sb3h4VnhrYS5wbmciLCJhdXRob3JpdGllcyI6WyJhZG1pbmlzdHJhdG9yIl0sImNsaWVudF9pZCI6InNhYmVyIiwicm9sZV9uYW1lIjoiYWRtaW5pc3RyYXRvciIsImxpY2Vuc2UiOiJwb3dlcmVkIGJ5IGJsYWRleCIsInBvc3RfaWQiOiIxMTIzNTk4ODE3NzM4Njc1MjAxIiwidXNlcl9pZCI6IjExMjM1OTg4MjE3Mzg2NzUyMDEiLCJyb2xlX2lkIjoiMTEyMzU5ODgxNjczODY3NTIwMSIsInNjb3BlIjpbImFsbCJdLCJuaWNrX25hbWUiOiLnrqHnkIblkZgiLCJvYXV0aF9pZCI6IiIsImRldGFpbCI6eyJ0eXBlIjoid2ViIn0sImV4cCI6MTYyNTE3OTY3MSwiZGVwdF9pZCI6IjExMjM1OTg4MTM3Mzg2NzUyMDEiLCJqdGkiOiI3YTY2YjQ3Mi1iODdmLTRmMTMtYjUzNi02ZmE1ZTY5NTEyMDUiLCJhY2NvdW50Ijoic3Vud2F5YWRtaW4ifQ.BCxuYqXI58bjaXuL5rwJlJy_fhnX8VoLa_Mrs93zZ_Y";
//    @Autowired
//    private JavaMailSender mailSender;
    @Autowired
    SendSimpleMail sendSimpleMail;

    @Value("${spring.mail.username}")
    private String from;
    @RequestMapping(value = "/download")
    public void download(HttpServletResponse response) throws IOException {
        // ???????????? ?????????????????????swagger ??????????????????????????????????????????????????????postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // ??????URLEncoder.encode???????????????????????? ?????????easyexcel????????????
        String fileName = URLEncoder.encode("??????", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        SimpleEasyExcel simpleEasyExcel = new SimpleEasyExcel();
        simpleEasyExcel.setAge(18);
        simpleEasyExcel.setName("???");
        SimpleEasyExcel simpleEasyExcel2 = new SimpleEasyExcel();
        simpleEasyExcel2.setAge(18);
        simpleEasyExcel2.setName("???");
        ArrayList<SimpleEasyExcel> simpleEasyExcels = new ArrayList<>();
        simpleEasyExcels.add(simpleEasyExcel);
        simpleEasyExcels.add(simpleEasyExcel2);
        EasyExcel.write(response.getOutputStream(), SimpleEasyExcel.class).autoCloseStream(Boolean.FALSE).sheet("??????")
                .doWrite(simpleEasyExcels);
    }

    /**
     * ????????????
     * <p>
     * 1. ??????excel????????????????????? ??????{@link }
     * <p>
     * 2. ??????????????????????????????excel?????????????????????excel???????????????????????????????????????{@link }
     * <p>
     * 3. ???????????????
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        //postman??? ??????????????????
        EasyExcel.read(file.getInputStream(), SimpleEasyExcel.class, new DemoDataListener()).sheet().doRead();
        return "success";
    }

    /**
     * ??????
     * @return
     */
    @PostMapping("/HttpRequestTest")
    public  Map<String, Object>  HttpRequestTest(){
        // ????????????
        String url = "http://192.168.1.91:8069/portmax/account/receivable";

        // ???????????????,x-www-form-urlencoded???????????????
        //?????????????????????????????????????????????????????????????????????????????????
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization","Basic ZDRhYjQxYzAtM2I2MS00OTliLWFiMDEtZDNhYTcyNWU0OWZj");
        //??????????????????
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("syncData","{\"amount\":303,\"bank_name\":\"????????????\",\"bank_no\":\"123456789000\",\"id\":\"8118888\",\"currency\":\"CNY\",\"date\":\"2021-06-08 11:07:03\",\"partner_id\":\"669\",\"partner_type\":\"supplier\"}\n");
        ArrayList<SimpleDetail> simpleDetails = new ArrayList<>();
        SimpleDetail simpleDetail = new SimpleDetail();
        simpleDetail.setP_name("?????????");
        simpleDetail.setPrice_unit(new BigDecimal(102));
        simpleDetail.setQuantity(1);
        simpleDetails.add(simpleDetail);
        SimpleDetail simpleDetail1 = new SimpleDetail();
        simpleDetail1.setP_name("?????????");
        simpleDetail1.setQuantity(1);
        simpleDetail1.setPrice_unit(new BigDecimal(201));
        simpleDetails.add(simpleDetail1);
        String s = JSON.toJSONString(simpleDetails);
        map.add("lineDate",s);
        // ???????????????
        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<MultiValueMap<String, String>>(map, headers);

        // ??????post??????????????????????????????String????????????????????????JSON?????????
        RestTemplate restTemplate = new RestTemplate();
        Map<String,Object> responseMap= restTemplate.postForObject(url, request, Map.class);

        return responseMap;

    }
    /**
     * @Description: ???????????????????????????
     * @Author: Yasuo
     * @Date: 2021-06-11 14:18
     */
    @GetMapping("mail")
    public Boolean  mail(@RequestBody SimpleEmailEntity simpleEmailEntity){
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(from);
//       simpleMailMessage.setSubject(simpleEmailEntity.getSubject());
//       simpleMailMessage.setText(simpleEmailEntity.getContent());
//       simpleMailMessage.setTo(simpleEmailEntity.getTos());
//        try {
//            mailSender.send(simpleMailMessage);
//        } catch (MailException e) {
//            e.printStackTrace();
//            return false;
//        }

            sendSimpleMail.sendSimpleMail(simpleEmailEntity);


        System.out.println("????????????");
        return true;

    }
}
