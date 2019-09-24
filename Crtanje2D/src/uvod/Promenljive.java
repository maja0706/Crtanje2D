package uvod;

public class Promenljive {

	public static void main(String[] args) {
		boolean b;
		int prviBroj;
		
		prviBroj = 7;
		
		int drugiBroj = 5;
		
		int kolicnik = prviBroj / drugiBroj;
		
		System.out.println(kolicnik);
		
		boolean prviVeciOdDrugog = prviBroj > drugiBroj;

		System.out.println(prviVeciOdDrugog);
		
		boolean uvekFalse = false;
		
		System.out.println(prviVeciOdDrugog && uvekFalse);
		
		System.out.println(prviVeciOdDrugog || uvekFalse);
		
		char space = ' ';
		
		String ime = "Petar";
		
		String prezime = "Petrovic";
		
		System.out.println(ime + space + prezime);
		
		System.out.println("Grananje IF");
		
		if (prviBroj > 0) {
			System.out.println("Broj je pozitivan.");
		} else if (prviBroj == 0) {
			System.out.println("Broj je 0.");
		} else {
			System.out.println("Broj je negativan.");
		}
		
		System.out.println("Petlje WHILE");
		int i = 1;
		
		while (i<=10) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("Petlje DO WHILE");
		
		i = 1;
		
		do {
			System.out.println(i);
		} while (i>10);
		
		System.out.println("Petlje FOR");
		for (i=1;i<=10;i++) {
			System.out.println(i);
		}
		
		System.out.println("Poziv metode sabiranje(5,6)");
		System.out.println(sabiranje(5,6));
		
		System.out.println("Poziv metode konobar()");
		konobar();
		
System.out.println("pomocu for petlje ispisati prirodne brojeve od 1 do 5");
		
		for (i=1; i<=5; i++) {
			System.out.println(i);
		}
		
		System.out.println("pomocu for petlje ispisati prirodne brojeve od 8 do 3");
		
		for (i=8;i>=3;i--) {
		System.out.println(i); }
		
		System.out.println("pomocu for petlje ispisati sumu prvih 5 prirodnih brojeva.");
		
		int zbir = 0;
		for (i=1;i<=5; i++) {
		zbir = zbir + i; 
		} 
		System.out.println(zbir);
		
		System.out.println("pomocu while petlje ispisati faktorijel prvih 5 prirodnih brojeva.");
		
		int faktorijel = 1;
		i=1;
		while (i<=5) {
			faktorijel = faktorijel * i;
			i++;
		}
		System.out.println(faktorijel);

		
		System.out.println("pomocu while petlje pronaci broj 6 u intervalu 1 do 10");
		
		i=1;
		int brojac = 0;
		
		while(i<=10) {
			brojac = brojac + 1;
			if (i == 6) {
				System.out.println("Pronasao sam broj 6... Jupi..");
				break;
			}
			i++;
		}
		
		System.out.println("Brojac je na: " + brojac);
		
		System.out.println("pomocu while petlje ispisati samo neparne brojeve u intervalu 1 do 10");
		
		i = 1;
		while(i<=10) {
			if (i%2 == 0) {
				i++;
				continue;
			}
			
			System.out.println(i);
			i++;
		}
		
		System.out.println("pomocu for i if ispisati samo parne brojeve u intervalu 1 do 50");
		
		i=1;
		while (i<=50) {
			if(i%2==0) {
				System.out.println(i);	
			}
			
			i++;
			
		} 
		
		System.out.println("pomocu for, if i break ispisati prvi broj koji je deljiv sa 12 u intervalu od 50 do 100");
		
		
		for (i=50; i<=100; i++) {
			if (i%12==0) {
				System.out.println(i);
				break;
			}
		}
		
		System.out.println("pomocu for, if i continue ispisati prvih 10 brojeva i oznaciti koji su parni, a koji ne");
		
		
		
		for (i=1; i<=10; i++) {
			if (i%2==0) {
				System.out.println("Broj " + i + " je paran.");
				continue;
			}
			System.out.println("Broj " + i + " je neparan.");
		}
		
		int[] niz = new int[5];
		niz[0] = 10;
		niz[1] = 20;
		niz[2] = 30;
		niz[3] = 40;
		niz[4] = 50;
		
		System.out.println("Treci element niza je " + niz[2]);
		
		System.out.println("Proveriti da li je cetvrti element niza pozitivan broj i ispisati poruku ako jeste.");
		
		if (niz[3]>0) {
			System.out.println("Broj je pozitivan");

		}
		
		System.out.println("Uporediti treci i drugi element niza i ispisati koji je veci, zanemariti jednakost.");
		
		if (niz[2] > niz[1]) {
			
			System.out.println("Treci element je veci.");
		} else {
			System.out.println("Drugi element je veci.");
		}
		
		System.out.println("Ispisati sve elemente niza, koristeci for i length");
		
		for(i=0;i<niz.length;i++) {
			System.out.println(niz[i]);
			
		}
		
		String s1;
		s1="Pera";
		String s2;
		s2="Pera";
		
		if (s1==s2) {
			System.out.println("Stringovi su jednaki");
			
			
		}
		else {
			System.out.println("Stringovi nisu jednaki");
		}
		
		
		if (s1.equals(s2)) {
			System.out.println("Stringovi su jednaki");
			
			
		}
		else {
			System.out.println("Stringovi nisu jednaki");
		}
		
		if (s1.equalsIgnoreCase(s2)) {
			System.out.println("Stringovi su jednaki");
			
			
		}
		else {
			System.out.println("Stringovi nisu jednaki");
		}
		
	}
	
	public static int sabiranje(int x, int y) {
		return x + y;
	}
	
	public static void konobar(){
		System.out.println("Dobar dan. Izvolite...");
	}

}
