import builders.StudentsBuilder;
import entities.Studant;
import java.util.*;
public class Main {
	
	 static List<Studant> allStudents = StudentsBuilder.getAllStudents();
	
    public static void main(String[] args) {
        var allStudents = StudentsBuilder.getAllStudents();

        // Agora vamos as atividades

        System.out.println("1 - exercicio 1.");
        System.out.println("2 - exercicio 2.");
        System.out.println("3 - exercicio 3.");
        System.out.println("4 - exercicio 4.");
        System.out.println("5 - exercicio 5.");
        System.out.println("6 - exercicio 6.");
        System.out.println("7 - exercicio 7.");
        System.out.print("Digite a opção: ");
        Scanner sc = new Scanner(System.in);
        int chosenExercise = sc.nextInt();
        switch (chosenExercise) {
            case 1 -> primeiroEx();
            case 2 -> segundoEx();
            case 3 -> terceiroEx();
            case 4 -> quartoEx();
            case 5 -> quintoEx();
            case 6 -> sextoEx();
            case 7 -> setimoEx();
            default -> System.out.println("Opção invalida");
        }
    }
        
        //1. Recupere da lista os alunos que passaram de ano (nota minima 7.0).
        //    - Exiba os dados nesse formato: <código> - <nome> : Média = <nota>
        public static void primeiroEx() {
       List<Studant> students = StudentsBuilder.getAllStudents();

        for (Studant student : students) {
            float average = (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3;

            if (average >= 7.0) {
                System.out.println(student.getCode() + " - " + student.getName() + " : Média = " + average);
            }
        }
        }
       // 2. Recupere da lista os alunos que não passaram de ano.
          //  - Exiba os dados nesse formato: <código> - <nome> : Média = <media> (Faltou = <nota_faltante>)
        public static void segundoEx() {
        List<Studant> students2 = StudentsBuilder.getAllStudents();

        for (Studant student2 : students2) {
            float average = (student2.getTestOne() + student2.getTestTwo() + student2.getTestThree()) / 3;

            if (average < 7.0) {
                float missingGrade = 7.0f - average;
                System.out.println(student2.getCode() + " - " + student2.getName() + " : Média = " + average + " (Faltou = " + missingGrade + ")");
            }
        }
        }
       // 3. Traga os alunos que tiraram a nota máxima (nota 10).
           // - Exiba os dados nesse formato: <código> - <nome>
        public static void terceiroEx() {
        List<Studant> students3 = StudentsBuilder.getAllStudents();

        for (Studant student3 : students3) {
            if (student3.getTestOne() == 10.0f) {
                System.out.println(student3.getCode() + " - " + student3.getName());
            }
        }
        }
        //4. Traga o aluno que tirou a menor nota, em caso de notas iguais, traga ambos os alunos.
          //  - Exiba os dados nesse formato: <código> - <nome> : Nota = <nota>
        public static void quartoEx() {
        List<Studant> students4 = StudentsBuilder.getAllStudents();

        float minGrade = Float.MAX_VALUE;
        
        for (Studant student4 : students4) {
            float average = (student4.getTestOne() + student4.getTestTwo() + student4.getTestThree()) / 3;
            
            if (average < minGrade) {
                minGrade = average;
            }
        }
        

        for (Studant student5 : students4) {
            float average = (student5.getTestOne() + student5.getTestTwo() + student5.getTestThree()) / 3;

            if (average == minGrade) {
                System.out.println(student5.getCode() + " - " + student5.getName() + " : Nota = " + average);
            }
        }
        }
       // 5. Faça uma lista com top 3 notas de alunos. Em caso de notas iguais coloque todos na mesma posição.
            //- Ex:
              //  1º - Fulano : Nota = 10.0;
              //     - Beltrano : Nota = 10.0;
             //   2º - Joãozinho : Nota = 9.0;
             //   3º - Mariazinha : Nota = 8.9;     
        //  - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
        public static void quintoEx() {
        List<Studant> allStudents1 = new ArrayList<>(StudentsBuilder.getAllStudents());
        allStudents1.sort((s1, s2) -> Float.compare(getMaxNote(s2), getMaxNote(s1)));
        List<Studant> topStudents = allStudents1.subList(0, Math.min(3, allStudents1.size()));
        for (int i = 0; i < topStudents.size(); i++) {
            Studant student = topStudents.get(i);
            float note = getMaxNote(student);
            System.out.println((i + 1) + "º - " + student.getName() + " : Nota = " + String.format("%.1f", note));
        }        System.out.println("---------------------");

    }

    private static float getMaxNote(Studant student) {
        return Math.max(Math.max(student.getTestOne(), student.getTestTwo()), student.getTestThree());
    }
       // 6. Faça uma lista com as 3 menores notas de alunos. Em caso de notas iguais coloque todos na mesma posição. Exemplo igual a anterior
          //  - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
    public static void sextoEx() {
        List<Studant> allStudents = new ArrayList<>(StudentsBuilder.getAllStudents());
        allStudents.sort((s1, s2) -> Float.compare(getMinNote(s1), getMinNote(s2)));
        List<Studant> topStudents = allStudents.subList(0, Math.min(3, allStudents.size()));
        for (int i = 0; i < topStudents.size(); i++) {
            Studant student = topStudents.get(i);
            float note = getMinNote(student);
            System.out.println((i + 1) + "º - " + student.getName() + " : Nota = " + String.format("%.1f", note));
        }System.out.println("---------------------");

    }
    private static float getMinNote(Studant student) {
        return Math.min(Math.min(student.getTestOne(), student.getTestTwo()), student.getTestThree());
    }
        //7. Monte a média de todos os alunos e exiba em tela ordenando da maior para a menor nota.
           // - Exiba os dados nesse formato: <posicao> - <código> - <nome> : Média = <nota>
    public static void setimoEx() {
        List<Studant> allStudents = new ArrayList<>(StudentsBuilder.getAllStudents());
        Collections.sort(allStudents, (s1, s2) -> Float.compare(getAverage(s2), getAverage(s1)));
        for (int i = 0; i < allStudents.size(); i++) {
            Studant student = allStudents.get(i);
            float note = getAverage(student);
            System.out.println((i + 1) + "º - " + student.getCode() + " - " + student.getName() + " : Média = " + String.format("%.1f", note));
        }
    }
//a
    private static float getAverage(Studant student) {
        return (student.getTestOne() + student.getTestTwo() + student.getTestThree()) / 3.0f;
    }
}