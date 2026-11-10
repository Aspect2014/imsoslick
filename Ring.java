import java.util.Scanner;
public class Ring{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rows and columns:");
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[n][m];
        System.out.println("enter matrix element");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter ring number(sno)and rotations (rno):");
        int sno=sc.nextInt();
        int rno=sc.nextInt();
        ringrotate(arr,sno,rno);
        display(arr);
    }
    public static void ringrotate(int[][] arr, int sno,int rno){
        int[] la=getring1d(arr,sno);
        rotate1d(la,rno);
        setring2d(arr,la,sno);
    }
    public static int[] getring1d(int[][] arr,int sno){
        int r1 = sno - 1, c1 = sno - 1;

int r2 = arr.length - sno, c2 = arr[0].length - sno;


int[] la = new int[2 * (r2 - r1 + c2 - c1)];

int idx = 0;

for (int i = r1; i <= r2; i++) la[idx++] = arr[i][c1]; // Left wall

for (int j = c1 + 1; j <= c2; j++) la[idx++] = arr[r2][j]; // Bottom wall

for (int i = r2 - 1; i >= r1; i--) la[idx++] = arr[i][c2]; // Right wall

for (int j = c2 - 1; j > c1; j--) la[idx++] = arr[r1][j]; // Top wall

return la;
    }
    public static void setRing2D(int[][] arr, int[] la, int sno) {

int r1 = sno - 1, c1 = sno - 1;

int r2 = arr.length - sno, c2 = arr[0].length - sno;

int idx = 0;

for (int i = r1; i <= r2; i++) arr[i][c1] = la[idx++];

for (int j = c1 + 1; j <= c2; j++) arr[r2][j] = la[idx++];

for (int i = r2 - 1; i >= r1; i--) arr[i][c2] = la[idx++];

for (int j = c2 - 1; j > c1; j++) arr[r1][j] = la[idx++];

}
    public static void setring2d(int[][] arr, int[] la, int sno) {
        int r1 = sno - 1, c1 = sno - 1;
        int r2 = arr.length - sno, c2 = arr[0].length - sno;
        int idx = 0;

        for (int i = r1; i <= r2; i++) arr[i][c1] = la[idx++];
        for (int j = c1 + 1; j <= c2; j++) arr[r2][j] = la[idx++];
        for (int i = r2 - 1; i >= r1; i--) arr[i][c2] = la[idx++];
        for (int j = c2 - 1; j > c1; j++) arr[r1][j] = la[idx++];
    }

    // Rotate 1D array by rno steps
    public static void rotate1d(int[] la, int rno) {
        int n = la.length;
        rno = (rno % n + n) % n; // Handle negative rotations

        reverse(la, 0, n - 1);
        reverse(la, 0, rno - 1);
        reverse(la, rno, n - 1);
    }

    // Helper to reverse array portion
    public static void reverse(int[] la, int left, int right) {
        while (left < right) {
            int temp = la[left];
            la[left++] = la[right];
            la[right--] = temp;
        }
    }

    // Display 2D matrix
    public static void display(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }



}
