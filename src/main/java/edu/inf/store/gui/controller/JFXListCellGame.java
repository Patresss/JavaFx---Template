package edu.inf.store.gui.controller;

import com.jfoenix.controls.JFXListCell;
import edu.inf.store.GameModel;

public class JFXListCellGame extends JFXListCell<GameModel> {

    public JFXListCellGame() {
        super();
    }

    @Override
    public void updateItem(GameModel item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            getStyleClass().add("game-item");
            setText(item == null ? "" : item.getName());
            setGraphic(null);
        }
    }

}
