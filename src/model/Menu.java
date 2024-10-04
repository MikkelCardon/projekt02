package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private static int menuChoice = 0;
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Team> teams = new ArrayList<>();

    public static void printMenuForSchool() {
        System.out.println("1: Create a team");
        System.out.println("2: Create a student");
        System.out.println("3: Show one student's info and results");
        System.out.println("4: Show one team's info and results");
        System.out.println("5: Show info and results for all teams");
        System.out.println("6: Exit program");

        menuChoice = scanner.nextInt();

        if (menuChoice == 1) {
            createTeam();
        }
        if (menuChoice == 2) {
            createStudent();
        }
        if (menuChoice == 3){
            printStudentInfo();
        }
        if (menuChoice == 6){
            scanner.close();
        }
    }

    public static void createTeam() {
        System.out.println("Insert the desired team name: ");
        String teamName = scanner.next();
        System.out.println("Insert desired room for the team: ");
        String teamRoom = scanner.next();
        Team team = new Team(teamName, teamRoom);
        teams.add(team);
        System.out.println("> Team created with the name " + teamName + " and with the room " + teamRoom);
        printMenuForSchool();
    }

    public static void createStudent() {
        System.out.println("Insert the name of the students team: ");
        String teamName = scanner.next();
        System.out.println("Insert the student name: ");
        String studentName = scanner.next();
        System.out.println("Is the student currently active?: ");
        boolean studentActive = scanner.nextBoolean();
        System.out.println("How many grades has the student recieved?: ");
        int amountOfGrades = scanner.nextInt();
        int[] StudentGrades = new int[amountOfGrades];
        System.out.println("Insert the grades of the student with space between each: ");
        for (int i = 0; i < StudentGrades.length; i++) {
            StudentGrades[i] = scanner.nextInt();
        }
        Student student = new Student(studentName, studentActive, StudentGrades);
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                team.addStudent(student);
            }
            System.out.println("Student created with the name " + studentName + " and the active status of " + studentActive + " and the grades " + java.util.Arrays.toString(StudentGrades));
            printMenuForSchool();
        }
    }
    public static void printStudentInfo(){
        System.out.println("Insert the students name: ");
        String studentName = scanner.next();
        for (Team team : teams) {
            if (team.getStudentList().contains(studentName)) {
                team.printStudentList();
            }
        }
        printMenuForSchool();
    }
}