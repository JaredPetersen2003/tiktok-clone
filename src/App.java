import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {

    private static UserTree Users;

    public static void main(String[] args) throws Exception {
        
        Users = new UserTree();
        
        int choice;

        while (choice != 8){
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Find the profile description for a given account");
            System.out.println("2. List all accounts");
            System.out.println("3. Create an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Display all posts for a single account");
            System.out.println("6. Add a new post for an account");
            System.out.println("7. Load a file of actions from disk and process this");
            System.out.println("8. Quit");
            System.out.println("Enter your choice");
            
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextLine():
            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    Users.inOrderTraversal(Users.root);
                    break;
                case 3:
                    addUser()
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    loadDataSet();
                    break;
                case 8:
                    
                    break;
            
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }


    private static void addUser(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter User Name");
        String userName = scan.nextLine();
        System.out.println("Enter Profile Description");
        String profileDescription = scan.nextLine();

        Users.insert(new User(profileDescription, userName));
        System.out.println("User Added!")        

    }
    
    private static void loadDataSet(){
        // Load a list of users from a text file
        try{
            File data = new File("/home/jaredp/Documents/CSC2001F/Assignment 4/tiktok-clone/data/dataset.txt");
            Scanner scan = new Scanner(data);

        while (scan.hasNextLine()){

            String line = scan.nextLine();
            if (line.startsWith("Create")){
                line = line.substring(7);
                //System.out.println(line);
                String userName = line.substring(0, line.indexOf(" "));
                String description = line.substring(line.indexOf(" ") + 1); 
                Users.insert(new User(description, userName));
                
            }            
        }
        scan.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error: Dataset not found");
        }

    }
}
