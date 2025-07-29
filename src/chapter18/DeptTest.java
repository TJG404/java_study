package chapter18;

import java.util.List;

public class DeptTest {

	public static void main(String[] args) {
		DeptDao deptDao = new DeptDao();
		deptDao.getStatement();
		List<DeptVo> list = deptDao.getResult();
		
		System.out.println("부서아이디\t\t부서명\t\t본부아이디\t생성일\n");
		list.forEach(department -> {
			System.out.print(department.getDeptId() + "\t");
			System.out.print(department.getDeptName() + "\t");
			System.out.print(department.getUnitId() + "\t");
			System.out.print(department.getStartDate() + "\n");
		});
		
		deptDao.close();
	}

}
