package senegal.modele;

import model.InfoPaie;

public class InfoPaieSenegal extends InfoPaie {
    private float primeAssiduite;
    private float primeRestauration;
    private float impotRevenu;

    public InfoPaieSenegal(float primeAssiduite, float primeRestauration, float impotRevenu) {
        this.primeAssiduite = primeAssiduite;
        this.primeRestauration = primeRestauration;
        this.impotRevenu = impotRevenu;
    }

    public InfoPaieSenegal() {
    }

    public float getPrimeAssiduite() {
        return primeAssiduite;
    }

    public void setPrimeAssiduite(float primeAssiduite) {
        this.primeAssiduite = primeAssiduite;
    }

    public float getPrimeRestauration() {
        return primeRestauration;
    }

    public void setPrimeRestauration(float primeRestauration) {
        this.primeRestauration = primeRestauration;
    }

    public float getImpotRevenu() {
        return impotRevenu;
    }

    public void setImpotRevenu(float impotRevenu) {
        this.impotRevenu = impotRevenu;
    }
}
