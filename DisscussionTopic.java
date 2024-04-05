package social_media;
import java.util.*;
class DiscussionTopic {
    private String title;
    private String authorId;
    private Date createdAt;

    public DiscussionTopic(String title, String authorId) {
        this.title = title;
        this.authorId = authorId;
        this.createdAt = new Date();
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

   
}
