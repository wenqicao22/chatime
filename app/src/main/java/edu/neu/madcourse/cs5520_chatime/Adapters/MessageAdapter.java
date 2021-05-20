package edu.neu.madcourse.cs5520_chatime.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.neu.madcourse.cs5520_chatime.Adapters.ViewHolder.ViewHolder;
import edu.neu.madcourse.cs5520_chatime.R;

//TODO: when message model is done, fix the string type to messages types
public class MessageAdapter extends RecyclerView.Adapter<ViewHolder> {
    //need a list of message from firebase for the current user
    private Context context;
//    private ArrayList<Messages> mMessages;
    private ArrayList<String> mMessages;


    public MessageAdapter(Context context, ArrayList<String> messages) {
        this.context = context;
        mMessages = messages;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.message_item, parent, false);
        return new ViewHolder(view);
    }

    //TODO: change the type of messages to Messages
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String messages = mMessages.get(position);
//        holder.username.setText(messages.getUsername);

        //can be extract to a public method
        //TODO: if the image url of the message is default, return default,
        //TODO: otherwise set Glider

//        Glide.with(context)
//                .load(url)
//                .placeholder(R.drawable.place_image)//before finish loading
//                .error(R.drawable.error_image)//if loading fails
//                .into(imageView);

    }

//TODO: when the message model done, fix this
    @Override
    public int getItemCount() {
        return mMessages.size();
    }



}
