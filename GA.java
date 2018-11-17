public class GA {



    public static void main(String[] args) {


        // Set a candidate solution
//        FitnessCalc.setSolution("0000");

        int time=(int)(Math.random()*((99-10)+1)+10);
        int initialSize=(int)(Math.random() * ((8 - 3) + 1)) + 3;
        // Create an initial population
        System.out.println("the initial size of population is "+initialSize);
        Population myPop = new Population(initialSize, true);  //build a population with

        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        int sameNum=0;
//        while (myPop.getFittest().getFitness() != FitnessCalc.getMaxFitness()) {
        while(sameNum<time){
            generationCount++;
            if(FitnessCalc.getMaxFitness()<myPop.getFittest().getFitness()){
                FitnessCalc.maxft=myPop.getFittest().getFitness();
            }
           myPop = Algorithm.evolvePopulation(myPop);  //there must be a problem
            if(myPop.getFittest().getFitness()==FitnessCalc.getMaxFitness()){
                sameNum++;
            }
            System.out.println("Generation: " + generationCount);
            System.out.println("Gene is "+myPop.getFittest());
            System.out.println("Fittest of this Gene: " + myPop.getFittest().getFitness());

        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes: "+myPop.getFittest());
        System.out.println(FitnessCalc.getMaxFitness());

    }
}
