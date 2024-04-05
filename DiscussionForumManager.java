package social_media;

import java.util.*;

public class DiscussionForumManager {
	    private Map<String, DiscussionForum> forums;
	    Scanner sc=new Scanner(System.in);

	    public DiscussionForumManager() {
	        this.forums = new HashMap<>();
	    }

	    public void createForum(String forumId, String name, String description, int creatorId) {
	        DiscussionForum newForum = new DiscussionForum(name, description, creatorId);
	        forums.put(forumId, newForum);
	    }

	    public List<DiscussionForum> getForums() {
	        return new ArrayList<>(forums.values());
	    }

}