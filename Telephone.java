import java.util.Scanner;

/**
 * Created by BelSi1731422 on 2018-01-22.
 */
public class Telephone {
    private String information;
    private String num;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void afficherTel(){
        System.out.println("Numero de telephone : " +num);
        System.out.println("Information : "+information);
    }
    public static Telephone creerTelephone() {
        Scanner sc = new Scanner(System.in);
        Telephone telephone = new Telephone();
        System.out.print("À quoi correspond ce numéro (cellulaire, maison, travail, …) ? ");
        telephone.information = sc.next();
        System.out.print("Quel est le numéro ? ");
        telephone.num = sc.next();
        return telephone;
    }
    public void modifierTelephone() {
        Scanner sc = new Scanner(System.in);
        String entre;
        System.out.print("  " + information + " (" + num + ") : ");
        entre =sc.nextLine().trim();
        if (!entre.equals("")) {
            num=entre;
        }
    }
}
