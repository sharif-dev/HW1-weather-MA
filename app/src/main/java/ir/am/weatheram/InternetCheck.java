package ir.am.weatheram;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class InternetCheck extends AsyncTask<Void, Void, Boolean> {
    private Consumer consumer;

    public InternetCheck(Consumer consumer) {
        this.consumer = consumer;
        execute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("8.8.8.8", 53), 1500);
            socket.close();
            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean hasInternet) {
        consumer.accept(hasInternet);
    }

    public interface Consumer {
        void accept(Boolean hasInternet);
    }
}
