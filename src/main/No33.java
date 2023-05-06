public class No33 {
    /*
    * 重点是找出数组旋转后两个
    * */
    public static int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int mid = 0;
        if (nums.length == 1){
            return nums[0] == target?0:-1;
        }
        //找出数组的分界点
        while (low <= high) {
            mid = low + ((high-low)>>1);
            if (nums[mid] >= nums[low]) {
                if (mid == high || nums[mid] > nums[mid + 1])
                    break;
                low = mid + 1;
            } else {
                if (mid == low ||nums[mid] < nums[mid - 1]) {
                    mid--;
                    break;
                }
                high = mid - 1;
            }
        }
        System.out.println(mid);
        int res1 = binarySearch(nums,0,mid,target);
        int res2 = binarySearch(nums,mid+1,nums.length -1,target);
        if (res1 != -1){
            return res1;
        }
        return res2;
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,1,2,3,4,5,6};
        //search(nums,0);
        System.out.println(search(nums, 2));
    }
}
