package hms;

public class patient {

private String Id;
private String Name,Contact;
public patient()
{
	Id=" ";
	this.Name=" ";
	this.Contact=" ";
}
public patient(String Id,String Name,String Contact)
{
	this.Id = Id;
	this.Name= Name;
	this.Contact=Contact;
}

public String getId() {
	return Id;
}

public void setId(String Id)
{
	this.Id=Id;
}

public String getName() {
	return Name;
}

public void setName(String Name)
{
	this.Name=Name;
}

public String getContact() {
	return Contact;
}

public void setContact(String Contact)
{
	this.Contact=Contact;
}

public String toString()
{
	return "patient("+"Id=" + Id +",Name="+Name+",Contact="+Contact+'}';
}

}
