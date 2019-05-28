import model.Classe;

import java.util.HashMap;
import java.util.Map;

public class Exporter {

    private static final Map<String, Classe> classes = new HashMap<>();

    public void ajouterClasse(Classe classe) {
        if (classe == null) return;
        if (classe.getNom().isEmpty()) return;
        classes.put(classe.getNom(), classe);
    }
}
