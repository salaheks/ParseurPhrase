package grammaire;

public class Main {
    public static void main(String[] args) {
        String[] testPhrases = {
            "la souris mange le fromage",          // Valide
            "le chat mange le fromage",             // Valide
            "mange le fromage",                    // Non valide
            "le fromage mange",                    // Non valide
            "nous chargeons le téléphone",         // Non valide (verbe incorrect)
        };

        for (String phrase : testPhrases) {
            TokenManager tm = new TokenManager(phrase);
            ParseurPhrase parseur = new ParseurPhrase(tm);

            try {
                parseur.parse();
                System.out.println(phrase + " est valide");
            } catch (RuntimeException exp) {
                System.out.println(phrase + " n'est pas valide");
               System.out.println("Erreur: " + exp.getMessage());
            }
        }
    }
}

