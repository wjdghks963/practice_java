package chap03;

import java.util.Calendar;

public class enumType {
    public static void main(String[] args) {
        Week friday = Week.FRIDAY;
        boolean isSame = friday == Week.FRIDAY;
        System.out.println("열거형으로 지역 변수에 초기화한 값과 열거형으로 직접 부른 값은 같은 주소를 가르킨다. "+isSame); // true

        // 일주일 중 오늘이 월요일이라면 나는 공부를 한다
        // calendar는 일주일의 기준을 일요일로 시작한다 => today에서 1은 일요일
        Calendar now = Calendar.getInstance();
        int today = now.get(Calendar.DAY_OF_WEEK);

        myJobToday(today);
    }


        private static void myJobToday(int today){

         switch (today) {
             case 1 : System.out.println(Week.SUNDAY + "오늘은 노는 날입니다."); break;
             case 2 : System.out.println(Week.MONDAY + "오늘은 공부하는 날입니다."); break;
             default: System.out.println("오늘은 노는 날입니다."); break;
        };

        };
}
