package CNS;

import java.util.Scanner;

public class practical8_40 {



    public static void extended_eculidean(int m,int b){
        int a1=1,a2=0,a3=b;
        int b1=0,b2=1,b3=m;
        int count=0;

        while(b3!=1 && b3!=0)
        {
          int  q=a3/b3;
            System.out.println("the phase " + count);
            System.out.println("q is" + q);
            count=count+1;

          int  t1=(a1-(q*b1));
          int t2=(a2-(q*b2));
          int  t3=(a3-(q*b3));


            System.out.print( "a1" +" " +a1 + "");
            System.out.println();
            System.out.print( "a2"+" " +a2 + "");
            System.out.println();
            System.out.println( "a3"+" "+ a3+ "");
            System.out.println();



            //copying values of previous b1,b2,b3 into current a1,a2,a3
            a1=b1;
            a2=b2;
            a3=b3;

            System.out.print("b1"+" " + b1 + "");
            System.out.println();
            System.out.print("b2"+" "+ b2 + "");
            System.out.println();
            System.out.println( "b3"+" "+ b3+ "");
            System.out.println();


            b1=t1;
            b2=t2;
            b3=t3;


        }
        System.out.println("phase "+ count);
        int  q=a3/b3;
        System.out.println("q is" + q);
        System.out.print("a1"+" " +a1 + "");
        System.out.println();
        System.out.print( "a2"+" "+ a2 + "");
        System.out.println();
        System.out.println("a3"+" " + a3+ "");
        System.out.println();


        System.out.print("b1" +" " + b1 + "");
        System.out.println();
        System.out.print("b2"+" " + b2 + "");
        System.out.println();
        System.out.println("b3"+" " + b3+ "");
        System.out.println();

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
        System.out.println("the inverse found : that is the answer");
        System.out.println( b2);




    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the value for finding inverse of that number ");
        int b=sc.nextInt();

        System.out.println("enter the value of galois field");
        int m=sc.nextInt();

        extended_eculidean(b,m);



    }
}
