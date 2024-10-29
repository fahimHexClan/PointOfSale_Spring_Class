package com.Pos.PointOfSale.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")//class map karanna use karana ekak
@CrossOrigin//wena server eke idala ena request ekak caugth karaganna and security eka high data eya wena katawath leak wenne na

public class TestController {
    @GetMapping(path = "01")
    public String getMyText(){
        String myText = "Hello World";
        System.out.println("myText: " + myText);
        return myText;

    }
    @GetMapping(path = "02")
    public void getMyText1(){
        String myText2 = "Hello World 2";
        System.out.println("myText: " + myText2);

    }
}
