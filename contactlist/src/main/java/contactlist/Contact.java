package contactlist;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
class Node{    
    String name;
    long phone;
    String email;   
    Node next;    
        
    public Node(String name,long phone,String email) {    
        this.name = name;  
        this.phone = phone;
        this.email = email;
        this.next = null;    
    }    
}
public class Contact 
  {
	static PrintStream prints = new PrintStream(new FileOutputStream(FileDescriptor.out));
	long phone;
	String name;
	String email;
	int cou=0;
	public Node head = null;    
    public Node tail = head; 
    public Node temp = head;
    public boolean check(String na,int count)
    {   
    	int x=0;
    	tail =head;
    	while(!(na.equals(tail.name)) && tail.next!=null)
        { 
            temp = tail;
            tail = tail.next; 
            if(count == x)
            {
            	return false;
            }
        }
    	if(tail.name.equals(na))
    	{
    		return true;
    	}
    	else
    	{
    		prints.println("Name is not in the list");
    	return false;
    	}
    	
    }
    public boolean check(Long c,int count)
    {
    	int x=0;
    	tail =head;
    	while(!(c.equals(tail.phone)) && tail.next!=null)
        { 
            temp = tail;
            tail = tail.next; 
            if(count == x)
            {
            	return false;
            }
        }
    	if(tail.name.equals(c))
    	{
    		return true;
    	}
    	else
    	{
    		prints.println("Name is not in the list");
    	return false;
    	}
    }
    public void addNode(String name,long phone,String email) 
    {    
    	
        Node newNode = new Node(name,phone,email);  
        tail = head;
        temp = head;
        if(head == null) {        
            head = newNode;    
            tail = newNode;
           
        }    
        else {       
        	while(tail.next != null)
            {
                temp = tail;
                tail = tail.next;
            }
            tail.next = newNode;
            temp = newNode;
            temp.next = null;
        } 
        cou++;
    } 
    public void remove()
    { 
    	if(head == null)
    	{    
    		prints.println("List is empty");    
        return;    
        }
    	if(head.next == null)
    	{
    		head=null;
    	}
    	else
    	{
    	tail = head;
        temp = null;
     
    	while(tail.next != null)
        {
            temp = tail;
            tail = tail.next;
        }
        temp.next = tail.next;
    	}
    }
    public void removebyname(String name)
    {
    	 String c=name;
    	   
    	 
        if(head == null) {    
        	prints.println("List is empty");       
        } 
        else
        {
        if(!check(name,cou))
   	 {
   		return; 
   	 }
        if(c.equals(head.name))
    	{
    		head=head.next;
    	}
        else
        { 
        	tail = head; 
       	    temp = head;
        while(!(c.equals(tail.name)))
        { 
            temp = tail;
            tail = tail.next;
        }
        temp.next = tail.next;  
        }
        prints.println("Contact " + tail.name + " got removed:");
        }
    }
    public void removebymail(String mail)
    {    
    	 String c=mail;
    	 
    	
        if(head == null) {    
        	prints.println("List is empty");    
               
        }  
        else
        {
        if(!check(mail,cou))
   	 {
   		return; 
   	 }
        if(c.equals(head.email) )
        {
        	head = head.next;
        }
        else
        {
        	tail = head;
       	 temp = head;
           
        while(!(c.equals(tail.email)))
        { 
            temp = tail;
            tail = tail.next;
        }
        temp.next = tail.next;
        }
        prints.println("Contact " + tail.name + " got removed:");
        }
    }
    public void removebynumber(Long num)
    {
    	 
        Long c=num;
        
        if(head == null) {    
        	prints.println("List is empty");    
               
        } 
        else
        {
        if(!check(num,cou))
      	 {
      		return; 
      	 }
        if(c.equals(head.phone))
        {
        	head = head.next;
        }
        else
        {
        	tail = head;
       	 temp = head;
        while(!(c.equals(tail.phone)))
        { 
            temp = tail;
            tail = tail.next;
        }
        temp.next = tail.next; 
        }
        prints.println("Contact " + tail.name + " got removed:");
        }
    }
    public void search(String na)
    {
    	 tail = head;
    	 temp = head;
       String c=na;
       if(head == null) {    
    	   prints.println("List is empty");    
           return;    
       }
       if(!check(c,cou))
     	 {
     		
     	 }
       else
       {
        while(!(c.equals(tail.name)))
        { 
            temp = tail;
            tail = tail.next;            
        }
        prints.println("Name :" + tail.name);
        prints.println("Ph_No:" + tail.phone);  
        prints.println("Email:" + tail.email);
       }
       
  }
    public void display() {      
        tail = head;    
            
        if(head == null) {    
        	prints.println("List is empty");    
              
        }  
        else
        {
        while(tail != null) {    
        	prints.println(tail.name + " " + tail.phone + " " + tail.email);    
            tail = tail.next;    
        } 
        }
    }   
	
	public static void main(String[] args)
    {	
		Scanner sc = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
	 Contact a = new Contact();
	 String n;
	 long ph;
	 String mail;
	 String ca;
	 prints.println("Enter the operation: Add , Remove ,Remove by phonenumber,Remove by name,Remove by Email, Search , display  ");
	 int c=0;
	 do
	 {	
		ca = sc.nextLine();
	 switch (ca)
	 {	 
	 case "Add":
		 prints.println("Enter the name,Email ,phone number of the contact:");
		 n= sc.nextLine();
		 mail = sc.nextLine();
		 ph =s.nextLong(); 
		 a.addNode(n, ph, mail);
		 break;
	 case "Remove":
		 a.remove();
		 break;
	 case "Remove by phonenumber":
		 prints.println("Enter the phone number of the contact to remove:");
		 Long number = s.nextLong();
		 a.removebynumber(number);
		 break;
	 case "Remove by name":
		 prints.println("Enter the Name of the contact to remove:");
		 String name = sc.nextLine();
		 a.removebyname(name);
		 break;
	 case "Remove by email":
		 prints.println("Enter the mail_id of the contact to remove:");
		 String email = sc.nextLine();
		 a.removebymail(email);
		 break;
	 case "search":
		 prints.println("Enter the name of the contact to search:");
		 String nam =sc.nextLine();
		 a.search(nam);
		 break;
	 case "Display":
		 a.display();
		 break;
	default:
		prints.println("Enter the valid operation:");
		break;	  
	 }
	 prints.println("press 0 to stop the operation or 1 to continue:");
	  c=s.nextInt();
	  
	 }while(c != 0);
		  
    }	
}
