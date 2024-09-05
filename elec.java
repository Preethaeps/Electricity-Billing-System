import java.util.*;
import java.lang.*;
class InvalidUnitsException extends Exception{
}
interface ComCal {
    abstract public void calculate();
}
interface HouseCal{
    abstract public void calto();
}
class ElecBill{
    String name,phone,month;

    Scanner obj = new Scanner(System.in);
ElecBill(String a,String b ,String c){
        name=a;
        phone=b;
        month=c;
    }
ElecBill(){
System.out.println("enter details");
System.out.println("enter name");
        name=obj.next();
System.out.println("enter phone no");
        phone=obj.next();
System.out.println("enter month");
        month=obj.next();
    }
    void set(String a,String b ,String c){
        name=a;
        phone=b;
        month=c;
    }
    void get(){
System.out.println("Name:"+name+"\nmonth:"+month);
    }
}
class CommercialBill extends ElecBill implements ComCal
{
    double billpay;
    long units;
    String shopno,shopname;
CommercialBill(String a, String b, String c,String d, String e,long f){
        super(a,b,c);
shopno=d;
shopname=e;
        units=f;
        calculate();
    }
CommercialBill(){
System.out.println("enter details");
System.out.println("enter name");
        name=obj.next();
System.out.println("enter phone no");
        phone=obj.next();
System.out.println("enter month");
        month=obj.next();
System.out.println("enter shopno");
shopno=obj.next();
System.out.println("enter shopname");
shopname=obj.next();
System.out.println("enter units");
        units=obj.nextLong();
        calculate();
    }
    void set(String a,String b ,String c,String d,String e,long f){
        name=a;
        phone=b;
        month=c;
shopno=d;
shopname=e;
        units=f;
    }
    void get(){
        System.out.println("Name:"+name+"\nmonth:"+month+"shopno:"+shopno);
    }

    public void calculate()
    {
        if(units<400)
billpay=units*4.5;
        else if(units<=500)
billpay=400*4.5+(units-400)*6;
        else if(units<=600)
billpay=400*4.5+100 *6+(units-500)*8;
        else if(units<=800)
billpay=400*4.5+100 *6+100*8+(units-600)*9;
        else if(units<=1000)
billpay=400*4.5+100 *6+100*8+200*9+(units-800)*10;
        else if(units>1000)
billpay=400*4.5+100*6+100*8+200*9+200*10+(units-1000)*11;
System.out.println("Total bill is:"+billpay);

    }
}
class HouseBill extends ElecBill implements HouseCal{
    double totbill;
    long units;
    String houseno,housename;
HouseBill(String a, String b, String c,String d, String e,long f){
        super(a,b,c);
houseno=d;
housename=e;
        units=f;
calto();
    }
HouseBill(){
System.out.println("enter details");
System.out.println("enter name");
        name=obj.next();
System.out.println("enter phone no");
        phone=obj.next();
System.out.println("enter month");
        month=obj.next();
System.out.println("enter houseno");
houseno=obj.next();
System.out.println("enter housename");
housename=obj.next();
System.out.println("enter units");
        units=obj.nextLong();
calto();
    }
    void set(String a,String b ,String c,String d,String e,long f){
        name=a;
        phone=b;
        month=c;
houseno=d;
housename=e;
        units=f;
    }
    void get(){
        System.out.println("Name:"+name+"\nmonth:"+month+"houseno:"+houseno);
    }
    public void calto()
    {
        if(units<100)
totbill=units*1.20;
        else if(units<=300)
totbill=100*1.20+(units-100)*2;
        else if(units>300)
totbill=100*1.20+200 *2+(units-300)*3;
System.out.println("Total bill is:"+totbill);

    }


}


class Main
{
    public static void main(String args[])
    {
        long units;

        String a,b,c,d,e;
        int n;
        Scanner obj=new Scanner(System.in);
System.out.println("enter household or commercial: house/commercial");
        String k=obj.next();
        if(k.charAt(0)=='c'){
System.out.println("enter 1 to fill deatails");
            n=obj.nextInt();
            if(n==1){
System.out.println("enter details");
System.out.println("enter name");
                a=obj.next();
System.out.println("enter phone no");
                b=obj.next();
System.out.println("enter month");
                c=obj.next();
System.out.println("enter shopno");
                d=obj.next();
System.out.println("enter shopname");
                e=obj.next();
System.out.println("enter units");
                units=obj.nextLong();
try{
        System.out.println("enter units");
        units=obj.nextLong();
        if(units<0){
            throw new InvalidUnitsException();
        }}
        catch(InvalidUnitsException e1){
            System.out.println(e1);
        }

CommercialBill cus1 = new CommercialBill(a,b,c,d,e,units);
            }
            else{
CommercialBill cus1 = new CommercialBill();
            }

        }
        else if(k.charAt(0)=='h'){
System.out.println("enter 1 to fill deatails");
            n=obj.nextInt();
            if(n==1){
System.out.println("enter details");
System.out.println("enter name");
                a=obj.next();
System.out.println("enter phone no");
                b=obj.next();
System.out.println("enter month");
                c=obj.next();
System.out.println("enter houseno");
                d=obj.next();
System.out.println("enter housename");
                e=obj.next();
System.out.println("enter units");
                units=obj.nextLong();
              try{
        System.out.println("enter units");
        units=obj.nextLong();
        if(units<0){
            throw new InvalidUnitsException();
        }}
        catch(InvalidUnitsException e1){
            System.out.println(e1);
        }

HouseBill cus1 = new HouseBill(a,b,c,d,e,units);
            }
            else{
HouseBill cus1 = new HouseBill();
            }
        }
    }
}
