package hms;

public class Checkup {
Doctor Doctor;
patient patient;
int priority;
String Recomendation,Date;

public Checkup(Doctor Doctor,patient patient,int priority,String Recomendation,String Date) {
	this.Doctor = Doctor;
	this.patient = patient;
	this.priority = priority;
	this.Recomendation = Recomendation;
	this.Date = Date;
	
}

public Doctor getDoctor() {
	return Doctor;
}

public void setDoctor(Doctor Doctor)
{
	this.Doctor=Doctor;
}
public patient getpatient() {
	return patient;
}

public void setpatient(patient patient)
{
	this.patient=patient;
}
public  int  getpriority() {
	return priority;
}

public void setpriority(int priority)
{
	this.priority=priority;
}
public String getRecomendation() {
	return Recomendation;
}

public void setRecomendation(String Recomendation)
{
	this.Recomendation=Recomendation;
}
public String getDate() {
	return Date;
}

public void setDate(String Date)
{
	this.Date=Date;
}
public String toString()
{
	return "Checkup(" + "DOctor =" + Doctor.toString() + ",patient=" + patient.toString() + 
			",priority=" + priority + ",Recomendation=" + Recomendation +",Date=" + Date+'}';
}

}
