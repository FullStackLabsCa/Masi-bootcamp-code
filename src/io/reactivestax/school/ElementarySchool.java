package io.reactivestax.school;
import java.text.DecimalFormat;

public class ElementarySchool extends SchoolClass {

    @Override
    public Double chargeFees(Student student) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        fee = 100 * 1.5;
        if (grade.equals("1")) {
            fee = 100 * 1.5;

        } else if (grade.equals("2")) {
            fee = (100 * 1.5) + (100 * 1.5) * 0.30;

        } else if (grade.equals("3")) {
            fee = ((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30);
        } else if (grade.equals("4")) {
            fee = (((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30)) + (((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30)) * 0.30;
        }else if(grade.equals("5")){
            fee=(((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30)) + (((100 * 1.5) + (100 * 1.5) * 0.30) + (((100 * 1.5) + (100 * 1.5) * 0.30) * 0.30)) * 0.30;
            fee= fee+fee*0.30;
        }
        return Double.valueOf(decimalFormat.format(fee));
    }
}
