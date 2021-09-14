import io.reactivestax.school.*;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    //Test Case for preSchool
    @Test
    public void testFeeCalculationforPreSchool(){
        PreSchool preSchool= new PreSchool();
        Student student= new Student("Robin","4",GradeType.JK_GRADE,"110",SchoolType.PRE_SCHOOL);
        double fee= preSchool.chargeFees(student);
        System.out.println(fee);
        Assert.assertTrue(fee==110);
    }


    //Test case for Elementary School
    @Test
    public void testFeeCalculationforElementarySchool(){
        ElementarySchool elementarySchool= new ElementarySchool();
        Student student= new Student("Brijesh","6", GradeType.GRADE2,"110", SchoolType.ELEMENTARY_SCHOOL);
        double fee= elementarySchool.chargeFees(student);
        Assert.assertTrue(fee==195);
    }

    //Test case for Middle School
    @Test
    public void testFeeCalculationforMiddleSchool(){
        MiddleSchool middleSchool= new MiddleSchool();
        Student student= new Student("Brijesh","11",GradeType.GRADE7,"110",SchoolType.MIDDLE_SCHOOL);
        double fee= middleSchool.chargeFees(student);
        Assert.assertTrue(fee==236.25);
    }


    //Test cases for High School
    @Test
    public void testFeeCalculationForHigh(){
        HighSchool highSchool = new HighSchool();
        Student student= new Student("Maninder","14",GradeType.GRADE9,"100",SchoolType.HIGH_SCHOOL);
        double fee= highSchool.chargeFees(student);
        Assert.assertTrue(fee==200);
    }

    @Test
    public void testFeeCalculationForHigh2(){
        HighSchool highSchool = new HighSchool();
        Student student= new Student("Maninder","14",GradeType.GRADE10,"100",SchoolType.HIGH_SCHOOL);
        double fee= highSchool.chargeFees(student);
        Assert.assertTrue(fee==290);
    }
}
