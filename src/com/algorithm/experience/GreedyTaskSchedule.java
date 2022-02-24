package com.algorithm.experience;

import java.util.*;


/**
 * @author: lqy
 * @create: 2020/12/6
 * @description: ex4
 */
public class GreedyTaskSchedule {
    private List<Task> tasks = null;
    private List<Task> earlyTasks = null;
    private List<Task> lateTasks = null;
    private Comparator<Task> comparator_d = null;
    private Comparator<Task> comparator_w = null;

    /**
     * 构造器
     *
     * @param d：deadline数组
     * @param w：惩罚数组
     */
    public GreedyTaskSchedule(int[] d, int[] w) {
        initComparator();
        initTasks(d, w);
    }

    public void scheduleTaskTest() {
        int n = tasks.size();
        // 标记数组，表示是否选择任务ai
        int[] NA = new int[n];
        // 依次将ai加入任务集A，并判断任务集A是否独立
        List<Task> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(tasks.get(i));
            if (check(A, n)) {
                NA[i] = 1;
            } else {
                // 加入ai后A不独立，将ai移出
                NA[i] = 0;
                A.remove(tasks.get(i));
            }
        }
        // 遍历NA，得到早任务集和迟任务集
        for (int i = 0; i < n; i++) {
            if (NA[i] == 1) {
                earlyTasks.add(tasks.get(i));
            } else {
                lateTasks.add(tasks.get(i));
            }
        }
        // 将早任务按deadline升序排列
        earlyTasks.sort(comparator_d);
    }

    // 用max{w1,12,...,wn}-wi替换wi
    public void rescheduleTask() {
        int max = tasks.get(0).getWeight();
        for (Task task : tasks) {
            task.setWeight(max - task.getWeight());
        }
        for (Task task : tasks) {
            System.out.print("a" + (task.getId() + 1) + "["
                    + task.getDeadLine() + ", " + task.getWeight() + "] ");
        }
        System.out.println();
        // 将任务按惩罚大小降序排序
        tasks.sort(comparator_w);
        earlyTasks = new ArrayList<Task>();
        lateTasks = new ArrayList<Task>();
        scheduleTaskTest();
    }

    /**
     * 检验任务集A的独立性：O(|A|)
     *
     * @param A：任务集
     * @param n：总任务的个数
     * @return 返回任务集A是否独立
     */
    private boolean check(List<Task> A, int n) {
        int len = A.size();
        if (len == 1) {
            return true;
        }
        int[] count = new int[n];
        // 统计deadline等于i的任务数
        for (Task ai : A) {
            count[ai.getDeadLine()]++;
        }
        // count[i]：deadline小于等于i的任务数
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (count[i] > i) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将输入数组转化为Task对象列表
     * 并将任务集按惩罚降序排列
     *
     * @param d：deadline
     * @param w：惩罚
     */
    public void initTasks(int[] d, int[] w) {
        tasks = new ArrayList<Task>();
        earlyTasks = new ArrayList<Task>();
        lateTasks = new ArrayList<Task>();
        int n = d.length;
        for (int i = 0; i < n; i++) {
            tasks.add(new Task(i, d[i], w[i]));
        }
        for (Task task : tasks) {
            System.out.print("a" + (task.getId() + 1) + "["
                    + task.getDeadLine() + ", " + task.getWeight() + "] ");
        }
        System.out.println();
        // 将任务按惩罚大小降序排序
        tasks.sort(comparator_w);
    }

    /**
     * 比较器
     */
    public void initComparator() {
        // 按deadline升序排列
        comparator_d = Comparator.comparingInt(Task::getDeadLine);
        // 按惩罚降序排列
        comparator_w = (t1, t2) -> Integer.compare(t2.getWeight(), t1.getWeight());
//        comparator_w = Comparator.comparing(Task::getWeight).reversed();
    }

    /**
     * 打印
     */
    public void printList() {
        int punish = 0;
        System.out.print("选择：");
        for (Task t : earlyTasks) {
            System.out.print("a" + (t.getId() + 1) + " ");
        }
        System.out.print("\n惩罚：");
        for (Task t : lateTasks) {
            System.out.print("a" + (t.getId() + 1) + " ");
        }
        System.out.print("\n惩罚数：");
        for (Task t : lateTasks) {
            punish += t.getWeight();
        }
        System.out.println(punish + "");
    }
}

class Task {
    private int id;
    private int deadLine;
    private int weight;

    public Task() {
    }

    public Task(int id, int deadLine, int weight) {
        this.id = id;
        this.deadLine = deadLine;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(int deadLine) {
        this.deadLine = deadLine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}