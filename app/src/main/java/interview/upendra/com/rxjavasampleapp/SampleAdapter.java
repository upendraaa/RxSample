package interview.upendra.com.rxjavasampleapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleHolder> {

    List<User> mUserList;

    public SampleAdapter(ArrayList<User> userList) {
        this.mUserList = userList;
    }


    @NonNull
    @Override
    public SampleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new SampleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SampleHolder sampleHolder, int i) {
        User user = mUserList.get(i);
        sampleHolder.bind(user);


    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}


class SampleHolder extends RecyclerView.ViewHolder {

    TextView textViewTitle, textViewSubTitle;

    public SampleHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.item);
        textViewSubTitle = itemView.findViewById(R.id.subTitle);
    }

    public void bind(User user) {
        textViewTitle.setText(user.userName);
        textViewSubTitle.setText(user.country);
    }
}
