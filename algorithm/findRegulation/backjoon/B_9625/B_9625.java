import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] Aarr = new int[46];
	public static int[] Barr = new int[46];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 처음 0번째, 1번째 인덱스만 setting 해주면 댐. 그 다음부턴 피보나치.
		Aarr[0] = 1;	
		Barr[0] = 0;
		// 피보나치 함수로 미리 배열 채워놓음.
		for (int i = 1; i <= 45; i++) {
			Aarr[i] = Barr[i-1];
            Barr[i] = Aarr[i-1] + Barr[i-1];
		}
		n = scan.nextInt();
		System.out.println(Aarr[n] + " " + Barr[n]);
	}
}
