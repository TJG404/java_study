package chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmpDao {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hrdb2019?useSSL=false&serverTimezone=Asia/Seoul";
        String user = "root";
        String password = "mysql1234";

        try {
            // 드라이버 로딩 (JDBC 4.0 이상은 생략 가능하나 명시적으로 작성 권장)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결 시도
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ MySQL 연결 성공!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ 드라이버 클래스 로드 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ DB 연결 실패: " + e.getMessage());
        }
    }
}
