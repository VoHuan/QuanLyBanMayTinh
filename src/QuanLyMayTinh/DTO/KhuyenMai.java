package QuanLyMayTinh.DTO;

import java.util.Date;

public class KhuyenMai {
	private int maKM;
    private String tenKM;
    private Date ngayBD;
    private Date ngayKT;
    
    
	public KhuyenMai() {
	}


	public KhuyenMai(int maKM, String tenKM, Date ngayBD, Date ngayKT) {
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.ngayBD = ngayBD;
		this.ngayKT = ngayKT;
	}


	public int getMaKM() {
		return maKM;
	}


	public void setMaKM(int maKM) {
		this.maKM = maKM;
	}


	public String getTenKM() {
		return tenKM;
	}


	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}


	public Date getNgayBD() {
		return ngayBD;
	}


	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}


	public Date getNgayKT() {
		return ngayKT;
	}


	public void setNgayKT(Date ngayKT) {
		this.ngayKT = ngayKT;
	}
    
    
}
