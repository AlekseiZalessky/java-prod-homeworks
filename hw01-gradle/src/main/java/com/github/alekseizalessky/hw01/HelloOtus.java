package com.github.alekseizalessky.hw01;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(Lists.reverse(list));
    }
}
