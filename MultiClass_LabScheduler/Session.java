/**
 * Project 02 --TimeKeeper
 *
 * This program helps you find your CS lab
 *
 * @author Katie O'Daniel,
 *
 * @version June 15, 2023
 *
 */
public class Session {
    private  String name;
    private int enrollment;

    public Session(String name, int enrollment) {
        this.name = name;
        this.enrollment = enrollment;
    }
    public Session() {
        name = "";
        enrollment = 0;
    }

    public String getName() {
        return name;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public String toString() {
        return "Session{Name - " + name + ", Enrollment - " + enrollment + "}";
    }
}