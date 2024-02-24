public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1}};
        spiralPrint(arr);
    }

    static void spiralPrint(int[][] arr){
        if (arr.length==0)
            return;
        int top=0,bottom= arr.length, left=0,right=arr[0].length;
        while (top<bottom&&left<right){
            for (int i=left;i<right;i++){
                System.out.print(arr[top][i]+" ");
            }
            System.out.println();
            top++;
            for (int j=top;j<bottom;j++){
                System.out.print(arr[j][right-1]+" ");
            }
            System.out.println();
            right--;
            if (top<bottom) {
                for (int l = right - 1; l >= left; l--) {
                    System.out.print(arr[bottom - 1][l] + " ");
                }
                System.out.println();
                bottom--;
            }
            if (left<right) {
                for (int m = bottom - 1; m >= top; m--)
                    System.out.print(arr[m][left] + " ");
                System.out.println();
                left++;
            }
        }
    }
}
