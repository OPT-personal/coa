package model;

public class Dossier {
    private boolean isAfgerond = false;
    private boolean INDUitspraak = false;
    private boolean eigenWoning = false;
    private boolean terugNaarLandHerKomst = false;

    public boolean isAfgerond() {
        return isAfgerond;
    }

    public void setAfgerond(boolean afgerond) {
        isAfgerond = afgerond;
    }

    public boolean isINDUitspraak() {
        return INDUitspraak;
    }

    public void setINDUitspraak(boolean INDUitspraak) {
        this.INDUitspraak = INDUitspraak;
    }

    public boolean isEigenWoning() {
        return eigenWoning;
    }

    public void setEigenWoning(boolean eigenWoning) {
        this.eigenWoning = eigenWoning;
    }

    public boolean isTerugNaarLandHerKomst() {
        return terugNaarLandHerKomst;
    }

    public void setTerugNaarLandHerKomst(boolean terugNaarLandHerKomst) {
        this.terugNaarLandHerKomst = terugNaarLandHerKomst;
    }
}
