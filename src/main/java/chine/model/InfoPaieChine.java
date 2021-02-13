package chine.model;

import model.InfoPaie;

public class InfoPaieChine extends InfoPaie {
    private double primeRisque;
    private double primeAnciennete;

    public InfoPaieChine(int id, double nombreHeure, double tauxHoraire, double montantAvantage, int heureSup, double montantPret, double primeRisque, double primeAnciennete) {
        super(id, nombreHeure, tauxHoraire, montantAvantage, heureSup, montantPret);
        this.primeRisque = primeRisque;
        this.primeAnciennete = primeAnciennete;
    }

    public double getPrimeRisque() {
        return primeRisque;
    }

    public void setPrimeRisque(double primeRisque) {
        this.primeRisque = primeRisque;
    }

    public double getPrimeAnciennete() {
        return primeAnciennete;
    }

    public void setPrimeAnciennete(double primeAnciennete) {
        this.primeAnciennete = primeAnciennete;
    }
}
