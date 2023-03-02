package contactlist;

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
