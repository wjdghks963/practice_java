package chap02;

public class loop {
    public static void main(String[] args) {
        // for
        int forSum = 0;
        for(int i = 0; i <= 3; i++){
            forSum += 1;
        }
        System.out.println("for문으로 0~3을 더한값 = "+ forSum);

        // 중첩 for
        int forforSum = 0;
        for(int r = 2; r < 4; r++){
            for(int m = 1; m < 4; m++ ){
                forforSum += m*r;
            }
        }
        System.out.println("중첩 for문의 결과값 : "+ forforSum); // 2*1 + 2*2 + 2*3 + 3*1 + 3*2 + 3*3

        // while
        int whileSum = 0;
        while (whileSum < 10){
            whileSum++;
        }
        System.out.println("whileSum의 값은 10입니다." + whileSum); // 10 보다 작을 때 까지 1을 더한다.

        // do while
        int doWhileSum = 0;
        // do 실행문을 실행
        do {
            doWhileSum++;
        }while (doWhileSum < 10); // 조건문이 맞을때 종료 10 보다 작을 때 까지만

        System.out.println("doWhileSum의 값은 10입니다."+doWhileSum);

        // break, continue

        for(int i=0; i<10;i++){
            if(i==2) continue; // 이번 조건에 맞는 반복문 종료
            if(i==3) break; // 반목문 자체를 종료
        }
    }
}
