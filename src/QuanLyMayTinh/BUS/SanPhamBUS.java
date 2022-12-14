package QuanLyMayTinh.BUS;




import QuanLyMayTinh.DAO.SanPhamDAO;
import QuanLyMayTinh.DTO.SanPham;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SanPhamBUS {

    private ArrayList<SanPham> listSanPham = null;
    private SanPhamDAO spDAO = new SanPhamDAO();

    public SanPhamBUS() {
        docListSanPham();
    }

    public void docListSanPham() {
        listSanPham = spDAO.getListSanPham();
    }

    public ArrayList<SanPham> getListSanPham() {
        if (listSanPham == null) {
            docListSanPham();
        }
        return listSanPham;
    }

    public SanPham getSanPham(String ma) {
        if (!ma.trim().equals("")) {
            try {
                int maSP = Integer.parseInt(ma);
                for (SanPham sp : listSanPham) {
                    if (sp.getMaSP() == maSP) {
                        return sp;
                    }
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    public ArrayList<SanPham> getSanPhamTheoTen(String ten) {
        ArrayList<SanPham> dssp = new ArrayList<>();
        for (SanPham sp : listSanPham) {
            String tenSP = sp.getTenSP().toLowerCase();
            if (tenSP.toLowerCase().contains(ten.toLowerCase())) {
                dssp.add(sp);
            }
        }
        return dssp;
    }

    public ArrayList<SanPham> getSanPhamTheoLoai(String ma) {
        if (!ma.trim().equals("")) {
            ArrayList<SanPham> dssp = new ArrayList<>();
            try {
                int maLoai = Integer.parseInt(ma);
                for (SanPham sp : listSanPham) {
                    if (sp.getMaLoai() == maLoai) {
                        dssp.add(sp);
                    }
                }
                return dssp;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public String getAnh(String ma) {
        int maSP = Integer.parseInt(ma);
        return spDAO.getAnh(maSP);
    }

    public void capNhatSoLuongSP(int ma, int soLuongMat) {
        spDAO.capNhatSoLuongSP(ma, soLuongMat);
    }

    public boolean themSanPham(
    		String ma,
    		String ten,
            String loai,
            String soLuong,
            String donGia,
            String anh, 
    		String mota) {

        if (ma.trim().equals("")||ten.trim().equals("")||donGia.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "Kh??ng ???????c ????? tr???ng th??ng tin !");
            return false;
        }
        

        try {
        	int maSP = Integer.parseInt(ma);
            String[] loaiTmp = loai.split(" - ");
            int maLoai = Integer.parseInt(loaiTmp[0]);
            int soLuongSP = Integer.parseInt(soLuong);
            //donGia = donGia.replace(",", "");
            int donGiaSP = Integer.parseInt(donGia);
            if (maLoai == 0) {
            	JOptionPane.showMessageDialog(null, "Vui l??ng nh???p l???i m?? lo???i s???n ph???m !");
                return false;
            }
            SanPham sp = new SanPham();
            sp.setMaSP(maSP);
            sp.setTenSP(ten);
            sp.setMaLoai(maLoai);
            sp.setSoLuong(soLuongSP);                 
            sp.setDonGia(donGiaSP);            
            sp.setHinhAnh(anh);          
            sp.setMoTa(mota);
            
            if (spDAO.themSanPham(sp)) {
            	JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng !");
                return true;
            } else {
            	JOptionPane.showMessageDialog(null, "Th??m th???t b???i !");              	
                return false;
                
            }
            
        } catch (Exception e) {
           System.out.println(e);               
        }
        return false;
        
    }

//    public boolean nhapSanPhamTuExcel(String ten,
//            String loai,
//            String soLuong,
//            String donViTinh,
//            String anh,
//            String donGia) {
//
//        try {
//            String[] loaiTmp = loai.split(" - ");
//            int maLoai = Integer.parseInt(loaiTmp[0]);
//            int soLuongSP = Integer.parseInt(soLuong);
//            donGia = donGia.replace(",", "");
//            int donGiaSP = Integer.parseInt(donGia);
//
//            SanPham sp = new SanPham();
//            sp.setTenSP(ten);
//            sp.setMaLoai(maLoai);
//            sp.setSoLuong(soLuongSP);
//            sp.setHinhAnh(anh);
//            sp.setDonGia(donGiaSP);
//
//            spDAO.nhapSanPhamTuExcel(sp);
//        } catch (Exception e) {
//        }
//        return false;
//    }

    public boolean xoaSanPham(String ma) {
        if (ma.trim().equals("")) {
        	JOptionPane.showMessageDialog(null, "M?? s???n ph???m kh??ng ??c ????? tr???ng !");
            return false;
        }

        int maSP = Integer.parseInt(ma);
        if (spDAO.xoaSanPham(maSP)) {
        	JOptionPane.showMessageDialog(null, "X??a th??nh c??ng !");
            return true;
        }

        JOptionPane.showMessageDialog(null, "X??a th???t b???i !");
        return false;
    }

    public boolean suaSanPham(String ma,   		
    		String ten,
            String loai,
            String soLuong,
            String donGia,
            String anh, 
    		String mota) {

        try {
            if (ma.trim().equals("")) {
            	JOptionPane.showMessageDialog(null, "M?? s???n ph???m kh??ng ??c ????? tr???ng !");
                return false;
            }          
            int maSP = Integer.parseInt(ma);
            String[] loaiTmp = loai.split(" - ");
            int maLoai = Integer.parseInt(loaiTmp[0]);
            int soLuongSP = Integer.parseInt(soLuong);
            int donGiaSP = Integer.parseInt(donGia);

            if (maLoai == 0) {
            	JOptionPane.showMessageDialog(null, "Nh???p sai m?? s???n ph???m !");
                return false;
            }

            if (ten.trim().equals("")) {
            	JOptionPane.showMessageDialog(null, "T??n s???n ph???m kh??ng ???????c ????? tr???ng !");
                return false;
            }
           

            SanPham sp = new SanPham();
            sp.setMaSP(maSP);
            sp.setTenSP(ten);
            sp.setMaLoai(maLoai);
            sp.setSoLuong(soLuongSP);                 
            sp.setDonGia(donGiaSP);            
            sp.setHinhAnh(anh);          
            sp.setMoTa(mota);

            if (spDAO.suaSanPham(sp)) {
            	JOptionPane.showMessageDialog(null, "S???a s???n ph???m th??nh c??ng !");
                return true;
            } else {
            	JOptionPane.showMessageDialog(null, "S???a th???t b???i !");
                return false;
            }
        } catch (Exception e) {
        	System.out.println(e);
        }
        return false;
    }

    public String getTenSP(int maSP) {
        for (SanPham sp : listSanPham) {
            if (sp.getMaSP() == maSP) {
                return sp.getTenSP();
            }
        }
        return "";
    }
}
