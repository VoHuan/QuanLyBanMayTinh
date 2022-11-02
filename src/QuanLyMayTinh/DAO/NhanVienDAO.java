package QuanLyMayTinh.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyMayTinh.DTO.NhanVien;

public class NhanVienDAO {
	public ArrayList<NhanVien> getDanhSachNhanVien() {
        try {
            String sql = "SELECT * FROM nhanvien WHERE TinhTrang=1 ";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<NhanVien> dssv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();

                nv.setMaNV(rs.getInt(1));
                nv.setHoNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setChucVu(rs.getString(5));
                nv.setTinhtrang(rs.getInt(6));

                dssv.add(nv);
            }
            return dssv;
        } catch (SQLException e) {
        }

        return null;
    }

    public NhanVien getNhanVien(int maNV) {
        NhanVien nv = null;
        try {
            String sql = "SELECT * FROM nhanvien WHERE MaNV=? AND TinhTrang=1 ";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(0, maNV);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getInt(1));
                nv.setHoNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setGioiTinh(rs.getString(4));
                nv.setChucVu(rs.getString(5));
            }
        } catch (SQLException e) {
            return null;
        }

        return nv;
    }

    public boolean updateNhanVien(NhanVien nv) {
        boolean result = false;
        try {
            String sql = "UPDATE nhanvien SET Ho=?, Ten=?, GioiTinh=?, ChucVu=? WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, nv.getHoNV());
            pre.setString(2, nv.getTenNV());
            pre.setString(3, nv.getGioiTinh());
            pre.setString(4, nv.getChucVu());      
            pre.setInt(5, nv.getMaNV());
            result = pre.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
        return result;
    }

    public boolean deleteNhanVien(int maNV) {
        boolean result = false;
        try {
            String sql = "UPDATE nhanvien SET TinhTrang = 0 WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maNV);
            result = pre.executeUpdate() > 0;
        } catch (SQLException ex) {
          
            System.out.println(ex);
            return false;
        }
        return result;
    }

    public boolean themNhanVien(NhanVien nv) {
        boolean result = false;
        try {
        	String sql = "INSERT INTO nhanvien VALUES(?,?,?,?,?,1)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, nv.getMaNV());
            pre.setString(2, nv.getHoNV());
            pre.setString(3, nv.getTenNV());
            pre.setString(4, nv.getGioiTinh());
            pre.setString(5, nv.getChucVu());
            //pre.setInt(6, nv.getTinhtrang());
            result = pre.executeUpdate() > 0;
        } catch (SQLException ex) {
        	System.out.println(ex);
            return false;
        }
        return result;
    }

    public boolean nhapExcel(NhanVien nv) {
        try {
            String sql = "DELETE * FROM nhanvien; " +
                    "INSERT INTO NhanVien(maNV, Ho, Ten, gioiTinh, chucVu) " +
                    "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, nv.getMaNV());
            pre.setString(2, nv.getHoNV());
            pre.setString(3, nv.getTenNV());
            pre.setString(4, nv.getGioiTinh());
            pre.setString(5, nv.getChucVu());
            return true;
        } catch (SQLException ex) {
        	System.out.println(ex);
        }
        return false;
    }
}
