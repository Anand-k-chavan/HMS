package hms;

class Dnode
{
	Doctor Doctor;
	Dnode next,pre;
	public Dnode()
	{
		
	}
	
	public Dnode(Doctor Doctor)
	{
		this.Doctor = Doctor;
		next=null;
		pre=null;
	}
	
	
}

public class DoctorList {
	Dnode head,tail;
	
	public DoctorList()
	{
		head=null;
		tail=null;
	}
	
	public void Insert(Doctor Doctor) 
	{
		Dnode node = new Dnode(Doctor);
		
		if(head==null || tail==null)
		{
			head=node;
			tail=node;
		}
		
		else
		{
			head.next=node;
			node.pre=head;
			head=node;
		}
		
	}
	public Doctor searchByID(String id)
	{
		Dnode temp=head;
		while(temp!=null)
		{
			if(temp.Doctor.getId().equals(id))
			{
				return temp.Doctor;
			}
			
			temp=temp.pre;
		}
		return null;
	}
	
	
	public Doctor searchByContact(String contact)
	{
		Dnode temp=head;
		while(temp!=null)
		{
			if(temp.Doctor.getContact().equals(contact))
			{
				return temp.Doctor;
			}
			
			temp=temp.pre;
		}
		return null;
	}
	public int size()
	{
	Dnode temp=head;
	int count=0;
	while(temp!=null)
	{
		count++;
		temp=temp.pre;
	}
	return count;
		
	}
	
	
	public void AllDoctorInfo()
	{
		Dnode temp=head;
		while(temp!=null)
		{
			System.out.println("Doctor ID =" +temp.Doctor.getId()+"  Speciality ="+temp.Doctor.getSpeciality());
			
			temp=temp.pre;
		}
		
	}
	public void printdata()
	{
		Dnode temp=head;
		int count=0;
		while(temp!=null)
		{
			count++;
			System.out.println(count+":  "+temp.Doctor.toString());
			temp=temp.pre;
		}
	}
	public Doctor getAtIndex(int index)
	{
		Dnode temp=head;
		for(int i=0;i<index;i++)
		{
			temp=temp.pre;
		}
		
		return temp.Doctor;
	}
	
	
}
