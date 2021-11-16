package ir.mobileprogram.nik98.homeWork1;

import java.util.Scanner;

public class HomeWork1 {
    //کارنامه
    public static void main(String[] args) {
      int moadel,riazi,phizik,ensha,olom,dini,varzesh;
        System.out.println("please inter riazi number");
        Scanner scanner = new Scanner(System.in);
        riazi=scanner.nextInt();
        System.out.println("riazi=  "+riazi+"  shode");
        System.out.println("please inter phizik number");
        phizik=scanner.nextInt();
        System.out.println("phizik=  "+phizik);

        System.out.println("please inter ensha number");
        ensha=scanner.nextInt();
        System.out.println("ensha=  "+ensha);

        System.out.println("please inter olom number");
        olom=scanner.nextInt();
        System.out.println("olom=  "+olom);

        System.out.println("please inter dini number");
        dini=scanner.nextInt();
        System.out.println("dini=  "+dini);

        System.out.println("please inter varzesh number");
        varzesh=scanner.nextInt();
        System.out.println("varzesh=  "+varzesh);

        moadel= (riazi+phizik+ensha+olom+dini+varzesh)/6;
        System.out.println("moadel:"  +moadel);

    }
}