
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VanVanPhuong
 */
public class Server {
    public static void main(String[] args) {
        try {
               System.out.println("*   CHƯƠNG TRÌNH TRÊN SERVER   *");
               Registry reg = LocateRegistry.createRegistry(8888);
               reg.rebind("rmi://nhacaitrungquoc/server", new ThuChiIPL());
               System.out.println("Đã đăng ký đối tượng Remote...");           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
