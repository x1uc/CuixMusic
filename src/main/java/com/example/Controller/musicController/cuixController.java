package com.example.Controller.musicController;

import com.example.Service.Music_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
