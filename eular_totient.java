package CNS;

import java.util.Scanner;

public class eular_totient {

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
            Scanner sc = new Scanner(System.in);

            int count=0;
            System.out.println("enter the number which you want to find out eular's totient function");
            int n = sc.nextInt();

            for (int i=0;i<n;i++){
              int gcd = (int) gcd(i,n);

                if (gcd==1){
                    count=count+1;
                }

            }

            System.out.println("this is the answer : " + count);

        }
    }

