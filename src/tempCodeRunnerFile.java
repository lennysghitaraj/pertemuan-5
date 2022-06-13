import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        ArrayList<Nasabah> nasabah = new ArrayList<Nasabah>();
        ArrayList<String> logMutasi = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        init(nasabah);
        String yn ="y";
        do{
            menu();

            int pilihan =0;
            pilihan = input.nextInt();

            if(pilihan==1){ 
                String NoRek;
                String Namansb;
                long Saldo=0;
                System.out.print("Nama Nasabah \t:\t");
                Namansb =input.next();
                System.out.print("Nomor Rekening \t:\t");
                NoRek = input.next();
                System.out.print("Saldo Awal \t:\t");
                Saldo = input.nextLong();

                nasabah.add(new Nasabah(NoRek, Namansb, Saldo));
            }
            else if(pilihan==2){ 
                String NoRek;
                long setoran=0;
                System.out.print("Nomor Rekening \t:\t");
                NoRek= input.next();
                System.out.print("Nominal setoran (IDR) \t:\t");
                setoran= input.nextLong();
                int i=0; //index
                for (Nasabah nasabah2 : nasabah) {
                    if(nasabah2.getNoRek().equals(NoRek)){
                        Nasabah tmpnsb = nasabah2;
                        tmpnsb.setSaldo(tmpnsb.getSaldo() + setoran);
                        nasabah.set(i, tmpnsb); 

                        System.out.println("Setoran telah berhasil");
                        logMutasi.add("Setor uang " + setoran + " ke Rekening " + tmpnsb.getNoRek() + " " + tmpnsb.getNamansb());
                    }
                    i++;
                }
            }
            else if(pilihan==3){ 
                for (String string : logMutasi) {
                    System.out.println(string);
                }
            }else if(pilihan==4){ 
                
            }else if(pilihan==5){ 
                cetakNamaNasabah(nasabah);
            }
            else if(pilihan==6) { break;}
            else { continue;}

            System.out.print("Apakah anda ingin kembali ke menu utama (y/n) :");
            yn = input.next();
        }while(yn.equalsIgnoreCase("y"));
    }

    public static ArrayList<Nasabah> init(ArrayList<Nasabah> nasabah){
        Nasabah nsb1 =  new Nasabah("0214578","Jian",500000);
        nasabah.add(nsb1);
        Nasabah nsb2 =  new Nasabah("0214571","Gilbert",500000);
        nasabah.add(nsb2);
        Nasabah nsb3 =  new Nasabah("0214572","Kimberlly",500000);
        nasabah.add(nsb3);
        nasabah.add( new Nasabah("0214573","Wilbert",500000));
        return nasabah;
    }
    public static void menu(){
        System.out.println("Aplikasi Banking");
        System.out.println("1. Tambah Nasabah Baru");
        System.out.println("2. Setor Uang");
        System.out.println("3. Cetak Mutasi");
        System.out.println("4. Transfer Uang");
        System.out.println("5. Cetak Data Nasabah");
        System.out.println("6. Keluar");
        System.out.print("Masukkan Pilihan Anda : ");
    }

    public static void hapusNasabah(ArrayList<Nasabah> nasabah,int idx){
        nasabah.remove(idx);
    }
    public static void hapusNasabah(ArrayList<Nasabah> nasabah,Nasabah nsb){
        nasabah.remove(nsb);
    }

    public static void cetakNamaNasabah(ArrayList<Nasabah> nasabah){
        System.out.println("No.Rekening\tNama\t\tSaldo\tNo.kartu\tPIN\tTgl. Daftar");
        System.out.println("-------------------------------------------------------------------------");
        for (Nasabah nsbh : nasabah) {
            System.out.println(nsbh);
        }
        System.out.println("-------------------------------------------------------------------------");
 
    }
}