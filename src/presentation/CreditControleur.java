package presentation;

import matier.CreditMetier;
import matier.IMetier;

public class CreditControleur implements ICreditControleur{
    CreditControleur Iconroleur;
    //CreditMetier creditMetier;
    IMetier creditMetier;
    public IMetier setCreditMetier(IMetier metier){
        return this.creditMetier=metier;
    }
    @Override
    public void afficher_Menduaalite(Long idCredit) throws Exception {
     var creditAvecMensualite =  creditMetier.calculer_Mensualite(idCredit);
        System.out.println(creditAvecMensualite);
    }
}
