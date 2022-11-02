package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import MyCustom.MyDialog;
import QuanLyMayTinh.BUS.CTKhuyenMaiBUS;
import QuanLyMayTinh.BUS.KhuyenMaiBUS;
import QuanLyMayTinh.DAO.MyConnect;
import QuanLyMayTinh.DTO.CTKhuyenMai;
import QuanLyMayTinh.DTO.KhuyenMai;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.ListSelectionModel;

public class DLG_HoaDon extends JFrame {

	private JPanel contentPane;
	boolean checkBanHang = false;
	private JTable tbl_hd;
	DefaultTableModel model_hd = new DefaultTableModel();
	private JEditorPane txt_title,txt_nhanVien,txt_ngayLap,txt_khachHang;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    DecimalFormat dcf = new DecimalFormat("###,### VND");
	CTKhuyenMaiBUS CTKM = new CTKhuyenMaiBUS();
	KhuyenMaiBUS KM = new KhuyenMaiBUS();
	
	 private ArrayList<Vector> dsGioHang;
	 private int tongTien;
	 private String nhanVien;
	 private String khachHang;
	
	QL_BanHang BHForm = new QL_BanHang();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLG_HoaDon frame = new DLG_HoaDon();
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
	
	public DLG_HoaDon() {
		new MyConnect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 784, 677);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(13, 31, 747, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_title = new JEditorPane();
		txt_title.setText("Hóa Đơn Thanh Toán");
		txt_title.setFont(new Font("Dialog", Font.BOLD, 31));
		txt_title.setEditable(false);
		txt_title.setBounds(221, 10, 349, 43);
		panel.add(txt_title);
		
		txt_nhanVien = new JEditorPane();
		txt_nhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_nhanVien.setEditable(false);
		txt_nhanVien.setBackground(Color.WHITE);
		txt_nhanVien.setBounds(123, 63, 183, 19);
		panel.add(txt_nhanVien);
		
		txt_ngayLap = new JEditorPane();
		txt_ngayLap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_ngayLap.setEditable(false);
		txt_ngayLap.setBackground(Color.WHITE);
		txt_ngayLap.setBounds(123, 92, 183, 19);
		panel.add(txt_ngayLap);
		
		txt_khachHang = new JEditorPane();
		txt_khachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_khachHang.setEditable(false);
		txt_khachHang.setBackground(Color.WHITE);
		txt_khachHang.setBounds(123, 121, 183, 19);
		panel.add(txt_khachHang);
		
		JLabel lblNewLabel = new JLabel("Nhân viên   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 60, 114, 26);
		panel.add(lblNewLabel);
		
		JLabel lblNgyLp = new JLabel("Ngày lập     :");
		lblNgyLp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNgyLp.setBounds(10, 89, 114, 26);
		panel.add(lblNgyLp);
		
		JLabel lblKhchHng = new JLabel("Khách hàng :");
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblKhchHng.setBounds(10, 121, 100, 26);
		panel.add(lblKhchHng);
		
		JLabel lblNewLabel_1 = new JLabel("=====================================================================");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(136, 154, 504, 13);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 170, 727, 274);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 707, 237);
		panel_1.add(scrollPane);
		
		tbl_hd = new JTable();		
		tbl_hd.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n"
			}
		));
		scrollPane.setViewportView(tbl_hd);
		
		JLabel lblNewLabel_1_1 = new JLabel("=====================================================================");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(123, 466, 504, 13);
		panel.add(lblNewLabel_1_1);
		
		JButton btn_inHoaDon = new JButton("In Hóa Đơn");
		btn_inHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_inHoaDon.setBounds(243, 568, 85, 33);
		contentPane.add(btn_inHoaDon);
		
		JButton btn_Thoat = new JButton("Thoát");
		btn_Thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Thoat.setBounds(389, 568, 85, 33);
		contentPane.add(btn_Thoat);
	}
	


	public void xuLyHienThiHoaDon(ArrayList<Vector> dsGioHang, int tongTien, String nhanVien, String khachHang, int tongphantram) {
		int count = 0;
		txt_nhanVien.setText(nhanVien);
		txt_khachHang.setText(khachHang);
		txt_ngayLap.setText(dtf.format(now));
		
		Vector header = new Vector();
		header.add("Mã SP ");
		header.add("Tên SP ");
		header.add("Số lượng");
		header.add("Đơn giá");
		header.add("Thành tiền");

		if (model_hd.getRowCount() == 0) {
			model_hd = new DefaultTableModel(header, 0);
		}
		for (Vector sp : dsGioHang) {
			model_hd.addRow(sp);
			tbl_hd.setModel(model_hd);
			count++;
		}
		
		for(int i =0;i<3;i++) {
			Vector val_null = new Vector();
			val_null.add("");
			val_null.add("");
			val_null.add("");
			val_null.add("");
			val_null.add("");
			model_hd.addRow(val_null);
		}		
		
		tbl_hd.setModel(model_hd);
		
		tbl_hd.setValueAt("Thành tiền :", count, 3);
		tbl_hd.setValueAt(tongTien+" VNĐ", count, 4);
		tbl_hd.setValueAt("Khuyến mãi :", count+1, 3);
		tbl_hd.setValueAt(tongphantram+" %", count+1, 4);
		tbl_hd.setValueAt("Tổng Tiền :", count+2, 3);
		tbl_hd.setValueAt(tongTien-(tongTien*tongphantram/100)+" VNĐ", count+2, 4);
	}
}
