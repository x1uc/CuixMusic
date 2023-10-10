CREATE DATABASE ssm_db;


CREATE TABLE CuixMusic
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(255) NOT NULL,
    path     VARCHAR(255) NOT NULL,
    musician VARCHAR(255) NOT NULL,
    arr_img  VARCHAR(255) NOT NULL
);

insert into CuixMusic
values (1, "星晴", "/song/星晴.mp3", "周杰伦", "/images/jay.png"),
       (2, "暗号", "/song/暗号.mp3", "周杰伦", "/images/八度空间.png"),
       (3, "晴天", "/song/晴天.mp3", "周杰伦", "/images/叶惠美.png"),
       (4, "七里香", "/song/七里香.mp3", "周杰伦", "/images/七里香.png")
