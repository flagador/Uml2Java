package Models;

import javafx.beans.property.*;
import javafx.beans.value.*;

import java.text.*;
import java.util.*;

public class Classe {

    private ArrayList<Attribut> attributArrayList = new ArrayList<Attribut>();
    private ArrayList<Methode> methodeArrayList = new ArrayList<Methode>();



    private final StringProperty nom = new SimpleStringProperty();

    public final String getNom() {
        return this.nom.get();
    }

    public final void setNom(String value) {
        this.nom.set(value);
    }

    public final StringProperty nomProperty() {
        return this.nom;
    }


    public Classe(String nom) {
        this.nomProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(MessageFormat.format("The name changed from \"{0}\" to \"{1}\"", oldValue, newValue));
            }
        });
        this.setNom(nom);
    }


}
