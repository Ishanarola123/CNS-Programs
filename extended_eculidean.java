package CNS;

import java.util.Scanner;

public class extended_eculidean {

    public static void extended_eculidean(int m,int b){
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





    }




    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("enter the number :");
        int b=sc.nextInt();

        System.out.println("enter the number of galois field");
        int m=sc.nextInt();

        System.out.println("this is the answer" );

        extended_eculidean(m,b);

    }
}
