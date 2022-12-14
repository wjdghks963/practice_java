package chap05;


interface Tv{
    String NAME = "TV";
    void turnOn();
    void turnOff();
    void setVolume(int volume);

}

public class Interface {
    public static void main(String[] args) {
       TestClass TS = new TestClass();
       Tv STv = new SamsungTv();
        TS.methodL();
        TS.methodS(STv);
        // 강제 타입 변환
        SamsungTv SMTV = (SamsungTv) STv;
        System.out.println(SMTV.name);
    }
}


class SamsungTv implements Tv{
    String name = "Samsung";
    public int volume=0;

    // interface에 있는 추상 함수들을 다 재정의 해야한다.
    @Override
    public void turnOn() {
        System.out.println("TV OFF");
    }

    @Override
    public void turnOff() {
        System.out.println("TV ON");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(name+"의 볼륨은"+volume);
    }

    // interface에서 선언한 상수 사용
    public void sayName(){
        System.out.println(Tv.NAME+"의 이름은 "+ name +"입니다.");
    }
}
class LGTV implements Tv{
    String name = "LGTV";
    public int volume=0;

    @Override
    public void turnOn() {
        System.out.println("TV OFF");
    }

    @Override
    public void turnOff() {
        System.out.println("TV ON");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(name+"의 볼륨은"+volume);
    }
    // 이건 안나옴 인터페이스에서 설정한 메소드만 나옴
    public void sayName(){
        System.out.println(Tv.NAME+"의 이름은 "+ name +"입니다.");    }
}


class TestClass {
    Tv Stv = new SamsungTv();
    TestClass(){}

    TestClass(Tv Stv){
        this.Stv = Stv;
        Stv.turnOn();
        Stv.setVolume(10);
    }

    void methodL(){
        Tv Ltv = new LGTV();
        Ltv.turnOn();
        Ltv.setVolume(12);
    }

    void methodS(Tv tv){
        tv.turnOn();
        tv.setVolume(10);
    }
}