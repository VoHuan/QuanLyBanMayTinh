package QuanLyMayTinh.BUS;

import QuanLyMayTinh.DAO.TaiKhoanDAO;
import QuanLyMayTinh.DTO.NhanVien;
import QuanLyMayTinh.DTO.TaiKhoan;

import java.util.ArrayList;

import MyCustom.MyDialog;

public class TaiKhoanBUS {

    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    private ArrayList<TaiKhoan> listTaiKhoan = null;
    public void docDanhSach() {
        this.listTaiKhoan = taiKhoanDAO.getDanhSachTaiKhoan();
    }

    public ArrayList<TaiKhoan> getDanhSachTaiKhoan() {
        if (this.listTaiKhoan == null)
            docDanhSach();
        return this.listTaiKhoan;
    }

//    public String getTenDangNhapTheoMa(String ma) {
//        int maNV = Integer.parseInt(ma);
//        return taiKhoanDAO.getTenDangNhapTheoMa(maNV);
//    }

    public String getQuyenTheoMa(String ma) {
        int maNV = Integer.parseInt(ma);
        return taiKhoanDAO.getQuyenTheoMa(maNV);
    }

    public boolean suaTaiKhoan(String ma, String tenDangNhap,String matKhau,String quyen) {
        int maNV = Integer.parseInt(ma);
        if (tenDangNhap.trim().equals("") ||matKhau.trim().equals("") ) {
            new MyDialog("Không được để trống thông tin !", MyDialog.ERROR_DIALOG);
            return false;
        }
        boolean flag = taiKhoanDAO.suaTaiKhoan(maNV, tenDangNhap, matKhau, quyen);
        if (flag) {
            new MyDialog("Sửa tài khoản thành công ! " , MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public void datLaiQuyen(String ma, String quyen) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.datLaiQuyen(maNV, quyen);
        if (flag) {
            new MyDialog("Đặt lại thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Đặt lại thất bại!", MyDialog.ERROR_DIALOG);
        }
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        return taiKhoanDAO.kiemTraTrungTenDangNhap(tenDangNhap);
    }

    public boolean themTaiKhoan(String ma, String tenDangNhap,String matkhau, String quyen) {
        int maNV = Integer.parseInt(ma);
        if (tenDangNhap.trim().equals("") ||matkhau.trim().equals("") ) {
            new MyDialog("Không được để trống thông tin !", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (kiemTraTrungTenDangNhap(tenDangNhap)) {
            MyDialog dlg = new MyDialog("Tên đăng nhập bị trùng! Có thể tài khoản bị khoá, thực hiện mở khoá?", MyDialog.WARNING_DIALOG);
            if (dlg.getAction() == MyDialog.OK_OPTION) {
                moKhoaTaiKhoan(ma);
                return true;
            }
            return false;
        }
        boolean flag = taiKhoanDAO.themTaiKhoan(maNV, tenDangNhap, matkhau, quyen);
        if (flag) {
            new MyDialog("Cấp tài khoản thành công!" , MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Cấp tài khoản thất bại! Tài khoản đã tồn tại", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public void khoaTaiKhoan(String ma) {
    	if(ma.equals(""))
   		 new MyDialog("Vui lòng nhập mã nhân viên!", MyDialog.ERROR_DIALOG);
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.khoaTaiKhoan(maNV);
        if (flag) {
            new MyDialog("Khoá tài khoản thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Khoá tài khoản thất bại!", MyDialog.ERROR_DIALOG);
        }
    }

    public void moKhoaTaiKhoan(String ma) {
    	if(ma.equals(""))
    		 new MyDialog("Vui lòng nhập mã nhân viên!", MyDialog.ERROR_DIALOG);
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.moKhoaTaiKhoan(maNV);
        if (flag) {
            new MyDialog("Mở khoá tài khoản thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Mở khoá tài khoản thất bại!", MyDialog.ERROR_DIALOG);
        }
    }

//    public boolean doiMatKhau(String matKhauCu, String matKhauMoi, String nhapLaiMatKhau) {
//        if(!matKhauMoi.equals(nhapLaiMatKhau)) {
//            new MyDialog("Mật khẩu mới không khớp!", MyDialog.ERROR_DIALOG);
//            return false;
//        }
//        boolean flag = taiKhoanDAO.doiMatKhau(matKhauCu, matKhauMoi);
//        if (flag) {
//            new MyDialog("Đổi thành công!", MyDialog.SUCCESS_DIALOG);
//        } else {
//            new MyDialog("Mật khẩu cũ nhập sai!", MyDialog.ERROR_DIALOG);
//        }
//        return flag;
//    }
    
    public int getTrangThai(int maNV) {      
        return taiKhoanDAO.getTrangThai(maNV);
    }

}
