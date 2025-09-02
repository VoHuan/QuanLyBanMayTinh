package QuanLyMayTinh.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import QuanLyMayTinh.BUS.ThongKeBUS;
import QuanLyMayTinh.DAO.MyConnect;
import MyCustom.MoneyFormatter;

public class ThongKeBieuDo extends JFrame {

	private JPanel contentPane;
	private String[] thang_Thu;
	private String[] thang_Chi;
	private ThongKeBUS TKBUS = new ThongKeBUS();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThongKeBieuDo frame = new ThongKeBieuDo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ThongKeBieuDo(String nam) {
		new MyConnect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 810);
		this.setLocationRelativeTo(null); //hiển thị giữa mà hình
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getTongThuThang(nam);
		getTongChiThang(nam);
		ChartPanel chartPanel_thu = new ChartPanel(createChart_Thu());
		chartPanel_thu.setPreferredSize(new java.awt.Dimension(1000, 340));
        
        ChartPanel chartPanel_chi = new ChartPanel(createChart_Chi());
        chartPanel_chi.setPreferredSize(new java.awt.Dimension(1000, 340));
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn_Thu = new JPanel();
		pn_Thu.setBounds(10, 0, 1166, 389);
		pn_Thu.add(chartPanel_thu);
		contentPane.add(pn_Thu);
		
		JPanel pn_chi = new JPanel();
		pn_chi.setBounds(10, 394, 1166, 369);
		pn_chi.add(chartPanel_chi);
		contentPane.add(pn_chi);
		
		
	}
	//Biểu đồ Thu
	public  JFreeChart createChart_Thu() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ TỔNG THU THEO THÁNG",
                "Tháng", "VNĐ",
                createDataset_Thu(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private  CategoryDataset createDataset_Thu() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 12; i++) {
        	if(thang_Thu[i]==null) {
        		thang_Thu[i] = 0+"";
        	}
        }
        for(int i = 0;i<12;i++) {
        	dataset.addValue((MoneyFormatter.parseMoney(thang_Thu[i])), "VNĐ",  i+1+"");
        }

        return dataset;
    }
    
    //Biểu đồ Chi
    public  JFreeChart createChart_Chi() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "BIỂU ĐỒ TỔNG CHI THEO THÁNG",
                "Tháng", "VNĐ",
                createDataset_Chi(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private  CategoryDataset createDataset_Chi() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 12; i++) {
        	if(thang_Chi[i]==null) {
        		thang_Chi[i] = 0+"";
        	}
        }
        for(int i = 0;i<12;i++) {
        	dataset.addValue((MoneyFormatter.parseMoney( thang_Chi[i])), "VNĐ", i+1+"");
        }

        return dataset;
    }
    
    
    
    private String[] getTongThuThang(String nam) {		
    	thang_Thu = TKBUS.getTongThuThang(nam);	
		return thang_Thu;
	}
    
    
    private String[] getTongChiThang(String nam) {		
    	thang_Chi = TKBUS.getTongChiThang(nam);	
		return thang_Chi;
	}
}
