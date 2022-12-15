package chap08;

import java.awt.*;

public class ControlThread {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 3초마다 beep
        for(int i=0;i<5;i++){
            toolkit.beep();
            try{Thread.sleep(3000);}catch (Exception e){}
        }
        // 1초 후 setStop으로 종료
        PrintThread1 PrintThread1 = new PrintThread1();
        PrintThread1.start();
        try{Thread.sleep(1000);}catch (Exception e){}
        PrintThread1.setStop(true);
        // 1초 후 interupt로 안전하게 종료
        PrintThead2 printThead2 = new PrintThead2();
        printThead2.start();
        try{Thread.sleep(1000);}catch (Exception e){}
        printThead2.interrupt();

    }
}


class PrintThread1 extends Thread{
    public boolean stop;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        while (!stop){
            System.out.println("실행 중");
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}

// 에러 내서 1초만에 끝내기
class  PrintThead2 extends Thread{
    @Override
    public void run() {
            while (true){
            System.out.println("실행 중");
            if(Thread.interrupted()){break;}}
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}