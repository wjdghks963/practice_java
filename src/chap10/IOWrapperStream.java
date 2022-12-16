package chap10;

import java.io.*;


public class IOWrapperStream {

}

// 문자 변환 보조 스트림
// 소스 스트림이 바이트 기반 스트림이면서 입출력 데이터가 문자라면 Reader,Writer로 변환해 사용하는 것이 편리하다.
class CharStreamWrapper {

    class OutputStreamWrapper {
        OutputStreamWrapper() throws FileNotFoundException {
        }

        // Stream을 생성하고
        FileOutputStream fos = new FileOutputStream("..");
        // Wrapper Stream을 연결
        Writer writer = new OutputStreamWriter(fos);

        void writeOutput() throws IOException {
            String str = "보조 스트림으로 입력";
            writer.write(str);
            writer.flush();
            writer.close();
        }
    }

    class InputStreamWrapper {
        InputStreamWrapper() throws FileNotFoundException {
        }

        FileInputStream fis = new FileInputStream("");
        Reader reader = new InputStreamReader(fis);

        String readInput() throws IOException {
            char[] buffer = new char[100];
            int readCharNum = reader.read(buffer);
            reader.close();
            String data = new String(buffer, 0, readCharNum);
            return data;
        }
    }
}

// 성능 향상 보조 스트림
class PerformImproveStream{
        PerformImproveStream() throws Exception {}
        // 이 class가 있는 패키지에서 ""의 이름을 가진 자원의 path를 가져와라
        String originalFilePath1 = PerformImproveStream.class.getResource("").getPath();
        String targetFilePath1 = "output file path";
        FileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);
        String originalFilePath2 = PerformImproveStream.class.getResource("").getPath();
        String targetFilePath2 = "output file2 path";
        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);


        void timeDifference() throws Exception {
            long nonbufferTime = copy(fis, fos);
            System.out.println("버퍼를 사용하지 않았을 때 : \t"+nonbufferTime);
            long bufferTime = copy(fis2,fos2);
            System.out.println("버퍼를 사용했을 때 : \t"+bufferTime);
        }



        static int data = -1;
        long copy(InputStream is, OutputStream os) throws Exception{
            long start = System.nanoTime();
            while (true){
                data = is.read();
                if(data == -1) break;
                os.write(data);
            }
            os.flush();
            long end = System.nanoTime();
            return end-start

        }


}
