package QuanLyMayTinh.DTO;

public class SanPham {
	private int maSP;
    private String tenSP;
    private int maLoai;
    private int soLuong;
    private int donGia;
    private String hinhAnh;
    private String moTa;
	public SanPham() {
		
	}
	public SanPham(int maSP, String tenSP, int maLoai, int soLuong, int donGia, String hinhAnh, String moTa) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.maLoai = maLoai;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}
