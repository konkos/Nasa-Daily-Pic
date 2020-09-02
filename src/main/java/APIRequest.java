import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIRequest {
    private String urlString;
    private ImageJson imageJson;

    public APIRequest(String urlString){
        this.urlString = urlString;
    }

    public APIRequest(){
        urlString = "https://api.nasa.gov/planetary/apod?api_key=hQx4ayGVfsWpc5wbo3tvdRWpdA20lKqyA3bfa7Ci";
    }

    private String apiCall(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = reader.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public ImageJson getData() throws IOException {
        Gson gson = new Gson();
        String apiCall = apiCall(urlString);
        ImageJson imageJson = gson.fromJson(apiCall, ImageJson.class);
        return imageJson;
    }
}
