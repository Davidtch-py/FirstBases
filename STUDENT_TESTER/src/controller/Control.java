package controller;

import model.Student;
import view.Iomanager;

public class Control {
    private Iomanager io ;

    public Control() {
        io = new Iomanager();
    }

    public void init() {
        Student student = new Student(null, 0);

        // io.showMessage(student.fibonacci());
        // io.showMessage(student.factorial((float)5)+"");
        // io.showMessage(student.countCharacters("cacao"));
        // io.showMessage(student.toBase(4, 4));
        // io.showMessage(student.toHex(10, 1010));
        // io.showMessage(student.powerinn(10, 0)+"");
        io.showMessage(student.magicNumber(370)+"");
        // io.showMessage(student.toDouble("30")+"");
        io.showMessage(student.toDouble("+65.723")+"");
    }
    
}
