package QuanLyMayTinh.DTO;

public class KhachHang {
	private int maKH;
	private String hoKH;
	private String tenKH;
	private String gioitinh;
	private int tongchitieu;
	private int tinhTrang;
	
	public KhachHang() {
	}

	public KhachHang(int maKH, String hoKH, String tenKH, String gioitinh, int tongchitieu, int tinhTrang) {
		this.maKH = maKH;
		this.hoKH = hoKH;
		this.tenKH = tenKH;
		this.gioitinh = gioitinh;
		this.tongchitieu = tongchitieu;
		this.tinhTrang = tinhTrang;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getHoKH() {
		return hoKH;
	}

	public void setHoKH(String hoKH) {
		this.hoKH = hoKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public int getTongchitieu() {
		return tongchitieu;
	}

	public void setTongchitieu(int tongchitieu) {
		this.tongchitieu = tongchitieu;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	
	
}
