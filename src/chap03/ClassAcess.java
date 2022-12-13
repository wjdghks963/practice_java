package chap03;
import chap02.condition;
public class ClassAcess {
    public static void main(String[] args) {
        Default DInstance = new Default();
        int protectedTen = DInstance.ProtectedTen; // 10
        int publicTen = DInstance.PublicTen; // 10

    }

    // import 한 클래스로 객체 만들기
    condition conditionIns = new condition();

}


// 싱글톤 구현
// 싱글톤으로 생성된 인스턴스는 new를 이용하더라도 같은 메모리 주소를 가지고 있다.
class Single {
    // 접근이 불가능한 인스턴스 선언, 초기화
    private static final Single singleton = new Single();
    // 생성자
    private Single(){}
    // 정적으로 접근이 가능한 싱글톤을 반환하는 메소드
    static Single getInstance(){
        return singleton;
    }
}


// defualt 접근 제한자

class Default {
    // 자식 클래스 사용 가능
    protected int ProtectedTen  = 10;
    public int PublicTen = 10;
    // 접근 불가
    private int PrivateTen = 10;
}

