package QuanLyMayTinh.BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;


import QuanLyMayTinh.DAO.LoaiSanPhamDAO;
import QuanLyMayTinh.DTO.LoaiSanPham;

public class LoaiSanPhamBUS {
	private LoaiSanPhamDAO loaiDAO = new LoaiSanPhamDAO();
	private ArrayList<LoaiSanPham> listLoai = null;

	public LoaiSanPhamBUS() {
		docDanhSachLoai();
	}

	public void docDanhSachLoai() {
		this.listLoai = loaiDAO.getDanhSachLoai();
	}

	public ArrayList<LoaiSanPham> getDanhSachLoai() {
		if (listLoai == null) {
			docDanhSachLoai();
		}
		return this.listLoai;
	}

	public String getTenLoai(int ma) {
		for (LoaiSanPham loai : listLoai) {
			if (loai.getMaLoai() == ma) {
				return loai.getMaLoai() + " - " + loai.getTenLoai();
			}
		}
		return "";
	}

	public boolean themLoai(String maLoai, String tenLoai, String maNCC) {
		if (maLoai.trim().equals("") || tenLoai.trim().equals("")|| maNCC.trim().equals("")) {			
			JOptionPane.showMessageDialog(null, "Không được để trống thông tin !");
			return false;
		}
		for(LoaiSanPham loai : listLoai) {
			if(String.valueOf(loai.getMaLoai()).equals(maLoai)) {
				JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại !");
				return false;
			}
		}
		int maloai = Integer.parseInt(maLoai);
		int mancc = Integer.parseInt(maNCC);
		LoaiSanPham loai = new LoaiSanPham(maloai, tenLoai, mancc);
		if (loaiDAO.themLoai(loai)) {
			JOptionPane.showMessageDialog(null, "Thêm thành công !");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Thêm thất bại !");
			return false;
		}
	}

	public boolean xoaLoai(String ma) {
		if (ma.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa chọn loại để xóa !");
			return false;
		}
		int maLoai = Integer.parseInt(ma);
		if (loaiDAO.xoaLoai(maLoai)) {
			JOptionPane.showMessageDialog(null, "Xóa thành công !");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Xóa thất bại !");
			return false;
		}
	}

	public boolean suaLoai(String maloai, String ten, String mancc) {
		if (maloai.trim().equals("") || ten.trim().equals("")|| mancc.trim().equals("")) {			
			JOptionPane.showMessageDialog(null, "Không được để trống thông tin !");
			return false;
		}
//		for(LoaiSanPham loai : listLoai) {
//			if(String.valueOf(loai.getMaLoai()).equals(maloai)) {
//				JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại !");
//				return false;
//			}
//		}
		int maLoai = Integer.parseInt(maloai);
		int maNCC = Integer.parseInt(mancc);
		if (loaiDAO.suaLoai(maLoai, ten, maNCC)) {
			JOptionPane.showMessageDialog(null, "Sửa thành công !");
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Sữa thất bại !");
			return false;
		}
	}
}
