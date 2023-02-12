/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QUANLYTHUCHI;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VanVanPhuong
 */
public class Server {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server đã khởi động");
            Socket server = serverSocket.accept();
            System.out.println("Kết nối thành công");
            PrintWriter pw = new PrintWriter(server.getOutputStream());
            Scanner br = new Scanner(server.getInputStream());

            int truonghop;
            String nhan = "";
            String gui = "";
            String lichSu = "";
            double tien = 0;
            
            do {
                truonghop = Integer.parseInt(br.nextLine());
                switch (truonghop) {
                    case 1:
                        nhan = br.nextLine();
                        tien = tien + Double.parseDouble(nhan);
                        lichSu += "\tThu tien :"+tien;
                        break;

                    case 2:
                        nhan = br.nextLine();
                        tien = tien - Double.parseDouble(nhan);
                        lichSu += "\tChi tien :"+tien;
                        break;

                    case 3: 
                        gui = "So tien con lai :" + tien;
                        pw.println(gui);
                        pw.flush();
                        break;

                    case 4:
                        if(lichSu.equals("")){
                            pw.println("Chua co giao dich nao");
                            pw.flush();
                            return;
                        }                        
                        pw.println(lichSu);
                        pw.flush();
                        break;

                    case 5:
                        br.close();
                        pw.close();
                        server.close();
                }
            } while (truonghop != 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
