package exercise;

class SafetyList {
    private int[] numbers = new int[3000];
    private int size = 0;

    public synchronized void add(int i) {
        numbers[size] = i;
        size++;
    }

    public int getSize() {
        return this.size;
    }

    public int get(int i) {
        return numbers[i];
    }
}
