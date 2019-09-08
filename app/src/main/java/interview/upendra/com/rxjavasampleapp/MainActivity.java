package interview.upendra.com.rxjavasampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    SampleAdapter sampleAdapter;
    RecyclerView.LayoutManager layoutManger;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.itemList);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

    }

    @Override
    protected void onStart() {
        super.onStart();

        btn1.setOnClickListener(view -> {

            List<User> users = getUserWithBlog().blockingGet();
            setAdapter(users);

        });
        btn2.setOnClickListener(view -> {

        });
        btn3.setOnClickListener(view -> {

        });
        btn4.setOnClickListener(view -> {

        });
    }


    public Single<List<User>> getUserWithBlog() {
        return Observable.defer(() -> Observable.fromIterable(getUserList()).filter(user -> user.hasBlog == true)
                .sorted((user1, user2) -> user1.userName.compareTo(user2.userName))).toList();
    }

    private ArrayList<User> getUserList() {
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.userName = "Name " + i;
            user.country = "Country " + i;

            if (i % 2 == 0) {
                user.hasBlog = true;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            users.add(user);
        }
        return users;
    }

    private void setAdapter(List<User> users) {
        sampleAdapter = new SampleAdapter((ArrayList<User>) users);
        layoutManger = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManger);
        recyclerView.setAdapter(sampleAdapter);
    }


}