/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSINHVIEN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author VanVanPhuong
 */
public class Server {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server đã khởi động");
            Socket socket = serverSocket.accept();
            System.out.println("Kết nối thành công");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String sent = "";
            ArrayList<SinhVien> sinhviens = new ArrayList<>();
            int data;
            do {
                data = in.readInt();
                switch (data) {
                    case 1:
                        String[] arr = in.readUTF().split(",");
                        sinhviens.add(new SinhVien(arr[0], arr[1], Double.parseDouble(arr[2])));
                        out.writeUTF("Thêm thành công");
                        out.flush();
                        break;

                    case 2:

                        sent = "";
                        for (SinhVien sv : sinhviens) {
                            sent += sv.toString() + "\n";
                        }
                        out.writeUTF(sent);
                        out.flush();
                        break;

                    case 3:

                        for (int i = 0; i < sinhviens.size() - 1; i++) {
                            for (int j = i + 1; j < sinhviens.size(); j++) {
                                if (sinhviens.get(i).getdTB() < sinhviens.get(j).getdTB()) {
                                    SinhVien sv = sinhviens.set(i, sinhviens.get(i));
                                    sinhviens.set(i, sinhviens.get(j));
                                    sinhviens.set(j, sv);
                                }
                            }
                        }
                        sent = "";
                        for (SinhVien sv : sinhviens) {
                            sent += sv.toString() + "\n";
                        }
                        out.writeUTF(sent);
                        out.flush();
                        break;

                    case 4:
                        socket.close();
                        in.close();
                        out.close();

                }
            } while (data != 4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
