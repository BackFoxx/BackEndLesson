package anonymousInterface.v6;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//            }

//            while (true) {
//                System.out.println("Thread " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("exit!");
//                    return;
//                }
//            }
            System.out.println("Thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

//        System.out.println("hello");
//        Thread.sleep(3000L);
//        thread.interrupt();

        System.out.println("Thread " + Thread.currentThread().getName());
        thread.join(); // 기다림
        System.out.println(thread + " is finished");
    }

//    static class MyThread extends Thread {
//        @Override
//        public void run() {
//            System.out.println("Thread " + Thread.currentThread().getName());
//        }
//    }

}
