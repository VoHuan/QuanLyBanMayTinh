package QuanLyMayTinh.BUS;

import QuanLyMayTinh.DAO.KhachHangDAO;
import QuanLyMayTinh.DTO.KhachHang;
import QuanLyMayTinh.DTO.NhanVien;
import MyCustom.MyDialog;

import java.util.ArrayList;
import java.util.Locale;

public class KhachHangBUS {

    private ArrayList<KhachHang> listKhachHang = null;
    private KhachHangDAO khachHangDAO = new KhachHangDAO();

    public void docDanhSach() {
        this.listKhachHang = khachHangDAO.getListKhachHang();
    }

    public ArrayList<KhachHang> getListKhachHang() {
        if (listKhachHang == null)
            docDanhSach();
        return listKhachHang;
    }

    public ArrayList<KhachHang> timKiemKhachHang(String txtMin, String txtMax) {
        if (txtMax.trim().equals("") && txtMin.trim().equals(""))
            return listKhachHang;
        try {
            ArrayList<KhachHang> dskh = new ArrayList<>();
            txtMin = txtMin.replace(",", "");
            txtMax = txtMax.replace(",", "");
            int min = Integer.parseInt(txtMin);
            int max = Integer.parseInt(txtMax);
            for (KhachHang kh : listKhachHang) {
                if (kh.getTongchitieu() >= min && kh.getTongchitieu() <= max) {
                    dskh.add(kh);
                }
            }
            return dskh;
        } catch (Exception e) {
            new MyDialog("Hãy nhập giá trị nguyên phù hợp!", MyDialog.ERROR_DIALOG);
        }
        return null;
    }

    public ArrayList<KhachHang> timKiemKhachHang(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<KhachHang> dskh = new ArrayList<>();
        for (KhachHang kh : listKhachHang) {
            String ho = kh.getHoKH().toLowerCase();
            String ten = kh.getTenKH().toLowerCase();
            int ma = kh.getMaKH();
            if (ho.contains(tuKhoa) || ten.contains(tuKhoa) ||String.valueOf(ma).equalsIgnoreCase(tuKhoa)) {
                dskh.add(kh);
            }
        }
        return dskh;
    }

    public boolean themKhachHang(String ma, String ho, String ten, String gioiTinh) {
        if (ten.trim().equals("") || ma.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (gioiTinh.equals("Chọn giới tính")) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        int makh = Integer.parseInt(ma);
        KhachHang kh = new KhachHang();
        kh.setMaKH(makh);
        kh.setHoKH(ho);
        kh.setTenKH(ten);
        kh.setGioitinh(gioiTinh);
        kh.setTongchitieu(0);
        boolean flag = khachHangDAO.addKhachHang(kh);
        if (flag) {
            new MyDialog("Thêm thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Thêm thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public boolean suaKhachHang(String ma, String ho, String ten, String gioiTinh,int tongchitieu) {
        if (ten.trim().equals("")||ma.trim().equals("")||ho.trim().equals("")) {
            new MyDialog("Không được để trống tên!", MyDialog.ERROR_DIALOG);
            return false;
        }
        if (gioiTinh.equals("Chọn giới tính")) {
            new MyDialog("Hãy chọn giới tính!", MyDialog.ERROR_DIALOG);
            return false;
        }
        int makh = Integer.parseInt(ma);
        KhachHang kh = new KhachHang();
        kh.setMaKH(makh);
        kh.setHoKH(ho);
        kh.setTenKH(ten);
        kh.setGioitinh(gioiTinh);
        kh.setTongchitieu(tongchitieu);
        boolean flag = khachHangDAO.updateKhachHang( kh);
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }

    public boolean xoaKhachHang(String ma) {
        boolean flag = false;
        try {
            int maKH = Integer.parseInt(ma);
            MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
            if(dlg.getAction() == MyDialog.CANCEL_OPTION)
                return false;
            flag = khachHangDAO.deleteKhachHang(maKH);
        } catch (Exception e) {
            new MyDialog("Chưa chọn khách hàng!", MyDialog.ERROR_DIALOG);
        }
        if (flag) {
            new MyDialog("Xoá thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Xoá thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    public boolean updateTongChiTieu(String maKH, String tongChiTieu) {
    	boolean flag = false;
    	int ma = Integer.parseInt(maKH);
    	int tct = Integer.parseInt(tongChiTieu);
    	
    	flag = khachHangDAO.updateTongChiTieu(ma, tct);
    	if(flag) {
    		return true;
    	}
    	return false;
    }
    public boolean nhapExcel(String ma,String ho, String ten, String gioiTinh, String tongchitieu) {
    	int manv = Integer.parseInt(ma);
    	int tongct = Integer.parseInt(tongchitieu);
        KhachHang kh = new KhachHang();
        kh.setMaKH(manv);
        kh.setHoKH(ho);
        kh.setTenKH(ten);
        kh.setGioitinh(gioiTinh);
        kh.setTongchitieu(tongct);
        boolean flag = khachHangDAO.nhapExcel(kh);
        return flag;
    }
}
