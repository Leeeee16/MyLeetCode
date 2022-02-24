package com.algorithm.experience;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreedyTaskScheduleTest {

    @Test
    public void scheduleTaskTest() {
        // deadline
        int[] d = {4, 2, 4, 3, 1, 4, 6};
        // 惩罚
        int[] w = {70, 60, 50, 40, 30, 20, 10};
        GreedyTaskSchedule gts = new GreedyTaskSchedule(d, w);
        gts.scheduleTaskTest();
        gts.printList();
        System.out.println();
    }

    @Test
    public void rescheduleTask() {
        // deadline
        int[] d = {4, 2, 4, 3, 1, 4, 6};
        // 惩罚
        int[] w = {70, 60, 50, 40, 30, 20, 10};
        GreedyTaskSchedule gts = new GreedyTaskSchedule(d, w);
        System.out.println("用max{w1,12,...,wn}-wi替换");
        gts.rescheduleTask();
        gts.printList();
    }
}