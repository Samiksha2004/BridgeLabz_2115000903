import java.util.*;

abstract class JobRole {
    abstract String getRoleName();
    abstract void displayRole();
}

class SoftwareEngineer extends JobRole {
    private String candidateName;

    public SoftwareEngineer(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getRoleName() {
        return "Software Engineer";
    }

    public void displayRole() {
        System.out.println("Candidate: " + candidateName + " - Role: " + getRoleName());
    }
}

class DataScientist extends JobRole {
    private String candidateName;

    public DataScientist(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getRoleName() {
        return "Data Scientist";
    }

    public void displayRole() {
        System.out.println("Candidate: " + candidateName + " - Role: " + getRoleName());
    }
}

class ProductManager extends JobRole {
    private String candidateName;

    public ProductManager(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getRoleName() {
        return "Product Manager";
    }

    public void displayRole() {
        System.out.println("Candidate: " + candidateName + " - Role: " + getRoleName());
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        jobRole.displayRole();
    }

    public T getJobRole() {
        return jobRole;
    }
}

class ResumeProcessor {
    public static <T extends JobRole> Resume<T> process(T jobRole) {
        return new Resume<>(jobRole);
    }

    public static void processAll(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            role.displayRole();
        }
    }
}

public class AIDrivenResumeScreening {
    public static void main(String[] args) {
        SoftwareEngineer se = new SoftwareEngineer("Alice");
        DataScientist ds = new DataScientist("Bob");
        ProductManager pm = new ProductManager("Charlie");

        Resume<SoftwareEngineer> seResume = ResumeProcessor.process(se);
        Resume<DataScientist> dsResume = ResumeProcessor.process(ds);
        Resume<ProductManager> pmResume = ResumeProcessor.process(pm);

        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        List<JobRole> jobRoles = Arrays.asList(se, ds, pm);
        ResumeProcessor.processAll(jobRoles);
    }
}

