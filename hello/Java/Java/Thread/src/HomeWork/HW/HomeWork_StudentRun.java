package HomeWork.HW;

class HomeWork_StudentRun implements Runnable {
    private static int rank = 0;

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "米");
        }
        rank++;
        System.out.println(Thread.currentThread().getName() + "跑了第" + rank + "名");
    }
}