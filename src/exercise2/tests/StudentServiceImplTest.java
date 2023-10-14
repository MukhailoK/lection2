package exercise2.tests;

import exercise2.model.Student;
import exercise2.repositories.StudentRepository;
import exercise2.repositories.repositoriesImpl.StudentRepositoryImpl;
import exercise2.services.StudentService;
import exercise2.services.srvicesImpl.StudentServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {
    StudentRepository studentRepository = new StudentRepositoryImpl("stud.txt");
    StudentService studentService = new StudentServiceImpl(studentRepository);

    @Test
    void getAllCountStudentsNotes() {
        Map<String, Long> students = studentService.getAllCountStudentsNotes();
        assertEquals(2, students.get("jack"));
    }

    @Test
    void getStudentsWitchBiggestNotesThat() {
        List<Student> students = studentService.getStudentsWitchBiggestNotesThat(3);
        assertEquals(2, students.size());
    }
}