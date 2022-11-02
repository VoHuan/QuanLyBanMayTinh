package QuanLyMayTinh.BUS;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import MyCustom.MyDialog;
import QuanLyMayTinh.DAO.KhuyenMaiDAO;
import QuanLyMayTinh.DTO.KhuyenMai;

public class KhuyenMaiBUS {
	private ArrayList<KhuyenMai> listKhuyenMai = null;
    private KhuyenMaiDAO KMDAO = new KhuyenMaiDAO();

    public KhuyenMaiBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listKhuyenMai = KMDAO.getDanhSachKhuyenMai();
    }

    public ArrayList<KhuyenMai> getDanhSachKhuyenMai() {
        if (this.listKhuyenMai == null)
            docDanhSach();
        return this.listKhuyenMai;
    }

    public boolean themKhuyenMai(int ma, String ten, Date ngayBD, Date ngayKT) {
        if (ten.equals("")) {
            new MyDialog("Hãy nhập tên chương trình khuyến mãi!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (ngayBD.compareTo(ngayKT) > 0 || ngayBD.compareTo(ngayKT) == 0) {
            new MyDialog("Ngày kết thúc không hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
        boolean flag = false;
        try {           
            KhuyenMai km = new KhuyenMai();
            km.setMaKM(ma);
            km.setTenKM(ten);
            km.setNgayBD(ngayBD);
            km.setNgayKT(ngayKT);

            flag = KMDAO.themKhuyenMai(km);
        } catch (Exception e) {            
            return false;
        }
        if (flag) {
            new MyDialog("Thêm mới thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm mới thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public boolean suaKhuyenMai(String ma, String ten, Date ngayBD, Date ngayKT) {     
        if (ma.equals("")) {
            new MyDialog("Chưa chọn mã để sửa!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (ten.equals("")) {
            new MyDialog("Hãy nhập tên chương trình khuyến mãi!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (ngayBD.compareTo(ngayKT) > 0 || ngayBD.compareTo(ngayKT) == 0) {
            new MyDialog("Ngày kết thúc không hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
        boolean flag = false;
        try {
            int maKM = Integer.parseInt(ma);            
            KhuyenMai km = new KhuyenMai();
            km.setMaKM(maKM);
            km.setTenKM(ten);           
            km.setNgayBD(ngayBD);
            km.setNgayKT(ngayKT);

            flag = KMDAO.suaKhuyenMai(km);
        } catch (Exception e) {
            new MyDialog("Hãy nhập số nguyên hợp lệ!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    public boolean xoaKhuyenMai(String ma) {
    	if (ma.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa chọn loại để xóa !");
			return false;
		}
		int maKM = Integer.parseInt(ma);
		if (KMDAO.xoaKhuyenMai(maKM)) {
			JOptionPane.showMessageDialog(null, "Xóa thành công !");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại !");
			return false;
		}
    }
}
