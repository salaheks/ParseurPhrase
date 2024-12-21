package grammaire;

public class ParseurPhrase {
    private TokenManager tm;
    private String tc;

    public ParseurPhrase(TokenManager tm) {
        this.tm = tm;
        avancer();
    }

    private void avancer() {
        tc = tm.suivant();
    }

    private void consommer(String attendu) {
        if (tc.equals(attendu)) {
            avancer();
        } else {
            throw new RuntimeException(attendu + " attendu, mais " + tc + " trouvé");
        }
    }

    // Règle pour Phrase -> Sujet Verbe Complément
    private void Phrase() {
        Sujet();
        Verbe();
        Complement();
    }

    // Règle pour Sujet -> Article Nom
    private void Sujet() {
        Article();
        Nom();
    }

    // Règle pour Complément -> Article Nom
    private void Complement() {
        Article();
        Nom();
    }

    // Règle pour Article -> le | la | les | une | un | des
    private void Article() {
        if (isArticle(tc)) {
            consommer(tc);
        } else {
            throw new RuntimeException("Article attendu, mais " + tc + " trouvé");
        }
    }

    // Règle pour Nom -> souris | fromage | chat
    private void Nom() {
        if (isNom(tc)) {
            consommer(tc);
        } else {
            throw new RuntimeException("Nom attendu, mais " + tc + " trouvé");
        }
    }

    // Règle pour Verbe -> mange | mangent
    private void Verbe() {
        if (tc.equals("mange") || tc.equals("mangent")) {
            consommer(tc);
        } else {
            throw new RuntimeException("Verbe attendu, mais " + tc + " trouvé");
        }
    }

    // Helper methods to check token types
    private boolean isArticle(String token) {
        return token.equals("le") || token.equals("la") || token.equals("les") ||
               token.equals("une") || token.equals("un") || token.equals("des");
    }

    private boolean isNom(String token) {
        return token.equals("souris") || token.equals("fromage") || token.equals("chat");
    }

    // Démarrage de l'analyse
    public void parse() {
        Phrase();
        if (!tc.equals("#")) {
            throw new RuntimeException("Fin de chaîne attendue, mais " + tc + " trouvé");
        }
    }
}