package io.reactivestax.school.types;
public enum SchoolType {
    PRE_SCHOOL("PreSchool"),
    ELEMENTARY_SCHOOL("ElementarySchool"),
    MIDDLE_SCHOOL("MiddleSchool"),
    HIGH_SCHOOL("HighSchool");

    private String school_name;
    SchoolType(String school_name) {
        this.school_name=school_name;
    }
}