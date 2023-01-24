import java.util.concurrent.Semaphore;

class Foo {
    private final Semaphore semFirst = new Semaphore(1);
    private final Semaphore semSecond = new Semaphore(0);
    private final Semaphore semThird = new Semaphore(0);
    public void first(Runnable r) {
        try {
            semFirst.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("first");
        semSecond.release();
    }
    public void second(Runnable r) {
        try {
            semSecond.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("second");
        semThird.release();
    }
    public void third(Runnable r) {
        try {
            semThird.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("third");
    }
}