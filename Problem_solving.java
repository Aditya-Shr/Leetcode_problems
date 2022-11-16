import java.util.*;
import java.io.*;

public class Problem_solving {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        String s = "Hello World";

        System.out.println(lengthoflastword(s));
    }

    static boolean palindrome_number(int x){
        boolean flag = false;
        int rev = 0;
        int temp = x;
        while(temp>0) {
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }

        if(x<0){
            flag = false;
        }

        if(x==rev){
            flag = true;
        }
        return flag;
    }

    static int lengthOfLongestSubstring(String s) {
        int left=0,right=0,max =0;
        Set<Character> seen = new HashSet();

        while(right<s.length()){
            char c = s.charAt(right);
            if(seen.add(c)){
                max = Math.max(max,right-left+1);
                right++;
            }else{
                while(s.charAt(left)!=c){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);
                left++;
            }
        }
        return max;
    }

    static int missingNumber(int arr[], int n){
        Arrays.sort(arr);
        int min = 1;
        for(int i=0;i<n;i++){
            if(arr[i]==min){
                min++;
            }
        }
        return min;
    }

    static int binary_search(int[] arr,int n,int k){
        int low =0,high = n-1;
        if(n==1 && arr[0]==k){
            return 0;
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]>k){
                high = n-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    static int majorityElement(int[] arr,int n){
        int val = arr[0];
        int count =1;
        for(int i=1;i<n;i++){
            if(arr[i]==val){
                count++;
            }else{
                count--;
            }

            if(count==0){
                val=arr[i];
                count =1;
            }
        }
        return val;
    }

    static int findMin(int[] nums){
        int low =0;
        int n=nums.length;
        int high = n-1;
        int min = -1;

        if(nums[low]<nums[high]){
            return nums[low];
        }
        if(n==1){
            return nums[0];
        }

        while(low<=high){
            int mid = low+((high-low)/2);

            if(mid<high && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }else if(mid>low && nums[mid]<nums[mid-1]){
                return nums[mid];
            }else if(nums[high]<nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return min;
    }

    static int searchInsert(int[] arr,int target){
        int n=arr.length;
        int low =0;
        int high = n-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    static int search_rotated_sorted(int[] arr,int x){
        int n = arr.length;
        int low= 0;
        int high = n-1;
        while(low<=high){
            int mid = low+((high-low))/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[low]<=arr[mid]){
                if(x>=arr[low] && x<=arr[mid]){
                    high = n-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(x>=arr[mid] && x<=arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    static int[] search_first_and_last(int[] nums,int target){
        int[] res = new int[2];
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums,target);
        return res;
    }

    static int findFirst(int[] nums,int target){
        int n = nums.length;
        int index = -1;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(nums[mid]>=target){
                high = n-1;
            }else{
                low= mid+1;
            }
            if(nums[mid]==target){
                index = mid;
            }
        }
        return index;
    }
    static int findLast(int[] nums,int target){
        int n= nums.length;
        int index = -1;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+((high-low)/2);
            if(nums[mid]<=target){
                low = mid+1;
            }else{
                high = n-1;
            }
            if(nums[mid]==target){
                index = mid;
            }
        }
        return index;
    }

    void merge_sort(int[] nums1,int m,int nums2[],int n){
        int i = m-1;
        int j = n-1;
        int last = m+n-1;
        while(i>=0 && j>=0){
            nums1[last--] = nums1[i]>nums2[j] ? nums1[i--]:nums2[j--];
        }

        while(j>0){
            nums1[last--] = nums2[j--];
        }
    }

    public int trap(int[] height){
        int n = height.length;
        int res = 0;
        for(int i=0;i<n-1;i++){
            int lmax = height[i];
            for(int j=0;j<i;j++){
                lmax = Math.max(lmax,height[j]);
            }
            int rmax = height[i];
            for(int j=i+1;j<n;j++){
                rmax = Math.max(rmax,height[j]);
            }

            res += Math.min(lmax,rmax) - height[i];
        }
        return res;
    }

    public int trap_eff(int[] height){
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int res = 0;

        lmax[0] = height[0];
        for(int i=1;i<=n-1;i++){
            lmax[i] = Math.max(height[i],lmax[i-1]);
        }
        rmax[n-1]= height[n-1];
        for(int i=n-2;i>=0;i--){
            rmax[i] = Math.max(height[i],rmax[i+1]);
        }
        for(int i=0;i<n;i++) {
            res += Math.min(lmax[i],rmax[i])-height[i];
        }
        return res;
    }

    public static int lengthoflastword(String s){
        return s.trim().length() - s.trim().lastIndexOf(" ")-1;
    }


    public int[][] transpose(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        int trans[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                trans[i][j] = matrix[j][i];
            }
        }
        return trans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
            int r= matrix.length;
            int c = matrix[0].length;
            List<Integer> res = new ArrayList<>();
            int left=0,right=c-1,top=0,bottom=r-1;
            while(top<=bottom && left<=right){
                for(int i=left;i<=right;i++){
                    res.add(matrix[top][i]);
                }top++;
                for(int i =top;i<=bottom;i++){
                    res.add(matrix[i][right]);
                }right--;
                if(top<=bottom){
                    for(int i=right;i>=left;i--){
                        res.add(matrix[bottom][i]);
                    }bottom--;
                }
                if(left<=right){
                    for(int i=bottom;i>=top;i--){
                        res.add(matrix[i][left]);
                    }left++;
                }
            }
            return res;
        }

        static boolean searchmatrix(int matrix[][],int target){
        int r = matrix.length,c = matrix[0].length;
        int i = 0,j=c-1;
        while(i<r && j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;
        }

        static int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int count =0;
        for(int i=n-1;i>=2;i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
        }
        
        static void sort_colors_75(int nums[]){
        int n= nums.length;
        int low=0,mid=0,high=n-1;
        int temp;
        while(mid<=high){
            switch(nums[mid]){
                case 0:{
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp = nums[mid];
                    nums[mid]= nums[high];
                    nums[high]=temp;
                    high--;
                    break;
                }
            }
        }
        }

        static boolean is_isomorphic(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Boolean> map2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1)==true){
                if(map1.get(ch1)!=ch2){
                    return false;
                }
            }else{
                if(map2.containsKey(ch2)==true){
                    return false;
                }else{
                    map1.put(ch1,ch2);
                    map2.put(ch2,true);
                }
            }
        }
        return true;
    }

    static boolean checkIfPangram(String sentence){
        if(sentence.length()<26){
            return false;
        }
        String alphas = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<alphas.length();i++){
            if(sentence.indexOf(alphas.charAt(i))==-1){
                return false;
            }
        }
        return true;
    }

    public String binary_sum_67(String a,String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0){
                sum+= a.charAt(i--) - '0';
            }
            if(j>=0){
                sum+= b.charAt(j--) -'0';
            }
            sb.append(sum%2);
            carry = sum/2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String string_sum_415(String num1,String num2){
         StringBuilder sb = new StringBuilder();
         int carry = 0;

         for(int i=num1.length()-1,j=num2.length()-1 ; i>=0 || j>=0 || carry==1; i--,j--){
             int x = i<0 ? 0:num1.charAt(i)-'0';
             int y = j<0 ? 0:num2.charAt(j) - '0';

             sb.append((x+y+carry)%10);
             carry = ((x+y+carry)/10);
         }
         return sb.reverse().toString();
    }

    public int max_profit_121(int[] prices){
        int least = Integer.MAX_VALUE;
        int op = 0;
        int profit = 0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<least){
                least = prices[i];
            }
            profit = prices[i] - least;
            if(profit>op){
                op = profit;
            }

        }
        return op ;
    }

    public int max_profit_122(int[] prices){
        int max_profit =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                max_profit+= prices[i]-prices[i-1];
            }
        }
        return max_profit;
    }

    public void delete_node(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        else{
            return 1+Math.max(height(root.left),height(root.right));
        }
    }

    public static int diameteroftree_543_naive(Node root){
        if(root==null){
            return 0;
        }

        int d1 = 1+height(root.left)+height(root.right);
        int d2 = height(root.left);
        int d3 = height(root.right);

        return Math.max(d1,Math.max(d2,d3));
    }


    public Node lowestCommonAncestor(Node root,Node p,Node q){
        int parent =root.key;
        int left_node = p.key;
        int right_node = q.key;

        if(left_node>parent && right_node>parent){
            return lowestCommonAncestor(root.right,p,q);
        }else if(left_node<parent && right_node<parent){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return root;
        }
    }

    public Node lowestCommonAncestor_iter(Node root,Node p,Node q){
        int left_node = p.key;
        int right_node = q.key;

        Node node = root;
        while(node!=null){
            int parent = node.key;

            if(left_node>parent && right_node>parent){
                node = node.right;
            }else if(left_node<parent && right_node<parent){
                node = node.left;
            }else{
                return node;
            }
        }
        return null;
    }

    public int max_subarray(int[] nums){
        int sum = nums[0];
        int max_sum = nums[0];
        for(int i=1;i<nums.length;i++){
            max_sum = Math.max(max_sum+nums[i],nums[i]);
            sum = Math.max(max_sum,sum);
        }
        return sum;
    }

    public int remove_duplicates(int[] nums){
        int res = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    public int reverse(int x){
        int rev =0;
        while(x!=0){
            int pop = x%10;
            if(rev>Integer.MAX_VALUE || rev==Integer.MAX_VALUE && pop>7){
                return 0;
            }if(rev<Integer.MIN_VALUE || rev==Integer.MIN_VALUE && pop<-8){
                return 0;
            }
            rev = rev*10+pop;
            x /= 10;
        }
        return rev;
    }

    public int sqrt(int x){
        if(x<2){
            return x;
        }
        long num;
        int left = 0;
        int right = x/2;
        while(left<=right){
            int mid = left+(right-left)/2;
            num = (long)mid*mid;
            if(num>x) right = mid-1;
            else if(num<x) left = mid+1;
            else return mid;
        }
        return right;
    }

    public int[] two_sum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp = nums[i]-target;
            if(map.containsKey(comp)){
                return new int[] {map.get(comp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public boolean valid_palindrome(String s){
        StringBuilder str = new StringBuilder();

        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                str.append(Character.toLowerCase(ch));
            }
        }

        String new_str = str.toString();
        String rev = str.reverse().toString();

        return new_str.equals(rev);
    }

    public boolean validPalindrome(String s) {
        int i=0;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return (checkPalindrome(s,i+1,j) || checkPalindrome(s,i,j-1));
            }
            i++;
            j--;
        }
        return true;
    }

    boolean checkPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isValid(String s) {
//         if(s.length()%2 != 0){
//             return false;
//         }

        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack.push(')');
            }else if(ch=='['){
                stack.push(']');
            }else if(ch=='{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop()!=ch){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public int singleNumber(int[] nums){
        int a =0;
        for(int i:nums){
            a^=i;
        }
        return a;
    }

    static Map<String,Integer> values = new HashMap<>();
    static{
        values.put("M",1000);
        values.put("D",500);
        values.put("C",100);
        values.put("L",50);
        values.put("X",10);
        values.put("V",5);
        values.put("I",1);
    }
    public int roman_to_int(String s){
        int sum = 0;
        int i=0;
        while(i<s.length()){
            String curr_sym = s.substring(i,i+1);
            int curr_val = values.get(curr_sym);
            int next_val = 0;
            if(i+1<s.length()){
                String next_sym = s.substring(i+1,i+2);
                next_val = values.get(next_sym);
            }

            if(curr_val<next_val) {
                sum += (next_val - curr_val);
                i += 2;
            }else {
                sum += curr_val;
                i += 1;
            }
        }
        return sum;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if(nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k= nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                }
                else if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public ListNode addtwonumbers(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(l1!=null || l2!=null ||carry!=0){
            int x = (l1!=null) ? l1.val:0;
            int y = (l2!=null) ? l2.val:0;
            int sum = x+y+carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

public void setZeroes(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
}

public void setZeroes_1(int[][] matrix){
        boolean fr = false;
        boolean fc = false;
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    if(i==0){fr=true;}
                    if(j==0){fc=true;}
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(fr){
            for(int j=0;j<c;j++){
                matrix[0][j] =0;
            }
        }

        if(fc){
            for(int i=0;i<r;i++){
                matrix[i][0]=0;
            }
        }
}

public int lengthoflongestSubstring(String s){
        int maxCount = 0;
        int i=0;
        int j=0;
        int len = s.length();

        HashSet<Character> st = new HashSet<>();

        while(i<len && j<len){
            if(!st.contains(s.charAt(j))){
                st.add(s.charAt(j));
                maxCount = Math.max(maxCount,j-i+1);
                j++;
            }else{
                st.remove(s.charAt(i));
                i++;
            }
        }
        return maxCount;
}

public boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }

        int[] counter =new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)-'a']++;
            counter[t.charAt(i)-'a']--;
        }
        for(int count:counter){
            if(count!=0){
                return false;
            }
        }
        return true;
}



//    public boolean hasCycle(Node head){
//        if(head==null){
//            return false;
//        }
//
//        Node slow = head;
//        Node fast = head.next;
//
//        while(slow!=fast){
//            if(fast==null || fast.next==null){
//                return false;
//            }
//
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }



//    public Node mergeTwoLists(Node list1,Node list2){
//        if(list1==null){
//            return list2;
//        }else if(list2==null){
//            return list1;
//        }else if(list1.val<list2.val){
//            list1.next = mergeTwoLists(list1.next,list2);
//            return list1;
//        }else{
//            list2.next = mergeTwoLists(list1,list2.next);
//            return list2;
//        }
//    }


//    public int firstBadVersion(int n){
//        int left =1;
//        int right=n;
//
//        while(left<right){
//            int mid =left+(right-left)/2;
//            if(isBadVersion(mid)){
//                right = mid;
//            }
//            else{
//                left=mid+1;
//            }
//        }
//        return left;
//    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}

class Node{
    int key;
    Node left;
    Node right;
    Node(int k){
        key=k;
        left=right=null;
    }
}

