package chap07;

import java.util.Date;
import java.util.HashMap;

public class JAVALangAPI {
    public static void main(String[] args) {
        verifyHashCode.putKeyValue(new Key(1));
        verifyHashCode.putKeyValue(new Key(2));
        HashMap<Key, String> vHC = verifyHashCode.hashMap;
        System.out.println(vHC);

        STRINGCLASS stringclass = new STRINGCLASS();
        stringclass.saySTR();
    }
}

// equal()
class equalTestObject{ }
class OBJECT {
    equalTestObject obj1 = new equalTestObject();
    equalTestObject obj2 = new equalTestObject();

    // result1 == result2
    boolean result1 = obj1.equals(obj2);
    boolean result2 = obj1 == obj2;
}

// Hashcode()
class Key{
    int id;
    Key(int id){
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
class verifyHashCode {

    public static HashMap<Key, String> hashMap = new HashMap<Key, String>();
    public static void putKeyValue(Key key){
        hashMap.put(key, "홍길동");
    }
    public static void getValue(Key key){
        String value = hashMap.get(key);
        System.out.println(value);
    }
}

// toString()
class StringMethod{
    Date obj1 = new Date();
    void print(){
        System.out.println(obj1.toString());
    }
}

// System

// exit 프로그램 종료
class ForceExit{
    void exitProgram(){
        for(int i=0; i<4;i++){
            if(i==3){
                System.exit(0);
            }
        }
    }
}

// 시간 읽기
class ReadTime{
    // 현재 밀리 세컨드
    long time = System.currentTimeMillis();
    // 현재 나노 세컨드
    long nanoTime = System.nanoTime();
}

// Class

class GETCLASSINFO{
    // 찾고자 하는 클래스 패키지 네임부터 끝까지 = 절대 경로

    // 이름이 뭔지
    public static void getClassName() throws ClassNotFoundException{
       Class clazz = Class.forName("java.lang.Class");
       System.out.println(clazz.getName());
    }
    // clazz가 있는 패키지에서 접근 가능한 리소스들 path
    public static void getResourceName() throws ClassNotFoundException{
         Class clazz = Class.forName("java.lang.Class");
        clazz.getResource("").getPath();

    }
}

// String

class STRINGCLASS {
    byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
    String str = new String(bytes);
    String strFromTwoForThree = new String(bytes, 2,3); // 108, 108,111

    public void saySTR(){
        System.out.println(str);
        System.out.println(strFromTwoForThree);
    }
}

// Wrapper
class WRAPPER{
    // boxing
    Byte boxingByte = new Byte((byte) 10);
    Long boxingLong  = new Long(100000);
    Integer intValue = new Integer("10000");

    // unboxing
    Byte unboxingByte = new Byte("10");
    Long unboxingLong = new Long("100000");

    void unBoxing(){
        // 자동
        byte byteValue = boxingByte.byteValue();
        long longValue = boxingLong.longValue();
        // 자동 x
        long longIntegerValue =  intValue.longValue();
    }
}


// Math

class MATHCLASS{
    // 절대값
    public static int abs = Math.abs(-100);
    // 올림 내림
    public static double ceil = Math.ceil(2.3);
    public static double floor = Math.floor(3.4);
    // 최대 최소
    public static int max = Math.max(10,1); // 10
    public static int min = Math.min(12,11); // 11
    // 랜덤
    public static double random = Math.random();
    // 가까운 정수의 실수 값
    double rint = Math.rint(3.2); // 3
    // 반올림
    long round = Math.round(3.2); // 3
}