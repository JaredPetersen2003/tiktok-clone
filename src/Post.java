/**
 * The post class holds the title, video name, and number of likes for a User post
 * 
 * @author Jared Petersen
 */
public class Post implements Comparable<Post>{

    private String title;
    private String  video;
    private int numLikes;

    
    /**
     * The Post function is a constructor that creates an instance of the Post class.
     * 
     *
     * @param String title Set the title of the post
     * @param String  video Set the video field
     * @param int numLikes Set the number of likes for a post
     *
     * @return The title of the video
     */
    public Post(String title, String  video, int numLikes){
        this.title = title;
        this.video = video;
        this.numLikes = numLikes;
    }

    
    /**
     * The toString function returns a string representation of the object.
     *
     * @return The title, video and number of likes
     */
    public String toString(){
        return "Title: " + title + "\nVideo: " + video + "\nNumber of Likes: " + Integer.toString(numLikes);
    }

    
    /**
     * The getNumLikes function returns the number of likes for a given post.
     * 
     * @return The number of likes the post has
     */
    public int getNumLikes(){
        return numLikes;
    }

    
    /**
     * The compareTo function implements the Abstract Class comparable.
     * It compares the number of likes on two posts.
     * 
     *
     * @param Post o Compare the number of likes to another post
     *
     * @return The difference between the number of likes
     */
    @Override
    public int compareTo(Post o) {
        Integer numInteger = Integer.valueOf(numLikes);
        Integer otherPostLikes = Integer.valueOf(o.getNumLikes());
        return numInteger.compareTo(otherPostLikes);
    }


 
}