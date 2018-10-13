package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the studentcourse database table.
 * 
 */
@Embeddable
public class StudentcoursePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="student_id", insertable=false, updatable=false)
	private String studentId;

	@Column(name="course_id", insertable=false, updatable=false)
	private String courseId;

	public StudentcoursePK() {
	}
	public String getStudentId() {
		return this.studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StudentcoursePK)) {
			return false;
		}
		StudentcoursePK castOther = (StudentcoursePK)other;
		return 
			this.studentId.equals(castOther.studentId)
			&& this.courseId.equals(castOther.courseId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.studentId.hashCode();
		hash = hash * prime + this.courseId.hashCode();
		
		return hash;
	}
}