/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyComparing;

import ComparingStudents.Student;

/**
 *
 * @author HP
 */
public class PorovnavacStudentByNumber implements CompareInterface {

    @Override
    public boolean isBigger(CompareInterface o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean bigger(Object o1, Object o2) {
      return  ((Student)o1).getStudentNumber() > ((Student)o2).getStudentNumber();
    }
    
}
