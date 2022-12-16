package chap10;

import java.io.*;

public class IOStream {
    public static void main(String[] args) throws IOException {
        OutoutStreamTest OST =  new OutoutStreamTest();
        OST.testForWriteByte();
        OST.testForWriteByteList();

        InputStreamTest IST = new InputStreamTest();
        IST.testForReadByte();
        IST.testForReadByteArray();

        WriterTest writerTest = new WriterTest();
        writerTest.writerWriteString();

        ReaderTest readerTest = new ReaderTest();
        readerTest.readEach();

    }
}

// OutputStream
class OutoutStreamTest{
    OutoutStreamTest() throws FileNotFoundException {
    }

    // 내가 output을 생성할 위치
    OutputStream os = new FileOutputStream("/Users/junghwan/Programming/ioTest.txt");

    public void testForWriteByte() throws IOException {
        // ouputstream에 출력할 객체
        // write(int b)는 1byte만 출력한다.
        os.write(67);
        os.write(68);
        os.write(69);
        // 출력 버퍼에 잔류하는 모든 바이트 출력
        os.flush();
        // 출력 스트림 close
        os.close();
    }

    public void testForWriteByteList() throws IOException{
        byte[] array = {65,66,67};
        // 매개변수에 배열이 들어가면 배열의 모든 바이드를 출력 스트림으로 보낸다.
        os.write(array);
        os.flush();
        os.close();
    }

    public void testForWriteByteListSlice() throws IOException{
        byte[] array = {66,67,68,69,70};
        // 1번째 index서부터 3개 출력
        os.write(array,1,3);
        os.flush();
        os.close();
    }
}

// InputStream
// byte는 InputStream으로 읽지 않으면 유니코드 변환이 되어있는 상태로 파일이 생성된다. ex) 65 => A
class InputStreamTest{
    // 내가 in할 위치
    FileInputStream is = new FileInputStream("/Users/junghwan/Programming/ioTest.txt");

    InputStreamTest() throws FileNotFoundException {
    }

    void testForReadByte() throws IOException {
        while (true){
            // 1byte를 읽고 그 바이트 리턴
            int data = is.read();
            if(data == -1) break;
            System.out.println(data);
        }
        // 입력 스트림 close
        is.close();
    }

    void testForReadByteArray() throws IOException{
        // byte가 들은 length 100인 array 생성
        byte[] buffer = new byte[100];
        while (true){
            int readByteNum = is.read(buffer);
            // file의 끝에 도달
            if(readByteNum == -1) break;
            for(int i=0;i<readByteNum; i++){
                System.out.println(buffer[i]);
            }
        }
        is.close();
    }

    void testForReadByteArraySlice() throws IOException{
        byte[] buffer = new byte[5];
        // 3byte(0,1,2)를 읽고 buffer[2],buffer[3],buffer[4]에 저장
        int readByteNum = is.read(buffer,2,3);
        if(readByteNum != -1){
            for(int i=0;i<buffer.length;i++){
                System.out.println(buffer[i]);
            }
        }
        is.close();
    }
}

// Writer
class WriterTest{
    WriterTest()throws IOException{}
    Writer writer = new FileWriter("/Users/junghwan/Programming/ioTest.txt");
    void writerWrite() throws IOException {
        writer.write("a");
        writer.write("b");
        writer.write("c");

        writer.flush();
        writer.close();
    }

    void writerWriteArray() throws IOException{
        char[] array = {'A','B','C'};
        writer.write(array);
        writer.flush();
        writer.close();
    }

    void writerWriteArraySlice() throws IOException{
        char[] array = {'A','B','C','D','E','F'};
        // 1번째 인덱스부터 3개 출력
        writer.write(array,1,3);

        writer.flush();
        writer.close();
    }

    void writerWriteString() throws IOException{
        String str = "ABC";
        writer.write(str);

        writer.flush();
        writer.close();
    }
}


// Reader
class ReaderTest{
    ReaderTest() throws IOException{}

    Reader reader = new FileReader("/Users/junghwan/Programming/ioTest.txt");

    // read는 입력 스트림으로부터 1개의 문자(2byte)를 읽고 int(4byte) 타입으로 리턴한다. 따라서 문자열을 읽을때 char로 typecast한다. 만약 형변환을 해주지 않는다면 데이터 값을 유니코드로 반환한다.
    void readEach() throws IOException {
        while (true){
            int data = reader.read();
            if(data == -1) break;
            System.out.println((char) data);
        }
        reader.close();
    }

    // read(char[] cbuf)는 매개변수로 주어진 문자 배열의 길이만큼 문자를 읽고 배열에 저장한다.
    void readArray() throws IOException{
        char[] buffer = new char[100];
        while (true){
            int readCharNum = reader.read(buffer);
            if(readCharNum == -1)break;
            for(int i=0;i<readCharNum;i++){
                System.out.println(buffer[i]);
            }
        }
        reader.close();
    }

    void readArraySlice() throws IOException{
        char[] buffer = new char[5];
        // 3개의 문자를 읽고 buffer[2] buffer[3] buffer[4]에 저장
        int readCharNum = reader.read(buffer,2,3);
        if(readCharNum != -1){
            for(int i=0;i<buffer.length;i++){
                System.out.println(buffer[i]);
            }
        }
        reader.close();
    }
}

