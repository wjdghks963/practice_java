package chap08;

public class SyncThread {
    public static void main(String[] args) {
        TCalculator calculator = new TCalculator();

        // user1이 먼저 calculator 점유
        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();

        // user1이 하고 있는 일이 끝나기 전까진 setMemory 접근 못함
        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
    }
}

class TCalculator{
    private int memory;
    public int getMemory(){
        return memory;
    }

    public synchronized void setMemory(int memory){
        this.memory = memory;
        try{
            Thread.sleep(2000);
        }catch (Exception e){}
        System.out.println(Thread.currentThread().getName() + " : "+this.memory);
    };
}


class User1 extends Thread{
    private TCalculator calculator;

    public void setCalculator(TCalculator calculator) {
        this.setName("User1 Thread");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}

class User2 extends Thread{
    private TCalculator calculator;

    public void setCalculator(TCalculator calculator) {
        this.setName("User2 Thread");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);
    }
}