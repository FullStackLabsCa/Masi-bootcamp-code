package io.reactivestax.school;

import java.util.Formatter;

public class PreSchool extends SchoolClass{

    @Override
    public Double chargeFees(Student student) {
        Formatter formatter = new Formatter();
        double fee = 0;
        if (age <= 5) {
            fee = 100 * 1.1;
            formatter.format("%.2f", fee);
        } else if (age > 5) {
            fee = 100 * 1.1+(100 * 1.1) * 0.25;
            formatter.format("%.2f", fee);

        }return fee;
    }
}

