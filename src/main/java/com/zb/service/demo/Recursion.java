package com.zb.service.demo;

/**
 * Created by bzheng on 2018/9/19.
 * 递归方法
 */
public class Recursion {

    /**
     * 盘子移动问题
     *
     * @param dish 盘子数目
     * @param from 初始盘塔
     * @param team 中介盘塔
     * @param to   目标盘塔
     */
    public static void moved(int dish, String from, String team, String to) {
        if (1 == dish) {
            System.out.println("将" + dish + "号盘子从" + from + "移动到" + to);
        } else {
            moved(dish - 1, from, to, team);
            System.out.println("将" + dish + "号盘子从" + from + "移动到" + to);
            moved(dish - 1, team, from, to);
        }
    }

    /**
     * 排序数组
     *
     * @param c
     * @param start
     * @param last
     * @return
     */
    public static int[] mergerSort(int[] c, int start, int last) {
        if (last > start) {
            int mid = start + (last - start) / 2; // 也可以 (last + start)/2,但是这样可能溢出int范围
            // 排序左边
            mergerSort(c, start, mid);
            // 排序右边
            mergerSort(c, mid + 1, last);
            // 合并数组
            merger(c, start, mid, last);
        }
        return c;
    }

    /**
     * 合并数组
     *
     * @param c
     * @param start
     * @param mid
     * @param last
     */
    public static void merger(int[] c, int start, int mid, int last) {
        int[] temp = new int[last - start + 1];
        // 左边数组下标
        int i = start;
        // 右边数组下标
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= last) {
            if (c[i] < c[j]) {
                temp[k++] = c[i++];
            } else {
                temp[k++] = c[j++];
            }
        }
        // 将左边剩余的数据放进temp
        while (i <= mid) {
            temp[k++] = c[i++];
        }
        while (j <= last) {
            temp[k++] = c[j++];
        }
        // 将temp数组里的数据覆盖到c
        for (int index = 0; index < temp.length; index++) {
            c[start + index] = temp[index];
        }
    }

    /**
     * 乘方运算，x^y = (x^2)^(y/2); 令a = x^2,b=y/2;则x^y = a^b;
     *
     * @param x 底
     * @param y 幂
     * @return
     */
    public static int pow(int x, int y) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (y > 1) {
            int a = x * x;
            int b = y / 2;
            if (y % 2 == 1) {
                // 奇数
                return pow(a, b) * x;
            } else {
                return pow(a, b);
            }
        } else if (y == 0) {
            return 1;
        } else {
            // y == 1
            return x;
        }
    }

    /**
     * 背包问题：比如：假设想要让背包精确地承重20磅，并且有 5 个可以放入的数据项，它们的重量分别是 11 磅，8 磅，7 磅，6 磅，5 磅。这个问题可能对于人类来说很简单，我们大概就可以计算出 8 磅+ 7 磅 + 5 磅 = 20 磅。但是如果让计算机来解决这个问题，就需要给计算机设定详细的指令了。
     * 　　算法如下：
     * 　　一、如果在这个过程的任何时刻，选择的数据项的总和符合目标重量，那么工作便完成了。
     * 　　二、从选择的第一个数据项开始，剩余的数据项的加和必须符合背包的目标重量减去第一个数据项的重量，这是一个新的目标重量。
     * 　　三、逐个的试每种剩余数据项组合的可能性，但是注意不要去试所有的组合，因为只要数据项的和大于目标重量的时候，就停止添加数据。
     * 　　四、如果没有合适的组合，放弃第一个数据项，并且从第二个数据项开始再重复一遍整个过程。
     * 　　五、继续从第三个数据项开始，如此下去直到你已经试验了所有的组合，这时才知道有没有解决方案。
     *
     * @param total 总质量
     * @param index 要找的下标
     */

    // 备选数据项
    private int[] weights;

    // 标记是否已查找
    private boolean[] selects;

    public Recursion(int[] weights) {
        this.weights = weights;
        this.selects = new boolean[weights.length];
    }

    public void knapsack(int total, int index) {
        if (0 > total || 0 < total && index >= weights.length) {
            // 没找到数据项，直接返回
            return;
        }
        if (total == 0) {
            // 找到了
            for (int i = 0; i < index; i++) {
                if (selects[i]) {
                    System.out.print(weights[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        selects[index] = true;
        knapsack(total - weights[index], index + 1);
        selects[index] = false;
        knapsack(total, index + 1);
    }

    /**
     * 组合：选择一支队伍
     * 　　在数学中，组合是对事物的一种选择，而不考虑他们的顺序。
     * 　　比如有5个登山队员，名称为 A,B,C,D和E。想要从这五个队员中选择三个队员去登峰，这时候如何列出所有的队员组合。（不考虑顺序）
     * 　　还是以递归的思想来解决：首先这五个人的组合选择三个人分成两个部分，第一部分包含A队员，第二部分不包含A队员。假设把从 5 个人中选出 3 个人的组合简写为（5,3），规定 n 是这群人的大小，并且 k 是组队的大小。那么根据法则可以有：
     * 　　(n,k) = (n-1,k-1) + (n-1,k)
     * 　　对于从 5 个人中选择 3 个人，有：
     * 　　(5,3) = (4,2)+(4,3)
     * 　　(4,2)表示已经有A队员了，然后从剩下的4个队员中选择2个队员，(4,3)表示从5个人中剔除A队员，从剩下的4个队员中选择3个队员，这两种情况相加就是从5个队员中选择3个队员。
     * 　　现在已经把一个大问题转换为两个小问题了。从4个人的人群中做两次选择（一次选择2个，一次选择3个），而不是从5个人的人群中选择3个。
     * 　　从4个人的人群中选择2个人，又可以表示为：(4,2) = (3,1) + (3,2)，以此类推，很容易想到递归的思想。
     */
    public static class Combination {
        private char[] person;

        private boolean[] selects;

        private int count;

        public Combination(char[] person) {
            this.person = person;
            selects = new boolean[person.length];
            count = 0;
        }

        /**
         *
         * @param teamNumber 需要选择的队员数
         * @param index 选择队员
         */
        public void combination(int teamNumber,int index) {

            if (0 == teamNumber) {
                // 找到了
                for (int i = 0;i<index;i++) {
                    if (selects[i]) {
                        System.out.print(person[i] + " ");
                    }
                }
                System.out.println();
                count++;
                return;
            }
            if (index >= person.length) {
                // 没找到
                return;
            }
            selects[index] = true;
            combination(teamNumber -1, index+1);
            selects[index] = false;
            combination(teamNumber, index+1);
        }

    }

    public static void main(String[] args) {
        //moved(3,"A","B","C");
       /* int[] c = new int[]{2,3,6,5,4,1,9,8,7,6};
        c = mergerSort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));*/
        /*int pow = pow(2, 5);
        System.out.println("2^5 = " + pow);*/
        /*int[] weights = new int[]{11,9,7,6,5};
        int total = 20;
        Recursion recursion = new Recursion(weights);
        recursion.knapsack(total, 0);*/
        char[] persons = new char[]{'A','B','C','D','E'};
        Combination combination = new Combination(persons);
        combination.combination(3,0);
        System.out.println("有：" + combination.count + "种选择");
    }
}
