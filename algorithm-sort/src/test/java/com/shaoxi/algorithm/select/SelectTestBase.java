package com.shaoxi.algorithm.select;

import com.shaoxi.algorithm.sort.JdkSort;
import com.shaoxi.algorithm.test.tool.Printer;
import org.junit.jupiter.api.Assertions;

import java.util.function.Function;

/**
 * @author shaoxi.ycw
 * @since 2019-01-31
 */
public class SelectTestBase {
    /**
     * 查找
     *
     * @param testData
     * @param selectFunc
     * @param printLog
     * @param <R>
     * @return
     */
    public <R> R  select(int[] testData, Function<int[], R> selectFunc, boolean printLog) {
        long start = System.currentTimeMillis();
        R r = selectFunc.apply(testData);
        long useTime = System.currentTimeMillis() - start;

        if(printLog){
            System.out.println("select\tresult\t"+r);
            System.out.println("run\ttime\t"+ useTime);
        }

        return r;
    }
}
