/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComparingStudents;

import MyComparing.CompareInterface;
import java.util.Comparator;

/**
 *
 * @author HP
 */
public class CompareByFirstName implements Comparator<Student>{

    public CompareByFirstName() {
    }

    @Override
    public int compare(Student o1, Student o2) {
    return o1.getFirstName().compareTo(o2.getFirstName());
    }

    

    }
    

