Overvej at bruge foreach-løkker når I kan, for-løkker gør det samme,
men når man bliver vant til syntaksen, er det nemmere at læse, efter min mening.

så 

        double sum = 0;
        for (int i = 0; i < students.size(); i++) {
            sum += students.get(i).studentAverageGrade();
        }
        return sum / students.size();

bliver til 

        double sum = 0;
        for (Student student : students) {
            sum += student.studentAverageGrade();
        }
        return sum / students.size();

---

Rigtigt godt med jeres Menu klasse. Et forslag kunne være at dele koden endnu mere op i metoder.
printMenuForSchool metoden gør faktisk to ting. Den printer menuen som metoden indikerer, men den
spørger også om brugervalg, hvilket metodenavnet ikke siger noget om. 

---

Rigtigt fint med utility metoder som 

    public void printArray(Student[] array, String text){
        System.out.println(text);
        for (Student student : array) {
            System.out.println(student.getName());
        }
    }

der er lidt med navngivningen I skal tænke på. Det er ikke et Array i printer, det er 
et Array af Student-objekter. Så printStudents ville være et bedre navn for metoden. 
Parameternavnene ville give mere information, hvis de hed students og header.

---

Sørg for at rydde op I jeres kode, udkommenteret kode fylder og når man læser kode med udkommenteret kode,
skal man bruge tid på at finde ud af at det ikke er relevant.

    public ArrayList<Student> getStudentList(){
        //System.out.println(students);
        return students;
    }

Indrømmet en linje kode betyder ikke meget, men det er en god praksis ikke at efterlade udkommenteret kode.

---


