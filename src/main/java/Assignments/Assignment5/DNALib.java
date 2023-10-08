package Assignments.Assignment5;

public class DNALib {
    public static void main(String[] args) {
        System.out.println(validator("GATACA"));
        System.out.println(reverser("CAT"));
    }
    public static boolean validator(String dna) {
        if (dna.length() % 3 != 0) return false;
        if (dna.equals("")) return false;
        switch (dna.toUpperCase().charAt(0)) {
            case 'G', 'C', 'A','T': return validator(dna.substring(1) + '\0');
            case '\0': return true;
            default: return false;
        }
    }

    public static String reverser(String dna) {
        if (dna.length() == 0) {
            return "";
        }
        return dna.charAt(dna.length() - 1) + reverser(dna.substring(0, dna.length() - 1));
    }
}

