package chap08;

import java.awt.*;


/**
 * main 스레드의 반복문 띵과 task, beepTask의 run에 들어있는 함수가 동시에 작동한다.
 * 스레드 객체를 만들어서 Runnbale 객체를 줬기 때문에 스레드가 작동할 수 있고
 * 메인 스레드와 함께 다른 스레드들이 멀티 스레드로 작동하기 때문에 동시 작동이 가능하다.
 * */

public class UseThread {
    // main Thread
    public static void main(String[] args) {
        Runnable task = new Task();
        Runnable beepTask = new BeepTask();
        // 작업 스레드 객체 생성
        Thread thread = new Thread(task);
        Thread beepThread = new Thread(beepTask);

        // 스레드 클래스의 정적 메소드로 현재 스레드 참조
        Thread mainThread = Thread.currentThread();
        System.out.println("프로그램 메인 스레드"+mainThread.getName());

        // 데몬 스레드
        DemonThread demonThread = new DemonThread();
        demonThread.setDaemon(true);
        demonThread.start();

        // runable의 run 실행
        thread.start();
        beepThread.start();

        for(int i=0;i<5;i++){
            System.out.println("띵");
            try{Thread.sleep(500);}catch (Exception e){}
        }

        // 스레드 이름 설정, 가져오기
        thread.setName("sout하는 스레드");
        beepThread.setName("beep 소리 내는 스레드");
        System.out.println(thread.getName());
        System.out.println(beepThread.getName());
    }
}
// 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체 Runnable interface를 이용해 구현 객체를 만듦
// run 블록 안에 있는 작업을 마치면 스레드는 제거된다.
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("메인 말고 다른 작업 스레드 실행");
    }
}

class BeepTask implements Runnable{
    @Override
    public void run() {
        Toolkit toolkit =Toolkit.getDefaultToolkit();
        for(int i=0;i<5;i++){
            // 하드웨어 제어로 beep 소리가 남
            toolkit.beep();
            try{
                // 0.5초 정지
                Thread.sleep(500);
            }catch (Exception e){}
        }
    }
}

// Demon 스레드는 메인 스레드의 보조 스레드로 메인 스레드가 종료되면 같이 종료된다.
// 사용하기 위해선 setDemon(true)로 설정을 한 후 start한다.
class DemonThread extends Thread{
    public void save(){
        System.out.println("저장 완료");
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                break;
            }
        save();
        }
    }
}