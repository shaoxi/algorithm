package com.shaoxi.algorithm.test.tool;

public class ValueCompare {
    /**
     * 比较两个数组是否相等
     *
     * @param a1
     * @param a2
     * @return
     */
    public static boolean compare(int[] a1, int[] a2){
        if(a1==null || a2==null){
            return a1 == a2;
        }else if(a1.length!=a2.length){
            return false;
        }else{
            for(int i=0; i<a1.length; i++){
                if(a1[i] != a2.length){
                    return false;
                }
            }
            return true;
        }
    }
}
