package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;
import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    Post post;

    TextView tvUser;
    TextView tvDescription;
    TextView tvTime;
    ImageView ivPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvUser = (TextView) findViewById(R.id.tvUser);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        tvTime = (TextView) findViewById(R.id.tvTime);
        ivPost = (ImageView) findViewById(R.id.ivPost);

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));

        String createdAt = Post.calculateTimeAgo(post.getCreatedAt());

        tvUser.setText(post.getKeyUser().getUsername());
        tvDescription.setText(post.getKeyDescription());
        tvTime.setText(createdAt);
        ParseFile image = post.getKeyImage();
        if (image != null) {
            Glide.with(this).load(image.getUrl()).into(ivPost);
        }
    }
}