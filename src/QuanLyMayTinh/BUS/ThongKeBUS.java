package QuanLyMayTinh.BUS;

import java.util.ArrayList;

import QuanLyMayTinh.DAO.ThongKeDao;

public class ThongKeBUS {
	 public ThongKeDao thongKeDAO = new ThongKeDao();
	 private ArrayList<Double> doanhThuThang;
	 
	 public int getDoanhThuNam(String nam) {
		 int year = Integer.parseInt(nam);
		 return thongKeDAO.tongThuTheoNam(year);
	 }
	 public int getTongChiNam(String nam) {
		 int year = Integer.parseInt(nam);
		 return thongKeDAO.tongChiTheoNam(year);
	 }
	 
	 
	 
	 
	 public int getTongDoanhThuQuy(String nam, String quy) {
		 int year = Integer.parseInt(nam);
		 int Quy = Integer.parseInt(quy);
		 
		 return thongKeDAO.tongThuQuy(year, Quy);
	 }
	 
	 public int getTongDoanhChiQuy(String nam, String quy) {
		 int year = Integer.parseInt(nam);
		 int Quy = Integer.parseInt(quy);
		 
		 return thongKeDAO.tongChiQuy(year, Quy);
	 }
	 
	 
	 
	 
	 
	 public String[] getTongThuThang(String nam) {
		 int year = Integer.parseInt(nam);
		 return thongKeDAO.tongThuThang(year);
	 }
	 
	 public String[] getTongChiThang(String nam) {
		 int year = Integer.parseInt(nam);
		 return thongKeDAO.tongChiThang(year);
	 }
}
