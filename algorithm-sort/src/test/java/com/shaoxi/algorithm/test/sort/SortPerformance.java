package com.shaoxi.algorithm.test.sort;

import com.shaoxi.algorithm.sort.BubbleSort;
import com.shaoxi.algorithm.sort.InsertSort;
import com.shaoxi.algorithm.sort.JdkSort;
import com.shaoxi.algorithm.sort.MergeSort;
import com.shaoxi.algorithm.sort.tool.ArraysTool;
import com.shaoxi.algorithm.test.tool.SortTestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

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
        int[] testData = SortTestData.testData(2*10000);
        List<SortResult> resultList = new ArrayList<>();

        //插入排序
        sort(resultList, "InsertSort", testData, InsertSort::sort);
        //插入排序
        sort(resultList, "MergeSort", testData, MergeSort::sort);
        //jdk排序
        sort(resultList, "JdkSort", testData, JdkSort::sort);
        //冒泡排序
        sort(resultList, "BubbleSort", testData, BubbleSort::sort);

        System.out.println("============ sort use time =============");
        printResult(resultList);
    }

    private void printResult(List<SortResult> resultList){
        Collections.sort(resultList);
        for(SortResult result:resultList){
            System.out.println(result);
        }
    }

    private void sort(List<SortResult> resultList, String name, int[] a, Function<int[], Void> sortFunc){
        int[] _a = ArraysTool.copy(a, 0, a.length);
        System.out.println(ZonedDateTime.now() + name + " start");

        long useTime = sort(_a, sortFunc, false);

        resultList.add(new SortResult(name,a.length,useTime));
        System.out.println(ZonedDateTime.now() + name+ " finish");

    }

    private static class SortResult implements Comparable<SortResult>{
        public String name;
        public long dataSize;
        public long useTime;

        public SortResult(String name, long dataSize, long useTime) {
            this.name = name;
            this.useTime = useTime;
            this.dataSize = dataSize;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer();
            sb.append(name);
            sb.append("\t").append(dataSize);
            sb.append("\t").append(useTime);
            return sb.toString();
        }

        @Override
        public int compareTo(SortResult o) {
             if(this.useTime > o.useTime){
                 return 1;
             }else if(this.useTime < o.useTime){
                 return -1;
             }
            return 0;
        }
    }
}
