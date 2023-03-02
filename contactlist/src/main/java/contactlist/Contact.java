package contactlist;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
public class Contact 
  { 
	 
	static PrintStream prints = new PrintStream(new FileOutputStream(FileDescriptor.out));
	long phone;
	String name;
	String email;
	String printing = "List is empty";
	int count=0;
	Node head = null;    
    Node tail = head; 
    Node temp = head;
    public boolean check(String reference)
    {   
    	
    	tail =head;
    	while(!(reference.equals(tail.email)) && tail!=null )
        { 
            temp = tail;
            tail = tail.next; 
        }
    	if(tail.email.equals(reference))
    	{
    		return true;
    	}
    	else
    	{
    		prints.println("Name is not in the list");
    	return false;
    	}
    	
    }
    public boolean check(Long reference)
    {
    	
    	tail =head;
    	while((reference != tail.phone) && tail.next!=null)
        { 
            temp = tail;
            tail = tail.next; 
        }
    	if(tail.phone == reference)
    	{
    		return true;
    	}
    	else
    	{
    		prints.println("Number  is not in the list");
    	return false;
    	}
    }
    public void addNode(String name,long phone,String email) 
    {    
    	
        Node newNode = new Node(name,phone,email);  
        tail = head;
        if(head == null) {        
            head = newNode;    
            tail = head;           
        }    
        else {       
        	while(tail.next != null)
            {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = null;
        } 
        count++;
    } 
    public void remove()
    {   
    	tail = head;
    	if(head == null)
    	{    
    		prints.println(printing);    
        return;    
        }
    	if(head.next == null)
    	{
    		head=null;
    	}
    	else
    	{     
    	while(tail.next != null)
        {
            temp = tail;
            tail = tail.next;
        }
        temp.next = tail.next;
    	tail = tail.next;
    	}
    }
    
    public void removebymail(String mail)
    {    
        if(head == null) {    
        	prints.println(printing);           
        }  
        else
        {
        if(!check(mail))
   	 {
   		return; 
   	 }
        if(mail.equals(head.email) )
        {
        	head = head.next;
        }
        else
        {
        	tail = head;
       	 temp = head;
           
        while(!(mail.equals(tail.email)))
        { 
            temp = tail;
            tail = tail.next;
        }
        temp.next = tail.next;
        }
        
        }
    }
    public void removebynumber(Long num)
    {
    	tail = head;
        if(head == null) {    
        	prints.println(printing);            
        } 
        else
        {
        if(!check(num))
      	 {
      		return; 
      	 }
        if(num == head.phone)
        {
        	head = head.next;
        }
        else
        {
        while(num != tail.phone)
        { 
            temp = tail;
            tail = tail.next;
        }
        temp.next = tail.next; 
        }
       
        }
    }
    public void search(long number)
    {
    	 tail = head;
    	 temp = head;
       if(head == null) {    
    	   prints.println(printing);    
           return;    
       }
       
       if(check(number))
       {
        while(number != tail.phone)
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
        	prints.println(printing);         
        }  
        else
        {
        while(tail != null) {    
        	prints.println(tail.name + " " + tail.phone + " " + tail.email);    
            tail = tail.next;    
        } 
        }
    } 
    public static Long getinput()
    {   
    	Scanner sc = new Scanner(System.in);
    	Long phonenumber;
    	 do
		 {
			 try
			 {   sc = new Scanner(System.in);
				 phonenumber = sc.nextLong();
				 break; 
			 }
			 catch(InputMismatchException e)
			 {
				 prints.println(e);
				 prints.println("Re-Enter the phonenumber");
			 }
		 }while(true);
    	 return phonenumber;
    	
    }
	
    public static  void main(String[] args)
    {	
		Scanner sc = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
	 Contact a = new Contact();
	 String name;
	 long phonenumber;
	 String mail;
	 String choice;
	 prints.println("Enter the operation: Add , Remove ,Remove by phonenumber,Remove by name,Remove by Email, Search , display  ");
	 int option=0;
	 do
	 {	
		choice = sc.nextLine();
	 switch (choice)
	 {	 
	 case "Add":
		 prints.println("Enter the name,Email ,phone number of the contact:");
		 name= sc.nextLine();
		 mail = sc.nextLine();
		 phonenumber = getinput();
		 a.addNode(name, phonenumber, mail);
		 break;
	 case "Remove":
		 a.remove();
		 break;
	 case "Remove by phonenumber":
		 prints.println("Enter the phone number of the contact to remove:");
		 phonenumber = getinput();
		 a.removebynumber(phonenumber);
		 
		 break;
	 case "Remove by email":
		 prints.println("Enter the mail_id of the contact to remove:");
		 mail = sc.nextLine();
		 a.removebymail(mail);
		 break;
	 case "search":
		 prints.println("Enter the phone number of the contact to search:");
		phonenumber =getinput();
		 a.search(phonenumber);
		 break;
	 case "Display":
		 a.display();
		 break;
	default:
		prints.println("Enter the valid operation:");
		break;	  
	 } 
	 do
	 {
		 try
		 {   
			 s = new Scanner(System.in);
			 prints.println("press 0 to stop the operation or 1 to continue:");
			 option=s.nextInt();
			 break;
		 }
		 catch(InputMismatchException e)
		 {
			 prints.println(e);
		 }
	 }while(true);
	
	  
	 }while(option != 0);
		  
    }	
}
