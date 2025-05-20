package com.project.student.Service;

import com.project.student.Entity.Student;
import com.project.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository repo;

    public Student addTheStudent(Student s)
    {
        return repo.save(s);
    }


    public List<Student> getAllTheStudents() {
          return repo.findAll();
    }

    public Boolean deleteTheStudent(long id) {
        Optional<Student>presentStudent=repo.findById(id);
        if (presentStudent.isEmpty()){
            throw new RuntimeException("Student not found");
        }

        else
            repo.deleteById(id);
        return true;
    }



    public Student updateTheStudentById(long id, Student s) {Optional<Student>updateTheStudent=repo.findById(id);
        if (updateTheStudent.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        else {
            Student needToUpdate= updateTheStudent.get();
            needToUpdate.setStudentName(s.getStudentName());
            needToUpdate.setEmailId(s.getEmailId());
            needToUpdate.setRollNo(s.getRollNo());
            return repo.save(needToUpdate);
        }
    }
}


