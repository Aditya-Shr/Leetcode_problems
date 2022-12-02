public class binary {
    public static void main(String[] args) {

    }

    public int getSum(int a,int b){
        int x = Math.abs(a),y = Math.abs(b);
        if(x<y){
            return getSum(b,a);
        }

        int sign = a>0 ? 1:-1;

        if(a*b>=0){
            while(y!=0){
                int answer = x^y;
                int carry = (x&y) << 1;
                x = answer;
                y = carry;
            }
        }else{
            while(y!=0){
                int answer = x^y;
                int borrow = ((~x)&y) << 1;
                x = answer;
                y = borrow;
            }
        }
        return x*sign;
    }

    public int hammingweight(int n){
        int bits = 0;
        int mask = 0;
        for(int i=0;i<32;i++){
            if((n&mask)!=0){
                bits++;
            }
            mask <<=1;
        }
        return bits;
    }

    public int hammingweight_2(int n){
        int count =0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}
