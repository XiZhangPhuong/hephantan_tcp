/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author VanVanPhuong
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        ArrayList<Integer> listID = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            list.add(new User((i+1), "Username"+(i+1)));
        }
        
        for(int i = 0;i<list.size();i++){
           
        }

        for(User user : list){
            System.out.println(user.getId() +"\t"+user.getUsername());
        }
        
//        int id;
//        String username;
//        System.out.println("Nhap ID,username :");
//        id = Integer.parseInt(sc.nextLine());
//        username = sc.nextLine();
//        if(checkLogin(list, id, username)){
//            System.out.println("Login successfully");
//        }else{
//            System.out.println("Login faild");
//        }
         
        
    }
    private static boolean checkLogin(ArrayList<User> list,int id,String username){
        for(User user : list){
            if(user.getId()==id && user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}
