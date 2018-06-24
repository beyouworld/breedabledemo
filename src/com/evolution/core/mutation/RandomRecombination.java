package com.evolution.core.mutation;

import com.evolution.core.Chromosome;

import java.util.Random;

public class RandomRecombination implements Mutation {

    @Override
    public Chromosome[] mutate(Chromosome[] input) {

        Chromosome[] result = new Chromosome[2];

        Random rand = new Random();
        int numAlleles = input[0].Alleles.length;
        result[0] = new Chromosome(new Boolean[numAlleles]);
        result[1] = new Chromosome(new Boolean[numAlleles]);

        for(int locus = 0; locus < numAlleles; locus++) {
            if(rand.nextBoolean()) {
                // Copy alleles
                result[0].Alleles[locus] = input[0].Alleles[locus];
                result[1].Alleles[locus] = input[1].Alleles[locus];
            } else {
                // Swap alleles
                result[0].Alleles[locus] = input[1].Alleles[locus];
                result[1].Alleles[locus] = input[0].Alleles[locus];
            }
        }

        return result;
    }
}
