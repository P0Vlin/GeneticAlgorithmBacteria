package viewModel;

import models.Model;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class ViewModel extends JInternalFrame {
    private final Timer timer = new Timer("events generator", true);
    public ViewModel(Model model, View view) {
        getContentPane().add(view);

        timer.schedule(new TimerTask() // model
        {
            @Override
            public void run()
            {
                EventQueue.invokeLater(view::repaint);
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
}
