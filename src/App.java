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
                    displayPosts();
                    break;
                case 6:
                    addPost();
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


    
    /**
     * The addPost function adds a post to the user's list of posts.
     * 
     */
    private static void addPost() {
        scan = new Scanner(System.in);
        System.out.println("Enter User Name");
        String userName = scan.nextLine();
        System.out.println("Enter Post Title");
        String postTitle = scan.nextLine();
        System.out.println("Enter video name");
        String videoName = scan.nextLine();
    
        users.find(new User(userName)).data.addPost(postTitle, videoName, 0);
    }


    
    /**
     * The displayPosts function displays all of the posts made by a user.
     * 
     */
    private static void displayPosts() {
        scan = new Scanner(System.in);

        System.out.println("Enter User Name");
        users.find(new User(scan.nextLine())).data.displayPosts();
        
    }


    
    /**
     * The addUser function allows the user to add a new User object to the users BST.
     * The function prompts for a username and profile description, then creates a new User object with those values.
     * Finally, it inserts that User into the users BST. 
     */
    private static void addUser(){

        scan = new Scanner(System.in);

        System.out.println("Enter User Name");
        String userName = scan.nextLine();
        System.out.println("Enter Profile Description");
        String profileDescription = scan.nextLine();

        users.insert(new User(profileDescription, userName));
        System.out.println("User Added!");      

    }

    
    /**
     * The deleteUser function allows the user to delete a user from the system.
     * The function prompts for a username, and then searches through the binary tree of users to find that username.
     * If it finds it, it deletes that node from the tree and prints out "User deleted".  Otherwise, if no such user is found in 
     * the system, we print out "User not found".  
     * 
     */
    private static void deleteUser(){
        scan = new Scanner(System.in);

        System.out.println("Enter User Name");
        String userName = scan.nextLine();
        
        BinaryTreeNode<User> user = users.delete(new User(userName), users.root);
        if (user!= null)
            System.out.println("User deleted");
        else
            System.out.println("User not found");      


    }

    
    /**
     * The findUser function allows the user to search for a specific user in the binary tree.
     * The function prompts the user to enter a username, and then searches through all of 
     * the users in order to find that specific one. If it is found, then it prints out its description;
     * otherwise, it prints out "User not found". 
     * 
     */
    private static void findUser(){

        scan = new Scanner(System.in);
        

        System.out.println("Enter User Name");
        String userName = scan.nextLine();
        
        BinaryTreeNode<User> user = users.find(new User(userName));
        if (user!= null)
            System.out.println(user.data.getDescription());
        else
            System.out.println("User not found");      

    }
    

    
    /**
     * The loadDataSet function reads in a text file containing information about users and their posts.
     * The function then creates new User objects for each user, and adds Posts to the Users' post BST.
     * 
     */
    private static void loadDataSet() throws IOException{
        // Load a list of users from a text file
        try{
            File data = new File("/home/jaredp/Documents/CSC2001F/Assignment 4/tiktok-clone/data/dataset.txt");
            BufferedReader br = new BufferedReader(new FileReader(data));
            String line;
            
            while ((line = br.readLine()) != null){

                // Create new User
                if (line.startsWith("Create")){
                    line = line.substring(7);
                    String userName = line.substring(0, line.indexOf(" "));
                    String description = line.substring(line.indexOf(" ") + 1); 
                    users.insert(new User(description, userName));
                }      
                // Add Post
                else if (line.startsWith("Add")){
                    line = line.substring(4);
                    String userName = line.substring(0, line.indexOf(" "));
                    
                    line = line.substring(line.indexOf(" ") + 1);
                    String video = line.substring(0, line.indexOf(" "));
                    
                    line = line.substring(line.indexOf(" ") + 1);
                    int numLikes = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                    
                 
                    String title = line.substring(line.indexOf(" ") + 1);
           
                    User targetUser = users.find(new User(userName)).data;
                    if (targetUser != null)
                        targetUser.addPost(title, video, numLikes);
                }
            }
            br.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error: Dataset not found");
        }

    }
}
