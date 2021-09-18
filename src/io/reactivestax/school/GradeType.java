package io.reactivestax.school;

public enum GradeType {

        JK_GRADE("JK"),
        SK_GRADE("SK"),
        GRADE1("1"),
        GRADE2("2"),
        GRADE3("3"),
        GRADE4("4"),
        GRADE5("5"),
        GRADE6("6"),
        GRADE7("7"),
        GRADE8("8"),
        GRADE9("9"),
        GRADE10("10"),
        GRADE11("11"),
        GRADE12("12");

        private String getGradeType;

        GradeType(String gradeType){
            this.getGradeType =gradeType;
        }


        public static class Student{
                String studentID;
                String name;
                String age;
                GradeType grade;

                //No parameter constructor
                public Student() {
                }

                public Student(String name, String age, GradeType grade, String studentID) {
                    this.name = name;
                    this.age = age;
                    this.grade = grade;
                    this.studentID = studentID;
                }



                public String getStudentID() {
                    return studentID;
                }

                public void setStudentID(String studentID) {
                    this.studentID = studentID;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAge() {
                    return age;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public void setGrade(GradeType grade){
                    this.grade= grade;
                }

                public GradeType getGrade(){
                    return grade;
                }

                @Override
                public String toString() {
                    return "io.reactivestax.school.GradeType.Student{" +
                            "studentID='" + studentID + '\'' +
                            ", name='" + name + '\'' +
                            ", age=" + age +
                            ", grade='" + grade + '\'' +
                            '}';
                }
            }
}
