package ru.itmo.wp.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterRequest {
    @NotEmpty
    @Size(min = 2, max = 24)
    @Pattern(regexp = "[a-zA-Z]{2,24}", message = "Login can only contain latin letters")
    private String login;

    @NotEmpty
    @Size(min = 2, max = 36)
    @Pattern(regexp = "[a-zA-Z]{2,36}", message = "Name can only contain latin letters")
    private String name;

    @NotEmpty
    @Size(min = 1, max = 60)
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
