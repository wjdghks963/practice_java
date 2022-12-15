package chap05;

public class NestClassInterface {
    public static void main(String[] args) {
        Test Test =  new Test();
        // 정적 x
        Test.NestedClass TestNC =  Test.new NestedClass();
        TestNC.sayId(TestNC.NestID);
        // 정적
        Test.StaticNestedClass TestSNC = new Test.StaticNestedClass();
        chap05.Test.StaticNestedClass.sayId(TestSNC.SNCID);
        // local
        Test.localClassPrint();
        // interface test
        Test.setNIF(new NIFTest());
        Test.touch();
    }

    }

    class Test{

        int ID = 10;
        // 중첩 클래스
        class NestedClass {
            public int NestID = 0;
            NestedClass(){}
           public void sayId(int ID){ System.out.println("Nested ID는"+ID+ "밖 ID는"+Test.this.ID);}
        }

        static class StaticNestedClass {
            StaticNestedClass(){};
            public static int SNCID=1;
            static void sayId(int ID){System.out.println(ID);}

        }
         public void localClassPrint(){
            class LocalClass{
                LocalClass(){};
                int LocalID=3;
                void sayId(){
                    System.out.println("From Local"+LocalID);
                }

            }

            LocalClass LC = new LocalClass();
            LC.sayId();
         }

        // 중첩 인터페이스
        interface NestedInterface {
            void setName(String name);
        }
        // interface field
        NestedInterface NIF;
        // setter
        void setNIF(NestedInterface NIF){
            this.NIF = NIF;
        }
        // 구현 객체 메소드 호출
        void touch(){
            NIF.setName("Setter Name");
        }



    }

class NIFTest implements Test.NestedInterface {
    @Override
    public void setName(String name) {
        System.out.println(name);
    }
}
