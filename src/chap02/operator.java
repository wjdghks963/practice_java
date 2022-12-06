package chap02;

public class operator {
    public static void main(String[] args) {

        // 단항 연산자(증감, 논리) or 대입 오른쪽에서 왼쪽으로
        int x, y;
        x = y =10;

        ++x; // x = 11

        boolean boolResult = ( x + y ) < 5; // x+y 먼저 한 후 오른쪽과 비교

        boolean play = true;
        play = !play; // false

        // 이항 연산자
        int num = 13;
        int intResult =  num % 3; // 4

        char c1 = 'A' + 1; // int + int => 66 => 'B'

        String str1 = "JAVA" + 6.0; // string + string => string => "JDK6.0"

        boolean unicode = 'A' == 65; // 65 == 65 => true
        boolean doubleResult = 3 == 3.0;// 3.0 == 3.0 => true

        String str2 = "JAVA6.0";

        System.out.println("is str1,str2 same"+ str1.equals(str2)); // true

        // 논리 연산자

        int charCode = 'A';

        if(charCode>=65 && charCode<=90){
            System.out.println("대문자");
        }

        int six = 6;

        if(six%2==0 | six%3==0){
            System.out.println("2 또는 3 배수");
        }

        if(six%2==0||six%3==0){
            System.out.println("2 또는 3 배수");
        }

        // 대입 연산자

        int two = 2;
        two += 1; // 3
        two -= 1; // 2
        two ^= 3; // 8

        // 삼항 연산자

        int score = 93;
        char grade = score > 90 ? 'A' : 'B'; // 'A'


    }
}
