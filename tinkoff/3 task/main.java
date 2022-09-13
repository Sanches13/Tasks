import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPeople = sc.nextInt();
        int time = sc.nextInt();
        sc.nextLine();

        int[] floors = new int[numOfPeople];
        for(int i = 0; i < numOfPeople; i++)
            floors[i] = sc.nextInt();
        sc.nextLine();
        int numOfEmployee = sc.nextInt() - 1;

        int result = 0;
        if(floors[numOfEmployee] - floors[0] < floors[numOfPeople - 1] - floors[numOfEmployee]) {
            int start = 0;
            while(floors[numOfEmployee] - floors[start] > time)
                start++;
            if(start != 0)
                result += 2 * (floors[numOfEmployee] - floors[0]);
            result += floors[numOfPeople - 1] - floors[start];

            if(result - (floors[numOfEmployee] + floors[numOfPeople - 1] - 2 * floors[0]) > 0)
                result = floors[numOfEmployee] + floors[numOfPeople - 1] - 2 * floors[0];
        }
        else {
            int start = numOfPeople - 1;
            while(floors[start] - floors[numOfEmployee] > time)
                start--;
            if(start != numOfPeople - 1)
                result += 2 * (floors[numOfPeople - 1] - floors[numOfEmployee]);
            result += floors[start] - floors[0];

            if(result > (2 * floors[numOfPeople - 1] - floors[numOfEmployee] - floors[0]))
                result = 2 * floors[numOfPeople - 1] - floors[numOfEmployee] - floors[0];
        }
        System.out.println(result);
    }
}
