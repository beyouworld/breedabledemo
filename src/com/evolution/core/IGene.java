package com.evolution.core;

public interface IGene {

    int getSize();

    String getName();

    String getPhenotypeFromAlleleSet(Boolean[] alleles);
}
