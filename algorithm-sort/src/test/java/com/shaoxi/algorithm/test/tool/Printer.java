package com.shaoxi.algorithm.test.tool;

public class Printer {
    /**
     * 大约数组，格式：1,2,3,
     * @param a
     */
    public static void print(int[] a){
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
