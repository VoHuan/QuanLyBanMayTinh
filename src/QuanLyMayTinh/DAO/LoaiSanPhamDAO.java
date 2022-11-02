package QuanLyMayTinh.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import QuanLyMayTinh.DAO.LoaiSanPhamDAO;
import QuanLyMayTinh.DAO.MyConnect;
import QuanLyMayTinh.DTO.LoaiSanPham;

public class LoaiSanPhamDAO {
	public ArrayList<LoaiSanPham> getDanhSachLoai() {
        try {
            String sql = "SELECT * FROM loaisanpham";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<LoaiSanPham> dsl = new ArrayList<>();
            while (rs.next()) {
                LoaiSanPham loai = new LoaiSanPham();
                loai.setMaLoai(rs.getInt(1));
                loai.setTenLoai(rs.getString(2));
                loai.setMaNCC(rs.getInt(3));
                dsl.add(loai);
            }
            return dsl;
        } catch (SQLException e) {
        }
        return null;
    }

    public boolean themLoai(LoaiSanPham loai) {
        try {
            String sql = "insert into loaisanpham ( maLoai, tenLoai, maNCC) "
                    + "values ('"
                    + loai.getMaLoai()+"','" + loai.getTenLoai() + "','"+loai.getMaNCC()+"')";           
            Statement st = MyConnect.conn.createStatement();
            int x = st.executeUpdate(sql);
            return x > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean xoaLoai(int maLoai) {
        try {
            String sql = "DELETE FROM loaisanpham WHERE MaLoai='" + maLoai+"'";
            Statement st = MyConnect.conn.createStatement();
            int x = st.executeUpdate(sql);
            return x > 0 ? true : false;
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean suaLoai(int maLoai, String ten, int maNCC) {
        try {
            String sql = "UPDATE loaisanpham SET TenLoai='" + ten + "',"+"MaNCC='"+maNCC+"' WHERE MaLoai='"+maLoai+"'";        
            Statement st = MyConnect.conn.createStatement();
            int x = st.executeUpdate(sql);
            return x > 0 ? true : false;
        } catch (SQLException e) {
        }
        return false;
    }

}
