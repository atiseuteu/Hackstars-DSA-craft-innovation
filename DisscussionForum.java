package social_media;
import java.util.*;

// Class to represent a discussion forum or group
class DiscussionForum {
    private String name;
    private String description;
    private int creatorId;
    private List<Integer> members;
    private Map<String, DiscussionTopic> discussions;

    public DiscussionForum(String name, String description, int creatorId) {
        this.name = name;
        this.description = description;
        this.creatorId = creatorId;
        this.members = new ArrayList<>();
        this.discussions = new HashMap<>();
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public List<Integer> getMembers() {
		return members;
	}

	public void setMembers(List<Integer> members) {
		this.members = members;
	}

	public void setDiscussions(Map<String, DiscussionTopic> discussions) {
		this.discussions = discussions;
	}

	public void addMember(int memberId) {
        members.add(memberId);
    }

    public void removeMember(String memberId) {
        members.remove(memberId);
    }

    public void createDiscussion(String topicId, String title, String authorId) {
        DiscussionTopic newDiscussion = new DiscussionTopic(title, authorId);
        discussions.put(topicId, newDiscussion);
    }

    public List<DiscussionTopic> getDiscussions() {
        return new ArrayList<>(discussions.values());
    }
}