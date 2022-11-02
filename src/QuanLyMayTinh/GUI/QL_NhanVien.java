package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import MyCustom.MyDialog;
import MyCustom.XuLyFileExcel;
import QuanLyMayTinh.BUS.NhanVienBUS;
import QuanLyMayTinh.BUS.PhanQuyenBUS;
import QuanLyMayTinh.BUS.TaiKhoanBUS;
import QuanLyMayTinh.DAO.MyConnect;
import QuanLyMayTinh.DTO.NhanVien;
import QuanLyMayTinh.DTO.TaiKhoan;
import QuanLyMayTinh.DTO.PhanQuyen;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JCheckBox;

public class QL_NhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txt_maNV;
	private JTextField txt_Ho;
	private JTextField txt_ten;
	private JTable tbl_nhanvien;
	private JTextField txt_TK;
	private JTextField txt_MK;
	private JTextField txt_timKiem;
	JRadioButton rdb_Nam;
	JRadioButton rdb_Nu;
	JComboBox cbx_chucvu;
	JComboBox cbx_quyen;
	NhanVienBUS NVBUS = new NhanVienBUS();
	TaiKhoanBUS TKBUS = new TaiKhoanBUS();
	PhanQuyenBUS PQBUS = new PhanQuyenBUS();
	DefaultTableModel model_NV = new DefaultTableModel();
	JCheckBox check_QLNV,check_QLSP,check_QLKH,check_QLNH,check_QLTK;
	JButton btn_themquyen,btn_xoaquyen,btn_suaquyen,btn_menu_1,btn_menu;
	private boolean gender = true;
	private JPanel panel_PhanQuyen;
	private JPanel panel_NhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				new MyConnect();
				QL_NhanVien frame = new QL_NhanVien();
					frame.setVisible(true);
					frame.loadingNhanVien();
					
					frame.loadingcomboBoxquyen();
					frame.loadingPhanQuyen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QL_NhanVien() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 815);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		tabbedPane.setBounds(10, 10, 1106, 768);
		contentPane.add(tabbedPane);
				
		panel_NhanVien = new JPanel();
		tabbedPane.addTab("Nhân Viên", null, panel_NhanVien, null);
		panel_NhanVien.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(20, 10, 480, 371);
		panel_NhanVien.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 54, 153, 41);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Họ :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 105, 131, 41);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tên :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 156, 116, 46);
		panel.add(lblNewLabel_1_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new CompoundBorder(null,
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"Gi\u1EDBi T\u00EDnh", TitledBorder.LEADING, TitledBorder.TOP, null,
								new Color(0, 0, 0))),
				"Gi\u1EDBi t\u00EDnh", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 212, 460, 70);
		panel.add(panel_2);
		panel_2.setLayout(null);

		rdb_Nam = new JRadioButton("Nam");
		rdb_Nam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdb_Nam.isSelected()) {
					gender = true;
					rdb_Nu.setSelected(false);
				}
			}
		});
		rdb_Nam.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdb_Nam.setBounds(102, 26, 103, 21);
		panel_2.add(rdb_Nam);

		rdb_Nu = new JRadioButton("Nữ");
		rdb_Nu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdb_Nu.isSelected()) {
					gender = false;
					rdb_Nam.setSelected(false);
				}
			}
		});
		rdb_Nu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdb_Nu.setBounds(223, 26, 103, 21);
		panel_2.add(rdb_Nu);

		JLabel lblNewLabel_1_2_1 = new JLabel("Chức vụ :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(10, 301, 116, 46);
		panel.add(lblNewLabel_1_2_1);

		txt_maNV = new JTextField();
		txt_maNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_maNV.setBounds(186, 54, 189, 34);
		panel.add(txt_maNV);
		txt_maNV.setColumns(10);

		txt_Ho = new JTextField();
		txt_Ho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_Ho.setColumns(10);
		txt_Ho.setBounds(186, 112, 189, 34);
		panel.add(txt_Ho);

		txt_ten = new JTextField();
		txt_ten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_ten.setColumns(10);
		txt_ten.setBounds(186, 168, 189, 34);
		panel.add(txt_ten);

		cbx_chucvu = new JComboBox();
		cbx_chucvu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbx_chucvu.setModel(new DefaultComboBoxModel(new String[] { "Nhân viên", "Quản lý", "Admin" }));
		cbx_chucvu.setBounds(186, 309, 149, 31);
		panel.add(cbx_chucvu);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_1.setBounds(510, 10, 592, 371);
		panel_NhanVien.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 23, 572, 323);
		panel_1.add(scrollPane_2);

		tbl_nhanvien = new JTable();
		tbl_nhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTableNhanVien();
			}
		});
		tbl_nhanvien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD", "T\u00EAn", "Gi\u1EDBi T\u00EDnh", "Ch\u1EE9c v\u1EE5", "T\u00E0i kho\u1EA3n"
			}
		));
		scrollPane_2.setViewportView(tbl_nhanvien);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Qu\u1EA3n l\u00FD t\u00E0i kho\u1EA3n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 510, 504, 201);
		panel_NhanVien.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_3 = new JLabel("Tài khoản :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(123, 28, 153, 41);
		panel_3.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Mật khẩu : ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(123, 80, 153, 41);
		panel_3.add(lblNewLabel_1_4);

		txt_TK = new JTextField();
		txt_TK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_TK.setColumns(10);
		txt_TK.setBounds(248, 28, 233, 34);
		panel_3.add(txt_TK);

		txt_MK = new JTextField();
		txt_MK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_MK.setColumns(10);
		txt_MK.setBounds(248, 87, 233, 34);
		panel_3.add(txt_MK);

		JButton btn_Sua = new JButton("Sữa");
		btn_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaTaiKhoan();
			}
		});
		btn_Sua.setBounds(136, 149, 85, 21);
		panel_3.add(btn_Sua);

		JButton btn_khoa = new JButton("Khóa");
		btn_khoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoaTaiKhoan();
			}
		});
		btn_khoa.setBounds(248, 149, 85, 21);
		panel_3.add(btn_khoa);
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themTaiKhoan();
			}
		});
		btn_them.setBounds(25, 149, 85, 21);
		panel_3.add(btn_them);
		
		JButton btn_mokhoa = new JButton("Mở khóa");
		btn_mokhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moKhoaTaiKhoan();
			}
		});
		btn_mokhoa.setBounds(365, 149, 85, 21);
		panel_3.add(btn_mokhoa);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(10, 391, 498, 103);
		panel_NhanVien.add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNV();
			}
		});
		btnNewButton_2.setBounds(70, 10, 85, 21);
		panel_4.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Sửa");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaNV();
			}
		});
		btnNewButton_3.setBounds(207, 10, 85, 21);
		panel_4.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Xóa");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xoaNV();
			}
		});
		btnNewButton_4.setBounds(348, 10, 85, 21);
		panel_4.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Nhập Excel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLyNhapExcel();
			}
		});
		btnNewButton_5.setBounds(118, 58, 103, 21);
		panel_4.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Xuất Excel");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLyXuatExcel();
			}
		});
		btnNewButton_6.setBounds(275, 58, 109, 21);
		panel_4.add(btnNewButton_6);

		JLabel lblNewLabel_1_5 = new JLabel("Tìm kiếm :");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(550, 391, 123, 41);
		panel_NhanVien.add(lblNewLabel_1_5);

		JComboBox cbx_timkiem = new JComboBox();
		cbx_timkiem.setModel(new DefaultComboBoxModel(new String[] { "Mã", "Tên", "Giới Tính", "Chức vụ" }));
		cbx_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbx_timkiem.setBounds(667, 396, 149, 31);
		panel_NhanVien.add(cbx_timkiem);

		txt_timKiem = new JTextField();
		txt_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_timKiem.setColumns(10);
		txt_timKiem.setBounds(825, 395, 233, 34);
		panel_NhanVien.add(txt_timKiem);

		JButton btn_timkiem = new JButton("Tìm Kiếm");
		btn_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String infor = "" + cbx_timkiem.getItemAt(cbx_timkiem.getSelectedIndex());
				if(infor.equalsIgnoreCase("Mã")) {
					int ma = Integer.parseInt(txt_timKiem.getText());
					NhanVien nv = new NhanVien();
					nv = timTheoMa(ma);
					if(nv == null) {
                		JOptionPane.showMessageDialog(null, "Sinh viên không tồn tại !");
                	}
                	else {                		
                    	model_NV.setRowCount(0);
         		        Vector row=new Vector();
         		        row.add(nv.getMaNV());
         		        row.add(nv.getHoNV());
         		        row.add(nv.getTenNV());
         		        row.add(nv.getGioiTinh());
         		        row.add(nv.getChucVu());
         		        model_NV.addRow(row); 
         		        
         		        tbl_nhanvien.setModel(model_NV);
                	}
				}
				if(infor.equalsIgnoreCase("Tên"))
					timTheoTen();
				if(infor.equalsIgnoreCase("Giới tính"))
					timTheoGioiTinh();	
				if(infor.equalsIgnoreCase("Chức vụ"))
					timTheoChucVu();
			}
		});
		btn_timkiem.setBounds(667, 480, 123, 31);
		panel_NhanVien.add(btn_timkiem);
		
		JButton btn_showall = new JButton("Show All");
		btn_showall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadingNhanVien();
			}
		});
		btn_showall.setBounds(848, 480, 109, 31);
		panel_NhanVien.add(btn_showall);
		
		btn_menu = new JButton("Trang Chính");
		btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormGUI MF = new MainFormGUI();
				MF.setVisible(true);
				dispose();
			}
		});
		btn_menu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_menu.setBounds(715, 590, 216, 41);
		btn_menu.setIcon(new ImageIcon("Icon/home.png"));
		panel_NhanVien.add(btn_menu);
		
		
		// Căn giữa table
		for (int x = 0; x < tbl_nhanvien.getColumnCount(); x++) {
			tbl_nhanvien.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
		}

		
		panel_PhanQuyen = new JPanel();
		tabbedPane.addTab("Phân Quyền", null, panel_PhanQuyen, null);
		panel_PhanQuyen.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Phân Quyền");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setBounds(469, 24, 263, 33);
		panel_PhanQuyen.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Các loại quyền :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(419, 123, 146, 33);
		panel_PhanQuyen.add(lblNewLabel_2);
		
		cbx_quyen = new JComboBox();
		cbx_quyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadingPhanQuyen();
			}
		});
		cbx_quyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbx_quyen.setBounds(586, 123, 146, 33);
		panel_PhanQuyen.add(cbx_quyen);
		
		JLabel lblNewLabel_2_1 = new JLabel("Chức năng :");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(419, 186, 146, 33);
		panel_PhanQuyen.add(lblNewLabel_2_1);
		
		check_QLNV = new JCheckBox("Quản lý nhân viên");
		check_QLNV.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		check_QLNV.setBounds(533, 236, 199, 21);
		panel_PhanQuyen.add(check_QLNV);
		
		check_QLSP = new JCheckBox("Quản lý sản phẩm");
		check_QLSP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		check_QLSP.setBounds(533, 279, 182, 21);
		panel_PhanQuyen.add(check_QLSP);
		
		check_QLKH = new JCheckBox("Quản lý khách hàng");
		check_QLKH.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		check_QLKH.setBounds(533, 320, 233, 21);
		panel_PhanQuyen.add(check_QLKH);
		
		check_QLNH = new JCheckBox("Quản lý nhập hàng");
		check_QLNH.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		check_QLNH.setBounds(533, 363, 199, 21);
		panel_PhanQuyen.add(check_QLNH);
		
		check_QLTK = new JCheckBox("Quản lý thống kê");
		check_QLTK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		check_QLTK.setBounds(533, 405, 199, 21);
		panel_PhanQuyen.add(check_QLTK);
		
		btn_themquyen = new JButton("Thêm quyền");
		btn_themquyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themQuyen();
			}
		});
		btn_themquyen.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_themquyen.setBounds(273, 471, 160, 42);
		panel_PhanQuyen.add(btn_themquyen);
		
		btn_suaquyen = new JButton("Sửa quyền");
		btn_suaquyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaQuyen();
			}
		});
		btn_suaquyen.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_suaquyen.setBounds(522, 471, 182, 44);
		panel_PhanQuyen.add(btn_suaquyen);
		
		btn_xoaquyen = new JButton("Xóa quyền");
		btn_xoaquyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaQuyen();
			}
		});
		btn_xoaquyen.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_xoaquyen.setBounds(788, 471, 187, 42);
		panel_PhanQuyen.add(btn_xoaquyen);
		
		btn_menu_1 = new JButton("Trang Chính");
		btn_menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormGUI MF = new MainFormGUI();
				MF.setVisible(true);
				dispose();
			}
		});
		btn_menu_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_menu_1.setBounds(516, 607, 216, 41);
		btn_menu_1.setIcon(new ImageIcon("Icon/home.png"));
		panel_PhanQuyen.add(btn_menu_1);
		loadingNhanVien();
		loadingcomboBoxquyen();
		loadingPhanQuyen();
	}
	private void loadingNhanVien() {
		NVBUS.docDanhSach();
		model_NV.setRowCount(0);
		ArrayList<NhanVien> dsnv = NVBUS.getDanhSachNhanVien();
		Vector header = new Vector();
		header.add("Mã NV");
		header.add("HỌ");
		header.add("Tên");
		header.add("giới Tính");
		header.add("Chức Vụ");
		header.add("Tài khoản");

		if (model_NV.getRowCount() == 0) {
			model_NV = new DefaultTableModel(header, 0);
		}
		for (NhanVien nv : dsnv) {
			Vector row = new Vector();
			row.add(nv.getMaNV());
			row.add(nv.getHoNV());
			row.add(nv.getTenNV());
			row.add(nv.getGioiTinh());
			row.add(nv.getChucVu());			
			if(TKBUS.getTrangThai(nv.getMaNV()) == 1) {
				row.add("Hiệu lực");
			}
			else
				row.add("Không hiệu lực");
			model_NV.addRow(row);
			tbl_nhanvien.setModel(model_NV);
		}
	}

	private void clickTableNhanVien() {
		int row = tbl_nhanvien.getSelectedRow();
		if (row > -1) {
			String ma = tbl_nhanvien.getValueAt(row, 0) + "";
			String ho = tbl_nhanvien.getValueAt(row, 1) + "";
			String ten = tbl_nhanvien.getValueAt(row, 2) + "";
			String gioitinh = tbl_nhanvien.getValueAt(row, 3) + "";
			String chucvu = tbl_nhanvien.getValueAt(row, 4) + "";

			// lấy dữ liệu lên textfiled
			txt_maNV.setText(ma);
			txt_Ho.setText(ho);
			txt_ten.setText(ten);
			if (gioitinh.equalsIgnoreCase("Nam")) {
				rdb_Nam.setSelected(true);
				rdb_Nu.setSelected(false);
			} else {
				rdb_Nu.setSelected(true);
				rdb_Nam.setSelected(false);
			}
			int index0 = 0, index1 = 1, index2 = 2;
			if (chucvu.equalsIgnoreCase("Nhân viên"))
				cbx_chucvu.setSelectedIndex(0);
			if (chucvu.equalsIgnoreCase("Quản lý"))
				cbx_chucvu.setSelectedIndex(1);
			if (chucvu.equalsIgnoreCase("Admin"))
				cbx_chucvu.setSelectedIndex(2);
			//lấy thông tin tài khoản
			txt_TK.setText("");
			txt_MK.setText("");
			TKBUS.docDanhSach();
			ArrayList<TaiKhoan> dstk = TKBUS.getDanhSachTaiKhoan();
			int maNV = Integer.parseInt(ma);
			for(TaiKhoan tk : dstk) {
				if(tk.getMaNhanVien() == maNV) {
					txt_TK.setText(tk.getTenDangNhap());
					txt_MK.setText(tk.getMatKhau());
				}
			}
		}
	}

	private void themNV() {
		String gioitinh;
		if (gender == true) {
			gioitinh = "Nam";
		} else {
			gioitinh = "Nữ";
		}
		String chucvu = "" + cbx_chucvu.getItemAt(cbx_chucvu.getSelectedIndex());

		boolean flag = NVBUS.themNhanVien(txt_maNV.getText(), txt_Ho.getText(), txt_ten.getText(), gioitinh, chucvu);
		if (flag) {
			NVBUS.docDanhSach();
			loadingNhanVien();
		}
	}

	private void suaNV() {
		String gioitinh;
		if (gender == true) {
			gioitinh = "Nam";
		} else {
			gioitinh = "Nữ";
		}
		String chucvu = "" + cbx_chucvu.getItemAt(cbx_chucvu.getSelectedIndex());

		boolean flag = NVBUS.updateNhanVien(txt_maNV.getText(), txt_Ho.getText(), txt_ten.getText(), gioitinh, chucvu);
		if (flag) {
			NVBUS.docDanhSach();
			loadingNhanVien();
		}
	}

	private void xoaNV() {
		boolean flag = NVBUS.xoaNhanVien(txt_maNV.getText());
		if (flag) {			
			TKBUS.khoaTaiKhoan(txt_maNV.getText());
			loadingNhanVien();
		}
	}
	private NhanVien timTheoMa(int ma) {
		ArrayList<NhanVien> dsnv = NVBUS.getDanhSachNhanVien();
		for(NhanVien nv : dsnv) {
			if(nv.getMaNV() == ma)
				return nv;
		}
		return null;
	}

	private void timTheoTen() {
		model_NV.setRowCount(0);
		boolean check = false; 
		String temp = txt_timKiem.getText();
		ArrayList<NhanVien> dsnv = NVBUS.getDanhSachNhanVien();
		for(NhanVien nv : dsnv) {
			if(nv.getTenNV().equalsIgnoreCase(temp)) { 
				check = true;												
				Vector row = new Vector();
				row.add(nv.getMaNV());
				row.add(nv.getHoNV());
				row.add(nv.getTenNV());
				row.add(nv.getGioiTinh());
				row.add(nv.getChucVu());

				model_NV.addRow(row);
				tbl_nhanvien.setModel(model_NV);
			}
		}
		if(check == false) {
			JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại !");
		}
	}
	private void timTheoGioiTinh() {
		model_NV.setRowCount(0);
		boolean check = false; 
		String temp = txt_timKiem.getText();
		ArrayList<NhanVien> dsnv = NVBUS.getDanhSachNhanVien();
		for(NhanVien nv : dsnv) {
			if(nv.getGioiTinh().equalsIgnoreCase(temp)) { 
				check = true;												
				Vector row = new Vector();
				row.add(nv.getMaNV());
				row.add(nv.getHoNV());
				row.add(nv.getTenNV());
				row.add(nv.getGioiTinh());
				row.add(nv.getChucVu());

				model_NV.addRow(row);
				tbl_nhanvien.setModel(model_NV);
			}
		}
		if(check == false) {
			JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại !");
		}
	}
	private void timTheoChucVu() {
		model_NV.setRowCount(0);
		boolean check = false; 
		String temp = txt_timKiem.getText();
		ArrayList<NhanVien> dsnv = NVBUS.getDanhSachNhanVien();
		for(NhanVien nv : dsnv) {
			if(nv.getChucVu().equalsIgnoreCase(temp)) { 
				check = true;												
				Vector row = new Vector();
				row.add(nv.getMaNV());
				row.add(nv.getHoNV());
				row.add(nv.getTenNV());
				row.add(nv.getGioiTinh());
				row.add(nv.getChucVu());

				model_NV.addRow(row);
				tbl_nhanvien.setModel(model_NV);
			}
		}
		if(check == false) {
			JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại !");
		}
	}

	private void xuLyXuatExcel() {
		XuLyFileExcel xuatExcel = new XuLyFileExcel();
		xuatExcel.xuatExcel(tbl_nhanvien);
	}
	private void xuLyNhapExcel() {
        MyDialog dlg = new MyDialog("Dữ liệu cũ sẽ bị xoá, tiếp tục?", MyDialog.WARNING_DIALOG);
        if (dlg.getAction() != MyDialog.OK_OPTION) {
            return;
        }

        XuLyFileExcel nhapExcel = new XuLyFileExcel();
        nhapExcel.nhapExcel(tbl_nhanvien);

        int row = tbl_nhanvien.getRowCount();
        for (int i = 0; i < row; i++) {
        	String ma = tbl_nhanvien.getValueAt(i, 0) + "";
            String ho = tbl_nhanvien.getValueAt(i, 1) + "";
            String ten = tbl_nhanvien.getValueAt(i, 2) + "";
            String gioiTinh = tbl_nhanvien.getValueAt(i, 3) + "";
            String chucVu = tbl_nhanvien.getValueAt(i, 4) + "";

            NVBUS.nhapExcel(ma,ho, ten, gioiTinh, chucVu);

        }
    }
	private void themTaiKhoan() {
		String maNV = txt_maNV.getText();
		String user = txt_TK.getText();
		String pass = txt_MK.getText();		
		String chucvu = "" + cbx_chucvu.getItemAt(cbx_chucvu.getSelectedIndex());
		boolean flag = TKBUS.themTaiKhoan(maNV, user, pass, chucvu);
		if(flag) {
			loadingNhanVien();			
		}
	}
	private void suaTaiKhoan() {
		String maNV = txt_maNV.getText();
		String user = txt_TK.getText();
		String pass = txt_MK.getText();
		String chucvu = "" + cbx_chucvu.getItemAt(cbx_chucvu.getSelectedIndex());
		boolean flag = TKBUS.suaTaiKhoan(maNV, user, pass, chucvu);
		if(flag) {
			loadingNhanVien();		
		}
	}
	private void moKhoaTaiKhoan() {
		String maNV = txt_maNV.getText();
		TKBUS.moKhoaTaiKhoan(maNV);
		loadingNhanVien();			
	}
	private void khoaTaiKhoan() {
		String maNV = txt_maNV.getText();
		TKBUS.khoaTaiKhoan(maNV);
		loadingNhanVien();		
	}
	
	
	//evenst phân quyền
	private void loadingcomboBoxquyen() {
		PQBUS.docDanhSachQuyen();
		ArrayList<PhanQuyen> dsq = PQBUS.getListQuyen();
		cbx_quyen.removeAllItems();
		cbx_quyen.addItem("Chọn loại quyền");
		for (PhanQuyen pq : dsq) {
			cbx_quyen.addItem(pq.getQuyen());
		}
	}

	private void loadingPhanQuyen() {
		String quyen = "" + cbx_quyen.getItemAt(cbx_quyen.getSelectedIndex());

		ArrayList<PhanQuyen> dsq = PQBUS.getListQuyen();
		PhanQuyen phanQuyen = new PhanQuyen();
		for (PhanQuyen pq : dsq) {
			if (pq.getQuyen().equals(quyen)) {
				phanQuyen.setQuyen(pq.getQuyen());
				phanQuyen.setNhapHang(pq.getNhapHang());
				phanQuyen.setQlSanPham(pq.getQlSanPham());
				phanQuyen.setQlNhanVien(pq.getQlNhanVien());
				phanQuyen.setQlKhachHang(pq.getQlKhachHang());
				phanQuyen.setThongKe(pq.getThongKe());
				break;
			}
		}
		check_QLSP.setSelected(false);
		check_QLNV.setSelected(false);
		check_QLKH.setSelected(false);
		check_QLNH.setSelected(false);
		check_QLTK.setSelected(false);
		if (phanQuyen.getNhapHang() == 1) {
			check_QLNH.setSelected(true);
		}
		if (phanQuyen.getQlSanPham() == 1) {
			check_QLSP.setSelected(true);
		}
		if (phanQuyen.getQlNhanVien() == 1) {
			check_QLNV.setSelected(true);
		}
		if (phanQuyen.getQlKhachHang() == 1) {
			check_QLKH.setSelected(true);
		}
		if (phanQuyen.getThongKe() == 1) {
			check_QLTK.setSelected(true);
		}		
	}

	private void themQuyen() {
		String tenQuyen = JOptionPane.showInputDialog("Nhập tên quyền");
		boolean flag = PQBUS.themQuyen(tenQuyen);
		if (flag) {
			loadingcomboBoxquyen();
		}
	}
	private void suaQuyen() {
		if (cbx_quyen.getSelectedIndex() < 1) {
            new MyDialog("Chưa chọn nhóm quyền để sửa!", MyDialog.ERROR_DIALOG);
            return;
        }
        String tenQuyen = cbx_quyen.getSelectedItem() + "";
        int nhapHang = check_QLNH.isSelected() ? 1 : 0;
        int sanPham = check_QLSP.isSelected() ? 1 : 0;
        int nhanVien = check_QLNV.isSelected() ? 1 : 0;
        int khachHang = check_QLKH.isSelected() ? 1 : 0;
        int thongKe = check_QLTK.isSelected() ? 1 : 0;

        boolean flag = PQBUS.suaQuyen(tenQuyen, nhapHang, sanPham, nhanVien, khachHang, thongKe);
        if (flag) {
        	loadingcomboBoxquyen();
        }
	}
	private void xoaQuyen() {
		if (cbx_quyen.getSelectedIndex() < 1) {
            new MyDialog("Chưa chọn nhóm quyền để xoá!", MyDialog.ERROR_DIALOG);
            return;
        }
        MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
        if (dlg.getAction() == MyDialog.CANCEL_OPTION) {
            return;
        }
        String tenQuyen = cbx_quyen.getSelectedItem() + "";
        boolean flag = PQBUS.xoaQuyen(tenQuyen);
        if (flag) {
        	loadingcomboBoxquyen();
        }
	}
}
