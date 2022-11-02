package QuanLyMayTinh.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

import QuanLyMayTinh.BUS.ThongKeBUS;
import QuanLyMayTinh.DAO.MyConnect;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThongKeGUI extends JFrame {

	private JPanel contentPane;
	JRadioButton rdbtn_quy;
	JRadioButton rdbtn_thang;
	JButton btn_bieudo;
	private ThongKeQuy pn_hienthi;
	private ThongKeThang pn_hienthi1;
	private ButtonGroup G;
	boolean check=false;
	private JComboBox cbx_nam;
	ThongKeBUS TKBUS = new ThongKeBUS();
	private JLabel lbl_tongThu;
	private JLabel lbl_tongChi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeGUI frame = new ThongKeGUI();
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
	public ThongKeGUI() {
		new MyConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 810);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống Kê");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(307, 10, 456, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng Thu");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(132, 98, 229, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng Chi");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(704, 98, 229, 34);
		contentPane.add(lblNewLabel_1_1);
		
		lbl_tongThu = new JLabel("");
		lbl_tongThu.setForeground(Color.RED);
		lbl_tongThu.setFont(new Font("Tahoma", Font.BOLD, 35));
		lbl_tongThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tongThu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_tongThu.setBackground(Color.WHITE);
		lbl_tongThu.setBounds(73, 142, 339, 114);
		contentPane.add(lbl_tongThu);
		
		lbl_tongChi = new JLabel("");
		lbl_tongChi.setForeground(Color.RED);
		lbl_tongChi.setFont(new Font("Tahoma", Font.BOLD, 35));
		lbl_tongChi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lbl_tongChi.setBounds(670, 142, 339, 114);
		contentPane.add(lbl_tongChi);
		

		pn_hienthi = new ThongKeQuy();
		pn_hienthi.setBounds(10, 336, 1166, 437);
		pn_hienthi.setVisible(false);
		
		pn_hienthi1 = new ThongKeThang();
		pn_hienthi1.setBounds(10, 336, 1166, 437);
		
		contentPane.add(pn_hienthi);
		contentPane.add(pn_hienthi1);
		cbx_nam = new JComboBox();
		
		cbx_nam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiTongDoanhThuNam();
				hienThiTongChiNam();
							
				pn_hienthi.loadQuyThu("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
				pn_hienthi.loadQuyChi("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
				pn_hienthi1.loadThangThu("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
				pn_hienthi1.loadThangChi("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
				
			}
		});
		cbx_nam.setFont(new Font("Tahoma", Font.BOLD, 16));
		cbx_nam.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022"}));
		cbx_nam.setSelectedIndex(4);
		cbx_nam.setBounds(490, 109, 104, 21);
		contentPane.add(cbx_nam);
		
		pn_hienthi.loadQuyThu("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
		pn_hienthi.loadQuyChi("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
		pn_hienthi1.loadThangThu("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
		pn_hienthi1.loadThangChi("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
		
		rdbtn_quy = new JRadioButton("Theo quý");
		rdbtn_quy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtn_quy.isSelected()) {
					pn_hienthi.setVisible(true);
					pn_hienthi1.setVisible(false);
							
				}			
			}
		});
		rdbtn_quy.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtn_quy.setBounds(378, 292, 136, 21);
		contentPane.add(rdbtn_quy);
		
		rdbtn_thang = new JRadioButton("Theo Tháng");
		rdbtn_thang.setSelected(true);
		rdbtn_thang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtn_thang.isSelected()) {
					pn_hienthi1.setVisible(true);
					pn_hienthi.setVisible(false);	
					
				}
				
			}
		});
		rdbtn_thang.setFont(new Font("Tahoma", Font.BOLD, 20));
		rdbtn_thang.setBounds(560, 292, 144, 21);
		contentPane.add(rdbtn_thang);
		
		
		G = new ButtonGroup();
		G.add(rdbtn_quy);
		G.add(rdbtn_thang);
		
		btn_bieudo = new JButton("Biểu Đồ");
		btn_bieudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThongKeBieuDo TKBD = new ThongKeBieuDo("" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex()));
				TKBD.setVisible(true);
			}
		});
		btn_bieudo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_bieudo.setBounds(982, 305, 117, 21);
		contentPane.add(btn_bieudo);
		
		
		
		hienThiTongDoanhThuNam();
		hienThiTongChiNam();
	
	}
	private int getTongDoanhThuNam() {
		 String nam = "" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex());
		 return TKBUS.getDoanhThuNam(nam);
	}
	private void hienThiTongDoanhThuNam() {
		lbl_tongThu.setText(getTongDoanhThuNam()+" VNĐ");
	}
	
	
	private int getTongChiTheoNam() {
		 String nam = "" + cbx_nam.getItemAt(cbx_nam.getSelectedIndex());
		 return TKBUS.getTongChiNam(nam);
	}
	
	private void hienThiTongChiNam() {
		lbl_tongChi.setText(getTongChiTheoNam()+" VNĐ");
	}

	
}
