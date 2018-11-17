public class Individual {


        static int defaultGeneLength = 4;
        private byte[] genes = new byte[defaultGeneLength];  //for every generation, has four gene
        // Cache
        private double fitness = 0;

        // Create a random individual
        public void generateIndividual() {
            for (int i = 0; i < size(); i++) {
                byte gene = (byte) Math.round(Math.random());
                genes[i] = gene;
            }
        }


        public byte getGene(int index) {
            return genes[index];
        }

        public void setGene(int index, byte value) {
            genes[index] = value;
            fitness = 0;
        }


        public int size() {
            return genes.length;
        }

        public double getFitness() {


            if (fitness == 0) {
                fitness = FitnessCalc.getFitness(this);
            }
            return fitness;
        }


        public String toString() {
            String geneString = "";
            for (int i = 0; i < size(); i++) {
                geneString += getGene(i);
            }
            return geneString;
        }

}
