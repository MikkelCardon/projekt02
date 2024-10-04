package model;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;

    private char[] answers = new char[10];

    public Student(String name, boolean active, int[] grades){
        this.name = name;
        this.active =  active;
        this.grades = grades;
    }
    public String toString(){
        String gradeString = "";
        for (int grade : grades) {
            gradeString += grade + " ";
        }
        if (active) {
            return name + " - " + active + " - " + gradeString + " ";
        }
        else {return (this.name + " is not active");}
    }

    public String getName() {
        return name;
    }
    public int higgestGrade(){
        int higgestGrade = -3;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > higgestGrade){
                higgestGrade = grades[i];
            }
        }
        return higgestGrade;
    }
    public double studentAverageGrade(){
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public void studentAnswears(){

        char[] options = {'A', 'B', 'C', 'D'};

        for (int i = 0; i < answers.length; i++) {
            int random = (int)(Math.random()*4);
            answers[i] = options[random];
        }
        System.out.println(name + "'s answears are: ");
        for (char answear : answers) {
            System.out.print(answear + " ");
        }
        System.out.println();
    }

    public int corectAnswers(char[] correct){
        int numberOfCorrectAnswears = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == correct[i]){
                numberOfCorrectAnswears++;
            }
        }
        return numberOfCorrectAnswears;
    }

    public char[] getAnswers() {
        return answers;
    }

    public boolean isActive() {
        return active;
    }
}
