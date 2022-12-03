package CNS;

import java.util.Scanner;

public class DSA {

    //the method for calculate the inverse
    public static int cal_k_inverse(int m, int b){
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

//        System.out.println("inverse ok k inverse is: " + b2);
        return b2;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        System.out.println("enter the value of p");
        int p=sc.nextInt();

        System.out.println("enter the value of q");
        int  q=sc.nextInt();

        System.out.println("enter the value of g");
        int g=sc.nextInt();

        System.out.println("enter the value of hash");
        int h=sc.nextInt();

        System.out.println("sender side--------------------------------------------------------------------");
        System.out.println("enter the value of a(private key of sender)");
        int a=sc.nextInt();

        System.out.println("enter the value of k");
        int  k=sc.nextInt();

        Double r1=Math.pow(g,k)%p;
        System.out.println("the value of (g rest to k)mod p  is here:");
        System.out.println(r1);

        double r2=r1%q;
        System.out.println("the value of r2 is here:" + r2);

        double r=r2;
        System.out.println("the value of the r is the here ");
        System.out.println(r);

        System.out.println("now compute the value of the s :");
        System.out.println("we need to find out the value of k_inverse");
       int  k_inverse=cal_k_inverse(q,k);

        System.out.println("here the value of k inverse is:");
        System.out.println(k_inverse);

        System.out.println("now calculate the value of s ");
        int s1= (int) (h+(a*r));
        int s2=k_inverse * s1;
        int s=s2%q;
        System.out.println("the value of s is here :");
        System.out.println(s);

        System.out.println("----------------------------------------------------------");
        System.out.println("the signature is here: {" + r + "," + s + "}");
        System.out.println("--------------------------------------------------------------");


        System.out.println("now verified by receiver side");
        System.out.println("---------------------------------------------------------------------");

        int s_inverse=cal_k_inverse(q,s);

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

