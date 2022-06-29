import java.util.Scanner;

public class temp {
    public temp(String[] args) {
        Scanner s =new Scanner(System.in);
        String dna=s.next();
        int cag=0,cgg=0,ctg=0,gaa=0;
        String disorder="";
        for(int i=0;i<dna.length();i++)
        {
            if((i+2)<=dna.length()-1) {
                if (dna.charAt(i) == 'C' && dna.charAt(i + 1) == 'A' && dna.charAt(i + 2) == 'G') {
                    cag++;
                }
                if (dna.charAt(i) == 'C' && dna.charAt(i + 1) == 'G' && dna.charAt(i + 2) == 'G') {
                    cgg++;
                }
                if (dna.charAt(i) == 'C' && dna.charAt(i + 1) == 'T' && dna.charAt(i + 2) == 'G') {
                    ctg++;
                }
                if (dna.charAt(i) == 'G' && dna.charAt(i + 1) == 'A' && dna.charAt(i + 2) == 'A') {
                    gaa++;
                }
            }
        }
        if(cag>=40 && cag<=62)
        {
            disorder="Spinal and bulbar muscular atrophy";
        }
        if(cgg>=50 && cgg<=1500)
        {
            disorder="Fragile-X syndrome";
        }
        if(cgg>=100 && cgg<=1000)
        {
            disorder="Jacobsen syndrome";
        }
        if(cag>=21 && cag<=130)
        {
            disorder="Spinocerebellar ataxia";
        }
        if(cag>=37 && cag<=220)
        {
            disorder="Autosomal dominant cerebellar ataxia";
        }
        if(ctg>=44 && ctg<=3000)
        {
            disorder="Myotonic dystrophy";
        }
        if(cag>=37 && cag<=121)
        {
            disorder="Huntington disease";
        }
        if(gaa>=200 && gaa<=900)
        {
            disorder="Friedreich ataxia";
        }
        if(cag>=49 && cag<=75)
        {
            disorder="Dentatorubal-pallidoluysian atrophy";
        }

        System.out.println(cag+" "+cgg+" "+ctg+" "+gaa);
        System.out.println(disorder);

    }
}