/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE2;

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
            System.out.println("Server da khoi dong");
            Socket socket = serverSocket.accept();
            System.out.println("Ket noi thanh cong");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            int data;
            String arr[];
            ArrayList<SinhVien> sinhviens = new ArrayList<>();
            String sent = "";
            for (int i = 0; i < 10; i++) {
                sinhviens.add(new SinhVien("sv" + (i + 1), "Phuong", "12/11/1001", "Da Nang"));
            }
            do {
                data = in.readInt();

                switch (data) {
                    case 1:
                        arr = in.readUTF().split(";");
                        // sinhviens.add(new SinhVien(arr[0], arr[1], arr[2], arr[3]));

                        break;

                    case 2:
                        if(sinhviens.size()==0){
                            out.writeUTF("Danh sach trong");
                            out.flush();
                            return;
                        }
                        for (SinhVien sv : sinhviens) {
                            sent += sv.toString()+"\n";
                        }
                        out.writeUTF(sent);
                        out.flush();
                        break;
                        
                    case 3:
                        String search = in.readUTF();
                        if(timKiem(sinhviens,search ).equals("")){
                            out.writeUTF("K tim thay");
                            out.flush();
                        }else{
                            out.writeUTF(timKiem(sinhviens, search));
                            out.flush();
                        }

                }
            } while (data != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String timKiem(ArrayList<SinhVien> list,String data){
        String m = "";
        for(SinhVien sv : list){
            if(data.equals(sv.getNgaySinh()) || data.equals(sv.getQueQuan())){
                m+=sv.toString()+"\n";
            }
        }
        return m;
    }
}


