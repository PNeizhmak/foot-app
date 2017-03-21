package com.pneizhmak.footapp.controller;

import com.pneizhmak.footapp.db.model.Position;
import com.pneizhmak.footapp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Pavel Neizhmak
 */
@Controller
@RequestMapping("/positions")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String savePlayer(@RequestParam String name) {

        Position position = new Position(name);
        positionService.savePosition(position);

        return "Position successfully saved!";
    }

    @ResponseBody
    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public Object[] getAll() {
        return positionService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String deletePlayer(@RequestParam int id) {
        positionService.deletePosition(id);
        return "Position successfully deleted!";
    }
}
