package chap04;

public class ClassTypeCast {
    public static void main(String[] args) {
        Car car = new Car();

        for(int i=1;i<5;i++){
            int problemLocation = car.run();


            switch (problemLocation){
                case 1:
                    System.out.println("앞왼쪽 HankookTire로 교체");
                    car.frontL = new HankookTire("앞왼쪽", 15);
                    break;

                case 2:
                    System.out.println("앞오쪽 HankookTire로 교체");
                    car.frontR = new HankookTire("앞왼쪽", 15);
                    break;

                case 3:
                    System.out.println("뒤왼쪽 KimhoTire로 교체");
                    car.backR = new KimhoTire("뒤왼쪽", 15);
                    break;

                case 4:
                    System.out.println("뒤오쪽 KimhoTire로 교체");
                    car.backR = new KimhoTire("뒤왼쪽", 15);
                    break;
            }

        }
    }
}



class Car {

    Tire frontL = new Tire("앞왼", 6);
    Tire frontR = new Tire("앞오", 2);
    Tire backL = new Tire("뒤왼", 3);
    Tire backR = new Tire("뒤오", 4);

    int run(){
        System.out.println("자동차 작동 시작");
        if(!frontR.roll()){stop(); return 1;}
        if(!frontL.roll()){stop(); return 2;}
        if(!backL.roll()){stop(); return 3;}
        if(!backR.roll()){stop(); return 4;}
        return 0;
    }

    void stop(){
        System.out.println("자동차 멈춤");
    }

}
class Tire {
    public int maxRotation;
    public int accRotation;
    public String location;

    public Tire(String location, int maxRotation){
        this.location = location;
        this.maxRotation = maxRotation;
    }

    public boolean roll(){
        accRotation++;
        if(accRotation < maxRotation){
            System.out.println(location+"Tire 수명"+(maxRotation-accRotation)+"회");
            return true;
        }else{
            System.out.println("Tire 터짐");
            return false;
        }
    }
}

class HankookTire extends Tire{
    HankookTire(String location, int maxRotation){
        super(location, maxRotation);
    }

    @Override
    public boolean roll() {
        accRotation++;
        if(accRotation<maxRotation){
            System.out.println(location+"HankookTire 수명"+(maxRotation-accRotation)+"회");
            return true;
        }else{
            System.out.println(location+"HankookTire 펑크");
            return false;
        }
    }
}


class KimhoTire extends Tire{
    KimhoTire(String location, int maxRotation){
        super(location, maxRotation);
    }

    @Override
    public boolean roll() {
        accRotation++;
        if(accRotation<maxRotation){
            System.out.println(location+"KimhoTire 수명"+(maxRotation-accRotation)+"회");
            return true;
        }else{
            System.out.println(location+"KimhoTire 펑크");
            return false;
        }
    }
}