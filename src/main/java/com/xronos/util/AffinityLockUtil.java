package com.xronos.util;

import net.openhft.affinity.AffinityLock;

public class AffinityLockUtil {

    public static AffinityLock getLock() {
        for (int i = 0; i < AffinityLock.PROCESSORS; i++) {
            try{
                AffinityLock affinityLock = AffinityLock.acquireLock(i);
                return affinityLock;
            } catch (Exception ignored) {
                System.out.printf(String.valueOf(ignored));
                continue;
            }
        }
        return AffinityLock.acquireLock();
    }
}
