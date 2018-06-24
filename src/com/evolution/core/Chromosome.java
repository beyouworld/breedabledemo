package com.evolution.core;

public class Chromosome {
    public Boolean[] Alleles;

    public Chromosome(Boolean... alleles) {
        Alleles = alleles;
    }

    public Chromosome(String alleles) {
        Alleles = new Boolean[alleles.length()];

        for(int i = 0; i < alleles.length(); i++) {
            Alleles[i] = alleles.charAt(i) == '1';
        }
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < Alleles.length; i++) {
            result += Alleles[i] ? "1" : "0";
        }

        return result;
    }
}
