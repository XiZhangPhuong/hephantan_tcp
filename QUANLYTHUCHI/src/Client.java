
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VanVanPhuong
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("*    CHƯƠNG TRÌNH TRÊN CLIENT   *");
            Registry reg = LocateRegistry.getRegistry("localhost",9999);
            System.out.println("Client đang tìm kiếm đối tượng từ xa trên Server ...");
            IThuChi iThuChi = (IThuChi)reg.lookup("rmi://nhacaitrungquoc/server");
            
            Scanner sc = new Scanner(System.in);
            ArrayList<String> listLichSu = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
