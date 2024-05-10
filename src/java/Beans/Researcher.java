package Beans;

/**
 *
 * @author user
 */
public class Researcher {
    private String fName;
    private String lName;
    private String faculty;
    private String project;
    private int researcherId;
    private String department;
    private int collaboratorId;
    
    public void Researcher() {}
    
     public void Researcher(String fName, String lName, String project, String faculty, String department) {
         this.setfName(fName);
         this.setlName(lName);
         this.setProject(project);
         this.setFaculty(faculty);
         this.setDepartment(department);
    }
     
     /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the project
     */
    public String getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * @return the researcherId
     */
    public int getResearcherId() {
        return researcherId;
    }
    /**
     * @param researcherId the researcherId to set
     */
    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the collaboratorId
     */
    public int getCollaboratorId() {
        return collaboratorId;
    }

    /**
     * @param collaboratorId the collaboratorId to set
     */
    public void setCollaboratorId(int collaboratorId) {
        this.collaboratorId = collaboratorId;
    }
    
}
