package sio.devoir1;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import sio.devoir1.model.Equipe;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class Devoir1Controller implements Initializable
{
    // dans la Hashmap tournois, il y a :
    // Clé = Nom du tournoi
    // Value = Une TreeMap qui stocke :
    // Clé = nom de l'équipe
    // Value = l'objet EQUIPE avec ses scores
    private HashMap<String, TreeMap<String, Equipe>> tournois;
    TreeItem racine;
    Alert alert;

    @javafx.fxml.FXML
    private TextField txtScore;
    @javafx.fxml.FXML
    private Label lblResultat;
    @javafx.fxml.FXML
    private TextField txtEquipe;
    @javafx.fxml.FXML
    private TreeView tvTournois;
    @javafx.fxml.FXML
    private ComboBox cbTournois;
    @javafx.fxml.FXML
    private ComboBox cbEquipes;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        tournois = new HashMap<>();
        racine = new TreeItem("tournois");
        racine.setExpanded(true);
        tvTournois.setRoot(racine);
        chargerDonnees();
        chargerTreeView();
        // A vous de jouer : remplir la ComboxBox des tournois
        cbTournois.getItems().addAll("Robotique", "Cyber");
    }

    private void chargerDonnees()
    {
        // Voici au départ le jeu d'essais

        // 2 tournois : Robotique et Cyber
        tournois.put("Robotique", new TreeMap<>());
        tournois.put("Cyber", new TreeMap<>());

        // Les 3 équipes du tournoi "Robotique"
        Equipe e1 = new Equipe("Team Eclipse");
        e1.getScores().add(50);
        e1.getScores().add(40);
        e1.getScores().add(30);

        Equipe e2 = new Equipe("Team Alpha");
        e2.getScores().add(20);
        e2.getScores().add(25);
        e2.getScores().add(35);

        Equipe e3 = new Equipe("Team Nova");
        e3.getScores().add(60);
        e3.getScores().add(10);

        tournois.get("Robotique").put(e1.getNom(), e1);
        tournois.get("Robotique").put(e2.getNom(), e2);
        tournois.get("Robotique").put(e3.getNom(), e3);

        // Les 2 équipes du tournoi "Cyber"
        Equipe e4 = new Equipe("Phoenix");
        e4.getScores().add(35);
        e4.getScores().add(45);

        Equipe e5 = new Equipe("Titans");
        e5.getScores().add(50);
        e5.getScores().add(40);

        tournois.get("Cyber").put(e4.getNom(), e4);
        tournois.get("Cyber").put(e5.getNom(), e5);
    }

    private void chargerTreeView() {
//        // A vous de jouer
//        TreeItem noeudDate = null;
//        TreeItem noeudHeure = null;
//        TreeItem noeudRdv = null;
//
//        racine.getChildren().clear();
//
//        for (String champ : tournois.keySet())
//        {
//            noeudDate = new TreeItem(champ);
//            noeudDate.setExpanded(true);
//            for (String heure : tournois.get(champ).keySet())
//            {
//                noeudHeure = new TreeItem(heure);
//                noeudHeure.setExpanded(true);
//                noeudRdv = new TreeItem(equipes.get(champ).get(heure).getNomPatient());
//                noeudHeure.getChildren().add(noeudRdv);
//                noeudRdv = new TreeItem(equipes.get(champ).get(heure).getNomPathologie());
//                noeudHeure.getChildren().add(noeudRdv);
//                noeudDate.getChildren().add(noeudHeure);
//            }
//            racine.getChildren().add(noeudDate);
//        }
//        racine.setExpanded(true);
//        tvTournois.setRoot(racine);
    }
    private void protection()
    {
        if(cbTournois.getSelectionModel().getSelectedItem() == null)
        {
            lblResultat.setText("Sélectionner un tournois");

        }else  if(cbEquipes.getSelectionModel().getSelectedItem() == null)
        {
            lblResultat.setText("Sélectionner une equipe");
        }else if (txtEquipe.getText().isEmpty())
        {
            lblResultat.setText("metez le nom de l'equipe");
        }
    }

    private void chargerEquipes()
    {
        // A vous de jouer
        cbEquipes.getItems().clear();
        if (cbTournois.getSelectionModel().getSelectedItem().toString() == ("Robotique")) {
            cbEquipes.getItems().addAll("Phoenix", "Titans");
        } else {
            cbEquipes.getItems().addAll("Team Eclipse", "Team Alpha", "Team Nova");

        }
    }

    @javafx.fxml.FXML
    public void ajouterEquipe(ActionEvent actionEvent)
    {
        // A vous de jouer
        if(cbTournois.getSelectionModel().getSelectedItem() == null)
        {
            lblResultat.setText("Sélectionner un tournois");

        }else if (txtEquipe.getText().isEmpty())
        {
            lblResultat.setText("metez le nom de l'equipe");
        }else
        {
            cbEquipes.getItems().add(txtEquipe.getText());
            // cependant, il faut ensuite le faire persister dans le
            // treeview (il va être stocké et ensuite, je vais appeler le
            // treeview pour voir s'il y a des équipes manquantes).
        }

    }

    @javafx.fxml.FXML
    public void ajouterScore(ActionEvent actionEvent)
    {
        // A vous de jouer
        protection();
        // je vais regarder dans tournois pour voir les équipes et leurs scors
    }

    @javafx.fxml.FXML
    public void calculTotalTournoi(ActionEvent actionEvent)
    {
        // A vous de jouer
        if(cbTournois.getSelectionModel().getSelectedItem() == null)
        {
            lblResultat.setText("Sélectionner un tournois");
        }else
        {

        }
    }

    @javafx.fxml.FXML
    public void meilleureEquipe(ActionEvent actionEvent)
    {
        // A vous de jouer
        if(cbTournois.getSelectionModel().getSelectedItem() == null)
        {
            lblResultat.setText("Sélectionner un tournois");
        }else
        {

        }
    }

    @javafx.fxml.FXML
    public void renommerEquipe(ActionEvent actionEvent)
    {
        // A vous de jouer
        protection();

    }

    @javafx.fxml.FXML
    public void chargerEquipes(ActionEvent actionEvent)
    {
        // appelle chargerEquipes NORMALE (ne s'appelle pas elle-même)
        chargerEquipes();
    }
}
