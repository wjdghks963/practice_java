package chap01;

public class typecast {
    public static void main(String[] args) {

        // 자동 type cast

        byte byteValue = 10;
        int intValue = byteValue;
        System.out.println("10을 int :"+intValue); // 10

        char charValue = 'A';
        intValue = charValue;
        System.out.println("A의 유니코드:" + intValue); // 65

        long longValue = 100;
        float floatValue = longValue;
        System.out.println("100을 float : "+floatValue); // 100.0

        // 강제 type cast

        int x = 1;
        int y = 2;
        double result = (double) x/y;
        System.out.println("1/2 = "+result);

        double doubleVale = 3.14;
        int doubleToIntValue = (int) doubleVale;

        System.out.println("3.14 to int :" + doubleToIntValue);
    }
}
