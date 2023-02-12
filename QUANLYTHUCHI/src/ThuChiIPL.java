
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VanVanPhuong
 */
public class ThuChiIPL extends UnicastRemoteObject implements IThuChi{

    public ThuChiIPL() throws RemoteException {
    }
    
    @Override
    public String xemLichXuThuChi(String tien) {
        ArrayList<String> list  = new ArrayList<>();
        list.add(tien);
        String m = "";
        for(int i = 0;i<list.size();i++){
            m+=list.get(i)+"\n";
        }
        return m;
    }
    
}
