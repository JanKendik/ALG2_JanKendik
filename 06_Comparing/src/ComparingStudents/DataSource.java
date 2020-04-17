
package ComparingStudents;

import java.util.Arrays;
import java.util.List;

public class DataSource {
 private static Student[] data = {
 new Student("Alice", "mala", 345),
 new Student("Bob","Velky", 123),
 new Student("Cyril", "Stredni",567)
 };
    
 public static Student[] loadDataAsArray(){
 return Arrays.copyOf(data, data.length);
 }   
    
  public static List<Student> loadDataAsList(){
  return Arrays.asList(data);
  }  
    
    
    
}
