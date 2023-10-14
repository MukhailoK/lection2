package exercise2.services.srvicesImpl;

import exercise2.model.Student;
import exercise2.repositories.StudentRepository;
import exercise2.services.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Map<String, Long> getAllCountStudentsNotes() {
        return studentRepository.getAll().stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
    }

    @Override
    public List<Student> getStudentsWitchBiggestNotesThat(double note) {
        Map<String, Double> students = studentRepository.gerAverageForAll();
        Set<String> keys = students.keySet();
        return keys.stream()
                .filter(key -> students.get(key) >= note)
                .map(key -> new Student(key, students.get(key)))
                .collect(Collectors.toList());
    }
}
