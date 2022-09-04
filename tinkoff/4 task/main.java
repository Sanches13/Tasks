import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split("\\s");
        int size = Integer.parseInt(str1[0]);
        int operationsNum = Integer.parseInt(str1[1]);

        String[] str2 = br.readLine().split("\\s");
        Number[] numbers = new Number[size];
        for(int i = 0; i < size; i++)
            numbers[i] = new Number(Long.parseLong(str2[i]));

        Number[] result = new Number[size];
        for(int i = 0; i < size; i++)
            result[i] = new Number(numbers[i].number);

        Arrays.sort(result);

        for(int i = 0; i < operationsNum; i++) {
            if(result[size - 1].isAvailable()) {
                result[size - 1].changeNumber();
                result[size - 1].currentDifference = result[size - 1].getDifference();
                Arrays.sort(result);
            }
            else
                break;
        }

        long res = 0;
        for(int i = 0; i < size; i++) {
            res += result[i].number - numbers[i].number;
        }

        System.out.println(res);
    }
}

class Number implements Comparable<Number>{
    long number;
    int currentDigit;
    long currentDifference;

    public Number(long number) {
        this.number = number;
        this.currentDigit = getDigit();
        this.currentDifference = getDifference();
    }

    public boolean isAvailable() {
        return currentDigit > 0;
    }

    public int getDigit() {
        int digit = 1;
        long tmp = number;
        while(tmp > 9) {
            tmp /= 10;
            digit++;
        }
        return digit;
    }

    public long getDifference() {
        String n = String.valueOf(number);
        char[] array = n.toCharArray();

        while(isAvailable() && array[getDigit() - currentDigit] == '9')
            currentDigit--;

        if(isAvailable()) {
            array[getDigit() - currentDigit] = '9';
            String result = new String(array);
            return Long.parseLong(result) - number;
        }
        else return 0;
    }

    public void changeNumber() {
        String n = String.valueOf(number);
        char[] array = n.toCharArray();


        array[getDigit() - currentDigit] = '9';
        String result = new String(array);
        number = Long.parseLong(result);

    }

    @Override
    public int compareTo(Number o) {
        return Long.compare(currentDifference, o.currentDifference);
    }
}
