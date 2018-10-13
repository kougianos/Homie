package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the studentcourse database table.
 * 
 */
@Entity
@Table(name="studentcourse")
@NamedQuery(name="Studentcourse.findAll", query="SELECT s FROM Studentcourse s")
public class Studentcourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudentcoursePK id;

	private double grade;

	//bi-directional many-to-one association to Course
	@ManyToOne
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public Studentcourse() {
	}

	public StudentcoursePK getId() {
		return this.id;
	}

	public void setId(StudentcoursePK id) {
		this.id = id;
	}

	public double getGrade() {
		return this.grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}