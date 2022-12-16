package chap09;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        //ListCollections listCollections = new ListCollections();
        //listCollections.ListMethod();
        //listCollections.LinkedListMethod();

//        SetCollections setCollections = new SetCollections();
//        setCollections.hashSetMethod();

        MapCollections mapCollections = new MapCollections();
        mapCollections.HashMap();

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

// Set
// 1. 객체의 저장 순서 유지하지 않는다. 2. 객체 중복 저장 x 3. 하나의 null만 저장할 수 있다.
// 순서가 없기 때문에 전체 객체를 대상으로 한 번씩 반복해서 가져오는 반복자 iterator를 제공한다.
class SetCollections{
    // Hash Set
    Set<String> stringSet = new HashSet<String>();
    // 반복자 생성
    Iterator<String> HashSetIterator = stringSet.iterator();
    void hashSetMethod(){
        addValue(stringSet);
        loopSet(stringSet);
    }

    void addValue(Set<String> set){
        set.add("Java");
        set.add("Set");
        set.add("Map");
        set.add("List");
        System.out.println("SET CONTENT : "+set);
    }

    void loopSet(Set<String> set){
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println("\t" + element+"\t hashcode : "+element.hashCode());
        }
    }
}

// Map
// 1. key - value로 구성된 Map.Entry 객체를 저장하는 구조 2. key, value는 객체 3. key는 중복 불가, value는 중복 저장 가능 4. 동일한 key로 저장시 value update
class MapCollections{
    // HashMap
    Map<String, Integer> hashmap = new HashMap<String, Integer>();

    void HashMap(){
        // craete Map.Entry
        hashmap.put("철수",90);
        hashmap.put("영수",81);
        hashmap.put("김수",30);
        hashmap.put("가수",10);

        System.out.println("Map의 size는 "+hashmap.size()+"\t 철수의 점수는 "+ hashmap.get("철수"));

        // Set으로 key-value 얻기
        Set<String> keySet = hashmap.keySet();
        Iterator<String> iterator = keySet.iterator();

        while (iterator.hasNext()){
            String key = iterator.next();
            Integer value = hashmap.get(key);
            System.out.println("key : "+key+"\t value : "+value);
        }

        // 가수 제거
        hashmap.remove("가수");
    }

    // HashTable
    // 1. 동기화된 메소드로 구성 = 멀티 스레드가 동시에 hashtable의 메소드 실행 못함 => 스레드에 안전
    Map<String, String> hashtable = new Hashtable<String, String>();

    void HashTable(){
        // id, password를 map으로 저장
        hashtable.put("봄", "12");
        hashtable.put("여름", "123");
        hashtable.put("가을", "1234");
        hashtable.put("겨울", "12345");

        // 내용 입력받기 위해 스캐너 사용
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("아이디와 비번 입력하세요");
            System.out.println("아이디 : ");
            String id = scanner.nextLine();
            System.out.println("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();

            if(hashtable.containsKey(id)){
                if(hashtable.get(id).equals(password)){
                    System.out.println("로그인 완료");
                    break;
                }else{
                    System.out.println("비밀번호가 다릅니다.");
                }
            }else{
                System.out.println("아이디가 존재하지 않습니다.");
            }
        }

    }



}