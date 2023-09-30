Create table CuixMusic
(
    id       int primary key,
    name     varchar(255) not null,
    path     varchar(255) not null,
    musician varchar(255) not null,
    arr_img  varchar(255) not null
);


insert into CuixMusic
values (1, "星晴", "./song/星晴.mp3", "周杰伦", "/images/jay.png"),
       (2, "暗号", "./song/暗号.mp3", "周杰伦", "/images/八度空间.png"),
       (3, "晴天", "./song/晴天.mp3", "周杰伦", "/images/叶惠美.png"),
       (4, "七里香", "./song/七里香.mp3", "周杰伦", "/images/七里香.png")
