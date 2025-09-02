package QuanLyMayTinh.GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import QuanLyMayTinh.BUS.ThongKeBUS;
import MyCustom.MoneyFormatter;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class ThongKeQuy extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txt_thu1;
	private JTextField txt_thu2;
	private JTextField txt_thu3;
	private JTextField txt_thu4;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField txt_chi1;
	private JTextField txt_chi2;
	private JTextField txt_chi3;
	private JTextField txt_chi4;
	ThongKeBUS TKBUS = new ThongKeBUS();
	private String[] quy_Thu;
	private String[] quy_Chi;
	/**
	 * Create the panel.
	 */
	public ThongKeQuy() {
		setLayout(null);
		
		JPanel pn_quy = new JPanel();
		pn_quy.setLayout(null);
		pn_quy.setBounds(33, 10, 983, 422);
		add(pn_quy);
		
		textField = new JTextField();
		textField.setText("Qúy");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 33));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField.setBounds(206, 98, 111, 66);
		pn_quy.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Qúy 1");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_1.setBounds(316, 98, 131, 66);
		pn_quy.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("Qúy 2");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_2.setBounds(446, 98, 145, 66);
		pn_quy.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("Qúy 3");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_3.setBounds(591, 98, 138, 66);
		pn_quy.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("Qúy 4");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_4.setBounds(729, 98, 131, 66);
		pn_quy.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("Tổng");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_5.setBounds(206, 164, 111, 66);
		pn_quy.add(textField_5);
		
		txt_thu1 = new JTextField();
		txt_thu1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu1.setColumns(10);
		txt_thu1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu1.setBounds(316, 164, 131, 66);
		pn_quy.add(txt_thu1);
		
		txt_thu2 = new JTextField();
		txt_thu2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu2.setColumns(10);
		txt_thu2.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu2.setBounds(446, 164, 145, 66);
		pn_quy.add(txt_thu2);
		
		txt_thu3 = new JTextField();
		txt_thu3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu3.setColumns(10);
		txt_thu3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu3.setBounds(591, 164, 138, 66);
		pn_quy.add(txt_thu3);
		
		txt_thu4 = new JTextField();
		txt_thu4.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu4.setColumns(10);
		txt_thu4.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu4.setBounds(729, 164, 131, 66);
		pn_quy.add(txt_thu4);
		
		textField_10 = new JTextField();
		textField_10.setText("Qúy");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 33));
		textField_10.setColumns(10);
		textField_10.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_10.setBounds(206, 272, 111, 66);
		pn_quy.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("Qúy 1");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_11.setColumns(10);
		textField_11.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_11.setBounds(316, 272, 131, 66);
		pn_quy.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("Qúy 2");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_12.setColumns(10);
		textField_12.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_12.setBounds(446, 272, 145, 66);
		pn_quy.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("Qúy 3");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_13.setColumns(10);
		textField_13.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_13.setBounds(591, 272, 138, 66);
		pn_quy.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("Qúy 4");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_14.setColumns(10);
		textField_14.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_14.setBounds(729, 272, 131, 66);
		pn_quy.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("Tổng");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_15.setColumns(10);
		textField_15.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_15.setBounds(206, 337, 111, 66);
		pn_quy.add(textField_15);
		
		txt_chi1 = new JTextField();
		txt_chi1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi1.setColumns(10);
		txt_chi1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi1.setBounds(316, 337, 131, 66);
		pn_quy.add(txt_chi1);
		
		txt_chi2 = new JTextField();
		txt_chi2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi2.setColumns(10);
		txt_chi2.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi2.setBounds(446, 337, 145, 66);
		pn_quy.add(txt_chi2);
		
		txt_chi3 = new JTextField();
		txt_chi3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi3.setColumns(10);
		txt_chi3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi3.setBounds(591, 337, 138, 66);
		pn_quy.add(txt_chi3);
		
		txt_chi4 = new JTextField();
		txt_chi4.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi4.setColumns(10);
		txt_chi4.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi4.setBounds(729, 337, 131, 66);
		pn_quy.add(txt_chi4);
		
		JLabel lblNewLabel_3 = new JLabel("Thu");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3.setBounds(34, 134, 104, 45);
		pn_quy.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Chi");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_3_1.setBounds(34, 293, 104, 45);
		pn_quy.add(lblNewLabel_3_1);
		//loadQuy(2022+"");
	}
	private String[] getTongThuQuy(String nam) {
		quy_Thu = new String[4];
		for(int i =1;i<5;i++) {
			quy_Thu[i-1] = MoneyFormatter.formatMoney(TKBUS.getTongDoanhThuQuy(nam,i+""));
		}
		return quy_Thu;
	}
	public void loadQuyThu(String nam) {
		getTongThuQuy(nam);
		txt_thu1.setText(quy_Thu[0]);
		txt_thu2.setText(quy_Thu[1]);
		txt_thu3.setText(quy_Thu[2]);
		txt_thu4.setText(quy_Thu[3]);
	}
	
	
	
	private String[] getTongChiQuy(String nam) {
		quy_Chi = new String[4];
		for(int i =1;i<5;i++) {
			quy_Chi[i-1] = MoneyFormatter.formatMoney(TKBUS.getTongDoanhChiQuy(nam,i+""));
		}
		return quy_Chi;
	}
	public void loadQuyChi(String nam) {
		getTongChiQuy(nam);
		txt_chi1.setText(quy_Chi[0]);
		txt_chi2.setText(quy_Chi[1]);
		txt_chi3.setText(quy_Chi[2]);
		txt_chi4.setText(quy_Chi[3]);
	}
}
