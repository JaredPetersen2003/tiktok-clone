public class User implements Comparable<User>{
    
    private String description;
    private String accountName;
    private BinarySearchTree<Post> posts;

    public User(String description, String accountName){
        this.accountName = accountName;
        this.description = description;
        this.posts = new BinarySearchTree<>();
    }

    public User(String accountName){
        this.accountName = accountName;
    }

    public void addPost(String title, String video, int numLikes){
        posts.insert(new Post(title, video, numLikes));
    }

    public void displayPosts(){
        posts.inOrder();
    }

    public String getDescription(){
        return description;
    }

    public String getAccountName(){
        return accountName;
    }

    public String toString(){
        return accountName;
    }

    @Override
    public int compareTo(User anotherUser) {
        return this.accountName.compareTo(anotherUser.getAccountName());
    }

}