import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    static int N, M;
    static void toggle(int [][]array, int x, int y) {
        for(int i=x-1; i<=x+1; i++) {
            for(int j=y-1; j<=y+1; j++) {
                array[i][j] = 1 - array[i][j];
            }
        }
    }

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        int[][] first = new int[N][M];
        int[][] second = new int[N][M];
        int ans=0;

        for(int i=0; i<N; i++) {
            String line = scan.next();
            for(int j=0; j<M; j++) {
                first[i][j] = line.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++) {
            String line = scan.next();
            for(int j=0; j<M; j++) {
                second[i][j] = line.charAt(j)-'0';
            }
        }

        for(int i=0; i<N-2; i++) {
            for(int j=0; j<M-2; j++) {
                if(first[i][j] != second[i][j]) {
                    ans++;
                    toggle(first, i+1, j+1);
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(a[i][j] != second[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(ans);
    }
}