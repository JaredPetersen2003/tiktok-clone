import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {

    private static UserTree Users;
    public static void main(String[] args) throws Exception {
        Users = new UserTree();
        loadDataSet();
        Users.inOrderTraversal(Users.root);
        
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
