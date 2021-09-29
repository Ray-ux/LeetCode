package hashtable;

import java.util.HashMap;

/**
 * @author 张烈文
 * @date 2021/9/29 16:11
 */
public class FourAddⅡ {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map=new HashMap();
        int res=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum=nums1[i]+nums2[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int temp=nums3[i]+nums4[j];
                res+=map.getOrDefault(-temp,0);
            }
        }
        return res;

    }
}
