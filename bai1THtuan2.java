import java.text.NumberFormat;
import java.util.Scanner;
 
 class Account 
{
    private long sotk;
    private String tentk;
    private double sotientrongtk;
    private String trangthai;
 
    Scanner sc = new Scanner(System.in);
 
    public Account() 
    {
    }
 
    public Account(long sotk, String tentk, double sotientrongtk, String trangthai) 
    {
        this.sotk = sotk;
        this.tentk = tentk;
        this.sotientrongtk= sotientrongtk;
        this.trangthai = trangthai;
    }
 
    public long getsotk() 
    {
        return this.sotk;
    }
 
    public void setsotk(long sotk) 
    {
        this.sotk = sotk;
    }
 
    public String gettentk() 
    {
        return this.tentk;
    }
 
    public void settentk(String tentk) 
    {
        this.tentk = tentk;
    }
 
    public double getsotientrongtk() 
    {
        return this.sotientrongtk;
    }
 
    public void setsotientrongtk(double sotientrongtk) 
    {
        this.sotientrongtk = sotientrongtk;
    }

    public String gettrangthai()
    {
        return this.trangthai;
    }

    public void settrangthai(String trangthai)
    {
        this.trangthai = trangthai;
    }
 
    public String toString() 
    {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(sotientrongtk);
        return sotk + "-" + tentk + "-" + str1 + "-" + trangthai;
    }
 
    public double naptien() 
    {
        double nap;
        System.out.print("Nhap So Tien Can Nap: ");
        nap = sc.nextDouble();
        if (nap >= 0) 
        {
            sotientrongtk = nap + sotientrongtk;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("Da Nap " + str1 + " Vao Tai Khoan");
        } 
        else 
        {
            System.out.println("So Tien Can Nap Khong Hop Ly!");
        }
        return nap;
    }
 
    public double ruttien() 
    {
        double rut;
        System.out.print("Nhap So Tien Can Rut Ra: ");
        rut = sc.nextDouble();
        if (rut <= sotientrongtk) 
        {
            sotientrongtk = sotientrongtk - rut;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Da Rut" + str1 + "D Tu Tai Khoan");
        } 
        else 
        {
            System.out.println("So Tien Muon Rut Khong Hop Ly!");
            return ruttien();
        }
        return rut;
    }
 
    public double daohan() 
    {
        double laisuat = 0.035;
        sotientrongtk = sotientrongtk + sotientrongtk * laisuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(sotientrongtk);
        System.out.println("Da Duoc " + str1 + " Tu Dao Han 1 Thang");
        return sotientrongtk;
    }
 
    void inTK() 
    {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(sotientrongtk);
        System.out.printf("%-10d %-20s %-20s \n", sotk, tentk, str1);
    }
}
public class bai1THtuan2
{
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(Account tk) 
    {
        System.out.println("Nhap So Tai Khoan: ");
        tk.setsotk(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap Ten Tai Khoan: ");
        tk.settentk(sc.nextLine());
        tk.setsotientrongtk(50);
    }
    public static void main(String[] args) 
    {
        Account a[] = null;
        int k, n = 0;
        int chon;
        long s, d, c, f;
        boolean flag = true;
        do 
        {
            System.out.println("Vui Long Chon: ");
            System.out.println("1.Nhap Thong Tin\n"
                             + "2.Xuat Danh Sach Thong Tin\n" + "3.Nap Tien\n" + "4.Rut Tien\n"
                             + "5.Chuyen Tien\n" + "Nhan Phim 0 De Exit!");
            chon = sc.nextInt();
            switch (chon) 
            {
                case 1:
                {
                    System.out.println("Nhap So Luong Muon Nhap Thong Tin: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) 
                    {
                        System.out.println("Khach Hang Thu : " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                } 
                break;
                case 2:
                {
                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "So Tien Trong TK");
                    for (int i = 0; i < n; i++) 
                    {
                        a[i].inTK();
                    }
                } 
                break;
                case 3:
                {
                    System.out.println("Nhap So Tai Khoan Can Nap: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) 
                    {
                        d = a[i].getsotk();
                        if (s == d) 
                        {
                            System.out.println("Chon Tai Khoan: " + d);
                            a[i].naptien();
                        } 
                        else 
                        {
                            System.out.println("");
                        }
                    }
                } 
                break;
                case 4:
                {
                    System.out.println("Nhap So Tai Khoan Can Rut: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) 
                    {
                        d = a[i].getsotk();
                        if (s == d) 
                        {
                            System.out.println("Chon Tai Khoan: " + d);
                            a[i].ruttien();
                        }
                    }
                } 
                break;
                case 5:
                {
                    double chuyen, nhan, tienchuyen;
                    System.out.print("Nhap So Tai Khoan Chuyen Tien: ");
                    s = sc.nextLong();
                    System.out.print("Nhap So Tai Khoan Nhan Tien: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) 
                    {
                        d = a[i].getsotk();
                        if (s == d) 
                        {
                            chuyen = a[i].getsotientrongtk();
                            for (int j = 0; j < n; j++) 
                            {
                                f = a[j].getsotk();
                                if (c == f) 
                                {
                                    nhan = a[j].getsotientrongtk();
                                    System.out.println("Nhap So Tien: ");
                                    tienchuyen = sc.nextDouble();
                                    if (tienchuyen <= chuyen) 
                                    {
                                        chuyen = chuyen - tienchuyen;
                                        nhan = nhan + tienchuyen;
                                        a[i].setsotientrongtk(chuyen);
                                        a[j].setsotientrongtk(nhan);
                                        System.out.println("Tai Khoan " + d + " Vua Chuyen: $" + tienchuyen);
                                        System.out.println("Tai Khoan " + f + " Vua Nhan: $" + tienchuyen);
                                    } 
                                    else 
                                    {
                                        System.out.println("So Tien Nhap Khong Hop Ly!");
                                    }
                                } 
                                else 
                                {
                                    System.out.println("");
                                }
                            }
                        } 
                        else 
                        {
                            System.out.println("");
                        }
                    }
                } 
                break;
            }
        } 
        while (chon!=0);
    }
}