package chapter18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;


public class DeptDao {

		Connection conn;
		Statement stmt;
		ResultSet rs;
		
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521";
//		String user = "scott";
//		String password = "tiger";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/hrdb2019?useSSL=false&serverTimezone=Asia/Seoul";
        String user = "root";
        String password = "mysql1234";

		
		
		
		//Constructor - 1,2 단계
		public DeptDao() {
			try {
				Class.forName(driver);
				System.out.println("--------->>1");
				
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("--------->>2");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//Method
		public void getStatement() {
			try {
				stmt = conn.createStatement();
				System.out.println("--------->>3");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public String[] getResultColName() {
			String[] colList = null;
			try {
				ResultSetMetaData rsmd = rs.getMetaData();
				colList = new String[rsmd.getColumnCount()];
				for(int i=0;i<colList.length;i++) {
					colList[i] = rsmd.getColumnName(i+1);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return colList;
		}
		
		public ArrayList<Object[]> getResultObject(String sql) {
			ArrayList<Object[]> list = new ArrayList<Object[]>();
			
//			String sql = "select rownum rno, empno, ename, job, hiredate, deptno "
//					+ " from (select empno, ename, job, " 
//					+ "          to_char(hiredate,'yyyy/mm/dd') hiredate, deptno "
//					+ "         from emp "
//					+ "         order by deptno)";
			
			getStatement();
			
			try {
	System.out.println("sql-->" + sql);			
				rs = stmt.executeQuery(sql);
			    String[] colList = getResultColName();
			    
				//5. ResultSet 데이터 처리 - 콘솔창에 출력			
				while(rs.next()) {
					//System.out.println(rs.getObject(1));
					Object[] obj = new Object[colList.length];
					for(int i=0;i<colList.length;i++) {
						obj[i] = rs.getObject(i+1);
						System.out.println("obj["+i+"]="+ obj[i]);
					}
					
					list.add(obj);
//					EmpVo employee = new EmpVo();
//					employee.setRno(rs.getInt(1));
//					employee.setEmpno(rs.getInt(2));
//					employee.setEname(rs.getString(3));
//					employee.setJob(rs.getString(4));
//					employee.setHiredate(rs.getString(5));
//					employee.setDeptno(rs.getInt(6));
//					
//					list.add(employee);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			return list;
		}
		
		
		
		public ArrayList<DeptVo> getResult() {
			ArrayList<DeptVo> list = new ArrayList<DeptVo>();
			
			String sql = "select dept_id, dept_name, unit_id, start_date "
					+ " from department";

			
			getStatement();
			
			try {
				rs = stmt.executeQuery(sql);
			
				//5. ResultSet 데이터 처리 - 콘솔창에 출력			
				while(rs.next()) {
					DeptVo department = new DeptVo();
					department.setDeptId(rs.getString(1));
					department.setDeptName(rs.getString(2));
					department.setUnitId(rs.getString(3));
					department.setStartDate(rs.getString(4));					
					
					list.add(department);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
			return list;
		}
		
		
		public void close() {
			try {
				if(rs != null)  rs.close();
				if(stmt != null)  stmt.close();
				if(conn != null)  conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
