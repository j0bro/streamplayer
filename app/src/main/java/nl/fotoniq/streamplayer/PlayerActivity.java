package nl.fotoniq.streamplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PlayerActivity extends AppCompatActivity {

    private static final String URL_NPO_RADIO2 = "http://icecast.omroep.nl/radio2-bb-mp3";

    private final MediaPlayer mediaPlayer = MediaPlayer.create(this, Uri.parse(URL_NPO_RADIO2));

    private Button btnPlay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player);

        btnPlay = findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playOrPauseStream();
                updateButtonText();
            }
        });
    }

    private void updateButtonText() {
        if (mediaPlayer.isPlaying()) {
            btnPlay.setText(R.string.btn_pause);
        } else {
            btnPlay.setText(R.string.btn_play);
        }
    }

    private void playOrPauseStream() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }
}
