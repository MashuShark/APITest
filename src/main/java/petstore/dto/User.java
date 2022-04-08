package petstore.dto;

public class User {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    public User(Long id, String userName, String firstName, String lastName, String email, String password, String phone, Integer userStatus) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public static class UserBuilder {

        private Long id;
        private String userName;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        private Integer userStatus;

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withUserName(String username) {
            this.userName = username;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder withUserStatus(boolean userStatus) {
            if (userStatus == true) {
                this.userStatus = 1;
            } else {
                this.userStatus = 0;
            }
            return this;
        }

        public User build() {
            return new User(this.id,
                    this.userName,
                    this.firstName,
                    this.lastName,
                    this.email,
                    this.password,
                    this.phone,
                    this.userStatus);
        }
    }
}
