package CNS;

import java.util.Scanner;

public class elgamal_13 {
    public static int inverse(int m, int b){
        int a1=1,a2=0,a3=m;
        int b1=0,b2=1,b3=b;
        int count=0;

        while(b3!=1 && b3!=0)
        {
            int  q=a3/b3;


            int  t1=(a1-(q*b1));
            int t2=(a2-(q*b2));
            int  t3=(a3-(q*b3));




            //copying values of previous b1,b2,b3 into current a1,a2,a3
            a1=b1;
            a2=b2;
            a3=b3;




            b1=t1;
            b2=t2;
            b3=t3;


        }

        if(b3==0)
        {
            System.out.println("Inverse can not found");
        }

        else
        {
            if(b2<0) {
                b2=b2+m;
            }

        }

        System.out.println("the k_inverse is here:" + b2);
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

       int  k=sc.nextInt();

        System.out.println("now calculate the inverse of k");

        int ql=q-1;
        int k_inverse=inverse(ql,k);
        System.out.println(k_inverse);

        System.out.println("now compute s1");
        int s1= (int) (Math.pow(alpha,k)%q);
        System.out.println(s1);

        System.out.println("enter the hash value of m");
        int m=sc.nextInt();

        System.out.println("now compute s2");

        int s2_1= (int) (xa*s1);
        System.out.println(s2_1);
        int  s2_2=m-s2_1;
        System.out.println(s2_2);
        int  s2_3=k_inverse*s2_2;
        System.out.println(s2_3);

        int s2=s2_3%ql;
        System.out.println(s2);









        System.out.println("now here the digital signature is: {" + s1 + "," +s2+ "}");

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("receiver side");
        System.out.println("compute the value of v1");
        int v1= (int) (Math.pow(alpha,m)%q);
        System.out.println(v1);

        System.out.println("compute the value of v2");
        int v2_1= (int) Math.pow(ya,s1);
        int v2_2= (int) Math.pow(s1,s2);
        int v2_3=v2_1*v2_2;
        int v2= v2_3%q;
        System.out.println(v2);

        if (v1==v2){
            System.out.println("valid");
        }
        else {
            System.out.println("not valid");
        }









    }
    }



