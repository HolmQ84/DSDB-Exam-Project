package dsdb.logger.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dsdb.logger.Model.SongInfo;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class JsonModelConverter {

    public List<SongInfo> convertJsonToListOfSongs(JSONArray songs) {
        Gson gson = new GsonBuilder().setDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").create();
        Type type = new TypeToken<List<SongInfo>>(){}.getType();
        return gson.fromJson(String.valueOf(songs), type);
    }

    public SongInfo convertGameDTOToModel(JSONObject game) {
        Gson gson = new Gson();
        Type type = new TypeToken<SongInfo>(){}.getType();
        return gson.fromJson(String.valueOf(game), type);
    }

    public JSONObject songToObject(SongInfo songInfo) {
        JSONObject object = new JSONObject();
        object.put("songId", songInfo.getSongId());
        object.put("title", songInfo.getTitle());
        object.put("rank", songInfo.getRank());
        object.put("date", songInfo.getDate());
        object.put("artist", songInfo.getArtist());
        object.put("spotifyUrl", songInfo.getSpotifyUrl());
        object.put("region", songInfo.getRegion());
        object.put("streams", songInfo.getStreams());
        object.put("loggerMessage", songInfo.getLoggerMessage());
        return object;
    }
}
