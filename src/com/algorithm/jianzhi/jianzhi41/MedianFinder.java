package com.algorithm.jianzhi.jianzhi41;

import java.util.PriorityQueue;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/08/ 21:37
 */
public class MedianFinder {
    private int count;
    private PriorityQueue<Integer> minQueue;
    private PriorityQueue<Integer> maxQueue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        this.count = 0;
        this.maxQueue = new PriorityQueue<>((x, y) -> y - x);
        this.minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxQueue.offer(num);
        minQueue.offer(maxQueue.poll());
        if (count % 2 != 0) {
            maxQueue.add(minQueue.poll());
        }
    }

    public double findMedian() {
        if (count % 2 == 1) {
            return (double)maxQueue.peek();
        } else {
            return (double)(minQueue.peek() + maxQueue.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
