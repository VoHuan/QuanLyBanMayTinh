package QuanLyMayTinh.DAO;

import com.mysql.jdbc.Driver;

import MyCustom.MyDialog;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnect {
    
    public static Connection conn = null;
    private String severName;
    private String dbName;
    private String userName;
    private String password;

    public MyConnect() {
    	
    	docFileText();
    	
        String strConnect = "jdbc:mysql://" + severName + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        Properties pro = new Properties();
        pro.put("user", userName);
        pro.put("password", password);
        try {
            com.mysql.jdbc.Driver driver = new Driver();
            conn = driver.connect(strConnect, pro);       
        } catch (SQLException ex) {
            ex.printStackTrace();
            new MyDialog("Không kết nối được tới CSDL!", MyDialog.ERROR_DIALOG);
            System.exit(0);
        }
    }

	private void docFileText() {
		
		severName = "";
		dbName = "";
		userName = "";
		password = "";

		try {
			FileInputStream fis = new FileInputStream("Connect.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			severName = br.readLine();
			dbName = br.readLine();
			userName = br.readLine();
			password = br.readLine();

			if (password == null) {
				password = "";
			}

		} catch (Exception e) {
		}
	}
}
