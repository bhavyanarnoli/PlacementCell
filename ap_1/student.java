import java.util.ArrayList;
import java.util.Scanner;
class Student extends Studentsss{
    String Name;
    int Rollno;
    float cgpa;
    String Branch;
    boolean isPlacedd;
    boolean isblocked;
    int ctc;
    boolean isoffered;
    boolean applied= false;
    Company placed;
    Scanner in= new Scanner(System.in);
    //one more arraylist of all offers to be made to say print all the offers you recieve from anyone
    
    Student(String name, int roll, float gpa, String Branch){

        this.Name= name;
        this.Rollno= roll;
        this.cgpa= gpa;
        this.Branch= Branch;
        this.isPlacedd= false;

    }
    
    public void getallavail(ArrayList<Company> c){
        for(Company s:c){
            if(s.registered.contains(this) && this.cgpa >= s.cgpa  && this.isblocked != true && this.isPlaced!=true ){
                this.applied= true;
                this.isoffered= true;
                this.placed=s;
                System.out.println("Companies Name - "+ s.Company);
                System.out.println("Companies Role being offered is - "+ s.Role);
                System.out.println("Companies registeration date is within "+s.starttime+ " to "+ s.endtime);
            }
            if(s.registered.contains(this) && this.cgpa >= s.cgpa  && this.isblocked != true && this.isPlacedd != false && this.ctc>= s.packagee ){
                this.applied= true;
                this.isoffered= true;
                this.placed=s;
                System.out.println("Companies Name - "+ s.Company);
                System.out.println("Companies Role being offered is - "+ s.Role);
                System.out.println("Companies registeration date is within "+s.starttime+ " to "+ s.endtime);
            }
            //check if they guy is placed and then compare the ctc as well
            else if(s.registered.contains(this)){
                System.out.println("Sorry " +this.Name+" try again next time" );
            }
            else{
                System.out.println("You didn't register for "+ s.Company);
            }
        }
        if(!this.applied!= true){
            System.out.println("You didn't apply for any of the companies ");
        }
    
    }
    public void applyforcompany(Company c){
        if(this.cgpa>= c.cgpa && this.isblocked != true && this.isPlaced!=true){
            this.applied= true;
            this.isoffered= true;
            this.placed= c;
        }
        if(this.cgpa >= c.cgpa  && this.isblocked != true && this.isPlacedd != false && this.ctc>= c.packagee ){
            this.applied= true;
            this.isoffered= true;
            this.placed=c;
        }

    }
    public void currentstatus(){
        if(this.isPlacedd ){
            System.out.println("He is currently working in this company");
            System.out.println("Companies Name - "+ this.placed.Company);
            System.out.println("Companies Role being offered is - "+ this.placed.Role);
            System.out.println("Companies registeration date is within "+this.placed.starttime+ " to "+ this.placed.endtime);
        }
        else if(this.isblocked){
            System.out.println("The student is blocked from the placement process");
        }
        else if(this.isoffered){
            System.out.println("He has been offered by this company");
            System.out.println("Companies Name - "+ this.placed.Company);
            System.out.println("Companies Role being offered is - "+ this.placed.Role);
            System.out.println("Companies registeration date is within "+this.placed.starttime+ " to "+ this.placed.endtime);
        }
        else{
            System.out.println("Unoffered");
        }
        }
    
    public void updatecgpa(){
        float gpa= in.nextFloat();
        this.cgpa= gpa;
        System.out.println("GO IN THE PLACEMENT CELL TO UPDATE YOUR GPA");
        //update via placement cell make one object in placement cell and pass it as argument
    }
    public void offerstatus(){
        if(isoffered== true){
            System.out.println("Congratulations, you have been selected by "+ this.placed.Company+ " for the role of "+ this.placed.Role);
            System.out.println("Please type y if you agree or type n");
            String x= in.next();
            if(x== "y"){
                this.isPlacedd= true;
                System.out.println("You have been placed!");
            }
            else{
                this.isPlacedd= false;
                System.out.println("Offer denied");
            }
        }
    }}

