package com.gabriel.draw.command;

import com.gabriel.drawfx.command.Command;
import com.gabriel.drawfx.service.AppService;

import java.awt.Color;


public class SetColorCommand implements Command {
    private final AppService appService;
    private final Color newColor;
    private Color oldColor;


    public SetColorCommand(AppService appService, Color newColor) {
        this.appService = appService;
        this.newColor = newColor;
    }


    @Override
    public void execute() {
        this.oldColor = appService.getColor();
        appService.setColor(newColor);
    }


    @Override
    public void undo() {
        appService.setColor(oldColor);
    }


    @Override
    public void redo() {
        appService.setColor(newColor);
    }
}
