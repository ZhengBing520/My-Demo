package com.zb.service.test;

/**
 * Created by bzheng on 2018/7/20.
 */
public class VolatileTest implements Runnable {

    private volatile Test1 test1; // 不加volatile会一直循环

    public Test1 getTest1() {
        return test1;
    }

    public void setTest1(Test1 test1) {
        this.test1 = test1;
    }

    public VolatileTest(Test1 test1) {
        this.test1 = test1;
    }

    @Override
    public void run() {
        long i = 0;
        while (test1.flag) {
            i++;
        }
        System.out.println("停止循环，输出i = " + i);
    }

    public void stop() {
        test1.setFlag(false);
    }

    static class Test1 {
        private boolean flag = true;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    public static void main(String[] args) throws Exception{

        VolatileTest volatileTest = new VolatileTest(new Test1());
        Thread thread = new Thread(volatileTest);
        thread.start();
        Thread.sleep(1000);
        volatileTest.stop();
        System.out.println(volatileTest.getTest1().flag);
    }
}
