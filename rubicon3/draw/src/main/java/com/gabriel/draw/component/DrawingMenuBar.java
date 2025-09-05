package com.gabriel.draw.component;

import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class DrawingMenuBar extends JMenuBar implements ActionListener {
    private AppService appService;

    private final JMenuItem lineMenuItem = new JMenuItem("Line");
    private final JMenuItem rectangleMenuItem = new JMenuItem("Rectangle");
    private final JMenuItem ellipseMenuItem = new JMenuItem("Ellipse");

    private final JMenuItem undoMenuItem = new JMenuItem("Undo");
    private final JMenuItem redoMenuItem = new JMenuItem("Redo");
    private final JMenuItem colorMenuItem = new JMenuItem("Color");
    private final JMenuItem fillColorMenuItem = new JMenuItem("Fill Color");


    public DrawingMenuBar(AppService appService ){
        super();
        this.appService = appService;
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        add(editMenu);
        undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
        undoMenuItem.addActionListener(this);
        editMenu.add(undoMenuItem);
        redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));;
        redoMenuItem.addActionListener(this);
        editMenu.add(redoMenuItem);

        JMenu drawMenu = new JMenu("Draw");
        drawMenu.setMnemonic(KeyEvent.VK_D);
        editMenu.add(drawMenu);
        drawMenu.add(lineMenuItem);
        lineMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK ));
        lineMenuItem.addActionListener(this);
        drawMenu.add(rectangleMenuItem);
        rectangleMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK ));
        rectangleMenuItem.addActionListener(this);
        drawMenu.add(ellipseMenuItem);
        ellipseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK ));
        ellipseMenuItem.addActionListener(this);

        JMenu propMenu = new JMenu("Properties");
        add(propMenu);
        propMenu.add(colorMenuItem);
        colorMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent. VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        colorMenuItem.addActionListener(this);
        propMenu.add(fillColorMenuItem);
        fillColorMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent. VK_F, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        fillColorMenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == undoMenuItem) {
            appService.undo();
        }
        if(e.getSource() == redoMenuItem) {
            appService.redo();
        }
        else if(e.getSource() == lineMenuItem){
            appService.setShapeMode( ShapeMode.Line);
        }
        else if(e.getSource() == rectangleMenuItem){
            appService.setShapeMode( ShapeMode.Rectangle);
        }
        else if(e.getSource() == ellipseMenuItem){
            appService.setShapeMode( ShapeMode.Ellipse);
        }
        else if(e.getSource() == colorMenuItem){
            Color selectedColor = JColorChooser.showDialog(null, "Choose a Color", appService.getColor());
            if (selectedColor != null) {
                appService.setColor(selectedColor);
            }
        } else if (e.getSource() == fillColorMenuItem) {
            Color selectedFillColor = JColorChooser.showDialog(null, "Choose a Fill Color", appService.getFill());
            if (selectedFillColor != null) {
                appService.setFill(selectedFillColor);
            }
        }
    }
}
