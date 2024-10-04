package model;
import java.util.ArrayList;

public class Team {
    private String name;
    private String room;
    private ArrayList<Student> students = new ArrayList<>();
    private char[] correctAnswers = {'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'};

    public Team(String name, String room){
        this.name = name;
        this.room = room;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public ArrayList<Student> getStudentList(){
        //System.out.println(students);
        return students;
    }

    public void removeStudent(String name){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)){
                students.remove(i);
            }
        }
    }

    public double classTeamAverageGrade(){
        double sum = 0;
        for (int i = 0; i < students.size(); i++) {
            sum += students.get(i).studentAverageGrade();
        }
        return sum / students.size();
    }

    public Student[] highScoreStudents(double minAverage){
        int numberOfStudents = 0;

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).studentAverageGrade() >= minAverage) {
                numberOfStudents++;
            }
        }
        Student[] highScoreStudents = new Student[numberOfStudents];

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).studentAverageGrade() >= minAverage) {
                highScoreStudents[i] = students.get(i);
            }
        }
        return highScoreStudents;
    }

    //Genbrugligt printArray - Benn må vudere hvad der er bedst.
    public void printArray(Student[] array, String text){
        System.out.println(text);
        for (Student student : array) {
            System.out.println(student.getName());
        }
    }

    public char[] getCorrectAnswers() {
        return correctAnswers;
    }

    public int[] teamCorrectAwnswears(){
        int[] correct = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            correct[i] = students.get(i).corectAnswers(correctAnswers);
        }
        return correct;
    }

    public String[] printStudentList() {
        String[] studentlist = new String[students.size()];

        System.out.printf("%-8s %11s %15s%n","Name","AVG Grade","Right answers");
        for (int i = 0; i < students.size(); i++) {

            String name = students.get(i).getName();
            double avgGrade = students.get(i).studentAverageGrade();
            int correctAnswers = students.get(i).corectAnswers(this.correctAnswers);

            studentlist[i] = name + " " + avgGrade + " " + correctAnswers;

            System.out.printf("%-8s %5.1f  %8d%n", name, avgGrade, correctAnswers);
        }
        return studentlist;
    }

    public int[] questionStats() {
        int[] correctStudentStats = new int[correctAnswers.length];

        for (Student student : students) {

            if (student.isActive()) {
                char[] studentAnswers = student.getAnswers();
                for (int index = 0; index < correctAnswers.length; index++) {

                    if (studentAnswers[index] == correctAnswers[index]) {
                        correctStudentStats[index]++;
                    }
                }
            }
        }
        for (int index = 0; index < correctStudentStats.length; index++) {
            System.out.println("Question " + (index + 1) + ": " + correctStudentStats[index] + " student(s) answered correctly");
        }

        return correctStudentStats;
    }

    public String getName() {
        return name;
    }
}
