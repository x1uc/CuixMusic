package com.example.Dao;

import com.example.Dao.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicDao {

    @Select("SELECT * FROM CuixMusic WHERE name LIKE CONCAT('%', #{str}, '%') OR musician LIKE CONCAT('%', #{str}, '%')")
    public List<Music> getByName(String str);


}
