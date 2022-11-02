package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import QuanLyMayTinh.BUS.CTKhuyenMaiBUS;
import QuanLyMayTinh.BUS.KhachHangBUS;
import QuanLyMayTinh.BUS.KhuyenMaiBUS;
import QuanLyMayTinh.DTO.KhachHang;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DLG_ChonKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txt_traCuu;
	private JTable tbl_KhachHang;
	private JButton btn_Chon;
	DefaultTableModel model_KH = new DefaultTableModel();
	KhachHangBUS KHBUS = new KhachHangBUS();
	public static KhachHang KHTimThay = new KhachHang();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLG_ChonKhachHang frame = new DLG_ChonKhachHang();
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
	public DLG_ChonKhachHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 744, 461);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 93, 705, 308);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 685, 236);
		panel.add(scrollPane);
		
		tbl_KhachHang = new JTable();
		tbl_KhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTableKhachHang();
			}
		});
		tbl_KhachHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		tbl_KhachHang.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(tbl_KhachHang);
		
		btn_Chon = new JButton("Ch\u1ECDn");
		btn_Chon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonKhachHang();
				dispose();
			}
		});
		btn_Chon.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_Chon.setBounds(295, 265, 132, 33);
		panel.add(btn_Chon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 710, 74);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tra C\u1EE9u :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(136, 10, 112, 38);
		panel_1.add(lblNewLabel);
		
		txt_traCuu = new JTextField();
		txt_traCuu.setBounds(251, 10, 257, 38);
		panel_1.add(txt_traCuu);
		txt_traCuu.setColumns(10);
		txt_traCuu.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				timKiem();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				timKiem();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				timKiem();
				
			}
		});
		loadingKhachHang();
	}
	private void loadingKhachHang() {
		KHBUS.docDanhSach();
		model_KH.setRowCount(0);
		ArrayList<KhachHang> dskh = KHBUS.getListKhachHang();
		Vector header = new Vector();
		header.add("Mã KH");
		header.add("Họ");
		header.add("Tên");
		header.add("giới Tính");			
		header.add("Tổng chi tiêu");
		if (model_KH.getRowCount() == 0) {
			model_KH = new DefaultTableModel(header, 0);
		}
		for (KhachHang kh : dskh) {
			Vector row = new Vector();
			row.add(kh.getMaKH());
			row.add(kh.getHoKH());
			row.add(kh.getTenKH());
			row.add(kh.getGioitinh());
			row.add(kh.getTongchitieu());
			model_KH.addRow(row);
		}
		tbl_KhachHang.setModel(model_KH);
	}
	private void timKiem() {
		model_KH.setRowCount(0);
		ArrayList<KhachHang> dskh = KHBUS.timKiemKhachHang(txt_traCuu.getText());
		Vector header = new Vector();
		header.add("Mã KH");
		header.add("Họ");
		header.add("Tên");
		header.add("giới Tính");
		header.add("Tổng chi tiêu");
		if (model_KH.getRowCount() == 0) {
			model_KH = new DefaultTableModel(header, 0);
		}
		for (KhachHang kh : dskh) {
			Vector row = new Vector();
			row.add(kh.getMaKH());
			row.add(kh.getHoKH());
			row.add(kh.getTenKH());
			row.add(kh.getGioitinh());			
			row.add(kh.getTongchitieu());
			model_KH.addRow(row);
		}
		tbl_KhachHang.setModel(model_KH);
	}
	private void clickTableKhachHang() {
		int row = tbl_KhachHang.getSelectedRow();
		if (row > -1) {
			String ma = tbl_KhachHang.getValueAt(row, 0) + "";
			String ho = tbl_KhachHang.getValueAt(row, 1) + "";
			String ten = tbl_KhachHang.getValueAt(row, 2) + "";
			String gioitinh = tbl_KhachHang.getValueAt(row, 3) + "";
			String tongchitieu = tbl_KhachHang.getValueAt(row, 4) + "";
			KHTimThay.setMaKH(Integer.parseInt(ma));
			KHTimThay.setHoKH(ho);
			KHTimThay.setTenKH(ten);
			KHTimThay.setGioitinh(gioitinh);
			KHTimThay.setTongchitieu(Integer.parseInt(tongchitieu));
		}
	}
	private void chonKhachHang() {
		QL_BanHang.getKhachHang(String.valueOf(KHTimThay.getMaKH()),KHTimThay.getHoKH(),KHTimThay.getTenKH(),KHTimThay.getGioitinh());
	}
}
