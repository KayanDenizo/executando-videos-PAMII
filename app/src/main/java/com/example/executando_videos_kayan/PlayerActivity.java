package com.example.executando_videos_kayan;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        // setMediaController cria os controles (play, pause, avancar e retroceder)
        videoView.setMediaController(new MediaController(this));
        // setVideoPath localiza o endereco do video dentro da pasta raw
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        // start comeca a rodar o video
        videoView.start();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            esconderBarras();
        }
    }

    /**
     * Executa o video em tela cheia escondendo a barra de navegacao
     * para ganhar espaco na tela.
     */
    private void esconderBarras() {
        View decorView = getWindow().getDecorView();
        int opcoes = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(opcoes);
    }
}
