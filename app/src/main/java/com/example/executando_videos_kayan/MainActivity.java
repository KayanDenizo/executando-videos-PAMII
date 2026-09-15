package com.example.executando_videos_kayan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageExecutar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mostra o app em tela cheia. Comentando essa linha aparece a barra de status.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        // Liga o botao de play do layout com o codigo
        imageExecutar = findViewById(R.id.imageExecutar);

        // Ao clicar no play mudamos de tela para a PlayerActivity
        imageExecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}
