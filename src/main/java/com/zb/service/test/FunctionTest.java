package com.zb.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bzheng on 2019/4/12.
 */
public class FunctionTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        BiConsumer<String, Long> biConsumer = (a,b) -> {
            list.add(a);
            System.out.println(a + b);
        };
        Consumer<String> stringBiConsumer = x -> System.out.println(x);
        Stream.of("a","b").forEach(stringBiConsumer); // 执行accept方法：a b
        list.forEach(stringBiConsumer);// 里面没数据，不打印
        System.out.println("=============");
        biConsumer.accept("Binggeg", 520L);// 执行accept，list添加Binggeg ，输出： Binggeg520
        list.forEach(stringBiConsumer);// 输出Binggeg
        biConsumer = biConsumer.andThen((x, y) -> {
            if (y < 600) {
                System.out.println(x + "<600");
            }
        }); // 转换 -> 看源码分析：biConsumer 变成  (l, r) -> accept(l, r); after.accept(l, r);
        biConsumer.accept("lihaio", 300L); // 这里输出： list添加lihaio， lihaio300 lihaio<600
        list.forEach(stringBiConsumer); // Binggeg lihaio
        Consumer<String> lihaio = stringBiConsumer.andThen(x -> {
            System.out.println(x);
            list.removeIf(a -> a.equals("lihaio"));}); // 新加一个lihaio执行器
        list.forEach(stringBiConsumer);// 不变 : Binggeg lihaio
        lihaio.accept("remove----");// 输出：remove---- remove---- list删除lihaio
        list.forEach(lihaio); // list还有一个Binggeg，所以这里输出：Binggeg Binggeg
        /***
         * a
         * b
         * =============
         * Binggeg520
         * Binggeg
         * lihaio300
         * lihaio<600
         * Binggeg
         * lihaio
         * Binggeg
         * lihaio
         * remove----
         * remove----
         * Binggeg
         * Binggeg
         *
         */

        Function<String, Integer> function = x -> x.length() > 6 ? 1 : 0;
        Integer y = function.apply("y");// 返回 0
        System.out.println(y); // 0
        List<Integer> collect = list.stream().map(function).collect(Collectors.toList());
        collect.forEach(x -> System.out.println(x));// 输出1

        //compose  将T 装成 V  String -> Object
        Function<Object, String> a = x -> x+"aa"; //  Function<Object, Integer> compose = function.compose(x -> x+"aa");
//        function = x -> x.length() > 10 ? 1 : 0; // 放这的话下面的都是0
        Function<Object, Integer> compose = function.compose(a);
        Integer apply = compose.apply(1); // 先执行a -> 1aa 然后执行function 1aa > 6? 否 -> 0
        Integer apply1 = compose.apply(11111);// 先执行a -> 11111aa 然后执行function 11111aa > 6? 是 -> 1
        System.out.println(apply);// 输出 0
        System.out.println(apply1);// 输出 1

        //        function = x -> x.length() > 10 ? 1 : 0; // 放这没用了
        List<Integer> collect1 = list.stream().map(compose).collect(Collectors.toList());// Binggegaa > 6 ? -> 1
        collect1.forEach(x -> System.out.println(x));

//        function.andThen(); 不介绍了

    }
}
