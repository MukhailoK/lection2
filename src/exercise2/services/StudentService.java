package exercise2.services;

import exercise2.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    Map<String, Long> getAllCountStudentsNotes();
    List<Student> getStudentsWitchBiggestNotesThat(double note);
}
