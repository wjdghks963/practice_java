package chap09;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        ListCollections listCollections = new ListCollections();
        listCollections.ListMethod();
        listCollections.LinkedListMethod();


    }
}



// List
// 배열과 비슷하게 객체를 인덱스로 관리한다. 저장 용량이 자동으로 증가하며 객체를 저장할 때 자동 인덱스가 부여된다.
class ListCollections{
    // ArrayList
    List<String> list = new ArrayList<String>();
    void ListMethod(){
        // add
        list.add("value added");
        list.add(1,"third value" );
        // remove index 지정
        list.remove(0);

        System.out.println("list content = "+list + "list size" +list.size() + "index 0 value is : " + list.get(0));
    }

    // Vector (thread safe)
    // 동기화된 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 Vector의 메소드들을 실행할 수 없다.
    List<String> vector = new Vector<String>();

    void VectorMethod(){
        vector.add("Vector added");
        vector.add("Vector added2");
        vector.remove(1);
    }

    // LinkedList
    // 인접 참조를 링크해 체인처럼 관리하기 때문에 중간 추가 삭제 시간 외의 행위들은 시간이 ArrayList보다 오래 걸린다.
    List<Integer> linkedList = new LinkedList<Integer>();
    List<Integer> arrayListForTest = new ArrayList<Integer>();

    long startTime;
    long endTime;

    void LinkedListMethod(){
        startTime = System.nanoTime();
        for(int i=0;i<1000; i++){
            arrayListForTest.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린 시간 : "+ (endTime - startTime)+" ns");

        startTime = System.nanoTime();
        for(int i=0;i<1000; i++){
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린 시간 : "+ (endTime - startTime)+" ns");
    }


}

