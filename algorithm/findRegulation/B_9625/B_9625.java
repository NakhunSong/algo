import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] Aarr = new int[46];
	public static int[] Barr = new int[46];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// ó�� 0��°, 1��° �ε����� setting ���ָ� ��. �� �������� �Ǻ���ġ.
		Aarr[0] = 1;	
		Barr[0] = 0;
		// �Ǻ���ġ �Լ��� �̸� �迭 ä������.
		for (int i = 1; i <= 45; i++) {
			Aarr[i] = Barr[i-1];
            Barr[i] = Aarr[i-1] + Barr[i-1];
		}
		n = scan.nextInt();
		System.out.println(Aarr[n] + " " + Barr[n]);
	}
}
