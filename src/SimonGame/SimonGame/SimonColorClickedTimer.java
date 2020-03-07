package SimonGame.SimonGame;

import java.awt.event.ActionListener;
import java.awt.event.*;

public class SimonColorClickedTimer implements ActionListener {
    SimonGamePanel _parent = null;
    SimonGPButton _button = null;

    SimonColorClickedTimer(SimonGamePanel parent) {
        this._parent = parent;
    }

    public void setButton(SimonGPButton button) {
        this._button = button;
    }

    public void actionPerformed(ActionEvent e) {
        _parent.repaintTheGamePanel();
    }
}
