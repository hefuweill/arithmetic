public class RQ45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int tempMax = nums[0];
        int preMax = tempMax;
        int count = 0;
        int index = 1;
        while (tempMax < nums.length - 1) {
            for (; index <= preMax; index++) {
                tempMax = Math.max(tempMax, nums[index] + index);
            }
            preMax = tempMax;
            count++;
        }
        return ++count;
    }

    public static void main(String[] args) {
        System.out.println(new RQ45().jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }
}
