package CNS;

import java.util.Scanner;

public class RSA {

    public static int cal_d(int phien, int e){
//        calculate value of d for private key generate
        int a1=1,a2=0,a3=phien;
        int b1=0,b2=1,b3=e;

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
                b2=b2+phien;
            }

        }
        System.out.println("The value of d is found :");
        System.out.println( b2);
        int d=b2;
        return d;

    }

    public static  void keygenerate(int p,int q,int e){


//        calculate n
        int n=p*q;

//        calculate eular totient function phie of n
        int phien=(p-1)*(q-1);

        int   d= cal_d(phien,e);

        System.out.println("public key is:- " + e + ","+ n);
        System.out.println("private key is:- " + d +"," +  n);


    }
    public  static double encrypt(int m, int e, int n) {


        double c=Math.pow(m,e);
        System.out.println("the value of m rest e ");
        System.out.println(c);

        double cipher= c %n;
        System.out.println("the cipher text :-");
        System.out.println(cipher);
        return cipher;
    }

    public  static  void decrypt(double cipher, int d, int n) {


        double p=Math.pow(cipher,d);
        System.out.println("the value of c rest d ");
        System.out.println(p);

        double plaintext= p%n;
        System.out.println("the plain text :-");
        System.out.println(plaintext);
    }

    public static void main(String[] args) {
        System.out.println("here RSA algorithm:");

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the prime number p");
        int p=sc.nextInt();

        System.out.println("enter the prime number q");
        int q=sc.nextInt();

        System.out.println("enter the value of e");
        int e=sc.nextInt();

        int n=p*q;
        int phien=(p-1)*(q-1);
        keygenerate(p,q,e);

        int d=cal_d(phien,e);
        System.out.println("enter the value of message m");
        int m=sc.nextInt();

        encrypt(m,e,n);
        double cipher=encrypt(m,e,n);

        decrypt(cipher,d,n);



    }
}
