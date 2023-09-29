package com.example.Service;

import com.example.Dao.pojo.Music;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface Music_Service {
    public List<Music> getByName(String str);

    public Boolean insertSong(String name, String sql_song_path, String musician, String sql_img_path);
}
