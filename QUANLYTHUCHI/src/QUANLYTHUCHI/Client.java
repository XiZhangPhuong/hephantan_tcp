/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLYTHUCHI;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author VanVanPhuong
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try {
            Socket client = new Socket("127.0.0.1", 9999);
            System.out.println("Client đã kết nối với Server");
            Scanner sc = new Scanner(System.in);
            Scanner br = new Scanner(client.getInputStream());
            PrintWriter pw = new PrintWriter(client.getOutputStream());

            int truonghop;
            String gui = "";
            String nhan = "";
            double tien;
            do {
                System.out.println("1.Thu tien");
                System.out.println("2.Chi tien");
                System.out.println("3.Xem so du");
                System.out.println("4.Xem lich su thu chi");
                System.out.println("5.Thoat chuong trinh !");
                truonghop = Integer.parseInt(sc.nextLine());

                pw.println(String.valueOf(truonghop));
                pw.flush();
               
                switch (truonghop) {
                    case 1:
                        System.out.println("Nhap so tien thu :");
                        tien = Double.parseDouble(sc.nextLine());
                        pw.println(String.valueOf(tien));
                        pw.flush();
                        break;
                    case 2:
                        System.out.println("Nhap so tien chi :");
                        tien = Double.parseDouble(sc.nextLine());
                        pw.println(String.valueOf(tien));
                        pw.flush();
                        break;
                    case 3:
                        nhan = br.nextLine();
                        System.out.println(nhan);
                        break;
                    case 4:
                        nhan = br.nextLine();
                        System.out.println(nhan);
                        break;

                    case 5:
                        pw.close();
                        br.close();
                        client.close();
                }
            } while (truonghop != 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
