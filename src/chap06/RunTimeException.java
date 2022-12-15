package chap06;

import java.util.logging.Logger;

public class RunTimeException {
    static Logger logger = Logger.getLogger(RunTimeException.class.getName());
    public static void main(String[] args) {

        try{
            Class clazz = Class.forName("java.lang.String2");
            String data1 = args[0];
            ThrowError();
        }catch (ClassNotFoundException e){
            System.out.println("class not found");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index not found");
        }catch (Exception e) {
            System.out.println("All Error log");
            logger.warning(e.toString());
        }finally {
            logger.info(RunTimeException.class.getName()+"의 코드를 다시 확인하세요");
        }
    }

    // 함수를 사용하는 곳에서 꼭 예외 처리를 해줘야함
    // throw는 이 함수내에서 예외처리 안하고 사용하는 곳으로 떠넘기는 키워드임
    public static void ThrowError() throws ClassNotFoundException{
        Class clazz = Class.forName("java.lang.String2");
    }
}


