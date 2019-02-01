package com.shaoxi.algorithm.test.tool;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 排序数据生成器
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class TestData {


    public static void main(String[] args) throws IOException {
        int size = 1000*10000;
        int[] data = testDataArray(size);
        FileWriter fw = new FileWriter("case_size_"+size);


        write (data, fw);
        fw.write("\n");
        Arrays.sort(data);
        write(data, fw);
    }

    /**
     * 随机生成测试数据
     *
     * @param size
     * @return
     */
    public static int[] testDataArray(int size, int min, int max){
        Random random = new Random();
        int[] data  = new int[size];
        int range = max - min;
        for(int i=0; i<size; i++){
            int v = random.nextInt(range)+min;
            data[i] = v;
        }
        return data;
    }

    /**
     * 随机生成测试数据
     *
     * @param size
     * @return
     */
    public static int[] testDataArray(int size){
        return testDataArray(size, 0, size);
    }

    /**
     * 随机生成测试数据
     *
     * @param size
     * @return
     */
    public static List<Integer> testDataList(int size, int min, int max){
        return toList(testDataArray(size, min, max));
    }


    /**
     * 随机生成测试数据
     *
     * @param size
     * @return
     */
    public static List<Integer> testDataList(int size){
        return toList(testDataArray(size, 0, size));
    }

    /**
     * 随机生成测试数据，已排序
     *
     * @param size
     * @return
     */
    public static List<Integer> testDataSortedList(int size){
        List<Integer> list = toList(testDataArray(size, 0, size));
        Collections.sort(list);
        return list;
    }

    private static List<Integer> toList(int[] a){
        List<Integer> list = new ArrayList<>(a.length);
        for(int v:a){
            list.add(v);
        }
        return list;
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

    /**
     * 最大值
     * @param a
     * @return
     */
    public static int maxValue(int[] a){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max = a[i];
            }
        }
        return max;
    }

    /**
     * 最小值
     * @param a
     * @return
     */
    public static int minValue(int[] a){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]<min){
                min = a[i];
            }
        }
        return min;
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
