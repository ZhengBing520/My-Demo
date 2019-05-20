package java8;

import com.zb.service.service.Service;
import io.lettuce.core.ScriptOutputType;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.yaml.snakeyaml.nodes.ScalarNode;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by bzheng on 2018/7/20.
 */

public class Test {

    @org.junit.Test
    public void time() {
        double a = 0;
        double b = 0;
        double c = (-1e-6);
        double d = (1e-6);

        if((a <=  c|| a >= (1e-6)) && (b <= (-1e-6) || b >= (1e-6))){
            System.out.println(a + ":" + b);
        }
        if (a <= c) {
            System.out.println("a");
        }
        if (a >= c) {
            System.out.println("b");
        }
        if (a <= d) {
            System.out.println("c");
        }
        if (a >= d) {
            System.out.println("d");
        }


    }

    @org.junit.Test
    public void testPrimer() {
        BigDecimal bigDecimal = new BigDecimal(0.01);
        double v = bigDecimal.doubleValue();
        System.out.println(v + "");
       /* Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个最大数：");
        int n = scanner.nextInt();
        printPrimeNumbers(n);*/
    }

    public void printPrimeNumbers(int n) {
        boolean flag ;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("质数：");

        if (n < 2) {
            return;
        }
        stringBuilder.append(2);
        // 偶数（除了2）不用除，必然不是质数
        for (int i = 3; i < n; i+=2) {
            flag = true;
            // 如果 a * b = c; 那么必然有： a <= c^(1/2) 或 b <= c^(1/2); 两个数相乘一定会有一个数小于或等于乘积的开方
            for (int j = 3; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    // 不是质数
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append("、").append(i);
            }
        }
        System.out.println(stringBuilder.toString());
    }

    @org.junit.Test
    public void test1() {
       /* Service service = () -> {
        };
        service.defaultService();*/

    }

