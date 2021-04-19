import com.xronos.dto.Timer;
import net.openhft.affinity.AffinityLock;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    DelayQueue<Timer> q = new DelayQueue<>();

    new Thread(() -> {
      try (AffinityLock affinityLock = AffinityLock.acquireLock();) {
        while (true) {
          Timer poll = q.poll();
          if (poll != null) {
            System.out.println("get:" + poll.name() + ":" + System.currentTimeMillis());
          }
        }
      }
    }).start();

    new Thread(() -> {
      try (AffinityLock affinityLock = AffinityLock.acquireLock();) {
        int count = 0;
        while (true) {
          int i = count++;
          String name = "time" + i;
          q.put(new Timer().name(name).time(10, TimeUnit.SECONDS));
          System.out.println("put:" + name + ":" + System.currentTimeMillis());
          TimeUnit.SECONDS.sleep(1);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();

  }
}
