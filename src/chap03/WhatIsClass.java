package chap03;

public class WhatIsClass {
    public static void main(String[] args) {
        Car myNewCar = new Car("빨간색", "빨강 자동차", 1000);
        Car onlyColor = new Car("파랑색");
        Car noArgs = new Car();

        myNewCar.spec(); // 색, 이름, cc가 들어간 차의 스펙
        myNewCar.seat(1,1,1); // 3
        onlyColor.spec(); // 색만 있는 차의 스펙
        onlyColor.seat("4"); // 4
        noArgs.spec(); // constructor에서 this를 사용해 매개변수 3개를 가진 생성자를 이용해 이미 필드값이 정해져 있는 인스턴스

    }
}

class Car{
    // filed
    int price;
    String name;
    String color;
    int cc;
    // constructor

    // this
    Car(){
        this("red", "빨간색 차", 10000);
    }
    // overreide
    Car(String color){
        this.color = color;
    }
    Car(String color, String name, int cc) {
       // filed에서 선언한 name 은 생성자에서 받은 name으로 초기화한다.
        this.name = name;
        this.color = color;
        this.cc = cc;
        price = 100000;
    }

    // method
    void spec(){
        System.out.printf("이 차의 이름은 %s이고 색은 %s, cc는 %d, 가격은 %d", name, color, cc, price);
    }

    // args에 값이 얼마나 들어올 줄 모를때 ...를 사용한다.
    void seat(int ... value){
        int result = 0;
        for (int i : value) {
            result += i;
        }
        System.out.println("이 차에는 몇명이 탈 수 있나요 " + result);
    }
    // method override
    void seat(String value){
        System.out.println("이 차에는 몇명이 탈 수 있나요 " + value);
    }
}
