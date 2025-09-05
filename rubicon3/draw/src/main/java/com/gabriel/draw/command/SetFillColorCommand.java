package com.gabriel.draw.command;

import com.gabriel.drawfx.command.Command;
import com.gabriel.drawfx.service.AppService;

import java.awt.Color;


public class SetFillColorCommand implements Command {
    private final AppService appService;
    private final Color newFillColor;
    private Color oldFillColor;


    public SetFillColorCommand(AppService appService, Color newFillColor) {
        this.appService = appService;
        this.newFillColor = newFillColor;
    }


    @Override
    public void execute() {
        this.oldFillColor = appService.getFill();
        appService.setFill(newFillColor);
    }


    @Override
    public void undo() {
        appService.setFill(oldFillColor);
    }


    @Override
    public void redo() {
        appService.setFill(newFillColor);
    }
}
