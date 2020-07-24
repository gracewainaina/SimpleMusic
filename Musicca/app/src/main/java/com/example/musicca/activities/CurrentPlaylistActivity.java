package com.example.musicca.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicca.R;
import com.example.musicca.adapters.CurrentPlaylistAdapter;
import com.example.musicca.adapters.QueueAdapter;
import com.example.musicca.models.Playlist;
import com.example.musicca.models.Song;
import com.parse.GetCallback;
import com.parse.ParseException;
<<<<<<< HEAD
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import org.json.JSONException;
=======
>>>>>>> Search view functionality completed
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CurrentPlaylistActivity extends AppCompatActivity {

    private static final String TAG = "CurrentPlaylistActivity";
    private static final String EXTRA_PLAYLISTOBJECTID = "playlistobjectid";

    private TextView tvPlaylistTitle;
    private RecyclerView rvPlaylistSongs;
    private Button btnAddMoreSongs;
    private String playlistObjectId;
    private CurrentPlaylistAdapter currentPlaylistAdapter;
<<<<<<< HEAD
<<<<<<< HEAD
    private List<String> currentPlaylistSongs;
    protected List<Song> songsInPlaylist;
    private Playlist currentPlaylist;


=======
    ArrayList<Song> currentPlaylistSongs = new ArrayList<>();
>>>>>>> Search view functionality completed
=======
    private List<String> currentPlaylistSongs;
>>>>>>> Resolving git comments on camel case, logs, constant, unused code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_playlist);

        tvPlaylistTitle = findViewById(R.id.tvPlaylistTitle);
        rvPlaylistSongs = findViewById(R.id.rvPlaylistSongs);
        btnAddMoreSongs = findViewById(R.id.btnAddMoreSongs);
        playlistObjectId = getIntent().getStringExtra(EXTRA_PLAYLISTOBJECTID);
<<<<<<< HEAD
        Log.d("PLAYLIST CURRENT objid ", playlistObjectId != null ? playlistObjectId : null);

        getCurrentPlaylistSongs(playlistObjectId);
        playlistObjectId = getIntent().getStringExtra("playlistobjectid");
=======
>>>>>>> Resolving git comments on camel case, logs, constant, unused code
        Log.d("PLAYLIST CURRENT objid ", playlistObjectId != null ? playlistObjectId : null);

        getCurrentPlaylistSongs(playlistObjectId);
        btnAddMoreSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoQueueActivity();
            }
        });
    }

    private void gotoQueueActivity() {
        Intent i = new Intent(this, QueueActivity.class);
        i.putExtra(EXTRA_PLAYLISTOBJECTID, playlistObjectId);
<<<<<<< HEAD
        startActivity(i);
    }

    private void getCurrentPlaylistSongs(String playlistobjectid) {
        ParseQuery<Playlist> query = ParseQuery.getQuery(Playlist.class);
        // First try to find from the cache and only then go to network
        // query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK); // or CACHE_ONLY
        i.putExtra("playlistobjectid", playlistObjectId);
=======
>>>>>>> Resolving git comments on camel case, logs, constant, unused code
        startActivity(i);
    }

    private void getCurrentPlaylistSongs(String playlistobjectid) {
        ParseQuery<Playlist> query = ParseQuery.getQuery(Playlist.class);
        // First try to find from the cache and only then go to network
        // query.setCachePolicy(ParseQuery.CachePolicy.CACHE_ELSE_NETWORK); // or CACHE_ONLY
        // Execute the query to find the object with ID
        query.getInBackground(playlistobjectid, new GetCallback<Playlist>() {
            @Override
            public void done(Playlist playlist, com.parse.ParseException e) {
                if (e == null) {
<<<<<<< HEAD
<<<<<<< HEAD
                    Log.d(TAG, "playlist found " + playlist.getName());
=======
                    Log.d(TAG, "playlist found" + playlist.getName());
>>>>>>> Search view functionality completed
=======
                    Log.d(TAG, "playlist found " + playlist.getName());
>>>>>>> Resolving git comments on camel case, logs, constant, unused code
                    tvPlaylistTitle.setText(playlist.getName());
                    if (playlist.getSongList() != null) {
                        currentPlaylistSongs = playlist.getSongList();
                        Log.d("playlist CURRENT size1", "SIZE OF" + currentPlaylistSongs.size());
                    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Resolving git comments on camel case, logs, constant, unused code
                    currentPlaylistAdapter = new CurrentPlaylistAdapter(CurrentPlaylistActivity.this, currentPlaylistSongs, playlistObjectId);
                    rvPlaylistSongs.setAdapter(currentPlaylistAdapter);

                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CurrentPlaylistActivity.this);
                    rvPlaylistSongs.setLayoutManager(linearLayoutManager);
<<<<<<< HEAD
=======
>>>>>>> Search view functionality completed
=======
>>>>>>> Resolving git comments on camel case, logs, constant, unused code
                } else {
                    Log.d(TAG, "playlist not found!");
                }
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD

        return currentplaylist[0];
=======
        Log.d("PLAYLIST CURRENT size2", "SIZE OF" + currentPlaylistSongs.size());
        currentPlaylistAdapter = new CurrentPlaylistAdapter(this, currentPlaylistSongs, playlistObjectId);
        rvPlaylistSongs.setAdapter(currentPlaylistAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvPlaylistSongs.setLayoutManager(linearLayoutManager);
>>>>>>> Search view functionality completed
=======

>>>>>>> Resolving git comments on camel case, logs, constant, unused code
    }
}
