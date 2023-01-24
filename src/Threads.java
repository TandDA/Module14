class MyThreadFirst implements Runnable{
    private final Foo _foo;
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
    private final Foo _foo;
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
    private final Foo _foo;
    MyThreadThird(Foo foo){
        _foo = foo;
        new Thread(this).start();
    }
    @Override
    public void run() {
        _foo.third(this);
    }
}