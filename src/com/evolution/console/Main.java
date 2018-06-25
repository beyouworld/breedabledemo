package com.evolution.console;

import com.evolution.core.*;
import com.evolution.core.mutation.Mutation;
import com.evolution.core.mutation.RandomMutation;
import com.evolution.core.mutation.RandomRecombination;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Setup mutation characteristics
        List<Mutation> mutations = new ArrayList<>();
        mutations.add(new RandomRecombination());
        //mutations.add(new RandomMutation(5));
        Genome genome = new Genome(mutations);

        // Configure genome
        Gene tailType = new CompleteDominanceGene("Tail Type", "Curly", "Straight");
        Gene color = new CompleteDominanceGene("Color", "White", "Red", "Blue", "Black");
        Gene pattern = new CompleteDominanceGene("Pattern", "Polka Dots", "Stripes", "Patches", "Solid");
        genome.addGene(tailType);
        genome.addGene(color);
        genome.addGene(pattern);

        // Test subjects
        Individual male = new Individual(genome, Sex.Male, new Chromosome("11111"), new Chromosome("00000"));
        Individual female = new Individual(genome, Sex.Female, new Chromosome("00000"), new Chromosome("11111"));
        Individual child1 = male.mate(female);
        Individual child2 = male.mate(female);
        Individual grandkid = child1.mate(child2);

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(grandkid);
    }
}
