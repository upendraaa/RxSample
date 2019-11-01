package rx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import interview.upendra.com.rxjavasampleapp.User;

public class RxSample {


    public static void main(String[] args) {


    }

    /**
     * Java8 also emit stream and have function like filter,map merge, but on top
     * of this RX java has handling the background and UI thread gracefully
     *
     * @param users
     * @return
     */
    public static List<User> getUsersViaJava8(List<User> users) {

        return users.stream().filter(user -> user.hasBlog).collect(Collectors.toList());

    }

    public static List<User> getUsers(List<User> users) {
        List<User> list = new ArrayList<>();
        for (User user : users) {
            if (user.hasBlog) {
                list.add(user);
            }
        }
        return list;
    }

}



