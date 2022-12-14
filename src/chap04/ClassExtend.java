package chap04;

public class ClassExtend {

    static Me meme = new Me("정정",25,"프로그래머","많은");
    static Alphago AI = new Alphago("알파고", "일하기");

    public static void main(String[] args) {
        meme.Grow();
        meme.PrintInfo();
    }
}

class Human {

    String name;
    int age;
    String job;
    private int iq;
    protected String hair;

    void Grow(){
        age++;
    }
    void PrintInfo(){
        System.out.printf("이 사람의 이름은 %s, 나이는 %d, 직업은 %s, 머리카락이 %s 입니다.", name,age,job,hair);
    }
}

class Me extends Human {
    // Human을 상속 받았기 때문에 Human이 this가 된다. = Human의 필드를 가지고 있다.
    // private인 iq는 상속 받지 못하고 protected와 defualt 는 받을 수 있다.
    Me(String name, int age, String job, String hair){
        this.name = name;
        this.age = age;
        this.job = job;
        this.hair = hair;
    }
    // override anotation, super를 통해 상속받은 메소드는 오버라이드가 가능하다.
    @Override
    void Grow() {
        super.Grow();
    }
}


// 기본 생성자가 없고 arg가 들어가야하는 생성자는 super를 사용한다.
class Human2 {
    String name;
    int age;

    Human2(String name, int age){
        this.name = name;
        this.age = age;
    }
}


class Me2 extends Human2{
    Me2(String name, int age) {
        super(name, age);
    }
}


// final은 상속 불가
//final class Robot {
//    String name;
//}

// final은 상속 불가능 오류
//class Alphago extends Robot{
//
//}

class Robot {
    String name;
    final String role;

    Robot(String name, String role) {
        this.name = name;
        this.role = role;
    }

    final void makeRole(){
        System.out.println("로봇은 규칙을 못 만듭니다.");
    }
}


class Alphago extends Robot{
    public Alphago(String name, String role) {
        super(name, role);
    }
    // final은 오버라이드 불가
    // void makeRole();

    // final 값은 변경 불가
//    void setRole(String role){
//        this.role = role;
//    }
}

