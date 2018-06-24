package com.evolution.core;


import com.evolution.core.mutation.Mutation;

import java.util.ArrayList;
import java.util.List;

public class Genome {
    private final List<Gene> genes;
    private final List<Mutation> mutations;

    public Genome(List<Mutation> mutations) {
        this.mutations = mutations;
        this.genes = new ArrayList<>();
    }

    public void addGene(Gene gene) {
        this.genes.add(gene);
    }

    public List<Gene> getGenes() {
        return this.genes;
    }

    public List<Mutation> getMutations() {
        return this.mutations;
    }

    public String interpretPhenotype(Gene gene, Chromosome[] chromosomes) {
        int startingLocus = getStartingLocus(gene);

        return gene.interpretPhenotype(chromosomes, startingLocus);
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
