package QuanLyMayTinh.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongKeDao {
	public int tongThuTheoNam(int nam) {
		try {
			PreparedStatement prep = MyConnect.conn
					.prepareStatement("Select Sum(tongtien) as 'Doanh thu' "
							+ "From hoadon WHERE Year(ngaylap) = ? Group by Year(ngaylap)");
			prep.setInt(1, nam);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException ex) {
			return -1;
		}
		return 0;
	}
	public int tongChiTheoNam(int nam) {
		try {
			PreparedStatement prep = MyConnect.conn
					.prepareStatement("Select  Sum(tongtien) as 'Doanh thu' "
							+ "From phieunhap WHERE Year(ngaynhap) = ? Group by Year(ngaynhap)");
			prep.setInt(1, nam);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException ex) {
			System.out.println(ex);
			return -1;
		}
		return 0;
	}
	public String[] getQUY(int quy) {
		String[] thang = new String[3];
		 switch (quy) {
         case 1:
             thang[0] = 1+"";
             thang[1] = 2+"";
             thang[2] = 3+"";
             break;
         case 2:
        	 thang[0] = 4+"";
             thang[1] = 5+"";
             thang[2] = 6+"";
             break;
         case 3:
        	 thang[0] = 7+"";
             thang[1] = 8+"";
             thang[2] = 9+"";
             break;
         case 4:
        	 thang[0] = 10+"";
             thang[1] = 11+"";
             thang[2] = 12+"";
             break;
     }
		 return thang;
	}
	public int tongThuQuy(int nam,int quy) {
		String[] thang = getQUY(quy);
		try {
			PreparedStatement prep = MyConnect.conn
					.prepareStatement("Select  Sum(tongtien) as 'Doanh thu' "
							+ "From hoadon WHERE Year(ngaylap) = ? and Month(ngaylap) =? Group by Year(ngaylap)");
			int sumQuy = 0;
			for(String i : thang) {
				prep.setInt(1, nam);
				prep.setString(2, i);
				ResultSet rs = prep.executeQuery();
				while (rs.next()) {
					sumQuy += rs.getInt(1);
				}				
			}
			return sumQuy;
		} catch (SQLException ex) {
			return -1;
		}
	}
	
	public int tongChiQuy(int nam,int quy) {
		String[] thang = getQUY(quy);
		try {
			PreparedStatement prep = MyConnect.conn
					.prepareStatement("Select  Sum(tongtien) as 'Doanh thu' "
							+ "From phieunhap WHERE Year(ngaynhap) = ? and Month(ngaynhap) =? Group by Year(ngaynhap)");
			int sumQuy = 0;
			for(String i : thang) {
				prep.setInt(1, nam);
				prep.setString(2, i);
				ResultSet rs = prep.executeQuery();
				while (rs.next()) {
					sumQuy += rs.getInt(1);
				}				
			}
			return sumQuy;
		} catch (SQLException ex) {
			return -1;
		}
	}
	
	
	
	
	
	
	
	public String[] tongThuThang(int nam) {
		String[] month = new String[12];
		try {
			PreparedStatement prep = MyConnect.conn
					.prepareStatement("Select  Sum(tongtien) as 'Doanh thu' "
							+ "From hoadon WHERE Year(ngaylap) = ? and Month(ngaylap) =? Group by Year(ngaylap)");
			for(int i=0;i<12;i++) {
				prep.setInt(1, nam);
				prep.setInt(2, i);
				ResultSet rs = prep.executeQuery();
				while (rs.next()) {
					month[i] = rs.getInt(1)+"";
				}				
			}
			return month;
		} catch (SQLException ex) {
			return null;
		}
	}
	
	
	public String[] tongChiThang(int nam) {
		String[] month = new String[12];
		try {
			PreparedStatement prep = MyConnect.conn
					.prepareStatement("Select  Sum(tongtien) as 'Doanh thu' "
							+ "From phieunhap WHERE Year(ngaynhap) = ? and Month(ngaynhap) =? Group by Year(ngaynhap)");
			for(int i=0;i<12;i++) {
				prep.setInt(1, nam);
				prep.setInt(2, i);
				ResultSet rs = prep.executeQuery();
				while (rs.next()) {
					month[i] = rs.getInt(1)+"";
				}				
			}
			return month;
		} catch (SQLException ex) {
			return null;
		}
	}
}
