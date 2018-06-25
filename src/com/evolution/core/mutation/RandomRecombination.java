package com.evolution.core.mutation;

import com.evolution.core.Chromosome;

import java.util.Random;

public class RandomRecombination implements Mutation {

    @Override
    public Chromosome[] mutate(Chromosome[] input) {

        int numChromosomes = input.length;
        Chromosome[] result = new Chromosome[numChromosomes];

        Random rand = new Random();
        int numAlleles = input[0].Alleles.length;

        for(int i = 0; i < numChromosomes; i++) {
            result[i] = new Chromosome(new Boolean[numAlleles]);
        }

        for(int locus = 0; locus < numAlleles; locus++) {

            // Copy alleles
            for(int i = 0; i < numChromosomes; i++) {
                result[i].Alleles[locus] = input[i].Alleles[locus];
            }

            if(rand.nextBoolean()) {

                // Swap alleles
                for(int i = 0; i < numChromosomes - 1; i++) {
                    int chromosomeToSwap = i + 1 + rand.nextInt(numChromosomes - 1) % numChromosomes;
                    result[i].Alleles[locus] = input[chromosomeToSwap].Alleles[locus];
                }
            }
        }

        return result;
    }
}
