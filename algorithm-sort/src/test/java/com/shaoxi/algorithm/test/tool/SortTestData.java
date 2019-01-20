package com.shaoxi.algorithm.test.tool;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * 排序数据生成器
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class SortTestData {


    public static void main(String[] args) throws IOException {
        int size = 1000*10000;
        int[] data = testData(size);
        FileWriter fw = new FileWriter("case_size_"+size);


        write (data, fw);
        fw.write("\n");
        Arrays.sort(data);
        write(data, fw);
    }

    /**
     * 随机生成排序测试数据
     *
     * @param size
     * @return
     */
    public static int[] testData(int size){
        Random random = new Random();
        int[] data  = new int[size];
        for(int i=0; i<size; i++){
            int v = random.nextInt(size);
            data[i] = v;
        }
        return data;
    }

    /**
     * 期望结果
     *
     * @param data
     * @return
     */
    public static int[] expectData(int[] data){
        int[] b = new int[data.length];
        System.arraycopy(data, 0, b, 0, data.length);
        Arrays.sort(b);
        return b;
    }


    private static void write(int[] a, FileWriter fw) throws IOException {
        for(int i=0; i< a.length; i++){
            fw.write(String.valueOf(a[i]));
            if(i != a.length - 1){
                fw.write(",");
            }
        }
    }
}
