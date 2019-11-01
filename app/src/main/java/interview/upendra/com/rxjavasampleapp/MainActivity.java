package interview.upendra.com.rxjavasampleapp;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
            List<User> users = getUserWithBlogSchedulers().blockingGet();
            setAdapter(users);
        });
        btn3.setOnClickListener(view -> {
            List<User> users = getUserWithBlog().blockingGet();
            setGridLayoutManager(users);

        });
        btn4.setOnClickListener(view -> {
            List<User> users = getUserWithBlog().blockingGet();
            setPostAnimation(users);
        });
    }



    public Single<List<User>> getUserWithBlog() {
        return Observable.defer(() -> Observable.fromIterable(getUserList()).filter(user -> user.hasBlog == true)
                .sorted((user1, user2) -> user1.userName.compareTo(user2.userName))).toList();
    }

    public Single<List<User>> getUserWithBlogSchedulers() {
        return Observable.defer(() -> Observable.fromIterable(getUserList()).subscribeOn(Schedulers.io()).filter(user -> user.hasBlog == true)
                .sorted((user1, user2) -> user1.userName.compareTo(user2.userName))).toList().observeOn(AndroidSchedulers.mainThread());
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
                Thread.sleep(20);
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

    private void setGridLayoutManager(List<User> users) {
        sampleAdapter = new SampleAdapter((ArrayList<User>) users);
        layoutManger = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManger);
        recyclerView.setAdapter(sampleAdapter);
    }

    private void setPostAnimation(List<User> users) {
        sampleAdapter = new SampleAdapter((ArrayList<User>) users);
        layoutManger = new GridLayoutManager(this, 3);
        layoutManger.postOnAnimation(new Runnable() {
            @Override
            public void run() {

            }
        });
        recyclerView.setLayoutManager(layoutManger);
        recyclerView.setAdapter(sampleAdapter);
    }


}
