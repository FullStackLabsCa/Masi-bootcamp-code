package io.reactivestax.school;

import java.text.DecimalFormat;

public class MiddleSchool extends SchoolClass {


    @Override
    public Double chargeFees(Student student) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if(student.getGrade().toString().equals("GRADE6")){
            fee= 100 * 1.75;

        }else if(student.getGrade().toString().equals("GRADE7")){
            fee=(100 * 1.75)+(100 * 1.75)*0.35;
        }
        else if(student.getGrade().toString().equals("GRADE8")){
            fee=((100 * 1.75)+(100 * 1.75)*0.35)+(((100 * 1.75)+(100 * 1.75)*0.35)*0.35);
        }
        return Double.valueOf(decimalFormat.format(fee));
    }
}

