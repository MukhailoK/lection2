package exercise2.repositories.repositoriesImpl;

import exercise2.model.Student;
import exercise2.repositories.StudentRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository {
    private String fileName;

    public StudentRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> getAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(l -> l.split(","))
                    .map(uArr -> new Student(uArr[0], Double.parseDouble(uArr[1])))
                    .toList();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Double> gerAverageForAll() {
        List<Student> students = getAll();
        Map<String, Double> res = new HashMap<>();
       students
                .forEach(student -> res.put(student.getName(), !res.containsKey(student.getName())
                        ? student.getNote()
                        : (res.get(student.getName()) + student.getNote()) / 2));
        return res;
    }
}


