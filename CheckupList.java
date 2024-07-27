package hms;

class Cnode{
	Checkup cu;
	Cnode next,pre;
	
	public Cnode(Checkup cu)
	{
		next=pre=null;
		this.cu=cu;
	}
}
public class CheckupList {

	Cnode head,tail;
	
	public CheckupList()
	{
		head=null;
		tail=null;
	}
	
	public void Enqueue(Checkup cu)
	{
		Cnode node=new Cnode(cu);
		
		if(head==null || tail== null)
		{
			head=node;
			tail=node;
		}
		
		else if(head.cu.getpriority() < cu.getpriority())
		{
			head.next=node;
			node.pre=head;
			head=node;
		}
		
		else if(tail.cu.getpriority() >= cu.getpriority())
		{
			tail.pre=node;
			node.next=tail;
			tail=node;
		}
		
		else 
		{
			 Cnode temp=tail;
			 
			 while(temp!=null)
			 {
				 if(temp.cu.getpriority() >= cu.getpriority())
				 {
					 break;
				 }
				 
				 temp=temp.next;
			 }
			 
			 node.next=temp;
			 node.pre=temp.pre;
			 temp.pre.next=node;
			 temp.pre=node;
		}
	}
	
	public Checkup dequeue() 
	{
	if(head==null)
	{
		return null;
		
	}
	
	Cnode checkup=head;
	head=head.next;
	return checkup.cu;
	}
	
	
	public void addRecomendation(int index,String rec)
	{
		Cnode temp=head;
		int i=0;
		while(temp!=null)
		{
			if(index==i)
			{
				temp.cu.setRecomendation(rec);
				break;
			}
			i++;
			
			temp=temp.pre;
		}
	}
	
	
	public patient getpatient(int index)
	{
		Cnode temp=head;
		int i=0;
		while(temp!=null)
		{
			if(index==i)
			{
				break;
			}
			i++;
			
			temp=temp.pre;
		}
		
		return temp.cu.getpatient();
		
	}
	
	public void print()
	{
		Cnode temp=head;
		while(temp!=null)
		{
			System.out.println(temp.cu.getpriority()+"  "+temp.cu.getRecomendation());
			temp=temp.pre;
		}
	}
	public int size()
	{
	Cnode temp=head;
	int count=0;
	while(temp!=null)
	{
		count++;
		temp=temp.pre;
	}
	return count;
	
	
}
	public Checkup getAtIndex(int index)
	{
		Cnode temp=head;
		for(int i=0;i<index;i++)
		{
			temp=temp.pre;
		}
		
		return temp.cu;
	}
	
}
