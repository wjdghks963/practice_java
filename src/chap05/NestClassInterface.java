package chap05;

public class NestClassInterface {
    public static void main(String[] args) {
        NestTest NestTest =  new NestTest();
        // 정적 x
        NestTest.NestedClass NestTestNC =  NestTest.new NestedClass();
        NestTestNC.sayId(NestTestNC.NestID);
        // 정적
        NestTest.StaticNestedClass NestTestSNC = new NestTest.StaticNestedClass();
        chap05.NestTest.StaticNestedClass.sayId(NestTestSNC.SNCID);
        // local
        NestTest.localClassPrint();
        // interface NestTest
        NestTest.setNIF(new NIFNestTest());
        NestTest.touch();
    }

    }

    class NestTest{

        int ID = 10;
        // 중첩 클래스
        class NestedClass {
            public int NestID = 0;
            NestedClass(){}
           public void sayId(int ID){ System.out.println("Nested ID는"+ID+ "밖 ID는"+NestTest.this.ID);}
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

class NIFNestTest implements NestTest.NestedInterface {
    @Override
    public void setName(String name) {
        System.out.println(name);
    }
}
