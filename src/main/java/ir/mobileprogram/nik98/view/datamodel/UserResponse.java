package ir.mobileprogram.nik98.view.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {
    @SerializedName("users")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
