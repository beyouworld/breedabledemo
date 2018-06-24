package com.evolution.core;


import com.evolution.core.mutation.Mutation;

import java.util.List;

public class Genome {
    public List<Gene> genes;
    private final List<Mutation> mutations;

    public Genome(List<Mutation> mutations) {
        this.mutations = mutations;
    }

    public List<Mutation> getMutations() {
        return this.mutations;
    }

    public String getPhenotype(Gene gene, Chromosome[] chromosomes) {
        int startingLocus = getStartingLocus(gene);
        Boolean[] expressedAlleles = new Boolean[gene.getSize()];

        for(int i = 0; i < gene.getSize(); i++) {
            int locus = startingLocus + i;

            expressedAlleles[i] = gene.isExpressed(chromosomes[0].Alleles[locus], chromosomes[1].Alleles[locus]);
        }

        return gene.getPhenotypeFromAlleleSet(expressedAlleles);
    }

    private int getStartingLocus(Gene gene) {
        int result = 0;

        for(Gene candidate : genes) {
            if(gene == candidate) {
                return result;
            }

            result += candidate.getSize();
        }

        return -1;
    }
}
