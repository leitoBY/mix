package net.mix.spring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Department")
public class Department {
	
	@Id
	@Column (name="dept_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dept_id;
	private String dept_name;
	private BigDecimal avg_salary;
	
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public BigDecimal getAvg_salary() {
		return avg_salary;
	}
	public void setAvg_salary(BigDecimal avg_salary) {
		this.avg_salary = avg_salary;
	}

}
