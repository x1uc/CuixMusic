package com.example.Controller.musicController;

import com.example.Service.Music_Service;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;


@CrossOrigin
@RestController
@RequestMapping
public class cuixController {

    @Autowired
    private Music_Service musicService;


    @GetMapping("/search/{str}")
    public Result searchByName(@PathVariable String str) {
        return new Result("Accept", musicService.getByName(str));
    }


    @PostMapping("/upload")
    public Result uploadSong(@RequestParam("file0") MultipartFile file, @RequestParam("file1") MultipartFile file1) throws IOException, CannotReadException, TagException, InvalidAudioFrameException, ReadOnlyFileException {
        String originalFilename = file1.getOriginalFilename();
        Path tempFile = Files.createTempFile("", originalFilename);
        file1.transferTo(tempFile);

        File filemusic = tempFile.toFile();
        Files.copy(file1.getInputStream(), filemusic.toPath(), StandardCopyOption.REPLACE_EXISTING);

        MP3File mp3File = (MP3File) AudioFileIO.read((filemusic));
        MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();
        //歌名
        ID3v23Frame songnameFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TIT2");
        //歌手
        ID3v23Frame artistFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TPE1");
        String cls_path = System.getProperty("user.dir");
//        保存图片  备注是的是再本地环境 下面的是打包之后的 记得再target中加上 static/song  和static/images 来存储 静态文件
//        String img_path = cls_path + "/src/main/resources/static/images/" + file.getOriginalFilename();
        String img_path = cls_path + "/classes/static/images/" + file.getOriginalFilename();
        file.transferTo(new File(img_path));
//        保存歌曲
//        String song_path = cls_path + "/src/main/resources/static/song/" + file1.getOriginalFilename();
        String song_path = cls_path + "/classes/static/song/" + file1.getOriginalFilename();
        file1.transferTo(new File(song_path));


        String sql_song_path = "/song/" + file1.getOriginalFilename();

        String sql_image_path = "/images/" + file.getOriginalFilename();

        String songName = songnameFrame.getContent();

        String artist = artistFrame.getContent();

        System.out.println(sql_song_path);
        System.out.println(sql_image_path);
        System.out.println(songName);
        System.out.println(artist);
        musicService.insertSong(songName, sql_song_path, artist, sql_image_path);


        return new Result();
    }
}
