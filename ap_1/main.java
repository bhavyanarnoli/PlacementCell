import java.time.LocalDateTime;
import java.util.*;
public class main{
    public static void main(String[] args) {
    int input=0;
    Scanner in= new Scanner(System.in);
    System.out.println("Welcome to FutureBuilder:");
    System.out.println(" 1) Enter the Application");
    System.out.println(" 2) Exit the Application");
    input= in.nextInt();
    int mainapp=0;
    ArrayList<Student> allstudents= new ArrayList();
    while(input!=2){
        System.out.println("Welcome to FutureBuilder:");
        System.out.println("  1) Enter the Application");
        System.out.println("  2) Exit the Application");
        input= in.nextInt();
        if(input==2){
            System.out.println("Thanks for Using FutureBuilder!!!!!!");
            break;
        }

        while(mainapp!=4){

            System.out.println("1)Enter as Student Mode");
            System.out.println("2) Enter as Company Mode");
            System.out.println("3) Enter as Placement Cell Mode");
            System.out.println("4) Return to Main Application");
            mainapp= in.nextInt(); // choose which mode you want to enter as
            data comp= new data();
            if(mainapp==3){
                
                // call the placement 
                Placement cell= new Placement();
                cell.introduction();
                int inp= in.nextInt();
                if(inp==1){
                    cell.Studreg();
                    
                }
                else if(inp==2){
                    String com= in.nextLine();
                    for(Company c: comp.regcompanies){
                        if(c.Company == com){
                            cell.companiesapplied(c);
                            break;
                }}}
                else if(inp==3){
                    System.out.println(comp.numberapp);

                }
                else if(inp==4){
                    System.out.println(comp.companies);

                }
                else if(inp==5){
                    // get number of offered / unoffered / block students
                    int isofe=0;
                    int isbl=0;
                    int isunof=0;
                    for(Student s: allstudents){
                        if(s.isoffered){
                            isofe+=1;                            
                        }
                        if(s.isblocked){
                            isbl+=1;
                        }
                        if(!s.isoffered){
                            isunof+=1;
                        }

                    }
                    System.out.println("Number of offered students  " + isofe );
                    System.out.println("Number  of blocked students "+ isbl);
                    System.out.println("Number  of unoffered students "+ isunof);

                }
                else if(inp==6){
                    // take name and roll no find student and check if name is there or not in companies regstudents
                    //call get avail from there
                    //get student details
                    String Name= in.nextLine();
  
                    int rolllnoo=in.nextInt();
                    
                    for(int i=0;i<allstudents.size();i++){
                        if( allstudents.get(i).Name== Name && allstudents.get(i).Rollno== rolllnoo){
                            for(int j=0;j<comp.regcompanies.size();j++){
                                if(comp.regcompanies.get(j).registered.contains(allstudents.get(i)) && comp.regcompanies.get(j).cgpa<=allstudents.get(i).cgpa && !allstudents.get(i).isblocked){
                                    System.out.println(allstudents.get(i).Name + " recieved an offer from "+comp.regcompanies.get(j).Company );
                                }
                                else if(comp.regcompanies.get(j).registered.contains(allstudents.get(i)) && comp.regcompanies.get(j).cgpa<=allstudents.get(i).cgpa && !allstudents.get(i).isblocked && allstudents.get(j).isPlacedd && 3*allstudents.get(i).ctc <= comp.regcompanies.get(j).packagee){
                                    System.out.println(allstudents.get(i).Name + " recieved an offer from "+comp.regcompanies.get(j).Company);}
                                else{
                                    System.out.println(allstudents.get(i)+ "didn't recieve an offer from "+ comp.regcompanies.get(j).Company);}
                            }
                            break;
                        }}}

                else if(inp==7){
                    //get company details
                    String nameofcomp= in.nextLine();
                    for(Company compppp: comp.regcompanies){
                        if( compppp.Company== nameofcomp ){
                            Company found= compppp;

                            System.out.println("Company Name "+ found.Company);
                            System.out.println("Company has offered a role for "+ found.Role);
                            System.out.println("Company's minimum cgpa cutoff "+ found.cgpa);
                            System.out.println("Company's package offered "+ found.packagee);
                            for(int j=0;j<found.registered.size();j++){
                                System.out.println(found.registered.get(j).Name);
                                System.out.println(found.registered.get(j).Rollno);
                            }
                            break;
                        }}}

                else if(inp==8){
                    int sum=0;
                    //Get Average Package
                    for(Company cd: comp.regcompanies){
                        sum+= cd.packagee;

                    }
                    System.out.println("Average Package is" + sum/comp.regcompanies.size());
                }
                else if(inp==9){
                    //Get Company Process Results
                    System.out.println("Enter the name of company");
                    String x= in.nextLine();
                    for(Company compppp: comp.regcompanies){
                        if( compppp.Company== x ){
                            Company found= compppp;
                            

                            System.out.println("The following students were selected/offered");
                            for(int j=0;j<found.registered.size();j++){
                                System.out.println(found.registered.get(j).Name);
                            }
                            break;
                        }
                    }
                }

            }
            if(mainapp==2){
                // company mode
                System.out.println("Choose the Company Query to perform-");
                System.out.println("1) Add Company and Details");
                System.out.println("2) Choose Company");
                System.out.println("3) Get Available Companies");
                System.out.println("4) Back");

                int inputofthis= in.nextInt();

                if(inputofthis==1){
                    System.out.println("You are welcome to the placement drive please fill the following details");
                    Company newcompany;
                    System.out.println("Enter Company Name");
                    System.out.println("Enter the name of the Company");
                    String Name= in.nextLine();
                    System.out.println("Enter the role of the company");
                    String Role= in.nextLine();
                    System.out.println("Enter the cgpa required ");
                    float cgpa= in.nextFloat(); 
                    System.out.println("Enter ctc for the role ");
                    float packagee= in.nextFloat();
                    Company c= new Company(Name, Role, packagee, cgpa);
                    comp.regcompanies.add(c);
                }
                else if(inputofthis==2){
                    //get selected students of any kind 
                    for( int i=0;i< allstudents.size();i++ ){
                        if(allstudents.get(i).isoffered){
                            System.out.println("Name " +allstudents.get(i).Name);
                            System.out.print("email-id " +allstudents.get(i).Name+ allstudents.get(i).Rollno+ "@iiitd.ac.in");
                            System.out.print("Roll No. " + allstudents.get(i).Rollno);

                        }
                    }
                }
                else if(inputofthis==3){
                    Placement plac= new Placement();
                    plac.choosecompany(comp.regcompanies);
                }}
               
    
            
            if(mainapp==1){
                // enter as a student 
                System.out.println("Choose the Student Query to perform-");
                System.out.println("1)Enter as a Student(Give Student Name, and Roll No.)");
                System.out.println("2) Add students");
                System.out.println( "3) Back");
                ArrayList<Student> students= new ArrayList();

                int mai= in.nextInt();

                if(mai==1){
                    //Choose student query to perform
                    String Name= in.nextLine();
                    int rollnumber= in.nextInt();
                    
                    for(Student s: students){
                        if(s.Name== Name && s.Rollno== rollnumber){
                            Student find = s;
                           
                        
                    
                    //Perform query on the student found       
                    System.out.println("1.Register for Placement Drive");
                    System.out.println("2.Register for Company");
                    System.out.println("3. Get All available companies");
                    System.out.println("4. Get Current Status");
                    System.out.println("5. Update CGPA");
                    System.out.println("6. Accept/Reject Offer");
                    int input2= in.nextInt();
                    
                    if(input2==1){
                        //Register for Placement Drive
                        System.out.println( find.Name  +  "Registered for the Placement Drive at IIITD!!!!");
                        System.out.println( "Your details are:");
                        System.out.println("Name:"+ find.Name);
                        System.out.println("RollNo:"+ find.Rollno);
                        System.out.println("CGPA:"+ find.cgpa);
                        System.out.println("Branch:"+ find.Branch);
                        }
                
                    if(input2==2){
                        System.out.println("Enter all the companies");
                        String com= in.nextLine();
                        for(Company c: comp.regcompanies){
                            if(c.Company == com){
                                c.registered.add(find);
                               
                                System.out.println("You're succesfully registered for "+ c.Role+ "at "+ c.Company );
                                break;
                            }
                        }
                        //Register for company
                    }
                    
                    if(input2==3){
                        System.out.println("List of All available companies is as follows:");
                        System.out.println("Company Name"+ find.placed.Company);
                        System.out.println("Company role offering:"+ find.placed.Role);
                        System.out.println("Company Package:"+ find.placed.packagee);
                        System.out.println("Company CGPA Criteria"+ find.placed.cgpa);

                        //get all available Companies
                    }
                    if(input2==4){
                        find.currentstatus();
                        //get current status
                    }
                    if (input2==5){
                        //done via placement cell'''''
                        //update cgpa

                    }
                    if(input2==6){
                        find.offerstatus();
                        //Accept/Reject Offer
                    } }
                    break;}  }


                if(mai==2){
                    System.out.println("Enter the number of students");
                    int inpt= in.nextInt();
                    for(int i=0;i<inpt;i++){
                        
                        System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
                        String name= in.nextLine();
                        int rollno= in.nextInt();
                        float gpa= in.nextFloat();
                        String branch= in.nextLine();
                        Student soo= new Student(name,rollno,gpa,branch);
                        System.out.println(LocalDateTime.now());
                        students.add(soo);
                        allstudents.add(soo);
                    }
                }         
        }
    }

}
}
}
    
        
                



