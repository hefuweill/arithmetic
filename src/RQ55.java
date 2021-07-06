public class RQ55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int max = nums[0];
        int index = 1;
        while (index <= max) {
            max = Math.max(max, index + nums[index]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 1, 4};
        System.out.println(new RQ55().canJump(array));
    }
}
