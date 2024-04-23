package gui;

import viewModel.ViewModel;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class GameWindow extends JInternalFrame
{
    //private final GameVisualizer m_visualizer;
    public GameWindow(ViewModel viewModel) //view
    {
        super("Игровое поле", true, true, true, true);
        //m_visualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(viewModel, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();
    }
}
