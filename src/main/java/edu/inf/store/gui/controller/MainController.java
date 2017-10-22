package edu.inf.store.gui.controller;

import com.jfoenix.controls.*;
import edu.inf.store.GameModel;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    // ================================================================================
    // Components
    // ================================================================================
    @FXML
    private StackPane root;

    @FXML
    private StackPane content;

    @FXML
    private StackPane titleBurgerContainer;
    @FXML
    private JFXHamburger titleBurger;

    @FXML
    private StackPane optionsBurger;
    @FXML
    private JFXRippler optionsRippler;

    @FXML
    private JFXToolbar title;

    @FXML
    private JFXTabPane tabPane;

    @FXML
    private JFXListView<GameModel> gamesListView;

    // ================================================================================
    // Configuration methods
    // ================================================================================
    public void initialize() {
        initComponents();
    }

    private void initComponents() {
        gamesListView.setCellFactory(listView -> new JFXListCellGame());
        gamesListView.getItems().addAll(getGames());
    }


    // TODO: Just mock
    private List<GameModel> getGames() {
        ArrayList<GameModel> games = new ArrayList<>();
        GameModel game1 = new GameModel();
        game1.setName("Age of Empires II");
        games.add(game1);

        GameModel game2 = new GameModel();
        game2.setName("Civilization V");
        games.add(game2);

        GameModel game3 = new GameModel();
        game3.setName("Gothic II");
        games.add(game3);
        return games;
    }

    // ================================================================================
    // Properties
    // ================================================================================


    public StackPane getRoot() {
        return root;
    }

    public void setRoot(StackPane root) {
        this.root = root;
    }

    public StackPane getContent() {
        return content;
    }

    public void setContent(StackPane content) {
        this.content = content;
    }

    public StackPane getTitleBurgerContainer() {
        return titleBurgerContainer;
    }

    public void setTitleBurgerContainer(StackPane titleBurgerContainer) {
        this.titleBurgerContainer = titleBurgerContainer;
    }

    public JFXHamburger getTitleBurger() {
        return titleBurger;
    }

    public void setTitleBurger(JFXHamburger titleBurger) {
        this.titleBurger = titleBurger;
    }

    public StackPane getOptionsBurger() {
        return optionsBurger;
    }

    public void setOptionsBurger(StackPane optionsBurger) {
        this.optionsBurger = optionsBurger;
    }

    public JFXRippler getOptionsRippler() {
        return optionsRippler;
    }

    public void setOptionsRippler(JFXRippler optionsRippler) {
        this.optionsRippler = optionsRippler;
    }

    public JFXToolbar getTitle() {
        return title;
    }

    public void setTitle(JFXToolbar title) {
        this.title = title;
    }

    public JFXTabPane getTabPane() {
        return tabPane;
    }

    public void setTabPane(JFXTabPane tabPane) {
        this.tabPane = tabPane;
    }

    public JFXListView<GameModel> getGamesListView() {
        return gamesListView;
    }

    public void setGamesListView(JFXListView<GameModel> gamesListView) {
        this.gamesListView = gamesListView;
    }
}
