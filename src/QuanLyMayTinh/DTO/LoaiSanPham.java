package QuanLyMayTinh.DTO;

public class LoaiSanPham {
	 private int maLoai;
	 private String tenLoai;
	 private int maNCC;
	public LoaiSanPham() {
		
	}
	public LoaiSanPham(int maLoai, String tenLoai, int maNCC) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.maNCC = maNCC;
	}
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public int getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}
	
}
