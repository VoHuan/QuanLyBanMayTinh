package QuanLyMayTinh.BUS;

import java.util.ArrayList;
import java.util.Date;



import MyCustom.MyDialog;
import QuanLyMayTinh.DAO.CTKhuyenMaiDAO;
import QuanLyMayTinh.DAO.KhuyenMaiDAO;
import QuanLyMayTinh.DTO.CTKhuyenMai;
import QuanLyMayTinh.DTO.KhuyenMai;

public class CTKhuyenMaiBUS {
	private ArrayList<CTKhuyenMai> listCTKhuyenMai = null;
    private CTKhuyenMaiDAO CTKMDAO = new CTKhuyenMaiDAO();

    public CTKhuyenMaiBUS() {
        docDanhSach();
    }

    public void docDanhSach() {
        this.listCTKhuyenMai = CTKMDAO.getDanhSachCTKhuyenMai();
    }

    public ArrayList<CTKhuyenMai> getDanhSachKhuyenMai() {
        if (this.listCTKhuyenMai == null)
            docDanhSach();
        return this.listCTKhuyenMai;
    }

    public boolean themCTKhuyenMai(String maKM, String maSP, String phantramgiam, String dieukien) {
        if (maKM.equals("") || dieukien.equals("") || phantramgiam.equals("")) {
            new MyDialog("Không được để trống thông tin!", MyDialog.ERROR_DIALOG);
            return false;
        }
        int mact = Integer.parseInt(maKM);
        int masp = Integer.parseInt(maSP);
        int pt =  Integer.parseInt(phantramgiam);
        int dk = Integer.parseInt(dieukien);
        boolean flag = false;
        try {           
            CTKhuyenMai ctkm = new CTKhuyenMai();
            ctkm.setMaKM(mact);
            ctkm.setMaSP(masp);
            ctkm.setPhanTramGiam(pt);     
            ctkm.setDieuKien(dk);                 

            flag = CTKMDAO.themCTKhuyenMai(ctkm);
            System.out.println(flag);
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

    public boolean suaCTKhuyenMai(String maKM, String maSP, String phantramgiam,  String dieukien ) {     
    	if (maKM.equals("") || maSP.equals("")|| dieukien.equals("") || phantramgiam.equals("")) {
            new MyDialog("Không được để trống thông tin!", MyDialog.ERROR_DIALOG);
            return false;
        }
        int makm = Integer.parseInt(maKM);
        int masp = Integer.parseInt(maSP);
        int pt =  Integer.parseInt(phantramgiam);
        int dk = Integer.parseInt(dieukien);
        boolean flag = false;
        try {           
            CTKhuyenMai ctkm = new CTKhuyenMai();
            ctkm.setMaKM(makm);
            ctkm.setMaSP(masp);
            ctkm.setPhanTramGiam(pt); 
            ctkm.setDieuKien(dk);          

            flag = CTKMDAO.suaCTKhuyenMai(ctkm);          
        } catch (Exception e) {            
            return false;
        }
        if (flag) {
            new MyDialog("Sửa thành công!", MyDialog.SUCCESS_DIALOG);
        } else {
            new MyDialog("Sửa thất bại!", MyDialog.ERROR_DIALOG);
        }
        return flag;
    }
    public boolean xoaCTKhuyenMai(String maKM, String maSP) {
    	if (maKM.trim().equals("")) {
    		new MyDialog("Chưa chọn loại để xóa !", MyDialog.ERROR_DIALOG);
			return false;
		}
		int makm = Integer.parseInt(maKM);
		int masp = Integer.parseInt(maSP);
		if (CTKMDAO.xoaCTKhuyenMai(makm,masp)) {
			 new MyDialog("Xóa thành công!", MyDialog.SUCCESS_DIALOG);
			return true;
		} else {
			new MyDialog("Xóa thất bại!", MyDialog.ERROR_DIALOG);
			return false;
		}
    }
    public void xoaCTKhuyenMai(String maKM) {
    	int makm = Integer.parseInt(maKM);
    	CTKMDAO.xoaCTKhuyenMai(makm);
    }
}
