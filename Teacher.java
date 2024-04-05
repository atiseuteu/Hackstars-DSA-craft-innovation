package social_media;

public class Teacher {
	 int userID;
	    public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

		String name;
	    String schoolName;
	    String subject;
	    String qualification;

	    public Teacher(int userID, String name, String schoolName, String subject, String qualification) {
	        this.userID = userID;
	        this.name = name;
	        this.schoolName = schoolName;
	        this.subject = subject;
	        this.qualification = qualification;
	    }
}