package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MyCustom.MyDialog;
import QuanLyMayTinh.BUS.DangNhapBUS;
import QuanLyMayTinh.DAO.MyConnect;
import QuanLyMayTinh.DTO.TaiKhoan;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dangnhap extends JFrame {

	private JPanel contentPane;
	private JTextField txt_taikhoan;
	JCheckBox check_ghinho;
	private JPasswordField txt_matkhau;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public dangnhap() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 643, 480);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(172, 10, 264, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(73, 72, 151, 39);
		contentPane.add(lblNewLabel_1);
		
		txt_taikhoan = new JTextField();
		txt_taikhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_taikhoan.setBounds(211, 75, 288, 36);
		contentPane.add(txt_taikhoan);
		txt_taikhoan.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu :");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(73, 125, 151, 39);
		contentPane.add(lblNewLabel_1_1);
		
		check_ghinho = new JCheckBox("Ghi nhớ đăng nhập");
		check_ghinho.setBackground(Color.CYAN);
		check_ghinho.setFont(new Font("Tahoma", Font.ITALIC, 14));
		check_ghinho.setBounds(81, 180, 288, 21);
		contentPane.add(check_ghinho);
		
		JButton btn_dangnhap = new JButton("ĐĂNG NHẬP");
		btn_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLyDangNhap();
			}
		});
		btn_dangnhap.setBackground(Color.RED);
		btn_dangnhap.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_dangnhap.setBounds(81, 250, 433, 59);
		btn_dangnhap.setFocusPainted(false);
		contentPane.add(btn_dangnhap);
		
		txt_matkhau = new JPasswordField();
		txt_matkhau.setBounds(211, 121, 288, 38);
		contentPane.add(txt_matkhau);
		
		JLabel lblNewLabel_2 = new JLabel("Quên mật khẩu ?");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xuLyQuenMatKhau();
			}
		});
		lblNewLabel_2.setBounds(228, 319, 208, 21);
		contentPane.add(lblNewLabel_2);
		xuLyTaiKhoanDaGhiNho();
	}
	private void xuLyQuenMatKhau() {
        new MyDialog("Xin liên hệ Admin để giải quyết!", MyDialog.INFO_DIALOG);
    }
	private void xuLyDangNhap() {
        DangNhapBUS dangNhapBUS = new DangNhapBUS();
        TaiKhoan tk = dangNhapBUS.getTaiKhoanDangNhap(txt_taikhoan.getText(),
                txt_matkhau.getText(), check_ghinho.isSelected());
        if (tk != null) {
            MainFormGUI MF = new MainFormGUI();
            MF.setVisible(true);
            this.dispose();            
        }
    }
	private void xuLyTaiKhoanDaGhiNho() {
        DangNhapBUS dangNhapBUS = new DangNhapBUS();
        String line = dangNhapBUS.getTaiKhoanGhiNho();
        try {
            String[] arr = line.split(" | ");
            check_ghinho.setSelected(true);
            txt_taikhoan.setText(arr[0]);
            txt_matkhau.setText(arr[2]);
            txt_taikhoan.requestFocus();
        } catch (Exception e) {
        	txt_taikhoan.setText("");
        	txt_matkhau.setText("");
        	txt_taikhoan.requestFocus();
        }
    }
	
}
