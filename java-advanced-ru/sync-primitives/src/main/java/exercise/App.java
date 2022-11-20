package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        SafetyList list = new SafetyList();

        Thread thread = new Thread(new ListThread(list));
        Thread thread1 = new Thread(new ListThread(list));
        thread.start();
        thread1.start();
        thread1.join();
        thread.join();
    }
}

