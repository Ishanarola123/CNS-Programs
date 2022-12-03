package CNS;

import java.util.Scanner;

public class elgamal {

    public  static  double calinverse_k(double q,double k){
        double  a1=1,a2=0,a3=q;
        double  b1=0,b2=1,b3=k;


        while(b3!=1 && b3!=0){
            double qe=a3/b3;
            double  t1=(a1-(qe*b1));
            double  t2=(a2-(qe*b2));
            double  t3=(a3-(qe*b3));

            //coping value of previous b1,b2,b3
            a1=b1;
            a2=b2;
            a3=b3;

            //copying value of t1,t2,t3 into
            b1=t1;
            b2=t2;
            b3=t3;



        }

        if (b3==0){
            System.out.println("inverse can not found");
        }
        else {
            if (b2<0){
                b2=b2+q;

            }

        }
        System.out.println("k inverse is:" + b2);
        return b2;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number of prime number it is value of q:");
        int q=sc.nextInt();

        System.out.println("enter the value of primitive root (alpha)");
        int alpha=sc.nextInt();

        System.out.println("-------------------------------------------------------");
        System.out.println("sender side");

        System.out.println("step1 :");
        System.out.println("enter the private key of sender(xa)");
        double xa=sc.nextDouble();

        System.out.println("here the public key of sender(ya)");
        double ya=Math.pow(alpha,xa)%q;

        System.out.println("here the public key of sender is:");
        System.out.println(ya);

        System.out.println("step2:digital signature");
        System.out.println("choose random number of k ");
//        double k=Math.random()

        double k=sc.nextDouble();

        System.out.println("now calculate the inverse of k");

        double ql=q-1;
        double k_inverse=calinverse_k(ql,k);
        System.out.println(k_inverse);

        System.out.println("now compute s1");
        double s1=Math.pow(alpha,k)%q;
        System.out.println(s1);

        System.out.println("enter the hash value of m");
        double m=sc.nextDouble();

        System.out.println("now compute s2");

        double s2_1=xa*s1;
        System.out.println(s2_1);
        double s2_2=m-s2_1;
        System.out.println(s2_2);
        double s2_3=k_inverse*s2_2;
        System.out.println(s2_3);

        double s2=s2_3%ql;
        System.out.println(s2);







        double new_s2=Math.round(s2);
        System.out.println(new_s2);

        double abs_s2=Math.abs(new_s2);
        System.out.println(abs_s2);

        System.out.println("now here the digital signature is: {" + s1 + "," +abs_s2+ "}");

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("receiver side");
        System.out.println("compute the value of v1");
        double v1=Math.pow(alpha,m)%q;
        System.out.println(v1);

        System.out.println("compute the value of v2");
        double v2_1=Math.pow(ya,s1);
        double v2_2=Math.pow(s1,abs_s2);
        double v2_3=v2_1*v2_2;
        double v2= v2_3%q;
        System.out.println(v2);

        if (v1==v2){
            System.out.println("valid");
        }
        else {
            System.out.println("not valid");
        }









    }
}
