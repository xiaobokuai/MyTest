package leetcode.editor;

/**
 * 双指针解决数组问题
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("?");
        int[] nums = {0, 2, 0, 4, 5, 6, 7, 6};
        Test2 test2 = new Test2();
        System.out.println(test2.removeDuplicates(nums));
        test2.moveZeroes(nums);


        String ss = "012210";
        System.out.println(ss.substring(1, 5));


        System.out.println(test2.longestPalindrome(ss));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护nums[0 .. slow] 不重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    // 给你输入一个数组 nums，请你原地修改，将数组中的所有值为 0 的元素移到数组末尾
    void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println();
    }

    // 二分算法
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int mid = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == target) {
                return mid;
            } else if (mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return mid;
    }

    // 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
    // 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
    // 则 1 <= index1 < index2 <= numbers.length 。
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0, 0};
    }

    // 反转数组
    void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }

    // 回文串判断
    boolean isPalindrome(String s) {
        char[] array = s.toCharArray();
        int left = 0, right = array.length - 1;

        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    // 寻找最长回文串
    String longestPalindrome(String s) {
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            // 以s[i]为中心
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);

            str = str.length() > s1.length() ? str : s1;
            str = str.length() > s2.length() ? str : s2;
        }
        return str;
    }

    public String palindrome(String s, int left, int right) {
        // 双指针 向两侧发散
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        System.out.println("left: " + left + " right: " + right);
        return s.substring(left + 1, right);
    }


}
