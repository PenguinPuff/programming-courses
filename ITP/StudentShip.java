    package de.tum.cit.ase;

    import java.util.List;

    /**
     * This class represents a StudentShip which is a type of ContainerShip.
     * It contains a list of students and provides methods to manage these students.
     */
    public class StudentShip extends ContainerShip<Student> {
        private List<Student> students;

        /**
         * Constructs a new StudentShip with the given capacity, ship type, and list of students.
         *
         * @param capacity the capacity of the ship
         * @param students the list of students on the ship
         */
        public StudentShip(int capacity, List<Student> students) {
            super(capacity);
            this.students = students;
        }

        /**
         // Removes a student from the ship.
         //
         // @param student the student to be removed
         // @throws StudentNotFoundException if the student is not found on the ship
         **/

        public void throwStudentOut(Student student) throws StudentTypeNotFound {
            // TODO 2.1: create the StudentNotFoundException and implement this method
            if (!students.remove(student)){
                throw new StudentTypeNotFound("Student not found on the ship");
            }
        }

        /**
         * Allows a student to role-play depending on the student type
         *
         * @param student the student who is role-playing
         * @throws StudentTypeNotFound if the student type is not recognized
         */
        // Note: this method only covers the BusinessStudent and ComputerScienceStudent student types.
        // Every other student type should throw a StudentTypeNotFound exception.
        public void rolePlay(Student student) throws StudentTypeNotFound {
            // TODO 2.2: implement this method
            if (student instanceof BusinessStudent) {
                ((BusinessStudent) student).doBusiness();
            } else if (student instanceof ComputerScienceStudent) {
                ((ComputerScienceStudent) student).takeShower();
            } else {
                throw new StudentTypeNotFound();
            }
        }
        /**
         * Calculates the exam grade for a student based on the hours spent studying and the effort put into studying.
         *
         * @param student the student whose exam grade is being calculated
         * @param hoursSpentStudying the number of hours the student spent studying
         * @param effortPutIntoStudying the effort the student put into studying
         * @return the calculated exam grade
         */
        public static double calculateExamGrade(Student student, int hoursSpentStudying, double effortPutIntoStudying) {
            double grade = Math.random() * 4.0 + 1.0;
            return Math.round(grade * 10.0) / 10.0;
        }

    }