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

public class ThongKeThang extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField txt_thu1;
	private JTextField txt_thu2;
	private JTextField txt_thu3;
	private JTextField txt_thu4;
	private JTextField txt_thu5;
	private JTextField txt_thu6;
	private JTextField txt_thu7;
	private JTextField txt_thu8;
	private JTextField txt_thu9;
	private JTextField txt_thu10;
	private JTextField txt_thu11;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField txt_chi1;
	private JTextField txt_chi2;
	private JTextField txt_chi3;
	private JTextField txt_chi4;
	private JTextField txt_chi5;
	private JTextField txt_chi6;
	private JTextField txt_chi7;
	private JTextField txt_chi8;
	private JTextField txt_chi9;
	private JTextField txt_chi10;
	private JTextField txt_chi11;
	private JTextField txt_chi12;
	private JTextField txt_thu12;
	ThongKeBUS TKBUS = new ThongKeBUS();
	private String[] thang_Thu;
	private String[] thang_Chi;
	/**
	 * Create the panel.
	 */
	public ThongKeThang() {
		setLayout(null);
		
		JPanel pn_hienthi = new JPanel();
		pn_hienthi.setLayout(null);
		pn_hienthi.setBounds(0, 0, 1166, 437);
		add(pn_hienthi);
		
		textField = new JTextField();
		textField.setText("Tháng");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField.setBounds(0, 54, 89, 47);
		pn_hienthi.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_1.setBounds(87, 54, 89, 47);
		pn_hienthi.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("2");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_2.setBounds(174, 54, 89, 47);
		pn_hienthi.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("3");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_3.setBounds(260, 54, 89, 47);
		pn_hienthi.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("4");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_4.setBounds(348, 54, 89, 47);
		pn_hienthi.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("5");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_5.setBounds(435, 54, 89, 47);
		pn_hienthi.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("6");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_6.setColumns(10);
		textField_6.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_6.setBounds(524, 54, 89, 47);
		pn_hienthi.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("7");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_7.setColumns(10);
		textField_7.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_7.setBounds(611, 54, 89, 47);
		pn_hienthi.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("8");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_8.setColumns(10);
		textField_8.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_8.setBounds(699, 54, 89, 47);
		pn_hienthi.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("9");
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_9.setColumns(10);
		textField_9.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_9.setBounds(787, 54, 89, 47);
		pn_hienthi.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("10");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_10.setColumns(10);
		textField_10.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_10.setBounds(874, 54, 89, 47);
		pn_hienthi.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("11");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_11.setColumns(10);
		textField_11.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_11.setBounds(961, 54, 89, 47);
		pn_hienthi.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("12");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_12.setColumns(10);
		textField_12.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_12.setBounds(1049, 54, 89, 47);
		pn_hienthi.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setText("Tổng");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_13.setColumns(10);
		textField_13.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_13.setBounds(0, 98, 89, 47);
		pn_hienthi.add(textField_13);
		
		txt_thu1 = new JTextField();
		txt_thu1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu1.setColumns(10);
		txt_thu1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu1.setBounds(87, 98, 89, 47);
		pn_hienthi.add(txt_thu1);
		
		txt_thu2 = new JTextField();
		txt_thu2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu2.setColumns(10);
		txt_thu2.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu2.setBounds(174, 98, 89, 47);
		pn_hienthi.add(txt_thu2);
		
		txt_thu3 = new JTextField();
		txt_thu3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu3.setColumns(10);
		txt_thu3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu3.setBounds(260, 98, 89, 47);
		pn_hienthi.add(txt_thu3);
		
		txt_thu4 = new JTextField();
		txt_thu4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu4.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu4.setColumns(10);
		txt_thu4.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu4.setBounds(348, 98, 89, 47);
		pn_hienthi.add(txt_thu4);
		
		txt_thu5 = new JTextField();
		txt_thu5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu5.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu5.setColumns(10);
		txt_thu5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu5.setBounds(435, 98, 89, 47);
		pn_hienthi.add(txt_thu5);
		
		txt_thu6 = new JTextField();
		txt_thu6.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu6.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu6.setColumns(10);
		txt_thu6.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu6.setBounds(524, 98, 89, 47);
		pn_hienthi.add(txt_thu6);
		
		txt_thu7 = new JTextField();
		txt_thu7.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu7.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu7.setColumns(10);
		txt_thu7.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu7.setBounds(611, 98, 89, 47);
		pn_hienthi.add(txt_thu7);
		
		txt_thu8 = new JTextField();
		txt_thu8.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu8.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu8.setColumns(10);
		txt_thu8.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu8.setBounds(699, 98, 89, 47);
		pn_hienthi.add(txt_thu8);
		
		txt_thu9 = new JTextField();
		txt_thu9.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu9.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu9.setColumns(10);
		txt_thu9.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu9.setBounds(787, 98, 89, 47);
		pn_hienthi.add(txt_thu9);
		
		txt_thu10 = new JTextField();
		txt_thu10.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu10.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu10.setColumns(10);
		txt_thu10.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu10.setBounds(874, 98, 89, 47);
		pn_hienthi.add(txt_thu10);
		
		txt_thu11 = new JTextField();
		txt_thu11.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu11.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu11.setColumns(10);
		txt_thu11.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu11.setBounds(961, 98, 89, 47);
		pn_hienthi.add(txt_thu11);
		
		textField_25 = new JTextField();
		textField_25.setText("Tháng");
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_25.setColumns(10);
		textField_25.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_25.setBounds(0, 249, 89, 47);
		pn_hienthi.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setText("1");
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_26.setColumns(10);
		textField_26.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_26.setBounds(87, 249, 89, 47);
		pn_hienthi.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setText("2");
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_27.setColumns(10);
		textField_27.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_27.setBounds(174, 249, 89, 47);
		pn_hienthi.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setText("3");
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_28.setColumns(10);
		textField_28.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_28.setBounds(260, 249, 89, 47);
		pn_hienthi.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setText("4");
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_29.setColumns(10);
		textField_29.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_29.setBounds(348, 249, 89, 47);
		pn_hienthi.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setText("5");
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		textField_30.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_30.setColumns(10);
		textField_30.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_30.setBounds(435, 249, 89, 47);
		pn_hienthi.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setText("6");
		textField_31.setHorizontalAlignment(SwingConstants.CENTER);
		textField_31.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_31.setColumns(10);
		textField_31.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_31.setBounds(524, 249, 89, 47);
		pn_hienthi.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setText("7");
		textField_32.setHorizontalAlignment(SwingConstants.CENTER);
		textField_32.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_32.setColumns(10);
		textField_32.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_32.setBounds(611, 249, 89, 47);
		pn_hienthi.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setText("8");
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_33.setColumns(10);
		textField_33.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_33.setBounds(699, 249, 89, 47);
		pn_hienthi.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setText("9");
		textField_34.setHorizontalAlignment(SwingConstants.CENTER);
		textField_34.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_34.setColumns(10);
		textField_34.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_34.setBounds(787, 249, 89, 47);
		pn_hienthi.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setText("10");
		textField_35.setHorizontalAlignment(SwingConstants.CENTER);
		textField_35.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_35.setColumns(10);
		textField_35.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_35.setBounds(874, 249, 89, 47);
		pn_hienthi.add(textField_35);
		
		textField_36 = new JTextField();
		textField_36.setText("11");
		textField_36.setHorizontalAlignment(SwingConstants.CENTER);
		textField_36.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_36.setColumns(10);
		textField_36.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_36.setBounds(961, 249, 89, 47);
		pn_hienthi.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setText("12");
		textField_37.setHorizontalAlignment(SwingConstants.CENTER);
		textField_37.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_37.setColumns(10);
		textField_37.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_37.setBounds(1049, 249, 89, 47);
		pn_hienthi.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setText("Tổng");
		textField_38.setHorizontalAlignment(SwingConstants.CENTER);
		textField_38.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_38.setColumns(10);
		textField_38.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		textField_38.setBounds(0, 293, 89, 47);
		pn_hienthi.add(textField_38);
		
		txt_chi1 = new JTextField();
		txt_chi1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi1.setColumns(10);
		txt_chi1.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi1.setBounds(87, 293, 89, 47);
		pn_hienthi.add(txt_chi1);
		
		txt_chi2 = new JTextField();
		txt_chi2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi2.setColumns(10);
		txt_chi2.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi2.setBounds(174, 293, 89, 47);
		pn_hienthi.add(txt_chi2);
		
		txt_chi3 = new JTextField();
		txt_chi3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi3.setColumns(10);
		txt_chi3.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi3.setBounds(260, 293, 89, 47);
		pn_hienthi.add(txt_chi3);
		
		txt_chi4 = new JTextField();
		txt_chi4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi4.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi4.setColumns(10);
		txt_chi4.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi4.setBounds(348, 293, 89, 47);
		pn_hienthi.add(txt_chi4);
		
		txt_chi5 = new JTextField();
		txt_chi5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi5.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi5.setColumns(10);
		txt_chi5.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi5.setBounds(435, 293, 89, 47);
		pn_hienthi.add(txt_chi5);
		
		txt_chi6 = new JTextField();
		txt_chi6.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi6.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi6.setColumns(10);
		txt_chi6.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi6.setBounds(524, 293, 89, 47);
		pn_hienthi.add(txt_chi6);
		
		txt_chi7 = new JTextField();
		txt_chi7.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi7.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi7.setColumns(10);
		txt_chi7.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi7.setBounds(611, 293, 89, 47);
		pn_hienthi.add(txt_chi7);
		
		txt_chi8 = new JTextField();
		txt_chi8.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi8.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi8.setColumns(10);
		txt_chi8.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi8.setBounds(699, 293, 89, 47);
		pn_hienthi.add(txt_chi8);
		
		txt_chi9 = new JTextField();
		txt_chi9.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi9.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi9.setColumns(10);
		txt_chi9.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi9.setBounds(787, 293, 89, 47);
		pn_hienthi.add(txt_chi9);
		
		txt_chi10 = new JTextField();
		txt_chi10.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi10.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi10.setColumns(10);
		txt_chi10.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi10.setBounds(874, 293, 89, 47);
		pn_hienthi.add(txt_chi10);
		
		txt_chi11 = new JTextField();
		txt_chi11.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi11.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi11.setColumns(10);
		txt_chi11.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi11.setBounds(961, 293, 89, 47);
		pn_hienthi.add(txt_chi11);
		
		txt_chi12 = new JTextField();
		txt_chi12.setHorizontalAlignment(SwingConstants.CENTER);
		txt_chi12.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_chi12.setColumns(10);
		txt_chi12.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_chi12.setBounds(1049, 293, 89, 47);
		pn_hienthi.add(txt_chi12);
		
		txt_thu12 = new JTextField();
		txt_thu12.setHorizontalAlignment(SwingConstants.CENTER);
		txt_thu12.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_thu12.setColumns(10);
		txt_thu12.setBorder(new LineBorder(new Color(171, 173, 179), 2));
		txt_thu12.setBounds(1049, 98, 89, 47);
		pn_hienthi.add(txt_thu12);
		
		JLabel lblNewLabel_3 = new JLabel("Thống kê thu");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(418, 10, 236, 34);
		pn_hienthi.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Thống kê chi");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(435, 205, 236, 34);
		pn_hienthi.add(lblNewLabel_4);

	}
	private String[] getTongThuThang(String nam) {		
		thang_Thu = TKBUS.getTongThuThang(nam);	
		return thang_Thu;
	}
	public void loadThangThu(String nam) {
		getTongThuThang(nam);
		txt_thu1.setText(thang_Thu[0]);
		txt_thu2.setText(thang_Thu[1]);
		txt_thu3.setText(thang_Thu[2]);
		txt_thu4.setText(thang_Thu[3]);
		txt_thu5.setText(thang_Thu[4]);
		txt_thu6.setText(thang_Thu[5]);
		txt_thu7.setText(thang_Thu[6]);
		txt_thu8.setText(thang_Thu[7]);
		txt_thu9.setText(thang_Thu[8]);
		txt_thu10.setText(thang_Thu[9]);
		txt_thu11.setText(thang_Thu[10]);
		txt_thu12.setText(thang_Thu[11]);		
	}
	
	
	private String[] getTongChiThang(String nam) {		
		thang_Chi = TKBUS.getTongChiThang(nam);	
		return thang_Chi;
	}
	public void loadThangChi(String nam) {
		getTongChiThang(nam);
		txt_chi1.setText(thang_Chi[0]);
		txt_chi2.setText(thang_Chi[1]);
		txt_chi3.setText(thang_Chi[2]);
		txt_chi4.setText(thang_Chi[3]);
		txt_chi5.setText(thang_Chi[4]);
		txt_chi6.setText(thang_Chi[5]);
		txt_chi7.setText(thang_Chi[6]);
		txt_chi8.setText(thang_Chi[7]);
		txt_chi9.setText(thang_Chi[8]);
		txt_chi10.setText(thang_Chi[9]);
		txt_chi11.setText(thang_Chi[10]);
		txt_chi12.setText(thang_Chi[11]);		
	}
}
