package exercise;

public class MaxThread extends Thread {

    private int[] numbers;

    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        max = numbers[0];
        for (int i : numbers) {
            if (i > max) {
                max = i;
            }
        }
    }

    public int getMax() {
        return max;
    }
}
