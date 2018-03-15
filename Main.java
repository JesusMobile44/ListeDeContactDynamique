import java.lang.invoke.SwitchPoint;
import java.util.*;

/**
 * Created by BelSi1731422 on 2018-01-22.
 */
public class Main {

    public static void main(String[] args) {

        //Valeur
        int choixMenu = 0;
        int placeContact = 0;
        String rep;
        char repChar;
        boolean fini = false;
        boolean fini1;
        Contact contact[] = new Contact[10];
        HashMap<String, Contact> map=new HashMap<>();
        Queue<Contact> queue=new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("Bienvenue dans votre liste de contact!");
        System.out.println("======================================");
        System.out.println("");
        System.out.println("ps: plz faites pas d'espaces");
        System.out.println("");
        //Menu
        while(true){
            choixMenu = listeChoix();
            switch (choixMenu){
                case 1 :
                    Contact dude=Contact.ajouterContact();
                    map.put(dude.getPrenom(),dude);
                    break;
                case 2 :

                    System.out.println("Quel contact voulez-vous modifier?");
                    placeContact=sc.nextInt();
                    placeContact=placeContact-1;
                    if (contact[placeContact]!=null){
                        fini1=false;
                        while (!fini1){
                            System.out.println("Que voulez vous modifiez?");
                            System.out.println("Nom? (n)");
                            System.out.println("Prénom? (p)");
                            System.out.println("Adresse? (a)");
                            System.out.println("Occupation? (o)");
                            System.out.println("Information? (i)");
                            repChar=sc.next().toLowerCase().charAt(0);
                            switch (repChar){
                                case 'n' :
                                    System.out.println("Nom :");
                                    rep=sc.next();
                                    contact[placeContact].setNom(rep);
                                    break;
                                case 'p' :
                                    System.out.println("Prénom :");
                                    rep=sc.next();
                                    contact[placeContact].setPrenom(rep);
                                    break;
                                case 'a' :
                                    Adresse adresse = new Adresse("1A","rue",null,"Saguenay","Quebec","Canada");
                                    System.out.println("-=-Adresse Personnelle-=-");
                                    System.out.println("Pays de résidence :");
                                    rep=sc.next();
                                    adresse.setPays(rep);
                                    System.out.println("Province/État de résidence :");
                                    rep=sc.next();
                                    adresse.setProvince(rep);
                                    System.out.println("Ville de résidence :");
                                    rep=sc.next();
                                    adresse.setVille(rep);
                                    System.out.println("Appartement (o/n) :");
                                    repChar=sc.next().toLowerCase().charAt(0);
                                    if (repChar=='o'){//facultatif
                                        System.out.println("Nom de l'appart :");
                                        rep=sc.next();
                                        adresse.setAppart(rep);
                                    }
                                    System.out.println("Rue :");
                                    rep=sc.next();
                                    adresse.setRue(rep);
                                    System.out.println("Numero de porte");
                                    rep=sc.next();
                                    adresse.setNumPorte(rep);

                                    contact[placeContact].setAdresse(adresse);
                                    break;
                                case 'o' :
                                    Occupation occupation = new Occupation(null,null);
                                    Entreprise entreprise = new Entreprise(null,null);

                                    System.out.println("-=-Information-=-");
                                    System.out.println("Occupation :");
                                    rep=sc.next();

                                    occupation.setPoste(rep);

                                    Adresse adresse1 = new Adresse("1A","rue",null,"Saguenay","Quebec","Canada");
                                    System.out.println("Entreprise d'employement :");
                                    rep=sc.next();
                                    entreprise.setNom(rep);
                                    System.out.println("-=-Adresse de l'entreprise-=-");
                                    System.out.println("Pays de résidence :");
                                    rep=sc.next();
                                    adresse1.setPays(rep);
                                    System.out.println("Province/État de résidence :");
                                    rep=sc.next();
                                    adresse1.setProvince(rep);
                                    System.out.println("Ville de résidence :");
                                    rep=sc.next();
                                    adresse1.setVille(rep);
                                    System.out.println("Rue :");
                                    rep=sc.next();
                                    adresse1.setRue(rep);
                                    System.out.println("Numero de porte");
                                    rep=sc.next();
                                    adresse1.setNumPorte(rep);

                                    entreprise.setAdresseEnt(adresse1);

                                    occupation.setEntreprise(entreprise);

                                    contact[placeContact].setOccupation(occupation);
                                    break;
                                case 'i' :
                                    System.out.println("-=-Telephone-=-");
                                    for(int j=0;j<10&&!fini;j++){
                                        Telephone telephone = new Telephone();
                                        System.out.println("Numero de telephone");
                                        rep=sc.next();
                                        telephone.setNum(rep);
                                        System.out.println("Information de Contact");
                                        rep=sc.next();
                                        telephone.setInformation(rep);


                                        System.out.println("Voulez-vous ajoutez un numéro? (o/n)");
                                        repChar=sc.next().toLowerCase().charAt(0);
                                        if (repChar=='n'){
                                            fini=true;
                                        }
                                    }
                                    fini=false;
                                    break;
                                default :
                                    System.out.println("ok");
                                    break;
                            }
                            System.out.println("Voulez-vous modifiez d'autres parametres? (o/n)");
                            repChar=sc.next().toLowerCase().charAt(0);
                            if (repChar=='n'){
                                fini1=true;
                            }
                        }
                    }
                    else{
                        System.out.println("Cet emplacement est vide");
                    }

                    break;
                case 3 :
                    String k;
                    System.out.println("Quel contact voulez vous afficher? (dites prénom)");
                    k=sc.next();
                    System.out.println("");
                    afficherContacts(k,contact);
                    break;
                case 7 :
                    System.exit(0);
                default :
                    System.out.println("?????????");
                    break;
            }
        }

    }
    public static int listeChoix(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Que voulez-vous faire?");
        System.out.println(" 1-Ajouter un contact");
        System.out.println(" 2-Modifier un contact");
        System.out.println(" 3-Afficher un contact");
        System.out.println(" 4-Supprimer un contact");
        System.out.println(" 5-Ajouter un contact à la liste de rappels");
        System.out.println(" 6-Voir la liste de rappels");
        System.out.println(" 7-Quitter");
        System.out.println("");
        return sc.nextInt();
    }
    public static void afficherContacts(HashMap<String, Contact> liste){
        int i=0;
        for (Contact contact : liste.values()){
            i++;
            System.out.println("-----------------------------------------------------");
            System.out.println("");
            System.out.println("Prénom : "+contact.getPrenom());
            System.out.println("Nom : "+contact.getNom());
            System.out.println("  ");
            contact.getAdresse().afficherAdresse();
            System.out.println("");
            contact.getOccupation().afficherOccupation();
            System.out.println("");
            contact.afficherTelephones();
            System.out.println("-----------------------------------------------------");
        }

        if (i==0){
            System.out.println("Auncun contact à afficher");
            System.out.println("");
        }
    }
}
