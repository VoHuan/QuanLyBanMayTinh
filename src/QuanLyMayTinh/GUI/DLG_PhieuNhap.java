package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import QuanLyMayTinh.BUS.CTPhieuNhapBUS;
import QuanLyMayTinh.BUS.PhieuNhapBUS;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DLG_PhieuNhap extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTable tbl_CTPN;
	private JEditorPane txt_title,txt_nhanVien,txt_ngayLap,txt_NCC;
	DefaultTableModel model_CTPN = new DefaultTableModel();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    DecimalFormat dcf = new DecimalFormat("###,### VND");
    PhieuNhapBUS pnBUS = new PhieuNhapBUS();
    CTPhieuNhapBUS ctpnBUS = new CTPhieuNhapBUS();
    
    private ArrayList<Vector> dsPhieuNhap;
	private int tongTien;
	private String nhanVien;
	private String nhacungcap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLG_PhieuNhap frame = new DLG_PhieuNhap();
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
	public DLG_PhieuNhap() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 784, 677);
		contentPane = new JPanel();
		contentPane_1 = new JPanel();
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhân viên   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 55, 114, 26);
		contentPane_1.add(lblNewLabel);
		
		JEditorPane txt_title = new JEditorPane();
		txt_title.setText("Chi Tiết Phiếu Nhập");
		txt_title.setFont(new Font("Dialog", Font.BOLD, 31));
		txt_title.setEditable(false);
		txt_title.setBounds(228, 10, 349, 43);
		contentPane_1.add(txt_title);
		
		JLabel lblNgyLp = new JLabel("Ngày lập     :");
		lblNgyLp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNgyLp.setBounds(10, 91, 114, 26);
		contentPane_1.add(lblNgyLp);
		
		JLabel lblNhCungCp = new JLabel("Nhà cung cấp :");
		lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNhCungCp.setBounds(10, 127, 129, 26);
		contentPane_1.add(lblNhCungCp);
		
		txt_nhanVien = new JEditorPane();
		txt_nhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_nhanVien.setEditable(false);
		txt_nhanVien.setBackground(Color.WHITE);
		txt_nhanVien.setBounds(128, 55, 183, 26);
		contentPane_1.add(txt_nhanVien);
		
		txt_ngayLap = new JEditorPane();
		txt_ngayLap.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_ngayLap.setEditable(false);
		txt_ngayLap.setBackground(Color.WHITE);
		txt_ngayLap.setBounds(134, 91, 183, 26);
		contentPane_1.add(txt_ngayLap);
		
		txt_NCC = new JEditorPane();
		txt_NCC.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_NCC.setEditable(false);
		txt_NCC.setBackground(Color.WHITE);
		txt_NCC.setBounds(128, 127, 183, 26);
		contentPane_1.add(txt_NCC);
		
		JLabel lblNewLabel_1 = new JLabel("=====================================================================");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(151, 174, 504, 13);
		contentPane_1.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(20, 197, 727, 274);
		contentPane_1.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 707, 237);
		panel_1.add(scrollPane);
		
		tbl_CTPN = new JTable();
		tbl_CTPN.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 SP", "T\u00EAn SP", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(tbl_CTPN);
		
		JLabel lblNewLabel_1_1 = new JLabel("=====================================================================");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(151, 481, 504, 13);
		contentPane_1.add(lblNewLabel_1_1);
		
		JButton btn_inHoaDon = new JButton("In Phiếu Nhập");
		btn_inHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_inHoaDon.setBounds(228, 531, 141, 33);
		contentPane_1.add(btn_inHoaDon);
		
		JButton btn_Thoat = new JButton("Thoát");
		btn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Thoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Thoat.setBounds(454, 531, 123, 33);
		contentPane_1.add(btn_Thoat);
	}
	public void xuLyHienThiPhieuNhap(ArrayList<Vector> dsPhieuNhap, int tongTien, String nhanVien, String nhacungcap) {
		int count = 0;
		txt_nhanVien.setText(nhanVien);
		txt_NCC.setText(nhacungcap);
		txt_ngayLap.setText(dtf.format(now));
		
		Vector header = new Vector();
		header.add("Mã SP ");
		header.add("Tên SP ");
		header.add("Số lượng");
		header.add("Đơn giá");
		header.add("Thành tiền");

		if (model_CTPN.getRowCount() == 0) {
			model_CTPN = new DefaultTableModel(header, 0);
		}
		for (Vector pn : dsPhieuNhap) {
			model_CTPN.addRow(pn);
			tbl_CTPN.setModel(model_CTPN);
			count++;
		}
		
		
		Vector val_null = new Vector();
		val_null.add("");			
		model_CTPN.addRow(val_null);
		
		tbl_CTPN.setModel(model_CTPN);
		
		tbl_CTPN.setValueAt("Tổng Tiền :", count, 3);
		tbl_CTPN.setValueAt(tongTien+" VNĐ", count, 4);
		
	}
}
