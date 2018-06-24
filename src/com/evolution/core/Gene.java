package com.evolution.core;

public interface Gene {

    int getSize();

    String getName();

    String interpretPhenotype(Chromosome[] chromosomes, int startingLocus);
}
