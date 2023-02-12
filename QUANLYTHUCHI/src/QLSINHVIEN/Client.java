/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSINHVIEN;

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
            System.out.println("Kết nối thành công");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            String sent = "";
            int chon;

            do {
                System.out.println("1.Thêm sinh viên");
                System.out.println("2.In danh sách sinh viên");
                System.out.println("3.Sắp xếp theo ĐTB giảm dần");
                System.out.println("4.Kết thúc chương trình !");
                chon = Integer.parseInt(sc.nextLine());
                out.writeInt(chon);
                out.flush();
                switch (chon) {
                    case 1:
                        System.out.println("Nhập mã sinh viên : ");
                        String msv = sc.nextLine();
                        System.out.println("Nhập họ tên sinh viên : ");
                        String hoTen = sc.nextLine();
                        System.out.println("Nhập ĐTB : ");
                        double dtB = Double.parseDouble(sc.nextLine());

                        SinhVien sv = new SinhVien(msv, hoTen, dtB);
                        out.writeUTF(sv.toString());
                        out.flush();
                        System.out.println(in.readUTF());
                        break;

                    case 2:
                        System.out.println(in.readUTF());
                        break;

                    case 3:
                        System.out.println(in.readUTF());
                        break;

                    case 4:
                        socket.close();
                        in.close();
                        out.close();
                }
                out.flush();
            } while (chon != 4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
