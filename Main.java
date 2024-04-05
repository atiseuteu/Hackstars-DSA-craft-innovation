package social_media;
import java.util.*;

class NotificationManager {

    HashMap<Teacher, List<String>> notificationsMap = new HashMap<>();



    public void sendNotification(Teacher teacher, String notification) {

        if (!notificationsMap.containsKey(teacher)) {
            notificationsMap.put(teacher, new ArrayList<String>());
        }
        notificationsMap.get(teacher).add(notification);

    }

    public List<String> getNotifications(Teacher teacher) {
        List<String> notifications = notificationsMap.get(teacher);
        return notifications != null ? notifications : new ArrayList<String>();
    }

}
public class Main {
    static HashMap<Integer, Teacher> teachersMap = new HashMap<>();
    static HashMap<Teacher, List<Teacher>> teacherGraph = new HashMap<>();
    static NotificationManager notificationManager = new NotificationManager();


    static Scanner sc = new Scanner(System.in);

    public static void addTeacher() {
        System.out.println("Enter userID:");
        int userID = sc.nextInt();
        if (teachersMap.containsKey(userID)) {
            System.out.println("Error: User ID " + userID + " already exists.");
            return;
        }
        sc.nextLine(); // Consume newline character

        System.out.println("Enter teacher's name:");
        String name = sc.nextLine();

        System.out.println("Enter teacher's school or coaching name:");
        String school_name = sc.nextLine();

        System.out.println("Enter teacher's area of interest:");
        String subject = sc.nextLine();

        System.out.println("Enter teacher's qualifications:");
        String qualification = sc.nextLine();

        Teacher newTeacher = new Teacher(userID, name, school_name, subject, qualification);
        teachersMap.put(userID, newTeacher);
        teacherGraph.put(newTeacher, new ArrayList<>());
        System.out.println("Teacher added successfully.");
    }

    public static void viewTeachers() {
        if (teachersMap.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }
        System.out.println("List of Teachers with Connections:");
        for (Teacher teacher : teachersMap.values()) {
            System.out.println("User ID: " + teacher.userID +
                    ", Name: " + teacher.name +
                    ", School/Coaching Name: " + teacher.schoolName +
                    ", Area of Interest: " + teacher.subject +
                    ", Qualifications: " + teacher.qualification);

            List<Teacher> connections = teacherGraph.get(teacher);
            if (!connections.isEmpty()) {
                System.out.print("Connections: ");
                for (Teacher connectedTeacher : connections) {
                    System.out.print(connectedTeacher.name + ", ");
                }
                System.out.println();
            } else {
                System.out.println("No connections.");
            }
        }
    }

    public static void displayNotifications(int userID) {

        Teacher teacher = teachersMap.get(userID);

        if (teacher != null) {

            System.out.println("Notifications for " + teacher.name + ":");

            for (String notification : notificationManager.getNotifications(teacher)) {

                System.out.println(notification);

            }

        } else {

            System.out.println("Teacher with userID " + userID + " not found.");

        }

    }
    public static void addConnection() {
        System.out.println("Enter userID of the teacher:");
        int userID = sc.nextInt();
        Teacher teacher = teachersMap.get(userID);

        if (teacher == null) {
            System.out.println("Error: Teacher not found.");
            return;
        }

        System.out.println("Enter userID(s) of the teacher(s) to connect (comma-separated):");
        sc.nextLine(); // Consume newline character
        String[] connectedUserIDs = sc.nextLine().split(",");
        for (String connectedUserID : connectedUserIDs) {
            int connectedID = Integer.parseInt(connectedUserID.trim());
            Teacher connectedTeacher = teachersMap.get(connectedID);
            if (connectedTeacher != null) {
                teacherGraph.get(teacher).add(connectedTeacher);
                teacherGraph.get(connectedTeacher).add(teacher);
                System.out.println("Connection between " + teacher.name + " and " + connectedTeacher.name + " added successfully.");
                notificationManager.sendNotification(connectedTeacher, teacher.name + " added you as a friend.");
            } else {
                System.out.println("Error: Teacher with userID " + connectedID + " not found.");
            }
        }
    }

    public static void searchTeacher() {
        System.out.println("Enter userID of the teacher to search:");
        int userID = sc.nextInt();
        sc.nextLine(); // Consume newline character

        Teacher teacher = teachersMap.get(userID);
        if (teacher != null) {
            System.out.println("Teacher details:");
            System.out.println("UserID: " + teacher.userID);
            System.out.println("Name: " + teacher.name);
            System.out.println("School/Coaching Name: " + teacher.schoolName);
            System.out.println("Area of Interest: " + teacher.subject);
            System.out.println("Qualifications: " + teacher.qualification);
        } else {
            System.out.println("Teacher with userID " + userID + " not found.");
        }
    }

