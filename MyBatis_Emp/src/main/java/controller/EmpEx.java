package controller;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSeesionFactory();

		SqlSession sqlSession = null;

		sqlSession = sqlSessionFactory.openSession(true); // AutoCommit ON

		EmpDao empDao = sqlSession.getMapper(EmpDao.class);

		System.out.println("마이바티스 로드 완료!");

		//----------------------------------------------------
		System.out.println(" + + + 전체 직원 목록 + + + ");
		List<Emp> list = empDao.selectAll();
		for( Emp e : list) {
			System.out.println(e);
		}
		System.out.println("=============================");
		
		//----------------------------------------------------
		Emp newEmp = new Emp();

		System.out.println("+ + + 새로운 사원 추가하기 + + +");
		
		System.out.println("사원번호");
		newEmp.setEmpno( sc.nextInt());
		
		System.out.println("사원이름");
		sc.nextLine();
		newEmp.setEname( sc.nextLine());
		
		System.out.println("사원직무");
		newEmp.setJob( sc.nextLine());
		
		System.out.println("사원관리자");
		newEmp.setMgr( sc.nextInt());
		
		System.out.println("사원급여");
		sc.nextLine();
		newEmp.setSal( sc.nextDouble());
		
		System.out.println("사원커미션");
		newEmp.setComm( sc.nextDouble());
		
		System.out.println("사원부서번호");
		newEmp.setDeptno( sc.nextInt());
		sc.nextLine();
		
		int res = empDao.insertEmp(newEmp);
		System.out.println("사원추가 성공[1] | 실패[0] : " + res);
		
		System.out.println("=============================");
		//----------------------------------------------------
		
		Emp empNo = new Emp();
		System.out.println("조회하실 사원번호를 입력하세요");
		empNo.setEmpno(sc.nextInt());
		sc.nextLine();
		
		Emp emp = empDao.selectByEmpNo(empNo);
		System.out.println("조회된 사원 : " + emp);
		System.out.println("=============================");

		//----------------------------------------------------
		Emp delEmp = new Emp();
		delEmp.setEmpno(sc.nextInt());
		sc.nextLine();
		int i = empDao.deleteByEmpNo(delEmp);
	
		System.out.println("삭제확인 : " + i);
	
		System.out.println("=============================");
		//----------------------------------------------------
		
		System.out.println(" + + + 전체 직원 목록 + + + ");
		List<Emp> list2 = empDao.selectAll();
		for( Emp e : list2) {
			System.out.println(e);
		}
		
		sc.close();
		
		
	
	
	
	
	
	}

	
}
