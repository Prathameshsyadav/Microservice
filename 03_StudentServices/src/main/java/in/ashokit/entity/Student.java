package in.ashokit.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stuId;
	private String stuName;
	private String stuAdd;
	
	@ElementCollection
    private List<Integer> subjectIds;
	
	@Transient
	private List<Subject> stuSub;
	
	
	
	public List<Integer> getSubjectIds() {
		return subjectIds;
	}
	public void setSubjectIds(List<Integer> subjectIds) {
		this.subjectIds = subjectIds;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuAdd() {
		return stuAdd;
	}
	public void setStuAdd(String stuAdd) {
		this.stuAdd = stuAdd;
	}
	public List<Subject> getStuSub() {
		return stuSub;
	}
	public void setStuSub(List<Subject> stuSub) {
		this.stuSub = stuSub;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAdd=" + stuAdd + ", stuSub=" + stuSub + "]";
	}
	
	
	

}
