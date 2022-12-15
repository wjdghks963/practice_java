package chap06;

public class ExceptionClass {
    public static void main(String[] args) {

    }
}

// null 객체에 접근
class NullPointerEX{
    String data = null;
    data.toString();
}

// 존재하지 않는 index 참조
class ArrayIndexOutOfBoundsEX {
    int [] args = {1,3,4,5};
    int data   = args[10];
}

// number format error > parse할 값이 제대로된 값(숫자인 문자)이 아님
class NumberFormatEX{
   String data1 = "100";
   // a 가 섞여있어서 parse가 정상적으로 작동 안함
   String data2 = "a1000";

   int value1 = Integer.parseInt(data1);
   int value2 = Integer.parseInt(data2);

   // error
   int result = value1+value2;
}

// 같은 자식끼리 강제 형변환 에러
class Animal{}
class Dog extends Animal{}
class Cat extends Animal{}

class ClassCastEX{
    public static void changeDog(Animal animal){
        Dog dog = (Dog) animal;
    }

    void method(){
    Dog dog = new Dog();
        changeDog(dog);
    Cat cat = new Cat();
        // Cat 을 Dog 으로 형변환 못함 error
        changeDog(cat);
    }


}

