package com.tongwudi.algorithm.Tool;

import org.apache.tomcat.util.buf.StringUtils;

public class TongWuDiTool {
    /**
     * 找到数组最小值索引
     */
    public  static  int arrMinIndex(Integer [] arr){
        if(arr==null && arr.length<=0){
            return -1;
        }
        int min=arr[0];
        int index=0;
        for (int i = 0; i<arr.length; i++) {
            if(min>arr[i]){
                min=arr[i];
                index=i;
            }
        }
        return index;
    }
}
