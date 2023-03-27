package io.github.xronoshft.util;

public class OrderIdUtils {

    public static final String XS_PREFIX = "XS";
    private static final SnowflakeIdWorker worker = new SnowflakeIdWorker(0,0);

    public static Long generator() {
        return worker.nextId();
    }
}