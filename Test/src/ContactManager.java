import java.util.Scanner;


public class ContactManager {

    public static void main (String [] args){

        //System.out.println("Hello World")
        //ContactsManagerClass book = new ContactsManagerClass();
        //Contact Jay = new Contact("Jay", "8138138131");
        //System.out.println(book.friendsNum);
        //book.add(Jay);
        //book.view();
        //book.search("Jay");
        Scanner intScanner = new Scanner(System.in);
        System.out.println("How many people would you like to add?");
        Integer numContacts = intScanner.nextInt();
        takingInput(numContacts);
    }
    static void takingInput(int numInput){
        System.out.println("Hello welcome to the contact program");
        Scanner scanner = new Scanner(System.in);
        int Counter = 0;
        ContactsManagerClass manager = new ContactsManagerClass(numInput);
        do {
            Counter += 1;
            System.out.println("Print your name");
            String name = scanner.nextLine();
            System.out.println("\n");
            System.out.println("Type in your phone number");
            String phone = scanner.nextLine();
            System.out.println("\n");
            manager.add(new Contact(name, phone));
        } while (Counter < numInput);
        System.out.println("Finished");
        manager.view();
    }
}

class Contact{
    private String contactName;
    private String phoneNumber; //doing this will allow making contactName and phoneNumber not modifiable
    public Contact(String inputName, String phoneNum){
        this.contactName = inputName;
        this.phoneNumber = phoneNum;
    }
    public String returnName(){

        return contactName;
    }
    public String returnNum(){

        return phoneNumber;
    }
    //these public functions are used in order to access private variables for outside classes
    //these are called GETTERS
}

class ContactsManagerClass{
    int friendsNum;
    Contact [] myFriends;
    ContactsManagerClass(int ContactNum){
        this.friendsNum = 0;
        this.myFriends = new Contact[ContactNum];
    }
    void add(Contact person){
        myFriends[friendsNum] = person;
        friendsNum += 1;
    }
    void view(){
        for(int i = 0; i <friendsNum; i++)
        {
            System.out.println(myFriends[i].returnName() + " " + myFriends[i].returnNum());
        }

    }
    Contact search(String searchTarget){
        for(int i = 0; i < friendsNum; i++){
            if(myFriends[i].returnName().equals(searchTarget)) {

                System.out.println(searchTarget + " exists");
            }

        }
        return null;
    }
}