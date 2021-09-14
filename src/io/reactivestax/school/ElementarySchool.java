package io.reactivestax.school;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ElementarySchool extends SchoolClass {

    @Override
    public Double chargeFees(Student student) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        fee = 100 * 1.5;
        if (student.getGrade().toString().equals("GRADE1")) {
            fee = 100 * 1.5;
            System.out.println(fee);

        } else if (student.getGrade().toString().equals("GRADE2")) {
            fee = (100 * 1.5) + (100 * 1.5) * 0.30;

        } else if (student.getGrade().toString().equals("GRADE3")) {
            fee = ((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30);
        } else if (student.getGrade().toString().equals("GRADE4")) {
            fee = (((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30)) + (((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30)) * 0.30;
        }else if(student.getGrade().toString().equals("GRADE5")){
            fee=(((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30)) + (((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30)) * 0.30;
            fee= fee+fee*0.30;
        }
        return Double.valueOf(decimalFormat.format(fee));
    }
}