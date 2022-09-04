import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("\\s");
        System.out.println(new Tariff(str).getCost());
    }
}

class Tariff {
    int price;
    int traffic;
    int overprice;
    int realTraffic;

    public Tariff(String[] split) {
        this.price = Integer.parseInt(split[0]);
        this.traffic = Integer.parseInt(split[1]);
        this.overprice = Integer.parseInt(split[2]);
        this.realTraffic = Integer.parseInt(split[3]);
    }

    public int getCost() {
        int cost = price;
        if((realTraffic - traffic) > 0)
            cost += (realTraffic - traffic) * overprice;
        return cost;
    }
}
