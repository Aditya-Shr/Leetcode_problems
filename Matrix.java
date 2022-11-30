import java.lang.reflect.Array;
import java.util.*;

public class Matrix {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix){
        boolean fr = false;
        boolean fc =false;
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 0){
                    if(i==0){fr = true;}
                    if(j==0){fc = true;}

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(fr){
            for(int j=0;j<c;j++){
                matrix[0][j] =0 ;
            }
        }
        if(fc){
            for(int i=0;i<r;i++){
                matrix[i][0] = 0;
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int top = 0, bottom = r-1,left = 0, right = c-1;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }top++;
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }bottom--;
            }if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }left++;
            }
        }
        return res;
    }

    public void rotate_matrix(int[][] matrix){
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public void reflect(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
