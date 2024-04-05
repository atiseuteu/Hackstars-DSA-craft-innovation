package social_media;
import java.util.*;
public class TeacherPostSystem {
	private Map<Integer, Post> posts;
    private int postIdCounter;

    public TeacherPostSystem() {
        posts = new HashMap<>();
        postIdCounter = 1;
    }

    public int addPost(String content, String author) {
        Post post = new Post(postIdCounter++, content, author);
        posts.put(post.getId(), post);
        return post.getId();
    }

    public Post getPost(int postId) {
        return posts.get(postId);
    }

    public void likePost(int postId, int userId) {
        Post post = posts.get(postId);
        if (post != null) {
            post.addLike(userId);
        } else {
            System.out.println("Post not found!");
        }
    }

    public void unlikePost(int postId, int userId) {
        Post post = posts.get(postId);
        if (post != null) {
            post.removeLike(userId);
        } else {
            System.out.println("Post not found!");
        }
    }

    public void commentOnPost(int postId, String comment) {
        Post post = posts.get(postId);
        if (post != null) {
            post.addComment(comment);
        } else {
            System.out.println("Post not found!");
        }
    }
    public static void main(String[] args) {
        TeacherPostSystem postSystem = new TeacherPostSystem();

        int postId = postSystem.addPost("Introduction to Java Programming", "Aditi");
        System.out.println("Teacher A posted a new material: " + postId);

        postSystem.likePost(postId, 101); 
        postSystem.commentOnPost(postId, "Great material!"); 

        Post post = postSystem.getPost(postId);
        System.out.println("Post Content: " + post.getContent());
        System.out.println("Likes: " + post.getLikes().size());
        System.out.println("Comments:");
        for (String comment : post.getComments()) {
            System.out.println("- " + comment);
        }
    }
}