    public static void main(String args[]) {
    	
    	int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Teacher");
            System.out.println("2. View Teachers");
            System.out.println("3. Add Connection");
            System.out.println("4. Search Teacher");
            System.out.println("5.Show Notifications.");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    viewTeachers();
                    break;
                case 3:
                    addConnection();
                    break;
                case 4:
                    searchTeacher();
                    break;
                case 6:
                    System.out.println("Exiting program...");
  
                    break;
                case 5:

                    System.out.println("Enter userID of the teacher:");

                    int userID = sc.nextInt();

                    displayNotifications(userID);

                    break;   
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        }while(choice!=6);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
                DiscussionForumManager forumManager = new DiscussionForumManager();
                String e;
                List<DiscussionForum> forums;
            	DiscussionForum javaForum = null;
                int choice1;
                do {
                    System.out.println("1. Create a Forum");
                    System.out.println("2. Delete a Forum");
                    System.out.println("3. Add new member to forum");
                    System.out.println("4. Add a message");
                    System.out.println("5. Show Joined Forums");
                    System.out.println("6. Exit");
                    System.out.println("Enter your choice:");

                    choice1 = sc.nextInt();
                    sc.nextLine();
                    
                    switch (choice1) {
                        case 1:
                            System.out.println("Enter Forum Id:");
                            String forumId = sc.nextLine();
                            System.out.println("Enter Name:");
                            String name = sc.nextLine();
                            System.out.println("Enter Description:");
                            String description = sc.nextLine();
                            System.out.println("Enter Creator ID:");
                            int creatorId = sc.nextInt();

                            forumManager.createForum(forumId, name, description, creatorId);
                            System.out.println("Forum created successfully!");
                            break;
                        case 2:
                        	forums = forumManager.getForums();
                        	System.out.println("Enter name of forum");
                        	e=sc.nextLine();
                        	for (DiscussionForum forum : forums) {
                        	    if (forum.getName().equals(e)) {
                        	        javaForum = forum;
                        	        break;
                        	    }
                        	}
                        	forums.remove(javaForum);
                            break;
                        case 3:
                        	forums = forumManager.getForums();
                        	System.out.println("Enter name of forum");
                        	e=sc.nextLine();
                        	for (DiscussionForum forum : forums) {
                        	    if (forum.getName().equals(e)) {
                        	        javaForum = forum;
                        	        break;
                        	    }
                        	}
                        	System.out.println("Enter UseID");
                        	int j= sc.nextInt();
                        	javaForum.addMember(j);
                            break;
                        case 4:
                        	forums = forumManager.getForums();
                        	// Assuming 'forums' is a list of DiscussionForum objects
                        	Scanner sc = new Scanner(System.in);

                        	System.out.println("Enter name of forum:");
                        	String forumName = sc.nextLine();
                        	for (DiscussionForum forum : forums) {
                        	    if (forum.getName().equals(forumName)) {
                        	        javaForum = forum;
                        	        break;
                        	    }
                        	}

                        	if (javaForum != null) {
                        	    // Forum found, now create a discussion
                        	    System.out.println("Enter topic ID:");
                        	    String topicId = sc.nextLine();

                        	    System.out.println("Enter title:");
                        	    String title = sc.nextLine();

                        	    System.out.println("Enter author ID:");
                        	    String authorId = sc.nextLine();

                        	    // Create discussion in the forum
                        	    javaForum.createDiscussion(topicId, title, authorId);
                        	    System.out.println("Discussion created successfully!");
                        	} else {
                        	    System.out.println("Forum '" + forumName + "' not found.");
                        	}

                            break;
                        case 5:
                        	forums = forumManager.getForums();
                            System.out.println("**");
                            for (DiscussionForum forum : forums) {
                                System.out.println("Forum Name: " + forum.getName());
                                System.out.println("Description: " + forum.getDescription());
                                System.out.println("Creator ID: " + forum.getCreatorId());
                                System.out.println("Members: " + forum.getMembers());
                                System.out.println("Discussion Topics: ");
                                List<DiscussionTopic> discussions = forum.getDiscussions();
                                for (DiscussionTopic topic : discussions) {
                                    System.out.println("- " + topic.getTitle() + " (Author: " + topic.getAuthorId() + ", Created At: " + topic.getCreatedAt() + ")");
                                }
                                System.out.println();
                            }
                            break;
                        case 6:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }

                } while (choice1 != 6);
    }
    
}