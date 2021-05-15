package sort;

/**
 *
 * 假设堆的首节点下标为0，左孩子1，右孩子2
 * 则索引下标满足关系式：leftChildIndex=2*parentIndex+1
 *                   rightChildIndex=2*parentIndex+2
 *                   最大堆
 * @author 张烈文
 */
public class HeapSort {

    public static void heapSort(int[] nums, int count) {

//        从非叶子节点的第一个节点开始shiftDown操作,
//        从非叶子节点的第一个节点开始shiftDown操作可减少大量的不必要的shiftDown操作，优化了时间复杂度
        for (int index = (count - 2) / 2; index >= 0; index--) {
            shiftDown(nums, index, count);
        }
    }

//    主要就是比较左右孩子大小，然后将最大的那一个在于父节点比较，若大则交换，小则终止

    private  static void shiftDown(int[] nums,int index,int count) {
//        当前节点的左孩子小于数组的个数时
        while (getLeftChildIndex(index) < count) {
            int j = getLeftChildIndex(index);
//            若当前节点右孩子依然小于count，并且右孩子大于左孩子则将j赋值为右孩子下标
//            最大堆
            if (j + 1 < count && nums[j + 1] > nums[j]) {
                j=j+1;
            }

//            若j所指的元素已经小于了index所指元素，说明不需要在交换
            if (nums[index] > nums[j]) {
                break;
            }
//            交换两个节点
            swap(nums, index, j);
//            将index赋值为j，然后继续循环比较
            index = j;
        }
    }


    private static void swap(int[] nums, int index, int j) {
        int tmp = nums[index];
        nums[index] = nums[j];
        nums[j] = tmp;
    }


//    获取当前节点的左孩子下标
    private  static int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 1, 3, 0};
        heapSort(nums,nums.length);

        for (int num :nums
        ) {
            System.out.println(num);

        }
    }


}
