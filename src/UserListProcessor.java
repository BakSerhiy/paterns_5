import java.util.ArrayList;

public class UserListProcessor {
    private ArrayList<User> users;

    public UserListProcessor(ArrayList<User> users) {
        this.users = users;
    }

    public void processUserList() {
        for (User user : users) {
            processUser(user);
        }
    }

    private void processUser(User user) {
        System.out.println("Processing user: " + user.getUsername());
        if (user.isAdmin()) {
            System.out.println("Admin user detected!");
        }
    }

    public int countAdminUsers() {
        int adminCount = 0;
        for (User user : users) {
            if (user.isAdmin()) {
                adminCount++;
            }
        }
        return adminCount;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void sendEmailToUser(User user) {
        System.out.println("Sending email to: " + user.getEmail());
    }

    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("admin123", "admin@example.com", "password", "123 Admin St."));
        userList.add(new User("user456", "user@example.com", "password", "456 User Rd."));

        UserListProcessor ulp = new UserListProcessor(userList);
        ulp.processUserList();
        System.out.println("Number of admin users: " + ulp.countAdminUsers());
    }
}

class User {
    private String username;
    private String email;
    private String password;
    private String address;

    public User(String username, String email, String password, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return username.contains("admin");
    }
}
