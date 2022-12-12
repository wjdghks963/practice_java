package chap03;

public class referenceTypeVar {
    public static void main(String[] args) {
        String a1 = "A";
        String a2 = "A";
        // 아래 두 print가 출력하는 메모리 주소 값은 같다.
        System.out.println(System.identityHashCode(a1));
        System.out.println(System.identityHashCode(a2));


        String name = null;
        // null pointer exception error
        System.out.println(name.length());

    }
}
