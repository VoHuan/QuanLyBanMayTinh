package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import MyCustom.MyDialog;
import MyCustom.XuLyFileExcel;
import QuanLyMayTinh.BUS.KhachHangBUS;
import QuanLyMayTinh.DAO.MyConnect;
import QuanLyMayTinh.DTO.KhachHang;
import QuanLyMayTinh.DTO.NhanVien;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QL_KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txt_maKH;
	private JTextField txt_ho;
	private JTextField txt_ten;
	private JTable tbl_KH;
	private JTextField txt_tongchitieu;
	private JTextField txt_timkiem;
	private JTextField txt_tu;
	private JTextField txt_den;
	KhachHangBUS KHBUS = new KhachHangBUS();
	DefaultTableModel model_KH = new DefaultTableModel();
	JRadioButton rbt_Nam,rbt_Nu;
	private boolean gender = true;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new MyConnect();
//					QL_KhachHang frame = new QL_KhachHang();
//					frame.setVisible(true);
//					frame.loadingKhachHang();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public QL_KhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 822);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKhchHng = new JLabel("Kh\u00E1ch h\u00E0ng");
		lblKhchHng.setBounds(10, 10, 1092, 27);
		lblKhchHng.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblKhchHng);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 61, 1092, 246);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(163, 6, 153, 41);
		panel.add(lblNewLabel_1);
		
		txt_maKH = new JTextField();
		txt_maKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_maKH.setColumns(10);
		txt_maKH.setBounds(326, 10, 189, 34);
		panel.add(txt_maKH);
		
		JLabel lblNewLabel_1_1 = new JLabel("H\u1ECD :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(163, 57, 153, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("T\u00EAn :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(163, 101, 153, 34);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gi\u1EDBi T\u00EDnh :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(572, 6, 153, 41);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("T\u1ED5ng chi ti\u00EAu:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(572, 57, 153, 34);
		panel.add(lblNewLabel_1_4);
		
		txt_ho = new JTextField();
		txt_ho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_ho.setColumns(10);
		txt_ho.setBounds(326, 58, 189, 34);
		panel.add(txt_ho);
		
		txt_ten = new JTextField();
		txt_ten.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_ten.setColumns(10);
		txt_ten.setBounds(326, 102, 189, 34);
		panel.add(txt_ten);
		
		rbt_Nam = new JRadioButton("Nam");
		rbt_Nam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rbt_Nam.isSelected()) {
					gender = true;
					rbt_Nu.setSelected(false);
				}			
			}
		});
		rbt_Nam.setFont(new Font("Tahoma", Font.BOLD, 17));
		rbt_Nam.setBounds(720, 20, 103, 21);
		panel.add(rbt_Nam);
		
		rbt_Nu = new JRadioButton("N\u1EEF");
		rbt_Nu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rbt_Nu.isSelected()) {
					gender = false;
					rbt_Nam.setSelected(false);
				}		
			}
		});
		rbt_Nu.setFont(new Font("Tahoma", Font.BOLD, 17));
		rbt_Nu.setBounds(867, 20, 103, 21);
		panel.add(rbt_Nu);
		
		txt_tongchitieu = new JTextField();
		txt_tongchitieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_tongchitieu.setColumns(10);
		txt_tongchitieu.setBounds(735, 58, 189, 28);
		panel.add(txt_tongchitieu);
		
		JButton btn_tim = new JButton("T\u00ECm ");
		btn_tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemChiTieu();
			}
		});
		btn_tim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_tim.setBounds(720, 200, 108, 35);
		panel.add(btn_tim);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("T\u00ECm ki\u1EBFm:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1.setBounds(288, 155, 125, 34);
		panel.add(lblNewLabel_1_3_1);
		
		txt_timkiem = new JTextField();
		txt_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_timkiem.setColumns(10);
		txt_timkiem.setBounds(410, 159, 241, 28);
		panel.add(txt_timkiem);
		txt_timkiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                liveSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	 liveSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	 liveSearch();
            }
        });
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Chi ti\u00EAu t\u1EEB:");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1_1.setBounds(163, 195, 125, 41);
		panel.add(lblNewLabel_1_3_1_1);
		
		txt_tu = new JTextField();
		txt_tu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_tu.setColumns(10);
		txt_tu.setBounds(279, 199, 153, 34);
		panel.add(txt_tu);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("\u0110\u1EBFn :");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3_1_1_1.setBounds(442, 195, 75, 41);
		panel.add(lblNewLabel_1_3_1_1_1);
		
		txt_den = new JTextField();
		txt_den.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_den.setColumns(10);
		txt_den.setBounds(503, 199, 153, 34);
		panel.add(txt_den);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 406, 1092, 305);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 1072, 270);
		panel_1.add(scrollPane);
		
		tbl_KH = new JTable();
		tbl_KH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTableKhachHang();
			}
		});
		tbl_KH.setModel(new DefaultTableModel(
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
				"M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD", "T\u00EAn", "Gi\u1EDBi T\u00EDnh", "T\u1ED5ng Chi Ti\u00EAu"
			}
		));
		scrollPane.setViewportView(tbl_KH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(20, 317, 1082, 79);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btn_them = new JButton("Th\u00EAm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themKH();			}
		});
		btn_them.setBounds(110, 22, 97, 28);
		panel_2.add(btn_them);
		
		JButton btn_sua = new JButton("S\u1EEDa");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaKH();
			}
		});
		btn_sua.setBounds(277, 22, 103, 28);
		panel_2.add(btn_sua);
		
		JButton btn_xoa = new JButton("X\u00F3a");
		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaKH();
			}
		});
		btn_xoa.setBounds(436, 22, 97, 28);
		panel_2.add(btn_xoa);
		
		JButton btn_nhapExcell = new JButton("Nh\u1EADp Excell");
		btn_nhapExcell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLyNhapExcel();
			}
		});
		btn_nhapExcell.setBounds(585, 22, 109, 28);
		panel_2.add(btn_nhapExcell);
		
		JButton btn_xuatExcell = new JButton("Xu\u1EA5t Excell");
		btn_xuatExcell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLyXuatExcel();
			}
		});
		btn_xuatExcell.setBounds(747, 22, 97, 28);
		panel_2.add(btn_xuatExcell);
		
		JButton btn_menu = new JButton("Trang Chính");
		btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormGUI MF = new MainFormGUI();
				MF.setVisible(true);
				dispose();
			}
		});
		btn_menu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_menu.setBounds(486, 721, 216, 33);
		btn_menu.setIcon(new ImageIcon("Icon/home.png"));
		contentPane.add(btn_menu);
		loadingKhachHang();
		//căn giữa table
		for (int x = 0; x < tbl_KH.getColumnCount(); x++) {
			tbl_KH.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
		}
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
			tbl_KH.setModel(model_KH);
		}
	}
	private void clickTableKhachHang() {
		int row = tbl_KH.getSelectedRow();
		if (row > -1) {
			String ma = tbl_KH.getValueAt(row, 0) + "";
			String ho = tbl_KH.getValueAt(row, 1) + "";
			String ten = tbl_KH.getValueAt(row, 2) + "";
			String gioitinh = tbl_KH.getValueAt(row, 3) + "";
			String tongchitieu = tbl_KH.getValueAt(row, 4) + "";
			// lấy dữ liệu lên textfiled
			txt_maKH.setText(ma);
			txt_ho.setText(ho);
			txt_ten.setText(ten);
			if (gioitinh.equalsIgnoreCase("Nam")) {
				rbt_Nam.setSelected(true);
				rbt_Nu.setSelected(false);
			} else {
				rbt_Nu.setSelected(true);
				rbt_Nam.setSelected(false);
			}
			txt_tongchitieu.setText(tongchitieu);
		}
	}
	private void themKH() {
		String gioitinh;
		if (gender == true) {
			gioitinh = "Nam";
		} else {
			gioitinh = "Nữ";
		}
		boolean flag = KHBUS.themKhachHang(txt_maKH.getText(), txt_ho.getText(), txt_ten.getText(), gioitinh);
		if (flag) {
			KHBUS.docDanhSach();
			loadingKhachHang();
		}
	}
	private void suaKH() {
		String gioitinh;
		if (gender == true) {
			gioitinh = "Nam";
		} else {
			gioitinh = "Nữ";
		}
		int tongchitieu = Integer.parseInt(txt_tongchitieu.getText());
		boolean flag = KHBUS.suaKhachHang(txt_maKH.getText(), txt_ho.getText(), txt_ten.getText(), gioitinh,tongchitieu);
		if (flag) {
			KHBUS.docDanhSach();
			loadingKhachHang();
		}
	}
	private void xoaKH() {
		boolean flag = KHBUS.xoaKhachHang(txt_maKH.getText());
		if (flag) {
			loadingKhachHang();
		}
	}
	private void timKiemChiTieu() {
		model_KH.setRowCount(0);
		ArrayList<KhachHang> dskh = KHBUS.timKiemKhachHang(txt_tu.getText(), txt_den.getText());
        if (dskh == null)
            return;
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
			tbl_KH.setModel(model_KH);
		}			
	}
	private void  liveSearch() {
		model_KH.setRowCount(0);
		ArrayList<KhachHang> dskh = KHBUS.timKiemKhachHang(txt_timkiem.getText());
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
			tbl_KH.setModel(model_KH);
		}			
	}
	private void xuLyXuatExcel() {
		XuLyFileExcel xuatExcel = new XuLyFileExcel();
		xuatExcel.xuatExcel(tbl_KH);
	}
	private void xuLyNhapExcel() {
        MyDialog dlg = new MyDialog("Dữ liệu cũ sẽ bị xoá, tiếp tục?", MyDialog.WARNING_DIALOG);
        if (dlg.getAction() != MyDialog.OK_OPTION) {
            return;
        }

        XuLyFileExcel nhapExcel = new XuLyFileExcel();
        nhapExcel.nhapExcel(tbl_KH);

        int row = tbl_KH.getRowCount();
        for (int i = 0; i < row; i++) {
        	String ma = tbl_KH.getValueAt(i, 0) + "";
            String ho = tbl_KH.getValueAt(i, 1) + "";
            String ten = tbl_KH.getValueAt(i, 2) + "";
            String gioiTinh = tbl_KH.getValueAt(i, 3) + "";
            String tongchitieu = tbl_KH.getValueAt(i, 4) + "";

            KHBUS.nhapExcel(ma,ho, ten, gioiTinh, tongchitieu);

        }
    }
}

