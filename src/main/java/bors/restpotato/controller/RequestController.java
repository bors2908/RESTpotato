package bors.restpotato.controller;

import bors.restpotato.service.PotatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *  Simple REST controller class with two methods
 */
@RestController
@RequestMapping("/potato")
public class RequestController {

    private PotatoService potatoService;

    public RequestController(PotatoService potatoService) {
        this.potatoService = potatoService;
    }

   
    @PostMapping("/postStrings")
    public List<String> postStrings(@RequestBody List<String> strings) {
        return potatoService.prepareStrings(strings);
    }

    @GetMapping("/getMonth")
    public String postStrings(@RequestBody Integer num) {
        return potatoService.getMonthName(num);
    }
}
