package com.evolution.core;

public class Gene {
    private final int size;
    private final String[] phenotypes;
    private final String name;

    public Gene(String name, String... phenotypes) {
        this.name = name;
        this.size = (int) (Math.log(phenotypes.length) / Math.log(2));
        this.phenotypes = phenotypes;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public String getPhenotypeFromAlleleSet(Boolean[] alleles) {
        int phenotype = 0;
        for(int i = 0; i < alleles.length; i++) {
            if(alleles[i]) phenotype += Math.pow(2, i);
        }

        return phenotypes[phenotype];
    }

    public Boolean isExpressed(Boolean... alleles) {
        return alleles[0] || alleles[1];
    }
}
