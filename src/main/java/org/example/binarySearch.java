package org.example;

public class binarySearch {
    private binarySearch(){}

    /**
     * 实现二分查找
     * @param tmp 需要查找的数组
     * @param key 需要查找的数据
     * @return 如果查找成功返回该数据在数组中的索引，否则返回-1
     */
    public static int BinarySearch(int tmp[],int key){
        if (tmp==null){
            return -1;
        }
        return binarySearch(tmp,0,tmp.length,key);
    }

    /**
     * 实现数组的二分查找
     * @param tmp 需要查找的数组
     * @param fromIndex 开始索引
     * @param endIndex 结束索引
     * @param key 需要查找的呢若能
     * @return 如果该数据在数组中返回该数据对应的索引，否则返回-1
     */
    public static int binarySearch(int tmp[],int fromIndex,int endIndex,int key){
        int low=fromIndex;
        int high=endIndex-1;
        while (low<high){
            int mid=(low+ high)>>>1;
            if (tmp[mid]==key){
                return mid;
            } else if (tmp[mid]>key) {
                high=mid-1;
            }else {
                low=mid+1;
            }
//            int key1=((Comparable)tmp[mid]).compareTo(key);
//            if (key1<0){
//                low=mid+1;
//            } else if (key1>0) {
//                high=mid-1;
//            }else {
//                return mid;
//            }
        }
        return -1;
    }
}
