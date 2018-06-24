package com.evolution.core.mutation;

import com.evolution.core.Chromosome;

public interface Mutation {

    Chromosome[] mutate(Chromosome[] chromosomes);
}
