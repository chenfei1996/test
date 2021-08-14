package com.atguigu;

public class MergeArr {
    public static void main(String[] args) {
        int arr1[] = {1,5,3,4};
        int arr2[] = {2,6,9,8};
        int res[] = mergeArr(arr1, arr2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + "  ");
        }

    }
    public static int [] mergeArr(int arr1[], int arr2[]){
        //指向arr1数组当前工作的下标
        int aindex = 0;
        //指向arr2数组当前工作的下标
        int bindex = 0;
        //指向res数组当前工作的下标
        int rindex = 0;
        int res[] = new int[arr1.length + arr2.length];
        while (aindex < arr1.length && bindex < arr2.length){
            if(arr1[aindex] < arr2[bindex]){
                res[rindex] = arr1[aindex];
                rindex ++;
                aindex ++;
            }else{
                res[rindex] = arr2[bindex];
                rindex ++;
                bindex ++;
            }
        }
       while (aindex < arr1.length){
           res[rindex] = arr1[aindex];
           rindex ++;
           aindex ++;
       }
       while (bindex < arr2.length){
           res[rindex] = arr2[bindex];
           bindex ++;
           rindex ++;
       }
       return res;
    }


}
