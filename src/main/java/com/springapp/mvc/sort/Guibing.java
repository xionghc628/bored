package com.springapp.mvc.sort;

import java.util.Random;

/**
 * 归并排序
 * @author xionghuacheng
 *
 */
public class Guibing {


    public static void main(String[] args) {
        Random random = new Random();
        int[] x = new int[10];
        for(int i = 0;i < 10;i++){
            x[i] = random.nextInt(100);
            System.out.print(x[i]);
            System.out.print(",");
        }
        int[] temp = new int[10];
        guibing(x,0,x.length-1,temp);
        System.out.println("排序后：");
        for(int i = 0;i < 10;i++){
            System.out.print(temp[i]);
            System.out.print(",");
        }
    }

    private static void guibing(int[] x,int min,int max,int[] temp){
        if(min >= max){
            return;
        }
        int mid = (max + min) / 2;
        guibing(x,min,mid,temp);
        guibing(x,mid+1,max,temp);
        merge(x,min,mid,max,temp);
    }


    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }


}
