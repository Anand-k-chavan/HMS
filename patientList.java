package hms;


class Pnode{
	patient patient;
	Pnode next,pre;
	
	
//	public Pnode() {
//		
//	}
	
	public Pnode(patient patient) {
		this.patient=patient;
		next=null;
		pre=null;
	}
	
}

public class patientList {

	Pnode head,tail;
	
	public patientList()
	{
	head=null;
	tail=null;
	}
	
	public void Insert(patient patient) {
		Pnode node = new Pnode(patient);
		
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
	
	
	public patient searchByID(String id)
	{
		Pnode temp=head;
		while(temp!=null)
		{
			if(temp.patient.getId().equals(id))
			{
				return temp.patient;
			}
			
			temp=temp.pre;
		}
		return null;
	}
	
	
	public int size()
	
	{
	Pnode temp=head;
	int count=0;
	while(temp!=null)
	{
		count++;
		temp=temp.pre;
	}
	return count;
		
	}
	
	public patient searchByContact(String contact)
	{
		Pnode temp=head;
		while(temp!=null)
		{
			if(temp.patient.getContact().equals(contact))
			{
				return temp.patient;
			}
			
			temp=temp.pre;
		}
		return null;
	}
	
	public void printdata()
	{
		Pnode temp=head;
		int count=0;
		while(temp!=null)
		{
			count++;
			System.out.println(count+":  "+temp.patient.toString());
			temp=temp.pre;
		}
	}
	public patient getAtIndex(int index)
	{
		Pnode temp=head;
		for(int i=0;i<index;i++)
		{
			temp=temp.pre;
		}
		
		return temp.patient;
	}
}
