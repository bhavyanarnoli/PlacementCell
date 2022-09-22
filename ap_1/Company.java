import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

class companydetails {
    float packagee;
    float cgpa;
    boolean isregistered;
    LocalDateTime starttime;
    LocalDateTime endtime;
    
    ArrayList<Student> registered;
}

class Company extends companydetails {

    String Company;
    String Role;
    Scanner in = new Scanner(System.in);
    Company(String Company, String Role, float packagee, float cgpa){
        this.Company= Company;
        this.Role= Role;
        this.packagee=packagee;
        this.cgpa=cgpa;
        }
       
}

