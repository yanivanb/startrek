package be.vdab.startrek.controllers;

import be.vdab.startrek.services.WerknemerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WerknemerController {

    private final WerknemerService werknemerService;

    public WerknemerController(WerknemerService werknemerService) {
        this.werknemerService = werknemerService;
    }

    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("/", "alleWerknemers", werknemerService.alleWerkemers());
    }

}
