package ComparingStudents;

import MyComparing.CompareInterface;
import MyComparing.MyComparing;
import static MyComparing.MyComparing.print;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Comparing {

    public static void main(String[] args) {
        Student[] students = DataSource.loadDataAsArray();

        int[] gradesAlice = {2, 2, 3, 1};
        int[] gradesBob = {4, 5, 2, 3};
        int[] gradesCyril = {1, 1, 1, 4};

        students[0].setGrades(gradesAlice);
        students[1].setGrades(gradesBob);
        students[2].setGrades(gradesCyril);

        System.out.println("sort by number");
        // print(students);
        MyComparing.sortByNumber(students);
        print(students);

        System.out.println("sort by first name");
        Arrays.sort(students, new CompareByFirstName());
        print(students);

        System.out.println("sort by last name");
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            //abych použil češtinu
            public int compare(Student o1, Student o2) {
                Collator col = Collator.getInstance(new Locale("cs", "CZ")); //tovární metoda
                return col.compare(o1.getLastName(), o2.getLastName());
            }
        });
        print(students);

        System.out.println("sort by average");
        Arrays.sort(students, new CompareByAverage());
        print(students);

    }

}
