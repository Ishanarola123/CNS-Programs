package CNS;

import java.util.Scanner;

public class euclidean_gcd {

    public  static  long gcd(long a,long b){
        if ((a==0) || (b==0)){
          return 0;
        }

        //r is reminder
  int r;
        r= (int) ((int) a%b);
        if (r!=0){
            return gcd(b,r);
        }
        else{
            return b;
        }


    }


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number1");
        long n1=sc.nextLong();


        System.out.println("enter the number2");
        long n2=sc.nextLong();


        System.out.println("gcd of two number is :" + gcd(n1,n2));
    }
}
