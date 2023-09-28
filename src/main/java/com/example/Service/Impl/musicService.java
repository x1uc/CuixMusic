package com.example.Service.Impl;

import com.example.Dao.MusicDao;
import com.example.Dao.pojo.Music;
import com.example.Service.Music_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class musicService implements Music_Service {
    @Autowired
    private MusicDao musicDao;

    @Override
    public List<Music> getByName(String str) {
        return musicDao.getByName(str);
    }
}
