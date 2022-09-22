import java.time.LocalDateTime;
import java.time.*;
import java.time.format.*;
import java.util.Scanner;
import java.util.ArrayList;

class data{
    static int companies;
    int avgpkg;
    static int numberapp;
    ArrayList<Company> regcompanies;
}

class Studentsss  {

    boolean isPlaced;
    boolean isblocked;
    int ctc=0;

}

class Institute{
    LocalDateTime opentime;//companies
    LocalDateTime endtime; //companies
    LocalDateTime opentimee; //students
    LocalDateTime endtimee; //students
}

class Placement {
    Scanner in= new Scanner(System.in);
    Institute s= new Institute();
    public void introduction(){
        System.out.println ("1) Open Student Registrations");
        System.out.println ("2) Open Company Registrations");
        System.out.println ("3) Get Number of Student Registrations");
        System.out.println ("4) Get Number of Company Registrations");
        System.out.println ("5) Get Number of Offered/Unoffered/Blocked Students");
        System.out.println ("6) Get Student Details");
        System.out.println ("7) Get Company Details");
        System.out.println ("8) Get Average Package");
        System.out.println("9) Get Company Process Results");
        System.out.println("10) Back");
    }
    public void Studreg(){
        
        System.out.println("Institute is open for student registerations for the Placement Drive");
        System.out.println("Fill in the details:-");
        System.out.println("1) Set the Opening time for Student registrations");
        String enterdatetime=in.nextLine();
        LocalDateTime enter= LocalDateTime.parse(enterdatetime);
        System.out.println("2) Set the Ending time for Student registrations.");
        String endtime=in.nextLine();
        LocalDateTime end= LocalDateTime.parse(endtime);
        
        s.opentime=enter;
        s.endtime= end;
        }

    public void companiesapplied(Company c){

        System.out.println("Enter the registeration date start");
        String dateStr= in.nextLine();
        LocalDateTime enter =  LocalDateTime.parse(dateStr);
        String end= in.nextLine();
        System.out.println("Enter the registeration date end");
        LocalDateTime endtime =  LocalDateTime.parse(dateStr);
        s.opentimee=enter;
        s.endtimee=endtime;
 
    }

    public void studentsapplied(data c){
        System.out.println("The total number of students that registered for placement drive are "+ c.numberapp);
    }   

    public void choosecompany(ArrayList<Company> companies){
        for(int i=0;i<companies.size();i++){
            System.out.println(i+1+ " "+ companies.get(i).Company);
        }  

        int inputt=   in.nextInt();

        System.out.println("Welcome "+ companies.get(inputt-1)); 
        System.out.println("1) Update Role") ;
        System.out.println("2)Update Package");
        System.out.println("3)Update CGPA criteria");
        System.out.println("4)Back");
        int input=in.nextInt();
        if(input==1){
            System.out.println("Enter the new role ");
            String ne= in.nextLine();
            updaterole(companies.get(input-1),ne);
        }
        else if(input==2){
            System.out.println("Enter the new package for this company");
            float newpac= in.nextFloat();
            updatepackage(companies.get(input-1),newpac);
        }
        else if(input==3){
            System.out.println("Enter the new cgpa criteria for the company");
            float gpa= in.nextFloat();
            updatecgpa(companies.get(input-1), gpa);
        }
        else if(input==4){
            System.out.println(LocalDateTime.now());
            System.out.println("Registered!!!");
            
        }

        //1. update role
        // 2. update package
        //3. update cgpa
        //4. register to institute drive
        //5 is back

    }
    public void updaterole(Company c, String newrole){
        c.Role= newrole;
    }
    public void updatepackage(Company c, float packagee){
        c.packagee=packagee;
    }
    public void updatecgpa(Company c, float cgpa){
        c.cgpa=cgpa;
    }

}
