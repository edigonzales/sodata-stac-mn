package ch.so.agi.sodata.stac;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.MediaType;

@Controller
public class MainController {

    @Get("ping") 
    @Produces(MediaType.TEXT_PLAIN) 
    public String index() {
        return "Hello World"; 
    }
}
