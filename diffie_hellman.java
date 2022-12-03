package CNS;

import java.util.Scanner;

public class diffie_hellman {


        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);

            System.out.println("enter the prime number which number both are agree(q)");
            int q=sc.nextInt();

            System.out.println("enter the primitive root(alpha)");
            int alpha=sc.nextInt();


            System.out.println("enter private key for sender(XA)");
            int xa=sc.nextInt();

            System.out.println("here computes public key of sender(YA)");
            double ya= (Math.pow(alpha,xa))%q;
            System.out.println(ya);


            System.out.println("enter the private key of receiver(xb)");
            int xb=sc.nextInt();


            System.out.println("here computes public key of receiver");
            double yb=(Math.pow(alpha,xb))%q;
            System.out.println(yb);

            System.out.println("now ,sender calculate secret key");
            double K1=Math.pow(yb,xa);
            double Ka=K1%q;
            System.out.println(Ka);

            System.out.println("now ,receiver calculate secret key");
            double K2=Math.pow(ya,xb);
            double Kb=K2%q;
            System.out.println(Kb);

            if (Ka==Kb){
                System.out.println("success!secret key is same from both side ");

            }
            else{
                System.out.println("not success! key is may be alterd by anyone!!");
            }




        }
    }


