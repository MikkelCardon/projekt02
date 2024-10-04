package test;

import model.Student;
import model.Team;


public class App {
    public static void main(String[] args) {
        Team team1 = new Team("Klasse A", "SH-01");
        Team team2 = new Team("Klasse B", "SH-02");

        Student student1 = new Student("Mikkel", true, new int[]{12, 12, 2, 12, 12});
        Student student2 = new Student("Nikolaj", true, new int[]{4, 7, 10, 7, 4});
        Student student3 = new Student("Loke", false, new int[]{4, 7, 10, 7, 4});
        Student student4 = new Student("Benn", true, new int[]{12, 12, 12, 12, 12});
        Student student5 = new Student("Karsten", true, new int[]{4, 7, 10, 7, 4});
        Student student6 = new Student("Kell", true, new int[]{4, 7, 10, 7, 4});

        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);

        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);
        /* ####################################*/

        student1.studentAnswears();
        student2.studentAnswears();
        student3.studentAnswears();



        //Herunder printes de forskellige studenter, teams osv,
        System.out.println(student1.higgestGrade());

        team1.printArray(team1.highScoreStudents(4), "Students with a higher grade than 4:");

        team1.teamCorrectAwnswears();

        team1.printStudentList();

        team1.questionStats();

    }
}
