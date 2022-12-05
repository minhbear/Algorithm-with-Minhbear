package Hashtable;

public class Node {
    String name;
    String dateOfBirth;
    String country;
    Node next;

    Node(String name, String dateOfBirth, String country){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        next = null; 
    }
}
