import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new MyThreadSecond(foo);
        new MyThreadFirst(foo);
        new MyThreadThird(foo);
    }
}
class MyThreadFirst implements Runnable{
    private Foo _foo;
    MyThreadFirst(Foo foo){
        _foo = foo;
        new Thread(this).start();
    }
    @Override
    public void run() {
        _foo.first(this);
    }
}
class MyThreadSecond implements Runnable{
    private Foo _foo;
    MyThreadSecond(Foo foo){
        _foo = foo;
        new Thread(this).start();
    }
    @Override
    public void run() {
        _foo.second(this);
    }
}
class MyThreadThird implements Runnable{
    private Foo _foo;
    MyThreadThird(Foo foo){
        _foo = foo;
        new Thread(this).start();
    }
    @Override
    public void run() {
        _foo.third(this);
    }
}
class Foo {
    private Semaphore semFirst = new Semaphore(1);
    private Semaphore semSecond = new Semaphore(0);
    private Semaphore semThird = new Semaphore(0);
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
