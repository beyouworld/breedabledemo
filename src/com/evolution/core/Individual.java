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

    public Individual mate(Individual... mates) {
        int numChromosomes = this.chromosomes.length;

        for(Individual mate : mates) {
            if (mate.chromosomes.length > numChromosomes) {
                numChromosomes = mate.chromosomes.length;
            }
        }
        
        Chromosome[] combined = new Chromosome[numChromosomes];
        combined[0] = getRandomChromosome(this.chromosomes); // my genes

        for(int i = 1; i < numChromosomes; i++) {
            combined[i] = getRandomChromosome(mates[i - 1].chromosomes); // mates' genes
        }

        Individual offspring = new Individual(genome, getRandomSex(), combined);

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

        for(Gene gene : genome.getGenes()) {
            result += gene.getName() + ": " + genome.interpretPhenotype(gene, chromosomes) + "\n";
        }

        return result;

    }
}
