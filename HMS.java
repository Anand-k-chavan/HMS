package hms;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter; 

public class HMS {

		
		static patientList plist = new patientList();
		
		static DoctorList dlist = new DoctorList();
		public static void main(String[] args) {
		
			readPFile();
			
			readDFile();
		Scanner s = new Scanner(System.in);
		
		String choice;
		
		while(true)
		
		{
			
			MainMenu();
			System.out.println("Enter your choice:");
			choice = s.nextLine();
			if(choice.equals("1"))
				
			{
				System.out.println("\n Doctor ID:");
				String id = s.nextLine();
				
				System.out.println("\n Doctor Name:");
				String name = s.nextLine();
				
				System.out.println("\n Doctor Contact:");
				String contact = s.nextLine();
				
				System.out.println("\n Doctor Speciality:");
				String speciality = s.nextLine();
				
				System.out.println("\n Doctor fees:");
				int  fees = s.nextInt();
				s.nextLine();
				
				Doctor d = new Doctor(id,name,contact,speciality,fees);
				
				dlist.Insert(d);
				
			}
			
			if(choice.equals("2"))
				
			{
				System.out.println("\n Patient ID:");
				String id = s.nextLine();
				
				System.out.println("\n Patient Name:");
				String name = s.nextLine();
				
				System.out.println("\n Patient Contact:");
				String contact = s.nextLine();
				patient patient = new patient(id,name,contact);
				plist.Insert(patient);
				
			}
			
			if(choice.equals("3"))
			{
				dlist.printdata();
			}
			if(choice.equals("4"))
			{
				plist.printdata();
			}
			if(choice.equals("5"))
			{
				System.out.println("\n***WELCOME TO CHECKUP MENU***\n");
				
				CheckupList[] clist = new CheckupList[dlist.size()];
				
				for (int i =0;i<clist.length;i++)
				{
					clist[i] = new CheckupList();
					Doctor doctor = dlist.getAtIndex(i);
					System.out.println("\nEnter patient for Doctor: ");
					System.out.println("Name          :"+doctor.getName());
					System.out.println("Speciality    :"+doctor.getSpeciality());
					System.out.println("Fees          :"+doctor.getFees());
					
					System.out.println("All patients are:");
					plist.printdata();
					
					
					while(true)
					{
						System.out.println("Enter patient ID type null to stop:");
						String id= s.nextLine();
						
						if(id.equals("null"))
						{
							break;
						}
						
						System.out.println("Priority 3 For EMERGENCY 2 For INTERMEDIATE any other key are NORMAL");
						
						String per = s.nextLine();
						int p=1;
						
						if(per.equals("3"))
						{
							p=3;
						}
						
						else if(per.equals("2"))
						{
							p=2;
						}
						
						patient patient = plist.searchByID(id);
						if(patient==null)
						{
							System.out.println("\nInvalid patient ID!...");
						}
						
						else 
						{
							Checkup cup = new Checkup(doctor,patient,p,"","");
							
							clist[i].Enqueue(cup);
						}
					
					}
				
				
						
					
				}
				
				for(int i=0;i<clist.length;i++)
				{
					System.out.println("\n\n Patient "+(i+1)+" in Queue for Doctor  " +dlist.getAtIndex(i).getName());
					for(int j=0;j<clist[i].size();j++)
					{
						
						
						System.out.println("Enter Recomendation for patient:"+clist[i].getpatient(j));
						String rec=s.nextLine();
						clist[i].addRecomendation(i, rec);
					}
				}
                try{
                    String data="";
                    for(int i=0;i<clist.length;i++)
                    {
                        for(int j=0;j<clist[i].size();j++)
                        {
                            Checkup cup = clist[i].getAtIndex(j);
                            if(cup==null)
                            {
                                break;
                            }
                            data+=cup.getDoctor().getId()+";"+cup.getDoctor().getName()+";"+cup.getpatient().getId()+";"+cup.getDoctor().getName()
                            +";"+cup.getRecomendation()+";"+cup.getDate()+"\n";
                        }
                    }
                    FileWriter myWriter = new FileWriter("prec.txt");
                    myWriter.close();
                    System.out.println("Save data to file");
                }catch(IOException e)

                {
                    System.out.println("An error occured");
                    e.printStackTrace();
                }
				
				
			}
			if(choice.equals("0"))
			{
				break;
			}
		
		}
			
	}

		
	
	
	

	public static void MainMenu()
	{
		System.out.println("\n\n ||  *****HOSPITAL MANAGEMENT SYSTEM*****  ||  ");
		System.out.println("           || MAIN MENU   ||");
		System.out.println("\nEnter 1 for Insert new doctor:");
		System.out.println("\nEnter 2 for Insert patient  ");
		System.out.println("\nEnter 3 for print all doctor  ");
		System.out.println("\nEnter 4 for print all patient  ");
		System.out.println("\nEnter 5 for checkup menu  ");
		System.out.println("\nEnter 0 for exit  ");
	}


    private static void writeDFile()
    {
        try{
            String data="";
            for(int i=0;i<dlist.size();i++)
            {
                Doctor doc = dlist.getAtIndex(i);
                data+=doc.getId()+";"+doc.getName()+";"+doc.getContact()+";"+doc.getSpeciality()+";"+doc.getFees()+"\n";
            }
            FileWriter myWriter = new FileWriter("ddata.txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully added records.");
        }catch(IOException e)
        {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    private static void readDFile()
    {
        try{
            File myobj = new File("C:\\Users\\nagesh\\Desktop\\javafiles");
            Scanner myreader = new Scanner(myobj);
            while(myreader.hasNextLine())
            {
                String data = myreader.nextLine();
                if(data.length()>5)
                {
                    String[] cus = data.split(";");
                    dlist.Insert(new Doctor(cus[0],cus[1],cus[2],cus[3],Integer.parseInt(cus[4])));

                }

            }
            myreader.close();
        }catch(FileNotFoundException e)
        {
            System.out.println("An error occuered");
            e.printStackTrace();
        }
    }
    private static void writePFile()
    {
        try{
            String data="";
            for(int i=0;i<plist.size();i++)
            {
                patient poc = plist.getAtIndex(i);
                data+=poc.getId()+";"+poc.getName()+";"+poc.getContact()+"\n";
            }
            FileWriter myWriter = new FileWriter("pdata.txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully added records.");
        }catch(IOException e)
        {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
    private static void readPFile()
    {
        try{
            File myobj = new File("C:\\Users\\nagesh\\Desktop\\javafiles");
            Scanner myreader = new Scanner(myobj);
            while(myreader.hasNextLine())
            {
                String data = myreader.nextLine();
                if(data.length()>5)
                {
                    String[] cus = data.split(";");
                    dlist.Insert(new Doctor(cus[0],cus[1],cus[2],cus[3],Integer.parseInt(cus[4])));

                }

            }
            myreader.close();
        }catch(FileNotFoundException e)
        {
            System.out.println("An error occuered");
            e.printStackTrace();
        }
    }
}   