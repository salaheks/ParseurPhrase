package grammaire;

public class TokenManager {

    private String[] tokens;  // Séquence de mots dans la phrase
    private int index;        // Indice du mot courant

    public TokenManager(String phrase) {
        // Séparer la phrase en tokens basés sur les espaces, gérer les espaces multiples et convertir en minuscules
        this.tokens = phrase.trim().toLowerCase().split("\\s+"); // "\\s+" pour gérer les espaces multiples
        this.index = 0;
    }

    public String suivant() {
        // Retourner le prochain mot, ou un marqueur de fin si on dépasse la limite
        if (index < tokens.length) {
            return tokens[index++];
        }
        return "#";  // Fin de la chaîne
    }
}
