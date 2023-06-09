import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Tiktok clone with GUI
 * 
 * @author Jared Petersen
*/
public class TokTik{

    static JFrame frame;
    private static BinarySearchTree<User> users;

    public static void main(String[] args) throws NumberFormatException, IOException {
        users = new BinarySearchTree<>();
        
        //JFrame set up
        frame = new JFrame("TokTik");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        
        //JMenu set up
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem loadUsers = new JMenuItem("Load Users");

        // Manually load a list of users and post from a file
        loadUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showOpenDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        loadDataSet(fileChooser.getSelectedFile());
                        JOptionPane.showMessageDialog(frame, "File loaded successfully");
                    }
                    else
                        JOptionPane.showMessageDialog(frame, "Cancelled");

                    
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        fileMenu.add(loadUsers);

        frame.add(BorderLayout.NORTH, menuBar);

        // Text Area
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(scroll);


        // Button panel
        JPanel panel = new JPanel();
        JButton listUsers = new JButton("List Users");
        JButton addUser = new JButton("Add User");
        JButton addPost = new JButton("Add Post");
        JButton deleteUser = new JButton("Delete User");
        JButton findUser = new JButton("Find User");

        findUser.addActionListener(new ActionListener() {
            
            /**
             * The actionPerformed function is called when the user clicks on the "Find User" button.
             * It prompts the user to enter a username, and then searches for that username in our list of users.
             * If it finds a match, it displays all of that user's posts in chronological order (oldest first).
             */
            @Override
            public void actionPerformed(ActionEvent e){
                textArea.setText(null);

                String userName = JOptionPane.showInputDialog(frame, "Please enter username", "Find User", JOptionPane.QUESTION_MESSAGE);
                try {
                    User targetUser = users.find(new User(userName)).data;
                    textArea.append("User: " + targetUser.getAccountName() + "\n");
                    textArea.append("Description: " + targetUser.getDescription()+ "\n");
                    textArea.append("==========================================\n");
                    textArea.append("Posts:\n\n");
                    targetUser.displayPosts(textArea);
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
    
            }
        });

        

        deleteUser.addActionListener(new ActionListener() {
            
            /**
             * The actionPerformed function is called when the user clicks on the "Delete User" button.
             * It prompts the user to enter a username, and if that username exists in TokTik's database, it deletes it.
             */
            @Override
            public void actionPerformed(ActionEvent e){

                String userName = JOptionPane.showInputDialog(frame, "Please enter username", "Delete User", JOptionPane.QUESTION_MESSAGE);

                if (TokTik.users.find(new User(userName)) != null){
                    TokTik.users.delete(new User(userName), users.root);
                    JOptionPane.showMessageDialog(frame, "User Deleted");
                }
                else
                JOptionPane.showMessageDialog(frame, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
            }            
        });

        addPost.addActionListener(new ActionListener() {
            
            /**
             * The actionPerformed function is called when the user clicks on the "Add Post" button.
             * It prompts for a username, and if that user exists, it prompts for a title and video URL.
             * If both of those are entered correctly, then it adds a post to that user's profile with 
             * the given title and video URL. Otherwise an error message is displayed. 
             */
            @Override
            public void actionPerformed(ActionEvent e){

                String userName = JOptionPane.showInputDialog(frame, "Please enter username", "Add Post", JOptionPane.QUESTION_MESSAGE);

                if (TokTik.users.find(new User(userName)) != null){

                    JTextField titleField = new JTextField();
                    JTextField videoField = new JTextField();;
    
                    String message1 = "Please Enter Title";
                    String message2 = "Please Enter Video";

                    int result = JOptionPane.showOptionDialog(frame, new Object[] {message1, titleField, message2, videoField},
                    "Add Post", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if (result == JOptionPane.OK_OPTION){
                        if (!titleField.getText().isEmpty() && !videoField.getText().isEmpty()){
                            TokTik.users.find(new User(userName)).data.addPost(titleField.getText(), videoField.getText(), 0);
                            JOptionPane.showMessageDialog(frame, "Post added", "Confirmation", JOptionPane.PLAIN_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(frame, "Cannot have empty fields", "Error", JOptionPane.ERROR_MESSAGE);

                    }
    
                }
                else
                    JOptionPane.showMessageDialog(frame, "User not found");
            }            
        });

        addUser.addActionListener(new ActionListener() {
            /**
             * The actionPerformed function is called when the user clicks on the "Add User" button.
             * It creates a new JTextField for both username and description, then prompts the user to enter their desired username and description.
             * If they click OK, it adds a new User object with those values to TokTik's users list.
             */
            @Override
            public void actionPerformed(ActionEvent e){

                JTextField userField = new JTextField();
                JTextField descriptionField = new JTextField();
                String message1 = "Please Enter Username";
                String message2 = "Please Enter Description";

                int result = JOptionPane.showOptionDialog(frame, new Object[] {message1, userField, message2, descriptionField},
                "Add User", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (result == JOptionPane.OK_OPTION){
                    TokTik.users.insert(new User(descriptionField.getText(), userField.getText()));
                    JOptionPane.showMessageDialog(frame, "User added", "Confirmation", JOptionPane.PLAIN_MESSAGE);
                }
            }            
        });


        // List users in the text area
        listUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                textArea.setText(null);
                users.inOrder(users.root, textArea);               
            }            
        });

    
        // Add buttons
        panel.add(listUsers);
        panel.add(addUser);
        panel.add(addPost);
        panel.add(deleteUser);
        panel.add(findUser);
        frame.add(BorderLayout.SOUTH, panel);

        frame.setVisible(true);
    }

    
    /**
    * The loadDataSet function reads in a text file containing information about users and their posts.
    * The function then creates new User objects for each user, and adds Posts to the Users' post BST.
    * 
    */
    private static void loadDataSet(File file) throws IOException{
        // Load a list of users from a text file
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
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