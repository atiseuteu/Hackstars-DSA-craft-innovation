package social_media;
import java.util.*;
public class Post {
	private int id;
    private String content;
    private String author;
    private Set<Integer> likes;
    private List<String> comments;

    public Post(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.likes = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Set<Integer> getLikes() {
        return likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void addLike(int userId) {
        likes.add(userId);
    }

    public void removeLike(int userId) {
        likes.remove(userId);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }
}