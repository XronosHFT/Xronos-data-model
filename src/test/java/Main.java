import io.github.xronoshft.dto.adder.IntegerAdder;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, IntegerAdder> orderCancelCounts = new HashMap<>();

    public static void main(String[] args) {
        double x = 0.1 + 0.2;
        double round = Math.round(x * 1e15) / 1e15;
        double[] y = {1.0, 1.0, 1.01, 1.02, 1.03, 1.02, 1.01, 1.0, 0.99, 0.98, 0.97, 0.98, 0.99};
        printArray(y);
        double[] derivative = derivative(y);
        System.out.println("一阶导数");
        printArray(derivative);
        double[] derivative1 = derivative(derivative);
        System.out.println("\n二阶导数");
        printArray(derivative1);
        printArray(localMaxIndex(y));
        printArray(localMinIndex(y));
//        new KalmanFilter(new Process(), n/ew Me)
    }

    private static void printArray(double[] y) {
        for (int i = 0; i < y.length; i++) {
            System.out.print("[" + i + "]" + ":" + y[i] + ",");
        }
    }

    private static void printArray(int[] y) {
        for (int i = 0; i < y.length; i++) {
            System.out.print("[" + i + "]" + ":" + y[i] + ",");
        }
    }

    public static double[] derivative(double[] input) {
        double[] out = new double[input.length];
        for (int i = 1; i <= input.length - 1; i++) {
            out[i - 1] = Math.round((input[i] - input[i - 1]) * 1e15) / 1e15;
        }
        return out;
    }

    /**
     * 获取极大值索引
     * @param inputArray
     * @return
     */
    public static int[] localMaxIndex(double[] inputArray) {
        double[] fstDerivative = derivative(inputArray);
        StringBuilder ret = new StringBuilder();
        for (int i = 2; i < inputArray.length; i++) {
            if (fstDerivative[i - 2] > 0 && fstDerivative[i] < 0) {
                ret.append(i - 1).append(",");
            }
        }
        String[] split = ret.substring(0, ret.length() - 1).split(",");
        int[] localMaxIndexIndex = new int[split.length];
        for (int i = 0; i < localMaxIndexIndex.length; i++) {
            localMaxIndexIndex[i] = Integer.parseInt(split[i]);
        }
        return localMaxIndexIndex;
    }

    /**
     * 获取极小值索引
     * @param inputArray
     * @return
     */
    public static int[] localMinIndex(double[] inputArray) {
        double[] fstDerivative = derivative(inputArray);
        StringBuilder ret = new StringBuilder();
        for (int i = 2; i < inputArray.length; i++) {
            if (fstDerivative[i - 2] < 0 && fstDerivative[i] > 0) {
                ret.append(i - 1).append(",");
            }
        }
        String[] split = ret.substring(0, ret.length() - 1).split(",");
        int[] localMaxIndexIndex = new int[split.length];
        for (int i = 0; i < localMaxIndexIndex.length; i++) {
            localMaxIndexIndex[i] = Integer.parseInt(split[i]);
        }
        return localMaxIndexIndex;
    }
}
