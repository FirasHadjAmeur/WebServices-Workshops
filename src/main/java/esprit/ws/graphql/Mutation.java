package esprit.ws.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import esprit.ws.entities.Student;
import esprit.ws.reposot.StudentRepository;

public class Mutation implements GraphQLRootResolver{


    private StudentRepository studentRepository;

    
    public Mutation(StudentRepository stdR) {
        this.studentRepository=stdR;
    }
    // List<Student> studentRepository.getAllStudents();
    
    public Student addStudent(String cin, String nompre,String email) {
        Student S = new Student(cin,nompre,email);
        studentRepository.saveStudent(S);
        return S;
    }
    public Student updateStudent(String cin, String nompre,String email) {
        Student S = new Student(cin,nompre,email);
        studentRepository.updateStudent(S);
        return S;
    }
    public List<Student> deleteStudent(String cin) {
        studentRepository.deleteStudent(cin);
        return studentRepository.getListStudent();
    }
}
