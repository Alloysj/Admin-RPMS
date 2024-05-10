package Beans;

/**
 *
 * @author user
 */
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResearcherManager {
    private DataSource dataSource;

    public ResearcherManager() throws NamingException {
        InitialContext initContext = new InitialContext();
        dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/rpms");
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // retrieve all researchers
    public List<Researcher> getresearchers() throws SQLException {
        List<Researcher> researchers = new ArrayList<>();
        String sql = "SELECT * FROM researchers";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Researcher researcher = new Researcher();
                
                researcher.setResearcherId(rs.getInt("researcherId"));
                researcher.setfName(rs.getString("fName"));
                researcher.setlName(rs.getString("lName"));
                researcher.setProject(rs.getString("project"));
                researcher.setFaculty(rs.getString("faculty"));
                researcher.setDepartment(rs.getString("department"));
                // Set other fields...
                researchers.add(researcher);
            }
        }
        return researchers;
    }
     //insert researcher into database
    public void addResearcher(Researcher researcher) throws SQLException {
        String sql = "INSERT INTO researchers (fName, lName, faculty, department) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, researcher.getfName());
            stmt.setString(2, researcher.getlName());
            stmt.setString(3, researcher.getFaculty());
            stmt.setString(4, researcher.getDepartment());
            // 
            stmt.executeUpdate();
        }
    }
}

