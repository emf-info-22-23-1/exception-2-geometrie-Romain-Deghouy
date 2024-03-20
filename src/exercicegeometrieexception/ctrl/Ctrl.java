package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {
        try {
            refIhm.afficheMessage("");
            double valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du cercle ( " + value + " invalie )");
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        boolean areaValide = false;
        boolean longueurValide = false;
        try {
            refIhm.afficheMessage("");
            double valueAreaDouble = Double.parseDouble(valueArea);
            areaValide = true;
            double valueLongueurDouble = Double.parseDouble(valueLongueur);
            longueurValide = true;
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
        } catch (NumberFormatException e) {
            if (areaValide == false) {
                refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du rectangle ( " + valueArea + " invalie )");
            } else if (longueurValide == false) {
                refIhm.afficheMessage("Veuillez entrer une valeur valide pour la longueur du rectangle ( " + valueLongueur + " invalie )");
            }
        }
    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
