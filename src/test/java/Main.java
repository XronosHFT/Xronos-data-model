import com.xronos.dto.adder.IntegerAdder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Main {
  private static Map<String, IntegerAdder> orderCancelCounts = new HashMap<>();

  public static void main(String[] args) {
    List<String> symbolList = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      symbolList.add(UUID.randomUUID().toString());
    }
    for (String symbol : symbolList) {
      orderCancelCounts.put(symbol, new IntegerAdder(0));
    }

    for (String symbol : symbolList) {
      orderCancelCounts.get(symbol).increment();
      System.out.println(symbol + "====" + orderCancelCounts.get(symbol));
    }

    for (String symbol : symbolList) {
      orderCancelCounts.get(symbol).increment();
    }

    for (Map.Entry<String, IntegerAdder> entry : orderCancelCounts.entrySet()) {
      System.out.println(entry.getKey() + "====" + entry.getValue().get());

    }

    for (String symbol : symbolList) {
      orderCancelCounts.get(symbol).reset();
      System.out.println(symbol + "====" + orderCancelCounts.get(symbol));
    }

    for (Map.Entry<String, IntegerAdder> entry : orderCancelCounts.entrySet()) {
      System.out.println(entry.getKey() + "====" + entry.getValue().get());
    }
  }
}
