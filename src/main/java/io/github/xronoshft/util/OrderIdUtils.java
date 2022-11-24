package io.github.xronoshft.util;

public class OrderIdUtils {

    public static final String XS_PREFIX = "XS";

    public static String generator(String prefix) {
        return prefix + System.nanoTime();
    }

    public static void main(String[] args) {
        System.out.println(generator(XS_PREFIX));
    }
}