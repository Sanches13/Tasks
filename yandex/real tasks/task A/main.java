import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int candidatesNum = Integer.parseInt(br.readLine());

        Candidate[] candidates = new Candidate[candidatesNum];
        for(int i = 0; i < candidatesNum; i++) {
            String[] str = br.readLine().split(",");
            candidates[i] = new Candidate(str[0], str[1], str[2], Integer.parseInt(str[3]), Integer.parseInt(str[4]), Integer.parseInt(str[5]));
        }

        for(int i = 0; i < candidatesNum; i++) {
            System.out.print(candidates[i].getResult());
            if(i != candidatesNum - 1)
                System.out.print(" ");
        }
    }
}

class Candidate {
    String surname;
    String name;
    String patronymic;
    int day;
    int month;
    int year;

    Candidate(String surname, String name, String patronymic, int day, int month, int year) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getNumOfChar() {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < surname.length(); i++)
            set.add(surname.charAt(i));
        for(int i = 0; i < name.length(); i++)
            set.add(name.charAt(i));
        for(int i = 0; i < patronymic.length(); i++)
            set.add(patronymic.charAt(i));

        return set.size();
    }

    public int getSumOfNumbers() {
        int res = 0;
        int current = day;
        while(current != 0) {
            res += current % 10;
            current /= 10;
        }

        current = month;
        while(current != 0) {
            res += current % 10;
            current /= 10;
        }

        return res;
    }

    public int getLetterNumber() {
        return surname.charAt(0) - 'A' + 1;
    }

    public int getResultSum() {
        return getNumOfChar() + getSumOfNumbers()*64 + getLetterNumber()*256;
    }

    public String getResult() {
        String str = "";
        String res = Integer.toHexString(getResultSum());
        for(int i = res.length(); i < 3; i++)
            str = str.concat("0");
        str = str.concat(String.valueOf(res.charAt(res.length() - 3)).toUpperCase());
        str = str.concat(String.valueOf(res.charAt(res.length() - 2)).toUpperCase());
        str = str.concat(String.valueOf(res.charAt(res.length() - 1)).toUpperCase());
        return str;
    }
}
