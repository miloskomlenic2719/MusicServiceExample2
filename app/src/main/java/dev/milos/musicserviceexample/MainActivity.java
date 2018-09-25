package dev.milos.musicserviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStartService;

    private static  boolean STANJE = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnStartService = (Button) findViewById(R.id.btnStartService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(STANJE){
                    btnStartService.setText("Stop Service");
                    startService(new Intent(MainActivity.this, MyMusicPlayer.class));
                    STANJE = false;
                }else{
                    STANJE = true;
                    btnStartService.setText("Start Service");
                    stopService(new Intent(MainActivity.this, MyMusicPlayer.class));
                }

            }
        });




    }
}
