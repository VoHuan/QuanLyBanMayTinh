package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MyCustom.MyDialog;
import QuanLyMayTinh.BUS.NhaCungCapBUS;
import QuanLyMayTinh.DTO.NhaCungCap;
import QuanLyMayTinh.DTO.SanPham;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DLG_ChonNhaCungCap extends JFrame {

	private JPanel contentPane;
	private JTable table_NCC;
	private JTextField txt_timKiem;
	DefaultTableModel model_NCC = new DefaultTableModel();
	private NhaCungCapBUS NCCBUS = new NhaCungCapBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DLG_ChonNhaCungCap frame = new DLG_ChonNhaCungCap();
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
	public DLG_ChonNhaCungCap() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 824, 536);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 242, 790, 247);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 770, 227);
		panel.add(scrollPane);
		
		table_NCC = new JTable();
		table_NCC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getNCC();
			}
		});
		table_NCC.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 NCC", "T\u00EAn NCC", "\u0110\u1ECBa ch\u1EC9", "S\u0110T"
			}
		));
		scrollPane.setViewportView(table_NCC);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(227, 40, 104, 30);
		contentPane.add(lblNewLabel);
		
		txt_timKiem = new JTextField();
		txt_timKiem.setBounds(371, 44, 247, 30);
		contentPane.add(txt_timKiem);
		txt_timKiem.setColumns(10);
		txt_timKiem.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				liveSearch();			
			}@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				liveSearch();
			}@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				liveSearch();
			}
		 });
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DLG_ThemNCC them = new DLG_ThemNCC();
				them.setVisible(true);
			}
		});
		btn_them.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_them.setBounds(387, 118, 104, 36);
		contentPane.add(btn_them);
		
		JButton btn_sua = new JButton("Sửa");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_NCC.getSelectedRow();
		        if (row < 0) {
		            new MyDialog("Vui lòng chọn nhà cung cấp!", MyDialog.ERROR_DIALOG);           
		            return;
		        }
		        else {
		        	DLG_SuaNCC sua = new DLG_SuaNCC();
					sua.setVisible(true);
		        }
			}
		});
		btn_sua.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_sua.setBounds(618, 118, 104, 36);
		contentPane.add(btn_sua);
		
		JButton btn_Chon = new JButton("Chọn");
		btn_Chon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonNCC();
				dispose();
			}
		});
		btn_Chon.setBounds(153, 118, 101, 36);
		contentPane.add(btn_Chon);
		btn_Chon.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btn_refresh = new JButton("Refresh");
		btn_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadingTableNCC();
			}
		});
		btn_refresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btn_refresh.setBounds(670, 211, 112, 21);
		contentPane.add(btn_refresh);
		loadingTableNCC();
	}
	private void loadingTableNCC() {
		NCCBUS.docDanhSach();
		model_NCC.setRowCount(0);
		ArrayList<NhaCungCap> dsncc = NCCBUS.getListNhaCungCap();
		
		Vector header = new Vector();
		header.add("Mã NCC");
		header.add("Tên NCC");
		header.add("Địa chỉ");
		header.add("SĐT");
		
		if (model_NCC.getRowCount()==0){ 
        	model_NCC=new DefaultTableModel(header,0);
        } 
		for(NhaCungCap ncc : dsncc) {
			Vector row = new Vector();
			row.add(ncc.getMaNCC());
			row.add(ncc.getTenNCC());
			row.add(ncc.getDiaChi());
			row.add(ncc.getDienThoai());
			model_NCC.addRow(row);
			table_NCC.setModel(model_NCC);
		}
	}
	private void liveSearch() {
		String text = txt_timKiem.getText();
		model_NCC.setRowCount(0);
		ArrayList<NhaCungCap> dsncc = NCCBUS.getListNhaCungCap();
		Vector header = new Vector();
		header.add("Mã NCC");
		header.add("Tên NCC");
		header.add("Địa chỉ");
		header.add("SĐT");
        
        if (model_NCC.getRowCount()==0){ 
        	model_NCC=new DefaultTableModel(header,0);
        } 
        for(NhaCungCap ncc : dsncc) {
			if (String.valueOf(ncc.getMaNCC()).equalsIgnoreCase(text) || 
					ncc.getTenNCC().contains(text) ||
					ncc.getDiaChi().contains(text) ||
					ncc.getDienThoai().contains(text)){
				Vector row = new Vector();
				row.add(ncc.getMaNCC());
				row.add(ncc.getTenNCC());
				row.add(ncc.getDiaChi());
				row.add(ncc.getDienThoai());
				model_NCC.addRow(row);
				table_NCC.setModel(model_NCC);
			}
		}			
	}
	private void getNCC() {
		int row = table_NCC.getSelectedRow();
        if (row < 0) {
            new MyDialog("Vui lòng chọn nhà cung cấp!", MyDialog.ERROR_DIALOG);           
            return;
        }
        
        DLG_SuaNCC.thongtinNCC.setMaNCC(Integer.parseInt(table_NCC.getValueAt(row, 0) + ""));
        DLG_SuaNCC.thongtinNCC.setTenNCC(table_NCC.getValueAt(row, 1) + "");
        DLG_SuaNCC.thongtinNCC.setDiaChi(table_NCC.getValueAt(row, 2) + "");
        DLG_SuaNCC.thongtinNCC.setDienThoai(table_NCC.getValueAt(row, 3) + "");
	}
	private void chonNCC() {
		QL_NhapHang.txt_NCC.setText(DLG_SuaNCC.thongtinNCC.getMaNCC()+" - "+DLG_SuaNCC.thongtinNCC.getTenNCC());
	}
}
