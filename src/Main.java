

public class Main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new MyThreadSecond(foo);
        new MyThreadFirst(foo);
        new MyThreadThird(foo);
    }
}
