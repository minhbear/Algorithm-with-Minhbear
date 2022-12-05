package Hashtable;

// import java.util.ArrayList;

public class hashTable {
    // private final ArrayList<Node> hash = new ArrayList<>();
    // Declare Object array with fix lenght
    Node[] hash = new Node[11];

    // hashFunction
    // Algorithm: Sum of ASCII index of each character mod the lenght of array
    int hashFunction(String name) {
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            sum += name.charAt(i);
        }

        return sum % hash.length;
    }

    // Resolve collison
    // Use linklist
    void resolutionCollison(int index, Node infor) {
        if (hash[index] == null) {
            hash[index] = infor;
        } else {
            Node currNode = hash[index];
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = infor;
        }
    }

    // add object into array object
    void add(Node infor) {
        int index = hashFunction(infor.name);
        resolutionCollison(index, infor);
    }

    void printInformation(Node infor) {
        System.out.println("Name: " + infor.name);
        System.out.println("Date of Birth: " + infor.dateOfBirth);
        System.out.println("Country: " + infor.country);
    }

    // find value by hashFunction
    void findInfor(String name) {
        int index = hashFunction(name);
        if (hash[index].name.equalsIgnoreCase(name)) {
            System.out.println("Find success");
            printInformation(hash[index]);
        } else {
            Node currNode = hash[index];
            while (!currNode.name.equalsIgnoreCase(name) && currNode.next != null) {
                currNode = currNode.next;
            }
            if (currNode.name.equalsIgnoreCase(name)) {
                System.out.println("Find success");
                printInformation(currNode);
            } else {
                System.out.println("That name does not exist in array");
            }
        }
    }

    // print name
    void printHash() {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != null) {
                System.out.print(hash[i].name + " -> ");
                Node currNode = hash[i].next;
                while (currNode != null) {
                    System.out.print(currNode.name + " -> ");
                    currNode = currNode.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        hashTable hTable = new hashTable();
        Node infor1 = new Node("Bea", "19/04/2002", "English");
        Node infor2 = new Node("Tim", "19/05/2002", "Swedend");
        Node infor3 = new Node("Len", "19/06/2002", "Spain");
        Node infor4 = new Node("Moe", "19/07/2002", "Japan");
        Node infor5 = new Node("Mia", "19/08/2002", "India");
        Node infor6 = new Node("Sue", "19/09/2002", "English");
        Node infor7 = new Node("Zoe", "19/10/2002", "Vietnam");
        Node infor8 = new Node("Rae", "19/11/2002", "Thailand");
        Node infor9 = new Node("Lou", "19/12/2002", "English");
        Node infor10 = new Node("Max", "19/03/2002", "korea");
        Node infor11 = new Node("Tod", "19/02/2002", "English");
        hTable.add(infor1);
        hTable.add(infor2);
        hTable.add(infor3);
        hTable.add(infor4);
        hTable.add(infor5);
        hTable.add(infor6);
        hTable.add(infor7);
        hTable.add(infor8);
        hTable.add(infor9);
        hTable.add(infor10);
        hTable.add(infor11);
        // System.out.println("done");
        hTable.findInfor("Minh");
        // hTable.printHash();
    }
}
