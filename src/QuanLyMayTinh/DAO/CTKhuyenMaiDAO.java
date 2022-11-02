package QuanLyMayTinh.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import QuanLyMayTinh.DTO.CTKhuyenMai;
import QuanLyMayTinh.DTO.KhuyenMai;

public class CTKhuyenMaiDAO {
	public ArrayList<CTKhuyenMai> getDanhSachCTKhuyenMai() {
        try {
            String sql = "SELECT * FROM ctkhuyenmai";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<CTKhuyenMai> dsctkm = new ArrayList<>();
            while (rs.next()) {
                CTKhuyenMai ctkm = new CTKhuyenMai();
                ctkm.setMaKM(rs.getInt(1)); 
                ctkm.setMaSP(rs.getInt(2)); 
                ctkm.setPhanTramGiam(rs.getInt(3));         
                ctkm.setDieuKien(rs.getInt(4));              
                dsctkm.add(ctkm);
            }
            return dsctkm;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean themCTKhuyenMai(CTKhuyenMai ctkm) {
        try {
            String sql = "INSERT INTO ctkhuyenmai(maKM, maSP, phanTramGiam, dieukien) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, ctkm.getMaKM());
            pre.setInt(2, ctkm.getMaSP());
            pre.setInt(3, ctkm.getPhanTramGiam());
            pre.setInt(4, ctkm.getDieuKien());            
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean suaCTKhuyenMai(CTKhuyenMai ctkm) {
        try {
            String sql = "UPDATE ctkhuyenmai SET maKM=?, maSP=?, phanTramGiam=?, dieuKien=? WHERE ctkhuyenmai.maKM=? and ctkhuyenmai.maSP=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, ctkm.getMaKM());
            pre.setInt(2, ctkm.getMaSP());
            pre.setInt(3, ctkm.getPhanTramGiam());      
            pre.setInt(4, ctkm.getDieuKien());                                  
            pre.setInt(5, ctkm.getMaKM());
            pre.setInt(6, ctkm.getMaSP());
            System.out.println(pre);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean xoaCTKhuyenMai(int makm, int masp) {
    	try {
            String sql = "DELETE FROM ctkhuyenmai WHERE maKM='" + makm+"'"+" and maSP='"+masp+"'";              
            Statement st = MyConnect.conn.createStatement();
            int x = st.executeUpdate(sql);
            return x > 0 ? true : false;
        } catch (SQLException e) {
        }
        return false;
    }
    public boolean xoaCTKhuyenMai(int makm) {
    	try {
            String sql = "DELETE FROM ctkhuyenmai WHERE maKM='" + makm+"'";              
            Statement st = MyConnect.conn.createStatement();
            int x = st.executeUpdate(sql);
            return x > 0 ? true : false;
        } catch (SQLException e) {
        }
        return false;
    }
}
