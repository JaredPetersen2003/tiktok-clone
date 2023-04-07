public class Post implements Comparable<Post>{

    private String title;
    private String  video;
    private int numLikes;

    public Post(String title, String  video, int numLikes){
        this.title = title;
        this.video = video;
        this.numLikes = numLikes;
    }

    public String toString(){
        return "post content";
    }

    public int getNumLikes(){
        return numLikes;
    }

    @Override
    public int compareTo(Post o) {
        Integer numInteger = Integer.valueOf(numLikes);
        Integer otherPostLikes = Integer.valueOf(o.getNumLikes());
        return numInteger.compareTo(otherPostLikes);
    }


 
}