public class Rough_work {
    public static void main(String[] args) {
        int nums[] = {1, 2, 1, 2, 4};
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        System.out.println(a);
    }
}