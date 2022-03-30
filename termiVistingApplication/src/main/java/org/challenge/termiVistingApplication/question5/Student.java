package org.challenge.termiVistingApplication.question5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        if(id < 1 && id > 100000) throw new IllegalArgumentException("the id is not valid");
        else {
            this.id = id;
        }

        if(name.length() <2 && name.length() > 30) throw new IllegalArgumentException("the name length should be between 2 and 30");
        else{this.name = name;
        }

        if(cgpa <0 && cgpa > 5 ) throw new IllegalArgumentException("the cgpa should be within 0 and 4");
        else{
            this.cgpa = cgpa;
        }

    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    static class Priorities {
        private final PriorityQueue<Student> queue = new PriorityQueue<>(
                Comparator.comparing(Student::getCGPA).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getID));

        public List<Student> getStudents(List<String> events) {
            events.forEach((event) -> {
                if (event.equals("SERVED")) {
                    queue.poll();
                } else {
                    String[] details = event.split(" ");

                    queue.add(new Student(Integer.parseInt(details[3]), details[1], Double.parseDouble(details[2])));
                }
            });

            List<Student> students = new ArrayList<>();
            while (!queue.isEmpty()) {
                students.add(queue.poll());
            }

            return students;
        }

    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "Jalu", 3.5);
        Student student2 = new Student(2, "Bolu", 2.4);
        Student student3 = new Student(3, "dele", 3.9);
        Student student4 = new Student(4, "Bolaji", 1.5);
        Student student5 = new Student(5, "Adeou", 2.5);
        Student student6 = new Student(6, "Bisi", 3.7);
        Student student7 = new Student(7, "kunle", 3.6);
        Student student8 = new Student(8, "Ola", 2.8);
        Student student9 = new Student(9, "Olu", 2.9);
        Student student10 = new Student(10, "Alule", 1.5);
        List<Student>  students = new ArrayList<>();


    }
}
