package edu.neu.madcourse.cs5520_chatime.Adapters.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.madcourse.cs5520_chatime.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView chatMessage;
    public ImageView profileImg;
    public TextView username;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        chatMessage = itemView.findViewById(R.id.message_info);
        profileImg = itemView.findViewById(R.id.message_profile);
        username = itemView.findViewById(R.id.message_username);

    }
}
