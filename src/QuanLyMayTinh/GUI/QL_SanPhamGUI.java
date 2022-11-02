package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import MyCustom.MyDialog;
import MyCustom.MyFileChooser;
import QuanLyMayTinh.BUS.LoaiSanPhamBUS;
import QuanLyMayTinh.BUS.SanPhamBUS;
import QuanLyMayTinh.DAO.MyConnect;
import QuanLyMayTinh.DTO.LoaiSanPham;
import QuanLyMayTinh.DTO.SanPham;

import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.EtchedBorder;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class QL_SanPhamGUI extends JFrame {

	JPanel contentPane;
	JTextField txt_MaLoai,txt_TenLoai,txt_MaSP,txt_TenSP,txt_DonGia,txt_maNCC;
	JTable table_LoaiSP,table_SP;
	JTextArea txt_Mota;
	final JFileChooser fileDialog = new JFileChooser();
	DefaultTableModel model_SP = new DefaultTableModel();
	DefaultTableModel model_LSP = new DefaultTableModel();
	SanPhamBUS spBUS = new SanPhamBUS();
	LoaiSanPhamBUS lspBUS = new LoaiSanPhamBUS();
	JComboBox cbx_LocSP,cbx_loai;
	File fileAnhSP;
	JLabel lbl_HinhAnh;
	JButton btn_ThemLoai,btn_SuaLoai, btn_XoaLoai, btn_ThemSP,btn_XoaSP,btn_SuaSP,btn_themHinhAnh;
	JSpinner spi_SoLuong;
	private JButton btn_menu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					new MyConnect();					
//					QL_SanPhamGUI frame = new QL_SanPhamGUI();
//					frame.showWindows();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QL_SanPhamGUI() {
		addControls();
		addEvents();
	}
    private void addControls() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1108, 771);
    	this.setLocationRelativeTo(null); //hiển thị giữa mà hình
    	DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_SanPham = new JLabel("S\u1EA2N PH\u1EA8M");
		lbl_SanPham.setForeground(Color.CYAN);
		lbl_SanPham.setFont(new Font("Tahoma", Font.BOLD, 23));
		lbl_SanPham.setBounds(10, 10, 134, 42);
		contentPane.add(lbl_SanPham);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(SystemColor.control);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin lo\u1EA1i s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 62, 597, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_MaLoai = new JLabel("Mã loại sản phẩm :");
		lbl_MaLoai.setForeground(Color.BLACK);
		lbl_MaLoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_MaLoai.setBounds(25, 29, 168, 22);
		panel.add(lbl_MaLoai);
		
		JLabel lbl_TenLoai = new JLabel("Tên loại sản phẩm :");
		lbl_TenLoai.setForeground(Color.BLACK);
		lbl_TenLoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_TenLoai.setBounds(25, 66, 168, 22);
		panel.add(lbl_TenLoai);
		
		txt_MaLoai = new JTextField();
		txt_MaLoai.setBounds(202, 22, 234, 31);
		panel.add(txt_MaLoai);
		txt_MaLoai.setColumns(10);
		
		txt_TenLoai = new JTextField();
		txt_TenLoai.setColumns(10);
		txt_TenLoai.setBounds(202, 63, 234, 30);
		panel.add(txt_TenLoai);
		
		btn_ThemLoai = new JButton("Th\u00EAm");
		btn_ThemLoai.setBounds(125, 152, 85, 21);
		panel.add(btn_ThemLoai);
		
		btn_SuaLoai = new JButton("S\u1EEFa");
		btn_SuaLoai.setBounds(250, 152, 85, 21);
		panel.add(btn_SuaLoai);
		
		btn_XoaLoai = new JButton("X\u00F3a");
		btn_XoaLoai.setBounds(378, 152, 85, 21);
		panel.add(btn_XoaLoai);
		
		JLabel lbl_MaNCC = new JLabel("Mã nhà cung cấp :");
		lbl_MaNCC.setForeground(Color.BLACK);
		lbl_MaNCC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_MaNCC.setBounds(25, 103, 168, 22);
		panel.add(lbl_MaNCC);
		
		txt_maNCC = new JTextField();
		txt_maNCC.setColumns(10);
		txt_maNCC.setBounds(202, 103, 234, 39);
		panel.add(txt_maNCC);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(SystemColor.control);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch lo\u1EA1i s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(617, 62, 463, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 443, 153);
		panel_1.add(scrollPane);
		
		table_LoaiSP = new JTable();
		table_LoaiSP.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 Lo\u1EA1i", "T\u00EAn Lo\u1EA1i", "M\u00E3 NCC"
			}
		));
		scrollPane.setViewportView(table_LoaiSP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.background"));
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_2.setBounds(10, 266, 500, 375);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbl_MaSP = new JLabel("Mã sản phẩm :");
		lbl_MaSP.setForeground(Color.BLACK);
		lbl_MaSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MaSP.setBounds(212, 8, 106, 25);
		panel_2.add(lbl_MaSP);
		
		lbl_HinhAnh = new JLabel();
		lbl_HinhAnh.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_HinhAnh.setBounds(10, 40, 192, 181);
		lbl_HinhAnh.setIcon(new ImageIcon("Image/maytinh.jpg"));
		panel_2.add(lbl_HinhAnh);
		
		txt_MaSP = new JTextField();
		txt_MaSP.setBounds(328, 10, 106, 25);
		panel_2.add(txt_MaSP);
		txt_MaSP.setColumns(10);
		
		JLabel lbl_TênSP = new JLabel("Tên sản phẩm :");
		lbl_TênSP.setForeground(Color.BLACK);
		lbl_TênSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TênSP.setBounds(212, 43, 118, 25);
		panel_2.add(lbl_TênSP);
		
		txt_TenSP = new JTextField();
		txt_TenSP.setColumns(10);
		txt_TenSP.setBounds(328, 45, 162, 39);
		panel_2.add(txt_TenSP);
		
		JLabel lbl_LoaiSP = new JLabel("Loại sản phẩm :");
		lbl_LoaiSP.setForeground(Color.BLACK);
		lbl_LoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_LoaiSP.setBounds(212, 94, 118, 25);
		panel_2.add(lbl_LoaiSP);
		
		JLabel lbl_ThemHinhAnh = new JLabel("Hình ảnh :");
		lbl_ThemHinhAnh.setForeground(Color.BLACK);
		lbl_ThemHinhAnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ThemHinhAnh.setBounds(212, 132, 84, 25);
		panel_2.add(lbl_ThemHinhAnh);
		
		JLabel lbl_SoLuong = new JLabel("Số lượng :");
		lbl_SoLuong.setForeground(Color.BLACK);
		lbl_SoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SoLuong.setBounds(212, 167, 84, 25);
		panel_2.add(lbl_SoLuong);
		
		JLabel lbl_DonGia = new JLabel("Đơn giá :");
		lbl_DonGia.setForeground(Color.BLACK);
		lbl_DonGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_DonGia.setBounds(212, 207, 76, 25);
		panel_2.add(lbl_DonGia);
		
		JLabel lbl_MoTa = new JLabel("Mô tả :");
		lbl_MoTa.setForeground(Color.BLACK);
		lbl_MoTa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_MoTa.setBounds(212, 242, 62, 25);
		panel_2.add(lbl_MoTa);
		
		spi_SoLuong = new JSpinner();
		spi_SoLuong.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spi_SoLuong.setBounds(328, 167, 62, 25);
		panel_2.add(spi_SoLuong);
		
		txt_DonGia = new JTextField();
		txt_DonGia.setColumns(10);
		txt_DonGia.setBounds(328, 207, 125, 39);
		panel_2.add(txt_DonGia);
		
		JLabel lblNewLabel_2 = new JLabel("VNĐ");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(458, 214, 32, 13);
		panel_2.add(lblNewLabel_2);
		
		txt_Mota = new JTextArea();
		txt_Mota.setBounds(328, 254, 162, 90);
		panel_2.add(txt_Mota);
		
		btn_themHinhAnh = new JButton("Chọn file ảnh");
		btn_themHinhAnh.setHorizontalAlignment(SwingConstants.LEFT);
		btn_themHinhAnh.setBounds(328, 136, 118, 21);
		panel_2.add(btn_themHinhAnh);
		
		btn_ThemSP = new JButton("Thêm");		
		btn_ThemSP.setBounds(10, 304, 85, 21);
		panel_2.add(btn_ThemSP);
		
		btn_SuaSP = new JButton("Sữa");
		btn_SuaSP.setBounds(115, 304, 85, 21);
		panel_2.add(btn_SuaSP);
		
		btn_XoaSP = new JButton("Xóa");
		btn_XoaSP.setBounds(212, 304, 85, 21);
		panel_2.add(btn_XoaSP);
		
		cbx_loai = new JComboBox();
		cbx_loai.setMaximumRowCount(15);
		cbx_loai.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cbx_loai.setBackground(Color.WHITE);
		cbx_loai.setBounds(328, 93, 120, 22);
		panel_2.add(cbx_loai);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.control);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_3.setBounds(520, 311, 560, 330);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 21, 540, 299);
		panel_3.add(scrollPane_1);
		
		
		table_SP = new JTable();
		table_SP.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn SP", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "Lo\u1EA1i", "H\u00ECnh \u1EA3nh", "M\u00F4 t\u1EA3"
			}
		));
		scrollPane_1.setViewportView(table_SP);
		
		JLabel lblNewLabel_1 = new JLabel("L\u1ECDc s\u1EA3n ph\u1EA9m theo lo\u1EA1i");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.focus"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(520, 266, 248, 35);
		contentPane.add(lblNewLabel_1);
		
		cbx_LocSP = new JComboBox();
		cbx_LocSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comboBox = "" + cbx_LocSP.getItemAt(cbx_LocSP.getSelectedIndex());
				if(comboBox.equalsIgnoreCase("All")) {
					    loadingSanPham();
					    return;
				}
				locSPTheoLoai();
			}
		});
		cbx_LocSP.setMaximumRowCount(15);
		cbx_LocSP.setBackground(new Color(255, 255, 255));
		cbx_LocSP.setFont(new Font("Tahoma", Font.PLAIN, 19));
		//cbx_LocSP.setModel(DefaultComboBoxModel cbxModel = new DefaultComboBoxModel());
		cbx_LocSP.setBounds(778, 273, 120, 22);
		contentPane.add(cbx_LocSP);
		
		btn_menu = new JButton("Trang Chính");
		btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFormGUI MF = new MainFormGUI();
				MF.setVisible(true);
				dispose();
			}
		});
		btn_menu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_menu.setBounds(450, 672, 216, 33);
		btn_menu.setIcon(new ImageIcon("Icon/home.png"));
		contentPane.add(btn_menu);
		
		loadingSanPham();
		loadingLoaiSP();
		loadingComBox();
		//Căn giữa table
		for(int x=0;x<table_SP.getColumnCount();x++){
	         table_SP.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
	        }
		for(int x=0;x<table_LoaiSP.getColumnCount();x++){
	         table_LoaiSP.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
	        }
	}
    
    private void addEvents() {
    	btn_ThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSP();       		        
			}
		});
    	
    	btn_SuaSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaSP();
			}
		});
    	
    	btn_XoaSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSP();
			}
		});
    	
    	
    	btn_ThemLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themLoai();	
			}
		});	
		btn_SuaLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaLoai();
			}
		});	
		btn_XoaLoai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 xoaLoai();
			}
		});
		btn_themHinhAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themHinhAnh();
			}
		});
		table_LoaiSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTableLoai();
			}
		});
		table_SP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickTableSanPham();
			}
		});
    }	
    private void loadingLoaiSP() {
		lspBUS.docDanhSachLoai();
		model_LSP.setRowCount(0);
		ArrayList<LoaiSanPham> dslsp = lspBUS.getDanhSachLoai();
		Vector header = new Vector();
        header.add("Mã Loại ");
        header.add("Ten Loại ");
        header.add("Mã NCC");        
        
        if (model_LSP.getRowCount()==0){ 
        	model_LSP=new DefaultTableModel(header,0);
        } 
		for( LoaiSanPham lsp : dslsp) {
		        Vector row = new Vector();
		        row.add(lsp.getMaLoai());
		        row.add(lsp.getTenLoai());		      
		        row.add(lsp.getMaNCC());		        
		        model_LSP.addRow(row); 
		        table_LoaiSP.setModel(model_LSP);
		}
	}
    private void loadingSanPham() {
    	spBUS.docListSanPham();
		model_SP.setRowCount(0);
		ArrayList<SanPham> dssp = spBUS.getListSanPham();
		Vector header = new Vector();
        header.add("Mã SP");
        header.add("Ten SP");
        header.add("Số Lượng");
        header.add("Đơn Gía");
        header.add("Loại");
        header.add("Hình ảnh");
        header.add("Mô Tả");
        
        if (model_SP.getRowCount()==0){ 
        	model_SP=new DefaultTableModel(header,0);
        } 
		for( SanPham sp : dssp) {
		        Vector row = new Vector();
		        row.add(sp.getMaSP());
		        row.add(sp.getTenSP());		      
		        row.add(sp.getSoLuong());		       
		        row.add(sp.getDonGia());		      
		        String tenLoai = lspBUS.getTenLoai(sp.getMaLoai());
		        row.add(tenLoai);
		        row.add(sp.getHinhAnh());
		        row.add(sp.getMoTa());
		        model_SP.addRow(row); 
		        table_SP.setModel(model_SP);
		}
		
    }
	private void loadingComBox() {
		cbx_LocSP.removeAllItems();
		cbx_loai.removeAllItems();
        ArrayList<LoaiSanPham> dsl = lspBUS.getDanhSachLoai();
        cbx_LocSP.addItem("All");
        for (LoaiSanPham loai : dsl) {
        	cbx_LocSP.addItem(loai.getTenLoai());
        }
        cbx_loai.addItem("Chọn loại");
        for (LoaiSanPham loai : dsl) {       	
        	cbx_loai.addItem(loai.getMaLoai()+" - "+loai.getTenLoai());
        }
    }
	
	
	
	
	
	private void loadAnh(String anh) {
        lbl_HinhAnh.setIcon(getAnhSP(anh));
    }
	
	private void themHinhAnh() {
		JFileChooser fileChooser = new MyFileChooser("Image/");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Tệp hình ảnh", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileAnhSP = fileChooser.getSelectedFile();
            lbl_HinhAnh.setIcon(getAnhSP(fileAnhSP.getPath()));
        }
	}
	
	
	
	private void luuFileAnh() {
        BufferedImage bImage = null;
        try {
            File initialImage = new File(fileAnhSP.getPath());
            bImage = ImageIO.read(initialImage);

            ImageIO.write(bImage, "png", new File("Image/" + fileAnhSP.getName()));

        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
    }


    private ImageIcon getAnhSP(String src) {
        src = src.trim().equals("") ? "default.png" : src;
        //Xử lý ảnh
        BufferedImage img = null;
        File fileImg = new File(src);

        if (!fileImg.exists()) {
            src = "default.png";
            fileImg = new File("Image/" + src);
        }

        try {
            img = ImageIO.read(fileImg);
            fileAnhSP = new File(src);
        } catch (IOException e) {
            fileAnhSP = new File("imgs/anhthe/avatar.jpg");
        }

        if (img != null) {
            Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);
        }

        return null;
    }
    
    private void themLoai() {
    	String ml = txt_MaLoai.getText();
		String tl = txt_TenLoai.getText();
		String ncc = txt_maNCC.getText();
		if (lspBUS.themLoai(ml, tl, ncc)) {
			loadingLoaiSP();
        }							
		loadingComBox();			
    }
    private void suaLoai() {
    	String maloai = txt_MaLoai.getText();
        String ten = txt_TenLoai.getText();
        String  mancc= txt_maNCC.getText();
        if (lspBUS.suaLoai(maloai, ten,mancc)) {
        	loadingLoaiSP();
        }
        loadingComBox();
    }
    private void xoaLoai() {
    	MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
        if (dlg.OK_OPTION == dlg.getAction()) {
            String ma = txt_MaLoai.getText();
            if (lspBUS.xoaLoai(ma)) {
                loadingLoaiSP();
                txt_MaLoai.setText("");
                txt_TenLoai.setText("");
                txt_maNCC.setText("");
            }
        }
        loadingComBox();
        loadingSanPham();
    }
    private void themSP() {
    	String anh = fileAnhSP.getName();			
        String comboBox = "" + cbx_loai.getItemAt(cbx_loai.getSelectedIndex());               		        
       boolean flag= spBUS.themSanPham(
        		txt_MaSP.getText(),
        		txt_TenSP.getText(),		        		
                comboBox,		                
                String.valueOf(spi_SoLuong.getValue()),		                
                txt_DonGia.getText(),
                anh,
                txt_Mota.getText());
        if(flag) {       	
        spBUS.docListSanPham();
        loadingSanPham();
        luuFileAnh();
        }		        		        
    }
    private void suaSP() {
    	String anh = fileAnhSP.getName();
		String comboBox = "" + cbx_loai.getItemAt(cbx_loai.getSelectedIndex());
        boolean flag = spBUS.suaSanPham(
        		txt_MaSP.getText(),
        		txt_TenSP.getText(),		        		
                comboBox,		                
                String.valueOf(spi_SoLuong.getValue()),		                
                txt_DonGia.getText(),
                anh,
                txt_Mota.getText());
        spBUS.docListSanPham();
        loadingSanPham();
        luuFileAnh();
    }
    private void xoaSP() {
    	MyDialog dlg = new MyDialog("Bạn có chắc chắn muốn xoá?", MyDialog.WARNING_DIALOG);
        if (dlg.OK_OPTION == dlg.getAction()) {
            boolean flag = spBUS.xoaSanPham(txt_MaSP.getText());
            if (flag) {
                loadingSanPham();
            }
        }
    }
    private void clickTableLoai() {
    	int row = table_LoaiSP.getSelectedRow();
		if (row > -1) {
            String maLoai = table_LoaiSP.getValueAt(row, 0) + "";
            String tenLoai = table_LoaiSP.getValueAt(row, 1) + "";
            String maNCC = table_LoaiSP.getValueAt(row, 2) + "";
            txt_MaLoai.setText(maLoai);
            txt_TenLoai.setText(tenLoai);
            txt_maNCC.setText(maNCC);
        }
    }
    private void clickTableSanPham() {
    	int row = table_SP.getSelectedRow();
        if (row > -1) {
            String ma = table_SP.getValueAt(row, 0) + "";
            String ten = table_SP.getValueAt(row, 1) + "";
            String soLuong = table_SP.getValueAt(row, 2) + "";
            String donGia = table_SP.getValueAt(row, 3) + "";		            	
            String loai = table_SP.getValueAt(row, 4) + "";
            String anh = table_SP.getValueAt(row, 5) + "";
            String mota = table_SP.getValueAt(row, 6) + "";
            //lấy dữ liệu lên textfiled
            txt_MaSP.setText(ma);
            txt_TenSP.setText(ten);
            txt_DonGia.setText(donGia);		           
            txt_Mota.setText(mota);
            spi_SoLuong.setValue(Integer.parseInt(soLuong));
            
            String[] index = loai.split(" ");		            
            cbx_loai.setSelectedIndex(Integer.parseInt(index[0]));		           
            loadAnh("Image/" + anh);
        }
    }
    private void locSPTheoLoai() {
    	String cbx_values = "" + cbx_LocSP.getItemAt(cbx_LocSP.getSelectedIndex());
    	spBUS.docListSanPham();
		model_SP.setRowCount(0);
		ArrayList<SanPham> dssp = spBUS.getListSanPham();

		for( SanPham sp : dssp) {
			String[] ten = lspBUS.getTenLoai(sp.getMaLoai()).split(" - ");
			if(ten[1].equalsIgnoreCase(cbx_values)) {
		        Vector row = new Vector();
		        row.add(sp.getMaSP());
		        row.add(sp.getTenSP());		      
		        row.add(sp.getSoLuong());		       
		        row.add(sp.getDonGia());		      
		        String tenLoai = lspBUS.getTenLoai(sp.getMaLoai());
		        row.add(tenLoai);
		        row.add(sp.getHinhAnh());
		        row.add(sp.getMoTa());
		        model_SP.addRow(row); 
		        table_SP.setModel(model_SP);
			}
		}
    }
   private void showWindows() {	
	   	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1104, 688);
		this.setLocationRelativeTo(null); // hiển thị giữa mà hình
		this.setVisible(true); // hiển thị lên màn hình desktop
   }
}
