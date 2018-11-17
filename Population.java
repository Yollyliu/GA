public class Population {

    Individual[] individuals;  //store population


    // Create a population
    public Population(int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];

        System.out.println("Following is a population of "+populationSize);
        if (initialise) {
           // System.out.println("hello");
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
                System.out.println(newIndividual.toString()+"：" + newIndividual.getFitness());  //print the each gene
            }
        }
    }


    public Individual WheelSelection() {

        double m = Math.random();
        double Probability_Total = 0;
        int Selection = 0;
        for (int i = 0; i < individuals.length; i++)
        {
            Probability_Total = Probability_Total + possibilityInd(i);
            if (Probability_Total >= m) {
                Selection = i;
                break;
            }

        }
        return individuals[Selection];
    }

    public double possibilityInd(int targ){
        double sum=0;
        for(int i=0;i<individuals.length;i++){
            sum+=getIndividual(i).getFitness();
        }
        double ans=getIndividual(targ).getFitness()/sum;
        return ans;
    }





    public Individual getIndividual(int index) {   //get the gene of one choice in individual
        return individuals[index];
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];    //this fittest is individual

        for (int i = 0; i < size(); i++) {

            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;  //get the fittest individual
    }

    public int getFittestIndex() {
        int ans= 0;    //this fittest is individual
        Individual fittest = individuals[0];

        for (int i = 0; i < size(); i++) {

            if ( fittest.getFitness()<=getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
                ans=i;
            }
        }
        return ans;  //get the fittest individual
    }

    public int size() {
        return individuals.length;
    }


    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}
