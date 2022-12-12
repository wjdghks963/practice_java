package chap03;

import java.util.Arrays;

public class arrayDetail {
    public static void main(String[] args) {
        // 배열을 선언하는 두 가지 방법이 있다.
        int[] intArray1;
        int[] intArray2 = {1,2,3,4,5};


        // new를 사용한 배열 선언
        intArray1 = new int[] {1,2,3};

        System.out.println(Arrays.toString(intArray1)); // [1,2,3]
        System.out.println(Arrays.toString(intArray2)); // [1,2,3,4,5]

        int result = addArrValue(intArray2);
        System.out.println(result); // intArray2 의 총 합

        // new 연산자로 배열 생성
        // int array의 길이가 3인 배열 생성
        int[] newIntArray = new int[3];
        System.out.println("newIntArray는 3개의 0을 가진 배열 : "+ Arrays.toString(newIntArray));

        // string array의 길이가 3인 배열 생성
        String[] newStringArray = new String[3];
        System.out.println("newStringArray는 3개의 null을 가진 배열:"+ Arrays.toString(newStringArray));

        // 이차원 배열 초기화 첫번째 방법
        int[][] intDoubleArray1;
        intDoubleArray1 = new int[][]{{0, 1, 2}, {1, 2, 3}};
        System.out.println("이차원 배열에서 전체의 배열길이 :"+intDoubleArray1.length); // 2
        System.out.println("이차원 배열에서 첫행의 배열길이 :"+intDoubleArray1[0].length); // 3
        System.out.println("이차원 배열에서 두번째행의 배열길이 :"+intDoubleArray1[1].length); // 3
        System.out.println("2행 3열의 배열에서 1행 1열은 :"+intDoubleArray1[0][0]); // 0

        // 이차원 배열 초기화 두번째 방법
        int[][] intDoubleArray2 = new int[2][3];
        for(int i=0; i<intDoubleArray2.length; i++){
            for(int j=0; j<3;j++){
                intDoubleArray2[i][j] = j;
            }
        }

        System.out.println(Arrays.deepToString(intDoubleArray2));
        System.out.println("2행 3열의 배열에서 1행 1열은 :"+intDoubleArray1[1][2]); // 3

        // 배열 복사
        int[] toCopyArr = {1,2,3};
        int[] copyArr = new int[3];
        // System.arraycopy 0 = sourceArray 1 = start index from sourceArray 2 = new array to copy 3 = start index of new array 4 = count of copy
        System.arraycopy(toCopyArr, 0,copyArr,0, toCopyArr.length);
        System.out.println(Arrays.toString(copyArr)); // [1,2,3]

    }

     private static int addArrValue(int[] scores){
        int result = 0;
         for (int score : scores) {
             result += score;
         }
        return result;
    };



}
