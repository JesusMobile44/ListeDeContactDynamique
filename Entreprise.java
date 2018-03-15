import java.util.Scanner;

/**
 * Created by BelSi1731422 on 2018-01-22.
 */
public class Entreprise {
    private String nom;
    private Adresse adresseEnt;

    public Entreprise(String nom, Adresse adresseEnt) {
        this.nom = nom;
        this.adresseEnt = adresseEnt;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresseEnt() {
        return adresseEnt;
    }

    public void setAdresseEnt(Adresse adresseEnt) {
        this.adresseEnt = adresseEnt;
    }

    public static Entreprise creerEntreprise(){
        String rep;
        char repChar;
        Scanner sc = new Scanner(System.in);

        Entreprise entreprise = new Entreprise(null,null);

        System.out.println("Entreprise d'employement :");
        rep=sc.next();
        entreprise.setNom(rep);

        entreprise.setAdresseEnt(Adresse.creerAdresse());

        return entreprise;
    }
    public void afficherEntreprise(){
        System.out.println("Entreprise d'employement : "+nom);
        System.out.println("");
        System.out.println("-=-Adresse Entreprise-=-");
        adresseEnt.afficherAdresse();
    }
    public void modifierEntreprise(){
        Scanner sc = new Scanner(System.in);
        String entre;
        System.out.println("  Entreprise : ");
        System.out.print("    Nom (" + nom+ ") : ");
        entre=sc.nextLine().trim();
        if(!entre.equals("")) {
            nom=entre;
        }
        getAdresseEnt().modifierAdresse();
    }
    public void ajouterEntreprise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("  Entreprise : ");
        System.out.print("    Nom : ");
        nom=sc.next();
        getAdresseEnt().creerAdresse();
    }
}
