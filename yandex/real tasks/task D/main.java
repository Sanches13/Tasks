import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ordersNum = Integer.parseInt(br.readLine());
        Order[] orders = new Order[ordersNum];
        for(int i = 0; i < ordersNum; i++)
            orders[i] = new Order(br.readLine().split("\\s"));

        int requestsNum = Integer.parseInt(br.readLine());
        Request[] requests = new Request[requestsNum];
        for(int i = 0; i < requestsNum; i++)
            requests[i] = new Request(br.readLine().split("\\s"));

        int res;
        StringBuilder myStr = new StringBuilder();
        for (int i = 0; i < requestsNum; i++) {
            res = 0;
            switch (requests[i].type) {
                case 1:
                    for (int j = 0; j < ordersNum; j++) {
                        if (orders[j].start >= requests[i].start && orders[j].start <= requests[i].end)
                            res += orders[j].cost;
                    }
                    break;
                case 2:
                    for (int j = 0; j < ordersNum; j++) {
                        if (orders[j].end >= requests[i].start && orders[j].end <= requests[i].end)
                            res += orders[j].end - orders[j].start;
                    }
                    break;
            }
            myStr.append(res).append(" ");
        }
        bw.write(myStr.toString());
        bw.flush();
    }
}

class Order {
    int start;
    int end;
    int cost;

    public Order(String[] split) {
        this.start = Integer.parseInt(split[0]);
        this.end = Integer.parseInt(split[1]);
        this.cost = Integer.parseInt(split[2]);
    }
}

class Request {
    int start;
    int end;
    int type;

    public Request(String[] split) {
        this.start = Integer.parseInt(split[0]);
        this.end = Integer.parseInt(split[1]);
        this.type = Integer.parseInt(split[2]);
    }
}
