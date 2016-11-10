import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class LRUCache {

	static HashMap<Integer,Node> map;
	static Queue q;
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("\t\tThe LRU Cache Implementation \n\t\t____________________________");
		System.out.println("\nEnter the Cache capacity:");
		Scanner sc=new Scanner(System.in);
		int cap=sc.nextInt();
		int choice,page;
		map =new HashMap<Integer,Node>();
		q=new Queue(cap);
		while(true)
		{
			System.out.println("\n1. Request a page \n2. Show queue\n3. Exit");
			choice=sc.nextInt();
			System.gc();
			switch(choice)
			{
			case 1:
				System.out.println("\nEnter page number:");
				page=sc.nextInt();
				get(page);
				break;
			
			case 2:
				System.out.println("\nCurrent queue values:");
				q.display();
				break;
			case 3:
				System.out.println("Bye!");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice! Renter :");
				
			}
		}
		
		
	}
	public static void set(int key,Node val)
	{
		map.put(key, val);
	}
	public static void get(int key)
	{
	
		if(map.containsKey(key))
		{
			System.out.println("Page Hit!");
			Node n=map.get(key);
			
			
			if(q.size>=2)
			{
			q.remove(n);
			q.addFront(n);
			set(key,q.front);
			}
			System.out.println("Cache : ");
			q.display();
		}
		else
		{
			System.out.println("Page Fault!");
			Node n=new Node();
			n.data=key;
			
			if(q.isEmpty())
			{
				q.add(n);
			}
			else
			{
				if(q.exceedCapacity())
				{
					map.remove(q.rear.data);
					q.removeRear();
					
				}
				q.addFront(n);
			}
			set(key,n);
			System.out.print("Cache: ");
			q.display();
		}
	}

}
 class Node
{
int data;
Node next,prev;
	Node()
	{
		data=0;
		next=prev=null;
	}
}

 class Queue
{
	Node front,rear;
	int capacity,size;
	Queue(int cap)
	{
		capacity=cap;
		size=0;
	}
	public void add(Node n)
	{
		if(!exceedCapacity())
		{
			if(front==null && rear==null)
			{
				front=rear=n;
				
			}
			else
			{
				rear.next=n;
				n.prev=rear;
				n.next=null;
				rear=n;
				
			}
			size++;
		}
		
	}
	
	public void remove(Node n)
	{
	
		if(size>0)
		{
			if(size==1)
			{
				front=rear=null;
				size--;
				
			}
			else
			{
				if(n.next == front.next)
				{
					removeFront();
				}
				else
					if(n.prev == rear.prev)
					{
						removeRear();
					}
				
					else
					{
						Node prev=n.prev;
						Node next=n.next;
						prev.next=next;
						next.prev=prev;
						size--;
						
					}
			}
			
		}
		else
		{
			System.out.println("Empty!");
		}
		
		
	}
	public void removeFront()
	{
		if(front.next!=null)
		{
			front=front.next;
			front.prev=null;
		}
		else
		{
			front=rear=null;
		}
		size--;
	}
	public void removeRear()
	{
		if(rear.prev!=null)
		{
			rear=rear.prev;
			rear.next=null;
		}
		else
		{
			front=rear=null;
		}
		size--;
	}
	public void addFront(Node n)
	{
		if(!exceedCapacity())
		{
		front.prev=n;
		n.next=front;
		front=n;
		size++;
		}
		
	}
	
	public boolean exceedCapacity()
	{
		if(size>=capacity)
		{
			return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		return false;
	}
	public void display()
	{
		System.out.print("[ ");
		Node temp;
		temp=front;
		while(temp!=null)
		{
			System.out.print(temp.data+"  ");
			temp=temp.next;
		}
		
		System.out.println("]");
		
	}
	
}