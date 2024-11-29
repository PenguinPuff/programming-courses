package de.tum.cit.ase;

public class BusinessStudent extends Student {
    public BusinessStudent(String name, String studentId) {
        super(name, studentId);
    }

    public void doBusiness() {
        System.out.println("I'm soㅤbusy!");
    }

}
