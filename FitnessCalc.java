public class FitnessCalc {

    static byte[] solution = new byte[64];
    static double maxft=0.0;


    public static void setSolution(byte[] newSolution) {
        solution = newSolution;
    }

    static void setSolution(String newSolution) {
        solution = new byte[newSolution.length()];

        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);

            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static double getFitness(Individual individual) {
//        System.out.println(individual.toString() );
        double fitness = 0.0;
        double year1=individual.getGene(0)*0.5+individual.getGene(1)+
                individual.getGene(2)*1.5+individual.getGene(3)*0.1;
        double year2=individual.getGene(0)*0.3+individual.getGene(1)*0.8
                +individual.getGene(2)*1.5+individual.getGene(3)*0.4;
        double year3=individual.getGene(0)*0.2+individual.getGene(1)*0.2
                +individual.getGene(2)*0.3+individual.getGene(3)*0.1;

        if(year1<=3.1 && year2<=2.5 && year3<=0.4){
            fitness=individual.getGene(0)*0.2+individual.getGene(1)*0.3
                    +individual.getGene(2)*0.5+individual.getGene(3)*0.1;
//            System.out.println(individual.toString()+" : "+fitness);
        }


        return fitness;
    }


    static double getMaxFitness() {

        return maxft;
    }


}
