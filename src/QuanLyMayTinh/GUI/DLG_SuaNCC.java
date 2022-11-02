package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import QuanLyMayTinh.DTO.NhaCungCap;
import QuanLyMayTinh.BUS.NhaCungCapBUS;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DLG_SuaNCC extends JFrame {

	private JPanel contentPane;
	private JTextField txt_maNCC;
	private JTextField txt_tenNCC;
	private JTextField txt_sdt;
	JTextArea txt_diachi;
	public static NhaCungCap thongtinNCC = new NhaCungCap() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLG_SuaNCC frame = new DLG_SuaNCC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DLG_SuaNCC() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 455);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMNcc = new JLabel("Mã NCC  :");
		lblMNcc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMNcc.setBounds(103, 63, 113, 27);
		contentPane.add(lblMNcc);
		
		txt_maNCC = new JTextField();
		txt_maNCC.setColumns(10);
		txt_maNCC.setBounds(226, 63, 239, 27);
		contentPane.add(txt_maNCC);
		
		JLabel lblTnNcc_1 = new JLabel("Tên NCC :");
		lblTnNcc_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTnNcc_1.setBounds(103, 100, 113, 27);
		contentPane.add(lblTnNcc_1);
		
		JLabel lblSt = new JLabel("SĐT        :");
		lblSt.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSt.setBounds(103, 137, 113, 27);
		contentPane.add(lblSt);
		
		JLabel lblaCh = new JLabel("Địa chỉ   :");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblaCh.setBounds(103, 186, 113, 27);
		contentPane.add(lblaCh);
		
		JButton btn_sua = new JButton("Sửa");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaNCC();
			}
		});
		btn_sua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_sua.setBounds(137, 315, 97, 36);
		contentPane.add(btn_sua);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_thoat.setBounds(356, 315, 97, 36);
		contentPane.add(btn_thoat);
		
		txt_tenNCC = new JTextField();
		txt_tenNCC.setColumns(10);
		txt_tenNCC.setBounds(226, 100, 239, 27);
		contentPane.add(txt_tenNCC);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(226, 145, 239, 27);
		contentPane.add(txt_sdt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 186, 355, 87);
		contentPane.add(scrollPane);
		
		txt_diachi = new JTextArea();
		scrollPane.setViewportView(txt_diachi);
		loadingThongTinNCC();
	}
	private void loadingThongTinNCC() {
		txt_maNCC.setText(thongtinNCC.getMaNCC()+"");
		txt_tenNCC.setText(thongtinNCC.getTenNCC());
		txt_sdt.setText(thongtinNCC.getDienThoai()+"");
		txt_diachi.setText(thongtinNCC.getDiaChi());
	}
	private void suaNCC() {
		 NhaCungCapBUS NCCBUS = new NhaCungCapBUS();
	        boolean flag = NCCBUS.suaNhaCungCap(
	        		txt_maNCC.getText(),
	                txt_tenNCC.getText(),
	                txt_diachi.getText(),
	                txt_sdt.getText());	      
	        if (flag) {
	            this.dispose();
	        }
	}
}
