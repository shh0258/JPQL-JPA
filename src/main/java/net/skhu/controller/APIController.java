package net.skhu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.domain.Course;
import net.skhu.domain.Department;
import net.skhu.domain.Professor;
import net.skhu.domain.Registration;
import net.skhu.domain.Student;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.ProfessorRepository;
import net.skhu.repository.StudentRepository;

//@RestController
//@RequestMapping("api")
//public class APIController {
//
//    @Autowired DepartmentRepository departmentRepository;
//    @Autowired StudentRepository studentRepository;
//    @Autowired ProfessorRepository professorRepository;
//
//    @RequestMapping("departments")
//    public List<Department> departments() {
//        return departmentRepository.findAll();
//    }
//
//    @RequestMapping("students")
//    public List<Student> students() {
//        return studentRepository.findAll();
//    }
//
//    @RequestMapping("department/{id}/students")
//    public List<Student> departmentStudents(@PathVariable("id") int id) {
//        return departmentRepository.findOne(id).getStudents();
//    }
//
//    @RequestMapping("department/{id}/professors")
//    public List<Professor> departmentProfessors(@PathVariable("id") int id) {
//        return departmentRepository.findOne(id).getProfessors();
//    }
//
//    @RequestMapping("student/{id}/registrations")
//    public List<Registration> studentRegistrations(@PathVariable("id") int id) {
//        return studentRepository.findOne(id).getRegistrations();
//    }
//
//    @RequestMapping("student/{id}/courses")
//    public List<Course> studentCourses(@PathVariable("id") int id) {
//        Student student = studentRepository.findOne(id);
//        List<Course> list = new ArrayList<Course>();
//        for (Registration r : student.getRegistrations())
//            list.add(r.getCourse());
//        return list;
//    }
//    
//    @RequestMapping("test/{n}")
//    public List<Student> test(@PathVariable("n") int n) {
//        List<Student> list = null;
//        Student student1 =null ;
//        switch (n) {
//            case 1: list = studentRepository.findByName("고은"); break;
//            case 2: list = studentRepository.findByNameStartsWith("김"); break;
//            case 3: list = studentRepository.findByDepartmentName("국어국문학"); break;
//            case 4: list = studentRepository.findByDepartmentNameStartsWith("국어"); break;
//            case 5: list = studentRepository.findAllByOrderByName(); break;
//            case 6: list = studentRepository.findAllByOrderByNameDesc(); break;
//            case 7: list = studentRepository.findByDepartmentIdOrderByNameDesc(1); break;
//            case 8: list = studentRepository.findAll(); break;
//        }
//        return list;
//    }
//
//}
//
@RestController
@RequestMapping("api")
public class APIController {

    @Autowired StudentRepository studentRepository;
    @Autowired JpaContext jpaContext;

    @RequestMapping("jpql")
    public Object jpql(@RequestParam("s") String s) {
        EntityManager manager = jpaContext.getEntityManagerByManagedType(Student.class);
        Query query = manager.createQuery(s);
        Object r = query.getResultList();
        return r;
    }
}
//
//@RestController
//@RequestMapping("api")
//public class APIController {
//
//    @Autowired StudentRepository studentRepository;
//
//    @RequestMapping("testFind/{n}")
//    public Object testFind(@PathVariable("n") int n) {
//        List list = null;
//        switch (n) {
//            case 1: list = studentRepository.find1(); break;
//            case 2: list = studentRepository.find2(1); break;
//            case 3: list = studentRepository.find3("200032010", "고은"); break;
//            case 4: list = studentRepository.find4("200032010", "고은"); break;
//            case 5: list = studentRepository.find5(); break;
//            case 6: list = studentRepository.find6(); break;
//            case 7: list = studentRepository.find7("200032010"); break;
//            case 8: list = studentRepository.find8(); break;
//            case 9: list = studentRepository.find9(); break;
//        }
//        return list;
//    }
//
//    @Transactional
//    @RequestMapping("testUpdate/{n}")
//    public Object testUpdate(@PathVariable("n") int n) {
//        String newName = (n == 0) ? "Go Eun" : "고은";
//        studentRepository.updateName(1, newName);
//        Student student = studentRepository.findOne(1);
//        return student;
//    }
//}


