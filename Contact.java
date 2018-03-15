import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by BelSi1731422 on 2018-01-22.
 */
public class Contact {
    private String nom;
    private String prenom;
    private Adresse adresse;
    private Occupation occupation;
    private ArrayList<Telephone> listeNumero = new ArrayList<Telephone>();
    private int nombreTelephones= 0;


    private int nbTel = 0;

    public Contact() {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.occupation = occupation;
        this.listeNumero = listeNumero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public List<Telephone> getListeNumero() {
        return listeNumero;
    }

    /*public void setListeNumero(List<Telephone> listeNumero) {
        this.listeNumero = listeNumero;
    }*/

    public int getNbTel() {
        return nbTel;
    }

    public void setNbTel(int nbTel) {
        this.nbTel = nbTel;
    }

    public void afficherContact(){
        System.out.println("");
        System.out.println("Nom : "+nom);
        System.out.println("Prenom : "+prenom);
        System.out.println("");
        System.out.println("-=-Adresse Personnelle-=-");
        adresse.afficherAdresse();

        occupation.afficherOccupation();

        System.out.println("-=-Téléphones-=-");
        for(Telephone telephone:listeNumero){
            System.out.println("  "+telephone.getInformation()+" : "+telephone.getNum());
        }
        System.out.println();
    }
    public static Contact ajouterContact(){
        int placeContact;
        String rep;
        char repChar;
        boolean fini = false;
        Contact contact[] = new Contact[10];

        Scanner sc = new Scanner(System.in);

        System.out.println("Dans quel emplacement voulez-vous ajouter un contact?(1 à 20)");
        placeContact=sc.nextInt();

        if (contact[placeContact]==null){

            List<Telephone> listeNumero = new ArrayList<Telephone>();
            Contact dude = new Contact();
            contact[placeContact-1]=dude;
            repChar = 'o';

            //Question
            System.out.println("Prénom :");
            rep=sc.next();
            dude.setPrenom(rep);

            System.out.println("Nom :");
            rep=sc.next();
            dude.setNom(rep);

            //adresse
            dude.setAdresse(Adresse.creerAdresse());

            //Occupation
            System.out.println("-=-Information-=-");
            dude.setOccupation(Occupation.creerOccupation());

            //Num de Telephone
            System.out.println("-=-Telephone-=-");
            repChar = 'o';
            while (repChar != 'n') {
                if(repChar=='o') {
                    Telephone telephone=Telephone.creerTelephone();
                    dude.listeNumero.add(telephone);
                    System.out.println();
                    dude.setNombreTelephones();
                    System.out.println("Voulez-vous ajoutez un numéro?");
                    repChar=sc.next().toLowerCase().charAt(0);
                }
                else{
                    repChar='n';
                }
            }
            return dude;
        }
        else{
            System.out.println("Cet emplacement de contact est occupé.");
            return null;
        }
    }
    public void modifierContact(){
        Scanner sc = new Scanner(System.in);
        char choixChar=0;
        String input;
        sc.reset();
        System.out.println("Veuillez entrer les informations suivantes :");
        //CONTACT
        System.out.print("Prénom (" + prenom + ") : ");
        input = sc.nextLine().trim();
        input = sc.nextLine().trim();
        if (!input.equals("")) {
            prenom = input;
        }
        System.out.print("Nom (" + nom + ") : ");
        input = sc.nextLine().trim();
        if (!input.equals("")) {
            nom = input;
        }
        //ADRESSE
        getAdresse().modifierAdresse();
        //OCCUPATION
        getOccupation().modifierOccupation();
        //TELEPHONE
        System.out.println("Téléphones : ");
        for (Telephone telephone:listeNumero) {
            telephone.modifierTelephone();
        }
        System.out.println();
        while (choixChar != 'n') {
            System.out.print("Entrer un numéro de téléphone (o/n) ? ");
            choixChar = sc.next().charAt(0);
            if(choixChar=='o') {
                Telephone tempTelephone=Telephone.creerTelephone();
                listeNumero.add(tempTelephone);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Votre contact a été modifié avec succès !");
    }
    public void setNombreTelephones() {
        this.nombreTelephones=this.nombreTelephones+1;
    }
    public void afficherTelephones(){
        for (int i=0; i<nombreTelephones; i++){
            System.out.println("Téléphone #"+(i+1));
            System.out.println("Information : "+listeNumero.get(i).getInformation());
            System.out.println("Numéro : "+listeNumero.get(i).getNum());
        }
    }
}

