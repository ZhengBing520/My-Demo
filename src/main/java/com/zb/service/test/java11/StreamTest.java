package com.zb.service.test.java11;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by bzheng on 2018/9/28.
 */
public class StreamTest {

    public static void main(String[] args) throws Exception{
        /*List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        List<Integer> b = List.of(1,2,3);

        var strings = List.copyOf(a);
        strings.add(2);
        List<Integer> strings2 = List.copyOf(b);
        strings2.add(2);
        System.out.println(strings == a);
        System.out.println(strings2 == b);*/
        /*var string = "ssss";
        var b = "ssss";
        var c = 2;
        var d = c + 5;
        System.out.println(b == string);*/
        String str = "丨";
        for (byte aByte : str.getBytes()) {
            System.out.println(aByte);
        }
        ;
    }
}
