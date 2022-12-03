package CNS;

import java.util.Scanner;

public class practical13 {
    public static double cal_k(double q, double k){
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
        System.out.println("the inverse found : that is the answer");
        System.out.println( b2);
       double k_inverse=b2;
        return  k_inverse;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the value of p");
        int p=sc.nextInt();

        System.out.println("enter the value of q");
        double q=sc.nextInt();

        System.out.println("enter the value of g");
        int g=sc.nextInt();

        System.out.println("enter the value of hash");
        int h=sc.nextInt();

        System.out.println("enter the value of a(private key of sender)");
        int a=sc.nextInt();

        System.out.println("enter the value of k");
        double  k=sc.nextInt();


        System.out.println("--------------------------------------------------------------");
        System.out.println("sender side : used the function used to generate digital signature(r,s)");
//        here the count of digital signature
        Double r1=Math.pow(g,k)%p;
        System.out.println("the value of (g rest to k)mod p  is here:");
        System.out.println(r1);

        double r2=r1%q;
        System.out.println("the value of r2 is here:" + r2);

        double r=r2;
        System.out.println("the value of the r is the here ");
        System.out.println(r);

        //here the calculate the value of the s
        //first we need the value of k inverse so need the extended eculidiean

        double  k_inverse=cal_k(q,k);


        Double s1=(h+(a*r));
        Double s2=k_inverse * s1;
        double s=s2%q;
        System.out.println("the value of s is here :");
        System.out.println(s);

        Double S=s;

        System.out.println("----------------------------------------------------------------");
        System.out.println("receiver side:");
        System.out.println("now validation on receiver side!!");

        double s_inverse=cal_k(q,s);

        System.out.println("here the value of s inverse" + s_inverse);

        double w=s_inverse % q;
        System.out.println("the value of w:"  + w);

        double u1=(h*w)%q;
        System.out.println("the value of u1:" + u1);

        double u2=(r*w)%q;
        System.out.println("thw value of u2:"+u2);

        double y= Math.pow(g,a)%p;
        System.out.println("the value of y :" + y);


        double v1=(Math.pow(g,u1)*Math.pow(y,u2))%p;
        double v=v1%q;

        System.out.println("the value of v" + v);

        if (v==r){
            System.out.println("verified successfully!!");
        }
        else {
            System.out.println("not verified!!");
        }


    }
}

