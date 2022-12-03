package CNS;

import java.util.Scanner;

public class p8 {
    public static int extended_gcd(int m, int b) {

        int a1 = 1, a2 = 0, a3 = m;
        int b1 = 0, b2 = 1, b3 = b;
        int count = 0;
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        while (b3 !=1){
            int q = (a3/b3);
            System.out.println("q is"+q);


            a1 = b1;
            a2 = b2;
            a3 = b3;

            int t1, t2, t3;
            t1 = a1 - q * b1;
            t2 = a2 - q * b2;
            t3 = a3 - q * b3;

            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);


            b1 = t1;
            b2 = t2;
            b3 = t3;
            System.out.println(b1);
            System.out.println(b2);
            System.out.println(b3);

        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of inverse");
        int b=sc.nextInt();

        System.out.println("enter the number of galois field");
        int m=sc.nextInt();

        System.out.println("this is the answer"+ extended_gcd(b,m) );


    }
}
