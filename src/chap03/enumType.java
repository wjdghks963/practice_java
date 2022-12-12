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
        Week weekOfToday =  Week.MONDAY;
        switch (today){
            case 1 : weekOfToday = Week.SUNDAY; break;
            case 3 : weekOfToday = Week.TUESDAY; break;
            case 4 : weekOfToday = Week.WEDNESDAY; break;
            case 5 : weekOfToday = Week.THURSDAY; break;
            case 6 : weekOfToday = Week.FRIDAY; break;
            case 7 : weekOfToday = Week.SATURDAY; break;
        }

        myJobToday(weekOfToday);
    }


        private static void myJobToday(Week today){

         switch (today) {
             case SUNDAY : System.out.println(Week.SUNDAY + "오늘은 노는 날입니다."); break;
             case MONDAY : System.out.println(Week.MONDAY + "오늘은 공부하는 날입니다."); break;
             default: System.out.println("오늘은 노는 날입니다."); break;
        };

        };
}
