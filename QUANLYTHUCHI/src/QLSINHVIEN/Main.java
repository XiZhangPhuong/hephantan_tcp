/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSINHVIEN;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author VanVanPhuong
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<SinhVien> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
           list.add(new SinhVien("User"+i,"Name"+i, new Random().nextInt(11)));
        }
        
//        for(int i = 0 ;i<list.size()-1;i++){
//            for(int j = i+1;j<list.size();j++){
//                if(list.get(i).getdTB() < list.get(j).getdTB() ){
//                    SinhVien sv = list.set(i, list.get(i));
//                    list.set(i, list.get(j));
//                    list.set(j, sv);
//                }
//            }
//        }
        Collections.sort(list);
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
}
