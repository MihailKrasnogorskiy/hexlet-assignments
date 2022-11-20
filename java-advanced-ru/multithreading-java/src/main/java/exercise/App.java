package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    public static Map<String, Integer> getMinMax(int[] numbers) {
        Map<String, Integer> minMax = new HashMap<>();
        MinThread trMin = new MinThread(numbers);
        MaxThread trMax = new MaxThread(numbers);
        trMin.start();
        trMax.start();
        try {
            trMax.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            trMin.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        minMax.put("min", trMin.getMin());
        minMax.put("max", trMax.getMax());
        return minMax;
    }
}
