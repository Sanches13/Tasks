import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int n;
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        String[] str = scanner.nextLine().split("\\s");
        int[] numbers = new int[str.length];
        for(int i = 0; i < str.length; i++)
            numbers[i] = Integer.parseInt(str[i]);

        System.out.println(getNumberOfOperations(n, numbers));
    }

    public static int getNumberOfOperations(int n, int[] numbers) {
        int k = 0;

        for(int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1])
                return -1;
        }

        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i + 1] == numbers[i])
                continue;
            k += numbers[i + 1] - numbers[i];
        }

        return k;
    }
}
