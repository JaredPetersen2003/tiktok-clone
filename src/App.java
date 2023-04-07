import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {

    private static BinarySearchTree<User> users;
    static Scanner scan;

    public static void main(String[] args) throws Exception {
        
        
        users = new BinarySearchTree<>();
        
        int choice = 0;
        scan = new Scanner(System.in);

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
            
            
            
            try {
                choice =  Integer.parseInt(scan.nextLine()) ;
            } catch (Exception e) {
                // TODO: handle exception
            }
            switch (choice) {
                case 1:
                    findUser();
                    break;
                case 2:
                    users.inOrder(users.root);
                    break;
                case 3:
                    addUser();
                    
                    break;
                case 4:
                    deleteUser();
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

        scan.close();
    }


    private static void addUser(){

        scan = new Scanner(System.in);

        System.out.println("Enter User Name");
        String userName = scan.nextLine();
        System.out.println("Enter Profile Description");
        String profileDescription = scan.nextLine();

        users.insert(new User(profileDescription, userName));
        System.out.println("User Added!");      

    }

    private static void deleteUser(){
        scan = new Scanner(System.in);

        System.out.println("Enter User Name");
        String userName = scan.nextLine();
        
        BinaryTreeNode<User> user = users.delete(new User(null, userName), users.root);
        if (user!= null)
            System.out.println(user.data.getDescription());
        else
            System.out.println("User not found");      


    }

    private static void findUser(){

        scan = new Scanner(System.in);
        

        System.out.println("Enter User Name");
        String userName = scan.nextLine();
        
        BinaryTreeNode<User> user = users.find(new User(null, userName));
        if (user!= null)
            System.out.println(user.data.getDescription());
        else
            System.out.println("User not found");      

    }
    
    private static void loadDataSet() throws IOException{
        // Load a list of users from a text file
        try{
            File data = new File("/home/jaredp/Documents/CSC2001F/Assignment 4/tiktok-clone/data/dataset.txt");
            BufferedReader br = new BufferedReader(new FileReader(data));
            while (br.readLine() != null){

                String line = br.readLine();
                if (line.startsWith("Create")){
                    line = line.substring(7);
                    String userName = line.substring(0, line.indexOf(" "));
                    String description = line.substring(line.indexOf(" ") + 1); 
                    users.insert(new User(description, userName));
                }            
        
            }
            br.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error: Dataset not found");
        }

    }
}
