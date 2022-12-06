package chap01;

import java.util.Scanner;

public class systemIO {
    public static void main(String[] args) {
        System.out.print("enter가 들어있지 않은 system log string");
        System.out.println("일반적으로 enter가 들어간 system log string");
        System.out.printf("문자 형식에 맞게 format 한 log string");

        // printf
        System.out.printf("이름 : %s \n", "문자열");
        System.out.printf("나이 : %d \n", 20);
        System.out.printf("이름 : %s, 나이 : %d", "문자열", 20);

        // Scanner
        Scanner scanner = new Scanner(System.in);
        String inputData;

        while (true){
            inputData = scanner.nextLine();
            System.out.println("입력된 문자열 : \""+inputData+"\"");
            if(inputData.equals("q")){
                break;
            }
        }
    }
}
