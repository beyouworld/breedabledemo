package com.evolution.core;

import com.evolution.core.mutation.Mutation;

import java.util.List;
import java.util.Random;

public class Individual {
    public Chromosome[] chromosomes;
    public Sex sex;
    public Genome genome;

    public Individual(Genome genome, Sex sex, Chromosome... chromosomes) {
        this.genome = genome;
        this.sex = sex;
        this.chromosomes = chromosomes;
    }

    public Individual mate(Individual mate) {
        Chromosome[] chromosomes = new Chromosome[2];
        chromosomes[0] = getRandomChromosome(this.chromosomes); // my genes
        chromosomes[1] = getRandomChromosome(mate.chromosomes); // mate's genes
        Individual offspring = new Individual(genome, getRandomSex(), chromosomes);

        return offspring;
    }

    private Chromosome getRandomChromosome(Chromosome[] chromosomes) {

        Chromosome[] recombined = performMutations(chromosomes, genome.getMutations());
        Random rand = new Random();
        return recombined[rand.nextInt(chromosomes.length)];
    }

    private Chromosome[] performMutations(Chromosome[] input, List<Mutation> mutations) {
        Chromosome[] result = input;

        for(Mutation mutation : mutations) {
            result = mutation.mutate(result);
        }

        return result;
    }

    private Sex getRandomSex() {
        Random rand = new Random();
        return rand.nextBoolean() ? Sex.Male : Sex.Female;
    }

    @Override
    public String toString() {

        String result = "";

        for(int i = 0; i < chromosomes.length; i++) {
            result += "Chromosome " + i + ": " + chromosomes[i].toString() + "\n";
        }

        result += sex.toString() + "\n";

        for(Gene gene : genome.genes) {
            result += gene.getName() + ": " + genome.getPhenotype(gene, chromosomes) + "\n";
        }

        return result;

    }
}
