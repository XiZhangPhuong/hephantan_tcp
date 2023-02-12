/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author VanVanPhuong
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);

            String gui = "";
            int chon;
            do {
                System.out.println("1.Them moi sinh vien");
                System.out.println("2.Xem danh sach sinh vien");
                System.out.println("3.Tim nhom theo nam sinh hoac que quan");
                System.out.println("Nhan 0 thoat chuong trinh ! ");
                chon = Integer.parseInt(sc.nextLine());
                // sent data chon to Server
                out.writeInt(chon);
                out.flush();

                switch (chon) {
                    case 1:
                        System.out.println("Nhap maSV,hoTen,ngaySinh,queQuan");
                        String maSV = sc.nextLine();
                        String hoTen = sc.nextLine();
                        String ngaySinh = sc.nextLine();
                        String queQuan = sc.nextLine();
                        SinhVien sv = new SinhVien(ngaySinh, ngaySinh, ngaySinh, queQuan);
                        out.writeUTF(sv.toString());
                        break;
                        
                    case 2 :                      
                        System.out.println(in.readUTF());
                        break;
                    case 3: 
                        System.out.println("Nhap nam sinh hoac que quan :");
                        String search = sc.nextLine();
                        out.writeUTF(search);
                        out.flush();
                        System.out.println(in.readUTF());
                        break;
                }
            } while (chon != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
