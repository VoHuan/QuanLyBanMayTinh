package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import QuanLyMayTinh.BUS.NhaCungCapBUS;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DLG_ThemNCC extends JFrame {

	private JPanel contentPane;
	private JTextField txt_tenNCC;
	private JTextField txt_sdt;
	private JTextArea txt_diachi;
	private NhaCungCapBUS NCCBUS = new NhaCungCapBUS();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLG_ThemNCC frame = new DLG_ThemNCC();
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
	public DLG_ThemNCC() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 455);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnNcc = new JLabel("Tên NCC :");
		lblTnNcc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTnNcc.setBounds(140, 59, 113, 27);
		contentPane.add(lblTnNcc);
		
		JLabel lblaCh = new JLabel("Địa chỉ   :");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblaCh.setBounds(140, 171, 113, 27);
		contentPane.add(lblaCh);
		
		JLabel lblSt = new JLabel("SĐT        :");
		lblSt.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSt.setBounds(140, 117, 113, 27);
		contentPane.add(lblSt);
		
		txt_tenNCC = new JTextField();
		txt_tenNCC.setColumns(10);
		txt_tenNCC.setBounds(246, 63, 239, 27);
		contentPane.add(txt_tenNCC);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(246, 121, 239, 27);
		contentPane.add(txt_sdt);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNCC();
			}
		});
		btn_them.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_them.setBounds(175, 299, 97, 36);
		contentPane.add(btn_them);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_thoat.setBounds(437, 299, 97, 36);
		contentPane.add(btn_thoat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 175, 355, 87);
		contentPane.add(scrollPane);
		
		txt_diachi = new JTextArea();
		scrollPane.setViewportView(txt_diachi);
	}
	private void themNCC() {
		String ten = txt_tenNCC.getText();
		String sdt = txt_sdt.getText();
		String diachi = txt_diachi.getText();
		boolean flag = NCCBUS.themNhaCungCap(ten, diachi, sdt);
		if(flag) {
			NCCBUS.docDanhSach();
		}
	}
}
