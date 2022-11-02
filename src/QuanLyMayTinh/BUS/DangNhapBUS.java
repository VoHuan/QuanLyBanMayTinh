package QuanLyMayTinh.BUS;

import QuanLyMayTinh.DAO.DangNhapDAO;
import QuanLyMayTinh.DTO.PhanQuyen;
import QuanLyMayTinh.DTO.TaiKhoan;
import MyCustom.MyDialog;

import java.io.*;

public class DangNhapBUS {

   
    public static TaiKhoan taiKhoanLogin = null;

    public TaiKhoan getTaiKhoanDangNhap(String user, String password, boolean selected) {
    	 if (user.equals("")||password.equals("")) {
            new MyDialog("Không được để trống thông tin!", MyDialog.ERROR_DIALOG);
            return null;
        }
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDangNhap(user);
        tk.setMatKhau(password);

        DangNhapDAO dangNhapDAO = new DangNhapDAO();
        TaiKhoan account = dangNhapDAO.dangNhap(tk);
        taiKhoanLogin = account;

        if (account == null) {
            new MyDialog("Sai thông tin đăng nhập hoặc tài khoản đã bị khoá!", MyDialog.ERROR_DIALOG);
        } else {
            PhanQuyenBUS phanQuyenBUS = new PhanQuyenBUS();
            phanQuyenBUS.kiemTraQuyen(account.getQuyen());
            xuLyGhiNhoDangNhap(user, password, selected);
            new MyDialog("Đăng nhập thành công!", MyDialog.SUCCESS_DIALOG);
        }
        return account;
    }

    public String getTaiKhoanGhiNho() {
        try {
            FileInputStream fis = new FileInputStream("remember.dat");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = br.readLine();
            br.close();
            return line;
        }catch (Exception e) {
        	System.out.println(e);
        }
        return "";
    }

    private void xuLyGhiNhoDangNhap(String user, String password, boolean selected) {
        try {
            if (!selected) {
                user = "";
                password = "";
            }
            FileWriter fw = new FileWriter("remember.dat");
            fw.write(user + " | " + password);
            fw.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

  

}
