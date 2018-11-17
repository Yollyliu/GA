public class Algorithm {


        private static final double crossoverRate = 0.85;
        private static final double mutationRate = 0.15;
        private static final boolean elitism = true;
        private static final int parentNumber = 1;


        public static Population evolvePopulation(Population pop) {
//            Population newPopulation = new Population(pop.size(), false);

            // always save the fittest in the first
            if (elitism) {
                Individual temp=pop.getFittest();
                int index=pop.getFittestIndex();
                pop.saveIndividual(index,pop.getIndividual(0));
                pop.saveIndividual(0, pop.getFittest());
            }

            // Crossover population
            int elitismOffset;
            if (elitism) {       //if have fittest, then write 1, or write 0
                elitismOffset = 1;
            } else {
                elitismOffset = 0;
            }

            for (int i = elitismOffset; i < pop.size()-1; i++) {
                System.out.println("doing crossover now:");

                System.out.println();
                System.out.println();
                System.out.println("doing "+i+ " small steps: ");
                System.out.println();
                System.out.println();
                System.out.println("first tourname Selection now: ");
                System.out.println();
                Individual indiv1 = tournamentSelection(parentNumber);
                double f1=indiv1.getFitness();
                System.out.println("the fittest in first is "+indiv1.toString());
                System.out.println("the fitness in first is "+indiv1.getFitness());
                System.out.println();
                System.out.println();


                System.out.println("second tourname selection now: ");
                System.out.println();
                Individual indiv2 = tournamentSelection(parentNumber);
                double f2=indiv2.getFitness();
                System.out.println("the fittest in second is "+indiv2.toString());
                System.out.println("the fitness in second is "+indiv2.getFitness());
                System.out.println();
                System.out.println("doing crossover between those two "+
                        indiv1.toString()+" "+indiv2.toString());


                Individual newIndiv = crossover(indiv1, indiv2);
                double f3=newIndiv.getFitness();
                System.out.println("the fittest in crossover is "+newIndiv.toString()+
               " : "+newIndiv.getFitness());
                System.out.println();

                double tepMax= Math.max(Math.max(f1,f2),f3);
                Individual fnew;

                if(tepMax==f1){
                    pop.saveIndividual(i, indiv1);
                    fnew=indiv1;
                }else if(tepMax==f2){
                    pop.saveIndividual(i, indiv2);
                    fnew=indiv2;
                }else {
                    fnew=newIndiv;

                    pop.saveIndividual(i, newIndiv);
                }

                System.out.println("from those operation, we get "+ fnew+ " : "+tepMax);

                System.out.println("we are mutation each gene.");
                mutate(pop.getIndividual(i));




            }

            // Mutate population
            for (int i = elitismOffset; i < pop.size(); i++) {

                mutate(pop.getIndividual(i));
                System.out.println("we are mutation each gene.");
            }

//            System.out.println("hi, we are at Algorithm class in evolvePopulation");
//            System.out.println("the size of new population is "+ newPopulation.size());

            return pop;
        }

        // Crossover individuals
        private static Individual crossover(Individual indiv1, Individual indiv2) {
            Individual newSol = new Individual();

////            System.out.println("Before crossover, two fitness gene is "+
//            indiv1.toString()+"  " +indiv2.toString());
            for (int i = 0; i < indiv1.size(); i++) {
                // Crossover
                if (Math.random() <= crossoverRate) {
                    newSol.setGene(i, indiv1.getGene(i));
                } else {
                    newSol.setGene(i, indiv2.getGene(i));
                }
            }
            System.out.println("After crossover, the gene is "+ newSol.toString());
            return newSol;
        }

        // Mutate an individual
        private static void mutate(Individual indiv) {
            // Loop through genes
            System.out.println();
            System.out.println("before mutate, the gene is "+ indiv.toString());
            for (int i = 0; i < indiv.size(); i++) {
                if (Math.random() <= mutationRate) {
                    // Create random gene
                    byte gene = (byte) Math.round(Math.random());
                    indiv.setGene(i, gene);
                }
            }
            System.out.println("after mutate, the gene is "+indiv.toString());
            System.out.println();
        }

        // Select individuals for crossover
        private static Individual tournamentSelection(int num) {

            Population tournament = new Population(num, true);

            Individual fittest = tournament.getFittest();

            return fittest;
        }

}
