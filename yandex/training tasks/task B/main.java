import java.util.Scanner;

public class Main {

    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int schemeSize = sc.nextInt();
        sc.nextLine();

        Scheme scheme = new Scheme(schemeSize);
        for(int i = 0; i < schemeSize; i++)
            scheme.row[i] = new String(sc.nextLine());

        int groupsCount = sc.nextInt();
        sc.nextLine();

        Format[] format = new Format[groupsCount];
        for(int i = 0; i < groupsCount; i++)
            format[i] = new Format(sc.nextLine().split(" "));

        for(int i = 0; i < groupsCount; i++) {
            //System.out.println(scheme);
            for(int j = 0; j < schemeSize && !format[i].status; j++) {
                switch(format[i].side) {

                    case "left":

                        switch(format[i].position) {
                            case "window":

                                if(scheme.row[j].charAt(A) != '.')
                                    break;

                                switch(format[i].num) {
                                    case 1:
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "A");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, A).toString());
                                        scheme.row[j] = "#" + scheme.row[j].substring(1, 7);
                                        break;
                                    case 2:
                                        if(scheme.row[j].charAt(B) != '.')
                                            break;
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "A " + (j+1) + "B");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, A, B).toString());
                                        scheme.row[j] = "##" + scheme.row[j].substring(2, 7);
                                        break;
                                    case 3:
                                        if(scheme.row[j].charAt(B) != '.' || scheme.row[j].charAt(C) != '.')
                                            break;
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "A " + (j+1) + "B " + (j+1) + "C");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, A, B, C).toString());
                                        scheme.row[j] = "###" + scheme.row[j].substring(3, 7);
                                        break;
                                }
                                break;
                            case "aisle":

                                if(scheme.row[j].charAt(C) != '.')
                                    break;

                                switch(format[i].num) {
                                    case 1:
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "C");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, C).toString());
                                        scheme.row[j] = scheme.row[j].substring(0, 2) + "#" + scheme.row[j].substring(3, 7);
                                        break;
                                    case 2:
                                        if(scheme.row[j].charAt(B) != '.')
                                            break;
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "B " + (j+1) + "C");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, B, C).toString());
                                        scheme.row[j] = scheme.row[j].charAt(0) + "##" + scheme.row[j].substring(3, 7);
                                        break;
                                    case 3:
                                        if(scheme.row[j].charAt(A) != '.' || scheme.row[j].charAt(B) != '.')
                                            break;
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "A " + (j+1) + "B " + (j+1) + "C");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, A, B, C).toString());
                                        scheme.row[j] = "###" + scheme.row[j].substring(3, 7);
                                        break;
                                }
                                break;
                        }
                        break;

                    case "right":

                        switch(format[i].position) {
                            case "window":

                                if(scheme.row[j].charAt(F) != '.')
                                    break;

                                switch(format[i].num) {
                                    case 1:
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "F");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, F).toString());
                                        scheme.row[j] = scheme.row[j].substring(0, 6) + "#";
                                        break;
                                    case 2:
                                        if(scheme.row[j].charAt(E) != '.')
                                            break;
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "E " + (j+1) + "F");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, E, F).toString());
                                        scheme.row[j] = scheme.row[j].substring(0, 5) + "##";
                                        break;
                                    case 3:
                                        if(scheme.row[j].charAt(D) != '.' || scheme.row[j].charAt(E) != '.')
                                            break;
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "D " + (j+1) + "E " + (j+1) + "F");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, D, E, F).toString());
                                        scheme.row[j] = scheme.row[j].substring(0, 4) + "###";
                                        break;
                                }
                                break;
                            case "aisle":

                                if(scheme.row[j].charAt(D) != '.')
                                    break;

                                switch(format[i].num) {
                                    case 1:
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "D");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, D).toString());
                                        scheme.row[j] = scheme.row[j].substring(0, 4) + "#" + scheme.row[j].substring(5, 7);
                                        break;
                                    case 2:
                                        if(scheme.row[j].charAt(E) != '.')
                                            break;
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "D " + (j+1) + "E");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, D, E).toString());
                                        scheme.row[j] = scheme.row[j].substring(0, 4) + "##" + scheme.row[j].charAt(6);
                                        break;
                                    case 3:
                                        if(scheme.row[j].charAt(E) != '.' || scheme.row[j].charAt(F) != '.')
                                            break;
                                        format[i].status = true;
                                        System.out.println("Passengers can take seats: " + (j+1) + "D " + (j+1) + "E " + (j+1) + "F");
                                        System.out.print(Scheme.getModifiedScheme(scheme, j, D, E, F).toString());
                                        scheme.row[j] = scheme.row[j].substring(0, 4) + "###";
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            if(!format[i].status)
                System.out.println("Cannot fulfill passengers requirements");
        }
    }
}

class Scheme {
    String[] row;
    int schemeSize;

    public Scheme(int schemeSize) {
        this.schemeSize = schemeSize;
        this.row = new String[schemeSize];
    }

    public static Scheme getModifiedScheme(Scheme scheme, int rowNum, int... places) {
        Scheme newScheme = new Scheme(scheme.schemeSize);
        for(int i = 0; i < scheme.schemeSize; i++)
            newScheme.row[i] = scheme.row[i];
        for(int i = 0; i < places.length; i++)
            newScheme.row[rowNum] = newScheme.row[rowNum].substring(0, places[i]) + "X" + newScheme.row[rowNum].substring(places[i] + 1, 7);
        return newScheme;
    }

    public String toString() {
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i < schemeSize; i++)
            res.append(row[i]).append("\n");
        return res.toString();
    }
}

class Format {
    int num;
    String side;
    String position;

    boolean status;

    public Format(String[] str) {
        num = Integer.parseInt(str[0]);
        side = str[1];
        position = str[2];

        status = false;
    }

    public String toString() {
        return num + " " + side + " " + position;
    }
}
