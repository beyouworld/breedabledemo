package com.evolution.core;

public class CompleteDominanceGene implements Gene{
    private final int size;
    private final String[] phenotypes;
    private final String name;

    public CompleteDominanceGene(String name, String... phenotypes) {
        this.name = name;
        this.size = (int) (Math.log(phenotypes.length) / Math.log(2));
        this.phenotypes = phenotypes;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String interpretPhenotype(Chromosome[] chromosomes, int startingLocus) {
        Boolean[] expressedAlleles = new Boolean[this.getSize()];

        for(int i = 0; i < this.getSize(); i++) {
            int locus = startingLocus + i;

            expressedAlleles[i] = isExpressed(chromosomes[0].Alleles[locus], chromosomes[1].Alleles[locus]);
        }

        return getPhenotypeFromAlleleSet(expressedAlleles);
    }

    private String getPhenotypeFromAlleleSet(Boolean[] alleles) {
        int phenotype = 0;
        for(int i = 0; i < alleles.length; i++) {
            if(alleles[i]) phenotype += Math.pow(2, i);
        }

        return phenotypes[phenotype];
    }

    private Boolean isExpressed(Boolean... alleles) {
        return alleles[0] || alleles[1];
    }
}
