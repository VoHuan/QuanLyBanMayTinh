package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import MyCustom.MyDialog;
import QuanLyMayTinh.BUS.CTKhuyenMaiBUS;
import QuanLyMayTinh.BUS.KhuyenMaiBUS;
import QuanLyMayTinh.DAO.MyConnect;
import QuanLyMayTinh.DTO.CTKhuyenMai;
import QuanLyMayTinh.DTO.KhuyenMai;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DLG_ChonKhuyenMai extends JFrame {

	private JPanel contentPane;
	private JTextField txt_timKiem;
	private JTable tbl_dsKM;
	private KhuyenMaiBUS KMBUS = new KhuyenMaiBUS();
	private CTKhuyenMaiBUS CTKMBUS = new CTKhuyenMaiBUS();
    DefaultTableModel model_KM = new DefaultTableModel();
    public KhuyenMai KMTimThay = null;
    
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    Date now = new Date();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MyConnect();
					DLG_ChonKhuyenMai frame = new DLG_ChonKhuyenMai();
					frame.setVisible(true);
					frame.loadingKhuyenMai();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DLG_ChonKhuyenMai() {
		new MyConnect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 947, 486);
		this.setLocationRelativeTo(null); //hi???n th??? gi???a m?? h??nh
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 913, 96);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T??m ki???m :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(215, 28, 108, 29);
		panel_1.add(lblNewLabel);
		
		txt_timKiem = new JTextField();
		txt_timKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_timKiem.setBounds(332, 25, 291, 41);
		panel_1.add(txt_timKiem);
		txt_timKiem.setColumns(10);
		
		JButton btn_timKiem = new JButton("T??m");
		btn_timKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		});
		btn_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_timKiem.setBounds(660, 28, 85, 28);
		panel_1.add(btn_timKiem);
		
		JButton btn_showall = new JButton("T???t c???");
		btn_showall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadingKhuyenMai();
			}
		});
		btn_showall.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_showall.setBounds(754, 28, 85, 28);
		panel_1.add(btn_showall);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch khuy\u1EBFn m\u00E3i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 116, 923, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 903, 226);
		panel.add(scrollPane);
		
		tbl_dsKM = new JTable();
		tbl_dsKM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTableKhuyenMai();
			}
		});
		tbl_dsKM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbl_dsKM.setModel(new DefaultTableModel(
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
				"M\u00E3 KM", "Ch\u01B0\u01A1ng Tr\u00ECnh", "Ng\u00E0y B\u0110", " Ng\u00E0y KT", "T\u00ECnh tr\u1EA1ng"
			}
		));
		tbl_dsKM.getColumnModel().getColumn(0).setPreferredWidth(58);
		tbl_dsKM.getColumnModel().getColumn(1).setResizable(false);
		tbl_dsKM.getColumnModel().getColumn(1).setPreferredWidth(127);
		scrollPane.setViewportView(tbl_dsKM);
		
		JButton btn_chon = new JButton("Ch???n");
		btn_chon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonKhuyenMai();
				dispose();		
			}
		});
		btn_chon.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_chon.setBounds(425, 393, 106, 34);
		contentPane.add(btn_chon);
		this.loadingKhuyenMai();
	

	}
	private void loadingKhuyenMai() {
		model_KM.setRowCount(0);
        ArrayList<KhuyenMai> dskm = KMBUS.getDanhSachKhuyenMai();
        Vector header = new Vector();
        header.add("M?? KM");
        header.add("Ch????ng tr??nh");
        header.add("Ng??y B??");
        header.add("Ng??y KT");
        header.add("T??nh tr???ng");        
        if (model_KM.getRowCount()==0){ 
        	model_KM=new DefaultTableModel(header,0);
        }        
        for(KhuyenMai km : dskm) {
        	Vector vec = new Vector();
        	vec.add(km.getMaKM());
        	vec.add(km.getTenKM());
        	vec.add(km.getNgayBD());
        	vec.add(km.getNgayKT());
            if (km.getNgayBD().before(now) && km.getNgayKT().after(now)) {
                vec.add("C?? hi???u l???c");
            } else {
                vec.add("Kh??ng hi???u l???c");
            }
        	model_KM.addRow(vec);       	
        	tbl_dsKM.setModel(model_KM);       	
        }
        
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int x=0;x<tbl_dsKM.getColumnCount();x++){
	         tbl_dsKM.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
	    }
	}
	private void clickTableKhuyenMai() {
		int row = tbl_dsKM.getSelectedRow();
		if (row > -1) {
			String maKM = tbl_dsKM.getValueAt(row, 0) + "";
			String tenKM = tbl_dsKM.getValueAt(row, 1) + "";
			String start = tbl_dsKM.getValueAt(row, 2) + "";
			String end = tbl_dsKM.getValueAt(row, 3) + "";
			String trangthai = tbl_dsKM.getValueAt(row, 4) + "";
			if(trangthai.equalsIgnoreCase("Kh??ng hi???u l???c")) {
				JOptionPane.showInternalMessageDialog(null, "M?? n??y hi???n kh??ng c?? hi???u l???c, H??y ch???n m?? kh??c !");
				return;
			}
			
			java.util.Date ngayBD = new Date();
            java.util.Date ngayKT = new Date();
            try {
                ngayBD = new SimpleDateFormat("dd/MM/yyyy").parse(start);
                ngayKT = new SimpleDateFormat("dd/MM/yyyy").parse(end);
            } catch (Exception e) {
            }
            KMTimThay = new KhuyenMai();
			KMTimThay.setMaKM(Integer.parseInt(maKM));
			KMTimThay.setTenKM(tenKM);
			KMTimThay.setNgayBD(ngayBD);
			KMTimThay.setNgayKT(ngayKT);
		}
	}
	private void chonKhuyenMai() {
		if(KMTimThay==null) {
			JOptionPane.showInternalMessageDialog(null, "Ch??a ch???n khuy???n m??i !");
			return;
		}
		QL_BanHang.getKhuyenMai(String.valueOf(KMTimThay.getMaKM()),KMTimThay.getTenKM());
	}
	private void timKiem() {
		model_KM.setRowCount(0);
		String search = txt_timKiem.getText().toLowerCase();
		if(search.equals("")) {
			new MyDialog("Vui l??ng nh???p th??ng tin c???n t??m !", MyDialog.ERROR_DIALOG);
		}
		 ArrayList<KhuyenMai> dskm = KMBUS.getDanhSachKhuyenMai();		
		 if(search.equalsIgnoreCase("C?? hi???u l???c")) {
			 for(KhuyenMai km : dskm) {
				 if(km.getNgayBD().before(now) && km.getNgayKT().after(now)) {
					 Vector vec = new Vector();
			        	vec.add(km.getMaKM());
			        	vec.add(km.getTenKM());
			        	vec.add(km.getNgayBD());
			        	vec.add(km.getNgayKT());
			        	Date now = new Date();
			            if (km.getNgayBD().before(now) && km.getNgayKT().after(now)) {
			                vec.add("C?? hi???u l???c");
			            } else {
			                vec.add("Kh??ng hi???u l???c");
			            }
			        	model_KM.addRow(vec);       	
			        	tbl_dsKM.setModel(model_KM);      
				 }				 	 
			 }
			 return;
		 }
		for(KhuyenMai km : dskm) {
			if(km.getTenKM().toLowerCase().contains(search) ) {
	        	Vector vec = new Vector();
	        	vec.add(km.getMaKM());
	        	vec.add(km.getTenKM());
	        	vec.add(km.getNgayBD());
	        	vec.add(km.getNgayKT());
	        	Date now = new Date();
	            if (km.getNgayBD().before(now) && km.getNgayKT().after(now)) {
	                vec.add("C?? hi???u l???c");
	            } else {
	                vec.add("Kh??ng hi???u l???c");
	            }
	        	model_KM.addRow(vec);       	
	        	tbl_dsKM.setModel(model_KM);      
			}
		}
	}
}
