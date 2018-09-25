package dev.milos.musicserviceexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyMusicPlayer extends Service {

    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(getBaseContext(), "Servis je pokrenut.", Toast.LENGTH_LONG).show();
        new DoBackgroundTask().execute();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getBaseContext(), "Servis je zaustavljen.", Toast.LENGTH_LONG).show();
        mediaPlayer.stop();

    }

    private class DoBackgroundTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.pesmageneracija5);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();


            return null;
        }
    }
}
