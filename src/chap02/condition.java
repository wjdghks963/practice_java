package chap02;

public class condition {
    public static void main(String[] args) {
        int conditionValue = 10;

        if(conditionValue > 5){
            System.out.println("값이 5보다 큽니다.");
        } else if (conditionValue > 12) {
            System.out.println("값이 12보다 작습니다.");
        }

        int switchValue = (int) (Math.random() +1);
        switch (switchValue){
            case 10: {
                System.out.println("switchValue 값은 10입니다.");
            }
            case 21:{
                System.out.println("switchValue 값은 21입니다.");
            }
            default:{
                System.out.println("case 중에 답이 없습니다.");
            }
        }



    }
}
