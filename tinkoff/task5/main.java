import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("\\s");
        BigInteger left = new BigInteger(str[0]);
        BigInteger right = new BigInteger(str[1]);

        int count = 0;
        int len1 = String.valueOf(left).length();
        int len2 = String.valueOf(right).length();
        for(int i = len1; i <= len2; i++) {
            for(int j = '1'; j <= '9'; j++) {
                StringBuilder sb = new StringBuilder(i);
                for(int k = 0; k < i; k++)
                    sb.append((char) j);
                if(i == len1 && left.compareTo(new BigInteger(sb.toString())) > 0)
                    continue;
                else if(i == len2 && right.compareTo(new BigInteger(sb.toString())) < 0)
                    continue;
                else
                    count++;
            }
        }
        System.out.print(count);
    }
}
