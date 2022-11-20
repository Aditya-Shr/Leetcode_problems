import java.util.HashSet;
import java.util.Stack;

public class strings {
    public static void main(String[] args) {
    }

    public boolean isPalindrome_125(String s){
        StringBuilder str  = new StringBuilder();

        for(char ch:s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                str.append(Character.isLowerCase(ch));
            }
        }

        String new_str = str.toString();
        String rev_str = str.reverse().toString();

        return new_str.equals(rev_str);
    }

    public boolean isValidParenthesis_20(String s){
        Stack<Character> st = new Stack();

        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(')');
            }else if(c=='['){
                st.push(']');
            }else if(c=='{'){
                st.push('}');
            }else if(st.isEmpty() || st.pop()!=c){
                return false;
            }
        }
        return st.isEmpty();
    }

    public boolean isAnagram_242(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }

        int[] counter = new int[26];
        for(int i=0;i<s.length();i++){
            counter[s.charAt(i)]++;
            counter[t.charAt(i)]--;
        }

        for(int count:counter){
            if(count!=0){
                return false;
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring_3(String s){
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
}
