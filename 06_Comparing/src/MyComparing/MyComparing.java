package MyComparing;

import ComparingStudents.DataSource;
import ComparingStudents.Student;
import MyComparing.PorovnavacStudentByFirstName;
import java.util.List;

public class MyComparing {

    public static void main(String[] args) {
       /* Student[] students = DataSource.loadDataAsArray();
        print(students);

        System.out.println("sorted by number");
        sortByNumber(students);
        print(students);*/
       
       Student[] students = DataSource.loadDataAsArray();
        //print(students);

        //System.out.println("sorted by number");
        //sort(students);
        print(students);
        sort(students, new PorovnavacStudentByFirstName());
        print(students);
     
        
        

    }

    public static void sort(CompareInterface[] array) {//bubble sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1].isBigger(array[j])) {
                    CompareInterface pom = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = pom;
                }

            }

        }
    }
    
    public static void sort(Object[] array, CompareInterface o) {//třídí pole jakychkoli objektů
        for (int i = 0; i < array.length - 1; i++) {             //metoda bigger objektu typově kompatibilniho s compareinterface definuje jak třídit
            for (int j = 1; j < array.length - i; j++) {
                if (o.bigger(array[j-1], array[j])) {
                    Object pom = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = pom;
                }

            }

        }
    }
    
    public static void sortByNumber(Student[] array) {//bubble sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1].isBigger(array[j])) {
                    Student pom = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = pom;
                }

            }

        }
    }

    public static void print(Object[] array) {
        for (Object object : array) {
            System.out.println(object);
        }
    }
    
    public static void print(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
    

