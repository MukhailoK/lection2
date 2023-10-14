package exercise2.repositories;

import exercise2.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentRepository {
    List<Student> getAll();
    Map<String, Double> gerAverageForAll();
}
