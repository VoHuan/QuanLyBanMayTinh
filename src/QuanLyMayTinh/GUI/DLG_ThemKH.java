package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DLG_ThemKH extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ten;
	private JTextField txt_diachi;
	private JTextField txt_ho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLG_ThemKH frame = new DLG_ThemKH();
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
	public DLG_ThemKH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 455);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTnNcc = new JLabel("Tên :");
		lblTnNcc.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTnNcc.setBounds(129, 118, 113, 27);
		contentPane.add(lblTnNcc);
		
		JLabel lblSt = new JLabel("Địa chỉ :");
		lblSt.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSt.setBounds(129, 173, 108, 27);
		contentPane.add(lblSt);
		
		txt_ten = new JTextField();
		txt_ten.setColumns(10);
		txt_ten.setBounds(246, 118, 239, 27);
		contentPane.add(txt_ten);
		
		txt_diachi = new JTextField();
		txt_diachi.setColumns(10);
		txt_diachi.setBounds(247, 173, 239, 27);
		contentPane.add(txt_diachi);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_them.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_them.setBounds(145, 275, 97, 36);
		contentPane.add(btn_them);
		
		JButton btn_thoat = new JButton("Thoát");
		btn_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_thoat.setBounds(432, 275, 97, 36);
		contentPane.add(btn_thoat);
		
		JLabel lblTnNcc_1 = new JLabel("Họ :");
		lblTnNcc_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTnNcc_1.setBounds(129, 62, 113, 27);
		contentPane.add(lblTnNcc_1);
		
		txt_ho = new JTextField();
		txt_ho.setColumns(10);
		txt_ho.setBounds(246, 66, 239, 27);
		contentPane.add(txt_ho);
	}
}
