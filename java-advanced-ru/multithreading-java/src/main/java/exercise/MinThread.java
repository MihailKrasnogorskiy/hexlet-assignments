package exercise;

public class MinThread extends Thread {
    private int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        min = numbers[0];
        for (int i : numbers) {
            if (i < min) {
                min = i;
            }
        }
    }

    public int getMin() {
        return min;
    }
}

