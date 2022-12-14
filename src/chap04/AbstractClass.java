package chap04;

public class AbstractClass {
}


abstract class Phone{
    public String owner;
    public Phone(String owner){
        this.owner = owner;
    }

    public void turnOn(){
        System.out.println("Phone on");
    }
    public void turnOff(){
        System.out.println("Phone off");
    }
    // abstract 메소드는 본문을 가질수 없다.
    public abstract void ring();
}

class Galaxy extends Phone {
    public Galaxy(String owner){
        super(owner);
    }

    public void search(){
        System.out.println("전화번호 찾기");
    }

    @Override
    public void ring() {
        System.out.println("GalGal");
    }
}
class Apple extends Phone {
    public Apple(String owner){
        super(owner);
    }

    @Override
    public void ring() {
        System.out.println("AppApp");
    }
}

