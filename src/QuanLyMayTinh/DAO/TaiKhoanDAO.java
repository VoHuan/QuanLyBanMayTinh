package QuanLyMayTinh.DAO;

import QuanLyMayTinh.BUS.DangNhapBUS;
import QuanLyMayTinh.DTO.NhanVien;
import QuanLyMayTinh.DTO.TaiKhoan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TaiKhoanDAO {
	public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
		try {
            String sql = "SELECT * FROM taikhoan WHERE trangThai=1";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<TaiKhoan> dstk = new ArrayList<>();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();

                tk.setMaNhanVien(rs.getInt(1));               
                tk.setTenDangNhap(rs.getString(2));
                tk.setMatKhau(rs.getString(3));
                tk.setQuyen(rs.getString(4));
                tk.setTrangThai(rs.getInt(5));
                dstk.add(tk);
            
            }
            return dstk;
        } catch (SQLException e) {
        	System.out.println(e);
        }
        return null;
	}

    public boolean themTaiKhoan(int maNV, String tenDangNhap,String matkau, String quyen) {
        try {
            String sql = "INSERT INTO taikhoan(MaNV, TenDN, MatKhau, Quyen,trangthai) "
                    + "VALUES (?, ?, ?, ?,1)";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maNV);
            pre.setString(2, tenDangNhap);
            pre.setString(3, tenDangNhap);
            pre.setString(4, quyen);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        	System.out.println(e);
        }
        return false;
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        try {
            String sql = "SELECT * FROM TaiKhoan WHERE TenDN = '" + tenDangNhap + "'";
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public String getTenDangNhapTheoMa(int maNV) {
//        try {
//            String sql = "SELECT TenDangNhap FROM TaiKhoan WHERE MaNV=" + maNV;
//            Statement st = MyConnect.conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            if (rs.next()) {
//                return rs.getString(1);
//            }
//        } catch (Exception e) {
//        }
//        return "";
//    }

    public boolean suaTaiKhoan(int maNV, String tenDangNhap, String matKhau,String quyen) {
        try {
            String sql = "UPDATE TaiKhoan SET TenDN=?, MatKhau=?,quyen=? WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, tenDangNhap);
            pre.setString(2, matKhau);
            pre.setString(3, quyen);
            pre.setInt(4, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean datLaiQuyen(int maNV, String quyen) {
        try {
            String sql = "UPDATE TaiKhoan SET Quyen=? WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setString(1, quyen);
            pre.setInt(2, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public String getQuyenTheoMa(int maNV) {
        try {
            String sql = "SELECT Quyen FROM TaiKhoan WHERE MaNV=" + maNV;
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public boolean khoaTaiKhoan(int maNV) {
        try {
            String sql = "UPDATE TaiKhoan SET TrangThai=0 WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean moKhoaTaiKhoan(int maNV) {
        try {
            String sql = "UPDATE TaiKhoan SET TrangThai=1 WHERE MaNV=?";
            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
            pre.setInt(1, maNV);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

//    public boolean doiMatKhau(String matKhauCu, String matKhauMoi) {
//        try {
//            String sql = "UPDATE TaiKhoan SET MatKhau=? WHERE MaNV=? AND MatKhau=?";
//            PreparedStatement pre = MyConnect.conn.prepareStatement(sql);
//            pre.setString(1, matKhauMoi);
//            pre.setInt(2, DangNhapBUS.taiKhoanLogin.getMaNhanVien());
//            pre.setString(3, matKhauCu);
//            return pre.executeUpdate() > 0;
//        } catch (Exception e) {
//        }
//        return false;
//    }

    public int getTrangThai(int ma) {
        try {        	
            String sql = "SELECT TrangThai FROM TaiKhoan WHERE MaNV=" + ma;
            Statement st = MyConnect.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {              	
                return rs.getInt(1);
            }                    
        } catch (Exception e) {
        	System.out.println(e);
        }
        return -1;
    }
}
