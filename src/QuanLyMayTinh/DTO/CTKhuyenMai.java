package QuanLyMayTinh.DTO;

public class CTKhuyenMai {
	private int maKM;
	private int maSP;
	private int dieuKien;
	private int phanTramGiam;
	
	
	public CTKhuyenMai() {
	}


	public CTKhuyenMai(int maKM, int maSP, int dieuKien, int phanTramGiam) {
		this.maKM = maKM;
		this.maSP = maSP;
		this.dieuKien = dieuKien;
		this.phanTramGiam = phanTramGiam;
	}


	public int getMaKM() {
		return maKM;
	}


	public void setMaKM(int maKM) {
		this.maKM = maKM;
	}


	public int getMaSP() {
		return maSP;
	}


	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}


	public int getDieuKien() {
		return dieuKien;
	}


	public void setDieuKien(int dieuKien) {
		this.dieuKien = dieuKien;
	}


	public int getPhanTramGiam() {
		return phanTramGiam;
	}


	public void setPhanTramGiam(int phanTramGiam) {
		this.phanTramGiam = phanTramGiam;
	}


	
	
}
