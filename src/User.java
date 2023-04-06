public class User implements Comparable<User>{
    
    private String description;
    private String accountName;

    public User(String description, String accountName){
        this.accountName = accountName;
        this.description = description;
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