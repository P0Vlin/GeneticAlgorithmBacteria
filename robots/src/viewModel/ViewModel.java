package viewModel;

import models.Model;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class ViewModel extends JPanel {
    private final Timer timer = new Timer("events generator", true);
    private final View view;
    public ViewModel(Model model, View view) {
        this.view = view;

        timer.schedule(new TimerTask() // model
        {
            @Override
            public void run()
            {
                EventQueue.invokeLater(() -> repaint());
            }
        }, 0, 2);
        timer.schedule(new TimerTask() //model
        {
            @Override
            public void run()
            {
                model.update();
            }
        }, 0, 1);
        addMouseListener(new MouseAdapter() // model
        {
            @Override
            public void mouseClicked(MouseEvent e) //Viewmodel
            {
                model.setTargetPosition(e.getPoint());
                repaint();
            }
        });
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        view.paint(g);
    }
}