import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
        ArrayList<Nasabah> nasabah = new ArrayList<Nasabah>();
        ArrayList<String> logMutasi = new ArrayList<String>();
        
        Scanner input = new Scanner(System.in);
        init(nasabah);
        String yn = "y";
        do{
            menu();

            int pilihan = 0;
            pilihan = input.nextInt();

            if(pilihan == 1){ //tambah data nasabah
                String NoRek;
                String Namansb;
                long Saldo = 0;
                System.out.print("Nama Nasabah \t:\t");
                Namansb = input.next();
                System.out.print("Nomor Rekening \t:\t");
                NoRek = input.next();
                System.out.print("Saldo Awal \t:\t");
                Saldo = input.nextLong();

                nasabah.add(new Nasabah (NoRek, Namansb, Saldo));
            }

            else if(pilihan == 2){ //setor uang
                String NoRek;
                long setoran = 0;

                System.out.print("Nomor Rekening \t:\t");
                NoRek = input.next();
                int i = 0; //index
                boolean test = false;
                for(Nasabah nasabah2 : nasabah){
                    if(nasabah2.getNoRek().equals(NoRek)){
                        System.out.println("Nomor rekening ditemukan");
                        test = true;
                        System.out.println(nasabah2);
                        System.out.print("Nominal setoran (IDR) \t:\t");
                        setoran = input.nextLong();

                        Nasabah tmpnsb = nasabah2;
                        tmpnsb.setSaldo(tmpnsb.getSaldo() + setoran);
                        nasabah.set(i, tmpnsb);

                        System.out.println("Setoran Berhasil");
                        logMutasi.add("- Setor uang " + setoran + " ke Rekening " + tmpnsb.getNoRek() + " (" + tmpnsb.getNamansb() + ").");
                    }
                    i++;
                }
                if (test == false){
                    System.out.println("Nomor rekening tidak ditemukan");
                }
                
            }

            else if(pilihan == 3){ //cetak mutasi
                for (String string : logMutasi) {
                    System.out.println(string);
                }
            }

            else if(pilihan == 4){ //transfer
                
                int count = 0;
                long transfer = 0;
                String NoRek1, NoRek2;
                
                do {
                    System.out.print("Nomor Rekening Pengirim\t:\t");
                    NoRek1 = input.next();
                    int i = 0; //index
                    boolean test1 = false;
                    for(Nasabah nasabah2 : nasabah){
                        if(nasabah2.getNoRek().equals(NoRek1)){
                            System.out.println("Nomor rekening ditemukan");
                            test1 = true;
                            count++;
                            System.out.print("Nominal transfer (IDR) \t:\t");
                            transfer = input.nextLong();

                            Nasabah tmpnsb = nasabah2;
                            tmpnsb.setSaldo(tmpnsb.getSaldo() - transfer);
                            nasabah.set(i, tmpnsb);
                            logMutasi.add("- Transfer Uang " + transfer + " dari Rekening " + tmpnsb.getNoRek() + " " + "(" + tmpnsb.getNamansb() + ")");
                        }
                        i++;
                    }
                    if (test1 == false){
                        System.out.println("Nomor rekening tidak ditemukan");
                        continue;
                    }
                } while (count == 0);

                int count2 = 0;
                do {

                    System.out.print("Nomor Rekening Penerima\t:\t");
                    NoRek2 = input.next();
                    int i = 0; //index
                    boolean test1 = false;
                    for(Nasabah nasabah2 : nasabah){
                        if(nasabah2.getNoRek().equals(NoRek2)){
                            System.out.println("Nomor rekening ditemukan");
                            test1 = true;
                            count2++;
                            Nasabah tmpnsb = nasabah2;
                            tmpnsb.setSaldo(tmpnsb.getSaldo() + transfer);
                            nasabah.set(i, tmpnsb);

                            System.out.println("Transfer Berhasil");
                            logMutasi.add("kepada Rekening " + tmpnsb.getNoRek() + " " + "(" + tmpnsb.getNamansb() + ").");
                        }
                        i++;
                    }
                    if (test1 == false){
                        System.out.println("Nomor rekening tidak ditemukan");
                        continue;
                    }
                } while (count2 == 0);

            }

            else if(pilihan == 5){ //cetak data nasabah
                cetakNamaNasabah(nasabah);
            }

            else if(pilihan == 6){break;}
            else {continue;}

            System.out.print("Apakah Anda ingin kembali ke menu utama (y/n) : ");
            yn = input.next();

        }while(yn.equalsIgnoreCase("y"));

        // nsb3.setNamansb("Kimberly");
        // nasabah.set(2,nsb3);
        // cetakNamaNasabah(nasabah);

        // hapusNasabah(nasabah,1);
        // cetakNamaNasabah(nasabah);

        // nasabah.remove(nsb1);
        // cetakNamaNasabah(nasabah);
    }

public static ArrayList<Nasabah> init(ArrayList<Nasabah> nasabah){
    Nasabah nsb1 =  new Nasabah("0214578","Jian",500000);
    nasabah.add(nsb1);
    Nasabah nsb2 =  new Nasabah("0214571","Gilbert",500000);
    nasabah.add(nsb2);
    Nasabah nsb3 =  new Nasabah("0214572","Kimberlly",500000);
    nasabah.add(nsb3);
    nasabah.add( new Nasabah("0214573","Wilbert",500000));
    return(nasabah);
}

    public static void menu(){
        System.out.println("Aplikasi Banking");
        System.out.println("1. Tambah Nasabah Baru");
        System.out.println("2. Setor Uang");
        System.out.println("3. Cek Mutasi");
        System.out.println("4. Transfer Uang");
        System.out.println("5. Cetak Data Nasabah");
        System.out.println("6. Keluar");
        System.out.println("Masukkan pilihan Anda : ");
    }
    
    public static void hapusNasabah(ArrayList<Nasabah> nasabah, int idx){
        nasabah.remove(idx);
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