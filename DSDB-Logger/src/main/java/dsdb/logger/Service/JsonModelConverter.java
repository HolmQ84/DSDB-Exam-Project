package dsdb.logger.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dsdb.logger.Model.Song;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class JsonModelConverter {

    public List<Song> convertJsonToListOfSongs(JSONArray songs) {
        Gson gson = new GsonBuilder().setDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").create();
        Type type = new TypeToken<List<Song>>(){}.getType();
        return gson.fromJson(String.valueOf(songs), type);
    }

    public Song convertGameDTOToModel(JSONObject game) {
        Gson gson = new Gson();
        Type type = new TypeToken<Song>(){}.getType();
        return gson.fromJson(String.valueOf(game), type);
    }

    public JSONObject songToObject(Song song) {
        JSONObject object = new JSONObject();
        object.put("songId", song.getSongId());
        object.put("title", song.getTitle());
        object.put("rank", song.getRank());
        object.put("date", song.getDate());
        object.put("artist", song.getArtist());
        object.put("spotifyUrl", song.getSpotifyUrl());
        object.put("region", song.getRegion());
        object.put("streams", song.getStreams());
        object.put("loggerMessage", song.getLoggerMessage());
        return object;
    }
}
