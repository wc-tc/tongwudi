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

    /**
     * 分而久之思想实现快排
     * @param a
     * @return
     */
    public static Integer[] simpleDiGuiKuaiPai(Integer [] a){

        if(a.length<2){
            return a;
        }else {
            int pivot=a[0];
            Integer[]b=new Integer[a.length];
            int count=0;
            for (int i = 1; i <a.length; i++) {
                if(a[i]<=pivot){
                    b[count]=a[i];
                    count++;
                }
            }
            Integer[] c=new Integer[count];
            for (int i = 0; i <count; i++) {
                c[i]=b[i];
            }
            count=0;
            b=new Integer[a.length];
            for (int i = 1; i <a.length; i++) {
                if(a[i]>pivot){
                    b[count]=a[i];
                    count++;
                }
            }
            Integer[] d=new Integer[count];
            for (int i = 0; i <count; i++) {
                d[i]=b[i];
            }


            return shuZuPingJie(simpleDiGuiKuaiPai(c),pivot,simpleDiGuiKuaiPai(d),a);
        }

    }

    /**
     * 拼接数组
     * @param c  一个由基础准值划分的比他小的数组
     * @param pivot 基准值
     * @param d  一个由基准值划分的比他大的数组
     * @param a  原数组
     * @return
     */
    public static Integer[] shuZuPingJie(Integer [] c,int pivot,Integer d[],Integer [] a ){
        Integer [] b=new Integer[a.length];
        for (int i = 0; i <c.length; i++) {
            b[i]=c[i];
        }
        b[c.length]=pivot;
        int count=0;
        for (int i = c.length+1; i <b.length; i++,count++) {
            b[i]=d[count];
        }
        return b;
    }
}
