package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	public List<Emp> selectAll();

	public int insertEmp(Emp newEmp);

	public Emp selectByEmpNo(Emp empNo);

	public int deleteByEmpNo(Emp delEmp);

}
