package chap05;

public class AnonymousObject {
    public static void main(String[] args) {
        AnoLocalVar AnoVar = new AnoLocalVar();
        AnoVar.method(1,3);
    }
}


class AnoParent {
    public int age;
    public String job;
    public void sayHi(){
        System.out.println("Hi");
    }
}

class AnoChild extends AnoParent{ }

class AnonymousTest{
 AnoParent Child = new AnoChild();

 void method(){
     // 익명 객체 만들기, extends를 이용해서 새로운 클래스를 생성하지 않고 익명으로 함수에서 한번만 사용할 객체를 만들때 유용하다.
     AnoParent localVar = new AnoParent(){
         int childAge;
         String childJob;

         @Override
         public void sayHi() {
             super.sayHi();
         }
     };


 }


}


class AnonyInterface {
    // 일반적으로 사용하는 클래스 내 인터페이스
    Tv TV = new Tv() {
        @Override
        public void turnOn() {

        }

        @Override
        public void turnOff() {

        }

        @Override
        public void setVolume(int volume) {

        }
    };

    // 익명으로 사용
    void method1(Tv TV){}
    void method(){
        method1(
                new Tv() {
                    @Override
                    public void turnOn() {

                    }

                    @Override
                    public void turnOff() {

                    }

                    @Override
                    public void setVolume(int volume) {

                    }
                }
        );
    }

}

// 익명 객체 로컬 변수 사용
interface AnoCalculatable {
    int sum();
}
class AnoLocalVar{
    private int field;
    public void method(final int arg1, int arg2){
        final int var1 = 0;
        int var2 = 0;
        field = 10;

        AnoCalculatable calc = new AnoCalculatable() {
            @Override
            public int sum() {
                int result = field + arg1+arg2+var1+var2;
                return result;
            }
        };
        System.out.println(calc.sum());
    }
}