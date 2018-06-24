package com.evolution.core.mutation;

import com.evolution.core.Chromosome;

public class Clone implements Mutation {
    @Override
    public Chromosome[] mutate(Chromosome[] input) {
        Chromosome[] result = new Chromosome[input.length];

        int numAlleles = input[0].Alleles.length;

        for(int i = 0; i < input.length; i++) {
            result[i] = new Chromosome(new Boolean[numAlleles]);
            for (int locus = 0; locus < numAlleles; locus++) {
                // Copy alleles
                result[i].Alleles[locus] = input[i].Alleles[locus];
            }
        }
        return result;
    }
}
