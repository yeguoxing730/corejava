package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/11/16
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
/**
 * 初始化 增 删 改 查 比较 合并 转换 排序
 */

/***
 * 数组 声明 增 删 改 查 合并 复制 转换 排序 转换
 *  由于数组是final类型的 所以对数组的增 删 合并操作 最后生成的是一个新的数组 需要借助System.arraycopy方法
 *  而对于数组的查找 排序 转换 复制 操作需要借助 Arrays工具类提供的方法实现
 *
 * Arrays工具类 提供了对数组的 排序 查找 复制 比较 填充 转换为List的功能
 */
public class ArrayTest {
     public static void main(String[] args){
                 //  declareArrAndPrint();
        // insertElementToArr();
         //removeElementToArr();
//         findElement();
//         copyArrays();
//         sortArrays();
//         mergeArrs();
//         convertArrsToList();
         //   compareArrs();
         fillArrs();
     }

    /**
     * 数组声明
     */
    public static void  declareArrAndPrint(){
        String[] stringArray = { "a", "b", "c", "d", "e" };
        String[] aArray = new String[5];
        String[] bArray = {"a","b","c", "d", "e"};
        String[] cArray = new String[]{"a","b","c","d","e"};
        System.out.println(stringArray);
        System.out.println(Arrays.toString(stringArray));
        System.out.println(Arrays.toString(aArray));
        System.out.println(Arrays.toString(bArray));
        System.out.println(Arrays.toString(cArray));
    }

    /**
     * 增加元素  and update
     * 由于数组是final 所以增加元素会生成新的数组
     */
    public static void insertElementToArr(){
        int[] intArray = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(intArray));
        intArray[4]=7;
        System.out.println(Arrays.toString(intArray));
        intArray =  insertElement(intArray,6,2);
        System.out.println(Arrays.toString(intArray));
    }
    public static int[] insertElement(int original[],
                                      int element, int index){
        int length = original.length;
        int destination[] = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index
                + 1, length - index);
        return destination;
    }
    /**
     * remove element
     */
    public static void removeElementToArr(){
        int[] intArray = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(intArray));
        intArray =  removeElement(intArray, 1);
        intArray =  removeElement(intArray,3);
        System.out.println(Arrays.toString(intArray));
        Integer[] intArrays = { 1, 2, 3, 4, 5 };
        intArrays = removeElementUsingList(intArrays,3);
        System.out.println(Arrays.toString(intArrays));

    }
    public static int[] removeElement(int[] a, int del) {
        System.arraycopy(a,del+1,a,del,a.length-1-del);
        return a;
    }
    public static Integer[] removeElementUsingList(Integer[] arrs,int index){
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(arrs));
        a.remove(index);
        Integer[] arr = new Integer[a.size()];
         a.toArray(arr);
        return   arr;
    }
    /**
     * 查找
     */
    public static void findElement(){
        int[] intArray = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(intArray));
        int index = Arrays.binarySearch(intArray, 4);
        System.out.println("element index:"+index);
    }
    /**
     * 复制
     */
    public static void copyArrays(){
        int[] src = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(src));
        int[] dest =new int[5];
        System.out.println(Arrays.toString(dest));
        System.arraycopy( src, 0, dest, 0, src.length-3 );
        System.out.println(Arrays.toString(dest));
        int[] dest2 = Arrays.copyOf(src,src.length-2);
        System.out.println("dest2"+Arrays.toString(dest2));
    }
    /**
     * 排序
     */
    public static void sortArrays(){
        int[] src = { 1, 9, 3, 4, 6,0 };
        System.out.println(Arrays.toString(src));
        Arrays.sort(src);
        System.out.println(Arrays.toString(src));
    }
    /**
     * 合并数组
     */
    public static void mergeArrs(){
        Integer[] a = { 1, 9, 3, 4, 6,0 };
        Integer[] b = { 5, 2, 5, 1, 6,9 };
        System.out.println(Arrays.toString(concat(a,b)));
    }
    private static <T> T[] concat(T[] a, T[] b) {
        final int alen = a.length;
        final int blen = b.length;
        if (alen == 0) {
            return b;
        }
        if (blen == 0) {
            return a;
        }
        final T[] result = (T[]) java.lang.reflect.Array.
                newInstance(a.getClass().getComponentType(), alen + blen);
        System.arraycopy(a, 0, result, 0, alen);
        System.arraycopy(b, 0, result, alen, blen);
        return result;
    }
    /**
     * 转换
     */
    public static void convertArrsToList(){
        Integer[] a = { 1, 9, 3, 4, 6,0 };
        //first way    (most popular and accepted answer)
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(arrayList);
        //second way   popular answer but not recommand because this will reutrn an
        //private static class and not java.util.ArrayList .It will throw exception
        //when you add or remove an element  (UnsupportedOperationException)
        List<Integer> list = Arrays.asList(a);
        System.out.println(list);
        //list.add(9);
        //third way
        List<Integer> thirdList = new ArrayList<Integer>(a.length);
        Collections.addAll(thirdList,a);
        System.out.println("thirdList..."+thirdList);
    }
    /**
     * 比较
     */
    public static void compareArrs(){
        Integer[] a = { 1, 9, 3, 4, 6,0 };
        Integer[] b = { 1, 9, 3, 4, 6,0 };
        Integer[] c = { 1, 9, 3, 4, 6 };
        System.out.println(a.equals(b));
        System.out.println(Arrays.equals(a,b));
        System.out.println(Arrays.equals(a,c));

        Object[] arr1 = {a};
        Object[] arr2 = {b};
        System.out.println(arr1.equals(arr2));
        System.out.println(Arrays.equals(arr1,arr2));
        System.out.println(Arrays.deepEquals(arr1,arr2));
    }
    /**
     * 填充
     *
     */
    public static  void fillArrs(){
        // initializing int array
        int arr[] = new int[] {1, 6, 3, 2, 9};

        // let us print the values
        System.out.println("Actual values: ");
        for (int value : arr) {
            System.out.println("Value = " + value);
        }

        // using fill for placing 18
        Arrays.fill(arr, 18);

        // let us print the values
        System.out.println("New values after using fill() method: ");
        for (int value : arr) {
            System.out.println("Value = " + value);
        }
        int[] subArray = new int[10];
        Arrays.fill(subArray, 10);
        int[][] array = new int[10][];
        Arrays.fill(array, subArray);
        System.out.println("array " + Arrays.toString(array));
    }
}
