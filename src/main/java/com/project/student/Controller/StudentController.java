package com.project.student.Controller;

import com.project.student.Entity.Student;
import com.project.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/api/student")
@RestController
public class StudentController
{

    @Autowired
    private StudentService service;


    @PostMapping("/add-student")
    public HashMap<String,Object> addStudent(@RequestBody Student s)
    {
        HashMap<String, Object> response = new HashMap<String, Object>();
        try {
            Student addedStudent = service.addTheStudent(s);
            response.put("message", "Student added successfully");
            response.put("Student", addedStudent);
            return response;
        }
        catch (Exception e)
        {
            response.put("error","Show Error Occurred");
            return response;

        }
    }
    @GetMapping("/get-all-student")
    public HashMap<String,Object> getAllStudents() {
        HashMap<String, Object> response = new HashMap<String, Object>();
        try {
          List<Student> presentStudents = service.getAllTheStudents();
            response.put("message", "Student data fetched  successfully");
            response.put("Student", presentStudents);
            return response;
        } catch (Exception e) {
            response.put("error", "Show Error Occurred");
            return response;


        }


    }
    @DeleteMapping("/delete-student")
    public HashMap<String,Object> deleteStudent(@RequestParam long id)
    {
        HashMap<String, Object> response = new HashMap<String, Object>();
        try {
            Boolean deletedStudents = service.deleteTheStudent(id);
            response.put("message", "Student data deleted successfully");
            response.put("Student", deletedStudents);
            return response;
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
            return response;
        }
    }
    @PutMapping("/update-student")
    public HashMap<String, Object> updateTheStudent(@RequestParam Long id, @RequestBody Student s)
    {
      HashMap<String,Object> response=new HashMap<String, Object>();
        try {
            Student updatedTheStudents = service.updateTheStudentById(id,s);
            response.put("message", "Student data updated successfully");
            response.put("Student", updatedTheStudents);
            return response;
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
            return response;

        }
    
    }     
}