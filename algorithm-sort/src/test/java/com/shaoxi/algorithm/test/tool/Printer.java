package com.shaoxi.algorithm.test.tool;

/**
 *
 * 打印
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class Printer {
    /**
     * 大约数组，格式：title:1,2,3,
     * @param a
     */
    public static void print(String title, int[] a){
        if(title!=null){
            System.out.print(title+"\t");
        }
        if(a==null){
            System.out.println("null");
        }else{
            for (int v:a){
                System.out.print(v+",");
            }
        }
        System.out.println();
    }
}
