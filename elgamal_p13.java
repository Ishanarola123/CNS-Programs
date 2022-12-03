package CNS;

import java.util.Scanner;

public class elgamal_p13 {

    public static int cal_inverse(int m, int b){
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

 return b2;



    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number of prime number it is value of q:");
        int q=sc.nextInt();
        int ql=q-1;

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

        System.out.println("enter the hash value of m");
        double m=sc.nextDouble();

        System.out.println("step2:digital signature");
        System.out.println("choose random number of k ");
//        double k=Math.random()

        int k=sc.nextInt();

        System.out.println("now compute s1");
        double s1=Math.pow(alpha,k)%q;
        System.out.println(s1);

        System.out.println("now compute the value of s2");
        System.out.println("we need to value of k inverse");

       int k_inverse=cal_inverse(ql,k);

        System.out.println("here the value of k inverse is :" + k_inverse);
        System.out.println("now compute s2");

        double s2_1=xa*s1;
        System.out.println(s2_1);
        double s2_2=m-s2_1;
        System.out.println(s2_2);
        double s2_3=k_inverse*s2_2;
        System.out.println(s2_3);

        int new_s2,s2 = 0,final_s2;

        if (s2_3<0){
            new_s2= (int) Math.abs(s2_3);
             s2= (int) (new_s2%ql);

               if (s2<ql){
                  final_s2=ql-s2;
                   System.out.println("now the value of the s2 is here:" + final_s2 );

               }

        }
        else
        {

            final_s2 = (int) s2_3;
            System.out.println("now the value of the s2 is here:" + final_s2 );

        }








        System.out.println("now verified at receiver side ");
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("receiver side");
        System.out.println("compute the value of v1");
        double v1=Math.pow(alpha,m)%q;
        System.out.println(v1);

        System.out.println("compute the value of v2");
        double v2_1=Math.pow(ya,s1);
        double v2_2=Math.pow(s1,s2);
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
