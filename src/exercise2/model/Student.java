package exercise2.model;

import java.util.Objects;

public class Student {
    private String name;
    private double note;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", note=" + note +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Student() {
    }

    public Student(String name, double note) {
        this.name = name;
        this.note = note;
    }
}
