public class User implements Comparable<User>{
    
    private String description;
    private String accountName;
    private BinarySearchTree<Post> posts;

    
    /**
     * The User function is a constructor for the User class.
     * 
     *
     * @param String description Set the description of the user
     * @param String accountName Set the accountname variable
     *
     * @return A new user object with the given description and accountname
     */
    public User(String description, String accountName){
        this.accountName = accountName;
        this.description = description;
        this.posts = new BinarySearchTree<>();
    }

    
    /**
     * The User function is a constructor for the User class.
     * It takes in an accountName and sets it to the instance variable accountName.
     
     *
     * @param String accountName Set the accountname of the User
     * 
     * @return An object of the user class
     */
    public User(String accountName){
        this.accountName = accountName;
    }

    
    /**
     * The addPost function adds a new post to the user's account
     * Post stored in posts BST. 
     *
     * @param String title Set the title of the post
     * @param String video Store the video url
     * @param int numLikes Set the number of likes a post has
     *
     * @return Void
     */
    public void addPost(String title, String video, int numLikes){
        posts.insert(new Post(title, video, numLikes));
    }

    
    /**
     * The displayPosts function displays all the posts in the BST.
     *
     * @return The posts in order
     */
    public void displayPosts(){
        posts.inOrder();
    }

    
    /**
     * The getDescription function returns the description of the User account.
     *
     * @return The description of the room
     */
    public String getDescription(){
        return description;
    }

    
    /**
     * The getAccountName function returns the account name of the User.
     * 
     * @return The account name
     */
    public String getAccountName(){
        return accountName;
    }

    
    /**
     * The toString function returns a string representation of the account.
     *
     * @return The accountname
     */
    public String toString(){
        return accountName;
    }

    
    /**
     * The compareTo function implements the Abstract Class comparable.
     * The compareTo function compares the account names of two users.
     * 
     *
     * @param User anotherUser Compare the current user to another user
     *
     * @return A negative number if the current username is lexicographically less than the other account's username
     */
    @Override
    public int compareTo(User anotherUser) {
        return this.accountName.compareTo(anotherUser.getAccountName());
    }

}