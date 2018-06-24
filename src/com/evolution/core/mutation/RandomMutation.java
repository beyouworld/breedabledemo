package com.evolution.core.mutation;

import com.evolution.core.Chromosome;

import java.util.Random;

public class RandomMutation implements Mutation {

    private final float errorPercentage;

    public RandomMutation(float errorPercentage) {
        this.errorPercentage = errorPercentage;
    }

    @Override
    public Chromosome[] mutate(Chromosome[] input) {

        Chromosome[] result = new Chromosome[input.length];

        Random rand = new Random();
        int numAlleles = input[0].Alleles.length;

        // Initialize copied chromosomes
        for(int i = 0; i < input.length; i++) {
            result[i] = new Chromosome(new Boolean[numAlleles]);

            for(int locus = 0; locus < numAlleles; locus++) {
                if (rand.nextInt((int) (100 / errorPercentage)) == 1) {
                    // Error in copying allele
                    result[i].Alleles[locus] = !input[i].Alleles[locus];
                } else {
                    // Perfect copy
                    result[i].Alleles[locus] = input[i].Alleles[locus];
                }
            }
        }

        return result;
    }
}
