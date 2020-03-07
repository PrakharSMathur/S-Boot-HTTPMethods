package com.fakedb.trial.Dao;

import com.fakedb.trial.Entity.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

  private static Map<Integer, Student> students;

  static {
    students = new HashMap<Integer, Student>() {
      {
        put(1, new Student(1, "PSM", "ECM"));
        put(2, new Student(2, "dwij", "ECM"));
        put(3, new Student(3, "Aditya", "ECM"));
      }
    };
  }

  public Collection<Student> getAllStudents() {
    return this.students.values();
  }

  public Student getStudentById(int id) {
    return this.students.get(id);
  }

  public void removeStudentById(int id) {
    this.students.remove(id);
  }

  public void updateStudent(Student student) {
    Student s = students.get(student.getId());
    s.setCourse(student.getCourse());
    s.setName(student.getName());
    students.put(student.getId(), student);
  }

  public void insertStudentToDB(Student student) {
    this.students.put(student.getId(), student);
  }
}
