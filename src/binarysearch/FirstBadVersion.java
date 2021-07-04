package binarysearch;

import jdk.internal.util.xml.impl.Input;

import java.util.Random;

/**
 * 第一个错误的版本
 * @author 张烈文
 */
public class FirstBadVersion {

    /**
     * 二分查找
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int l=1;
        int r=n+1;
        while(l<n){
            int mid=l+(r-l)/2;
            if((mid-1)>0&&isBadVersion(mid-1)){
                r=mid;
            }else if(!isBadVersion(mid)){
                l=mid+1;
            }else{
                return mid;
            }
        }
        return n;
}

    private boolean isBadVersion(int n) {
        Random random = new Random();
        int in = random.nextInt(1000);
        if (n == in) {

            return true;
        }
        return false;
        }
    }