    @org.junit.Test
    public void test2() {
        String[] names = new String[]{"Tom", "Peter", "Jick"};
        List<Runnable> list = new ArrayList<>();
        /*for (String name : names) {
            list.add(() -> {
                System.out.println(name);
            });
        }*/
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            list.add(() -> {
                System.out.println(name);
            });
        }
        list.forEach(Runnable::run);
    }

    @org.junit.Test
    public void test3() {
        Integer[] integers = new Integer[10];
        int i = 0;
        for (; i <= 10; i++) {
            integers[i] = 0;
            System.out.println(i);
        }
    }

    @org.junit.Test
    public void test4() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        long count = list.stream().filter(integer -> integer > 50).count();
        System.out.println(count);
        long end = System.currentTimeMillis();
        long count1 = list.parallelStream().filter(integer -> integer > 50).count();
        System.out.println(count1);
        long end2 = System.currentTimeMillis();
        System.out.println("count = " + count + "???" + (end - start) + "\n" + "parallel ??? ?" + (end2 - end));
    }

    @org.junit.Test
    public void test5() {
        /*Method[] methods = User.class.getMethods();
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            Double a = new Double(1);
            System.out.println(returnType.isInstance(new Dauble()));
            if (method.getName().length() > 3 && method.getName().startsWith("get")
                    && !method.getName().equals("getClass") && Double.class.isInstance(method.getReturnType())) {
                System.out.println(method.getName());
                System.out.println();
            }
        }*/
    }

    @org.junit.Test
    public void test6() {
        String tmp = "101.0";
        Double aLong = Double.valueOf(tmp);
        System.out.println(Math.round(aLong));
        if (null != tmp) {
            tmp = dispose(tmp);
            System.out.println(tmp);
        }
    }

    public String dispose(String tmp) {
        String substring = tmp.substring(tmp.indexOf(".") + 1);
        if (null != substring && ("0".equals(substring) || "00".equals(substring))) {
            tmp = tmp.substring(0, tmp.indexOf("."));
        }
        return tmp;
    }

    @org.junit.Test
    public void test7() {
        int[] arr = new int[]{1, 10, 8, 5, 3, 9, 7, 2};
        for (int i = 1; i < arr.length; i++) {
            //????
            int insertVal = arr[i];
            //??????(?????????)
            int index = i - 1;
            //?????????????
            while (index >= 0 && insertVal < arr[index]) {
                //?? arr[index] ????
                arr[index + 1] = arr[index];
                //? index ????
                index--;
            }
            //???????????
            arr[index + 1] = insertVal;
        }
        ;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @org.junit.Test
    public void test8() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i / 2);
        }
    }

    @org.junit.Test
    public void test9() {
        int i = 0;
        while (true) {
            i++;
            String randomChar = RandomStringUtils.randomNumeric(7);
            System.out.println(randomChar);
            if (i == 10)
                break;
        }

    }

    @org.junit.Test
    public void test10() {
        Integer d = 5;
        Integer cc = new Integer(5);
        System.out.println(d == cc);
        System.out.println(d.hashCode());
        System.out.println(cc.hashCode());
        String c = new String("abc");
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        System.out.println(a == c);
    }

    @org.junit.Test
    public void test11() {
        String str = "hello word!";
        Stack stack = new Stack();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            stack.push(aChar);
        }
        while (!stack.empty()) {
            Object pop = stack.pop();
            System.out.print(pop);
        }
    }

    @org.junit.Test
    public void testType() {
        int j = 0;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            double a = 5 * Math.pow(10,i);
            System.out.println(a);
            count += a;
        }
        System.out.println(count);
    }

    @org.junit.Test
    public void test() {
        int[] a = new int[]{1,2,3,5,7,9,8};
        int target = 10;
        long startTime = System.currentTimeMillis();
        int[] ints = twoSum(a, target);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(ints));
        System.out.println(endTime - startTime);

    }

    public int[] twoSum(int[] nums, int target) {
        final int il = nums.length;
        int il2 = (il >> 2) - 1;

        int pot = 2;
        while((il2 >>= 1) > 0) pot <<= 1;
        final int bitMod = pot - 1;
        final int[] bucket = new int[pot];
        final int[] linked = new int[il];

        final int firstVal = nums[0];

        for (int i = 1; i < il; i++) {
            int currNum = nums[i];
            int complement = target - currNum;

            if (complement == firstVal) {
                return new int[] { 0, i };
            }

            int complementLLIndex = bucket[complement & bitMod];
            while(complementLLIndex != 0) {
                if(nums[complementLLIndex] == complement) {
                    //Found
                    return new int[] { complementLLIndex, i };
                }
                complementLLIndex = linked[complementLLIndex];
            }
            int currNumLLIndex = currNum & bitMod;
            linked[i] = bucket[currNumLLIndex];
            bucket[currNumLLIndex] = i;
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        /*for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }*/
        for(int i = 0; i < nums.length; i++) {
            Integer count = target - nums[i];
            if(map.containsKey(count) && map.get(count) != i) {
                return new int[] {i, map.get(count)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @org.junit.Test
    public void test23() {
        int index = 0;
        int length = 61;
        int max = 20;
        while (0 < length) {
            index++;
            length--;
            if (0 == length || index % max == 0) {
                System.out.println("length:" + length + "index:" + index);
            }
        }
    }

    @org.junit.Test
    public void test24() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(1544432400000L);
        ;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(cal.getTime());
        System.out.println(format1);
    }

    @org.junit.Test
    public void test25() throws Exception{
        int a = 2;
        int i = a << 3;
        int a1 = a >> 31;
        long b = 10L;
        long l = b << 64;
        System.out.println(a);
        System.out.println(i);
        System.out.println(a1);
        System.out.println(l);
        Callable<String> callable = test26();
        System.out.println(callable.call());
    }

//    @org.junit.Test
    public Callable<String> test26() throws Exception{
        System.out.println("当前主线程开始：" + Thread.currentThread() + "，当前毫秒数：" + System.currentTimeMillis());
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("当前子线程开始：" + Thread.currentThread() + "，当前毫秒数：" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("当前子线程结束：" + Thread.currentThread() + "，当前毫秒数：" + System.currentTimeMillis());
                return "SUCCESS";
            }
        };
        System.out.println("当前主线程结束：" + Thread.currentThread() + "，当前毫秒数：" + System.currentTimeMillis());
        return callable;
    }
    @org.junit.Test
    public void test27() throws Exception{
    }
}
