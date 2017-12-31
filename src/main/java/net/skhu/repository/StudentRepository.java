package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.skhu.domain.Course;
import net.skhu.domain.Department;
import net.skhu.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>  {

	List<Student> findByName(String name);
    List<Student> findByNameStartsWith(String name);
    List<Student> findByDepartmentName(String name);
    List<Student> findByDepartmentNameStartsWith(String name);

    List<Student> findAllByOrderByName();
    List<Student> findAllByOrderByNameDesc();
    List<Student> findByDepartmentIdOrderByNameDesc(int id);
    
    @Query("SELECT s FROM Student s ORDER BY name")
    List<Student> find1();

    @Query("SELECT s FROM Student s WHERE s.department.id = ?1")
    List<Student> find2(int departmentId);

    @Query("SELECT s FROM Student s WHERE s.studentNo = ?1 OR s.name = ?2")
    List<Student> find3(String studentNo, String name);

    @Query("SELECT s FROM Student s WHERE s.studentNo = :studentNo OR s.name = :name")
    List<Student> find4(@Param("studentNo") String studentNo, @Param("name") String name);

    @Query("SELECT s.department FROM Student s")
    List<Department> find5();

    @Query("SELECT DISTINCT s.department FROM Student s")
    List<Department> find6();

    @Query("SELECT r.course FROM Student s JOIN s.registrations r WHERE s.studentNo = ?1")
    List<Course> find7(String studentNo);

    @Query("SELECT s.id, s.name FROM Student s")
    List<Object[]> find8();

    @Query("SELECT s.department.name, COUNT(s) FROM Student s GROUP BY s.department")
    List<Object[]> find9();

    @Modifying
    @Query("UPDATE Student s SET name = :name WHERE id = :id")
    void updateName(@Param("id") int id, @Param("name") String name);
    

}

