package com.shaoxi.algorithm.sort;

import com.shaoxi.algorithm.common.tool.ArraysTool;
import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * 排序性能比较
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class SortPerformance extends SortTestBase {
    @Test
    @DisplayName("C0001_排序性能比较_size_200000")
    void run(){
        int[] testData = TestData.testData(2*10000);
        List<SortResult> resultList = new ArrayList<>();
        JdkSort.sort(testData);

        //归并排序
        sort(resultList, "MergeSort", testData, MergeSort::sort);
        //jdk排序
        sort(resultList, "JdkSort", testData, JdkSort::sort);
        //堆排序
        sort(resultList, "HeapSort", testData, HeapSort::sort);
        //冒泡排序
        sort(resultList, "BubbleSort", testData, BubbleSort::sort);
        //插入排序
        sort(resultList, "InsertSort", testData, InsertSort::sort);
        //快排
        sort(resultList, "QuickSort", testData, QuickSort::sort);
        //快排随机化版本
        sort(resultList, "QuickSort_random", testData, QuickSort::randomSort);
        //计数排序
        sort(resultList, "CountingSort", testData, CountingSort::sort);

        System.out.println("============ sort use time =============");
        printResult(resultList);
    }

    @Test
    @DisplayName("C0002_排序性能比较_size_1000000")
    void run2(){
        int[] testData = TestData.testData(100*10000);
        List<SortResult> resultList = new ArrayList<>();

        //归并排序
        sort(resultList, "MergeSort", testData, MergeSort::sort);
        //jdk排序
        sort(resultList, "JdkSort", testData, JdkSort::sort);
        //堆排序
        sort(resultList, "HeapSort", testData, HeapSort::sort);
        //快排
        sort(resultList, "QuickSort", testData, QuickSort::sort);
        //快排随机化
        sort(resultList, "QuickSort_random", testData, QuickSort::randomSort);
        //计数排序
        sort(resultList, "CountingSort", testData, CountingSort::sort);

        System.out.println("============ sort use time =============");
        printResult(resultList);
    }

    private void printResult(List<SortResult> resultList){
        Collections.sort(resultList);
        for(SortResult result:resultList){
            System.out.println(result);
        }
    }

    private void sort(List<SortResult> resultList, String name, int[] a, Consumer<int[]> sortFunc){
        int[] _a = ArraysTool.copy(a, 0, a.length);
        System.out.println(ZonedDateTime.now() + name + " start");
        long useTime = 0;
        String errMsg = null;
        try{
            useTime = sort(_a, sortFunc, false, false);
        }catch (Throwable e){
            errMsg = e.toString();
        }
        resultList.add(new SortResult(name,a.length, useTime, errMsg));


        System.out.println(ZonedDateTime.now() + name+ " finish");

    }

    private static class SortResult implements Comparable<SortResult>{
        public String name;
        public long dataSize;
        public long useTime;
        public String errMsg;

        public SortResult(String name, long dataSize, long useTime, String errMsg) {
            this.name = name;
            this.useTime = useTime;
            this.dataSize = dataSize;
            this.errMsg = errMsg;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer();
            sb.append(name);
            sb.append("\t").append(dataSize);
            sb.append("\t").append(useTime);
            sb.append("\t").append(errMsg);
            return sb.toString();
        }

        @Override
        public int compareTo(SortResult o) {
            if (this.errMsg != null) {
                return 1;
            }
            if (this.useTime > o.useTime) {
                return 1;
            } else if (this.useTime < o.useTime) {
                return -1;
            }
            return 0;
        }
    }
}
