/**
 * WildlifeSimulator - Manages population dynamics for multiple species
 * Uses an array of Species objects to store and simulate species data
 */
public class WildlifeSimulator {
    private Species[] species;
    private int speciesCount;
    
    public WildlifeSimulator(int maxSpecies) {
        //TODO
        species = new Species[maxSpecies];

    }
    
    /**
     * Add a species to the simulator
     */
    public void addSpecies(Species s) {
        //TODO
        species[speciesCount++] = s;
    }
    
    /**
     * Simulate one year of population changes for all species
     */
    public void simulateYear() {
        //call each species simulate year, loop species array
        for(Species s : species){
            if(s != null){
                s.simulateYear();
            }
        }
       

    }
    
    /**
     * Simulate multiple years
     */
    public void simulate(int years) {
        //loop for years, each year call simulate year
        for(int i = 0; i<years; i++){
            simulateYear();
        }
    }
    
    /**
     * Get species at given index
     */
    public Species getSpecies(int index) {
        if(index >= this.species.length){
            throw new IllegalArgumentException();
        }
        return this.species[index];
    }
    
    /**
     * Get species info as formatted string
     */
    public String getSpeciesInfo(int index) {
        return species[index].toString();
    }

    public String toString(){
        String m = "";
        for(Species s: species){
            if(s != null)
            m += s.toString() + "\n";
        
    }
        return m;
    }
    
    /**
     * Get total wildlife count across all species
     */
    public double getTotalPopulation() {
        long totalPop = 0;
        for(Species s : species){
            if(s != null)
                totalPop += s.getPopulation();
        }
        return totalPop;
    }
    
    /**
     * Find the species with largest population
     */
    public int getMostPopulousIndex() {
        //TODO
        int maxPopIndex = 0;
        for(int i = 0; i<speciesCount; i++){
            if(this.species[maxPopIndex].getPopulation() < this.species[i].getPopulation()){
                maxPopIndex = i;
            }
        }
        return maxPopIndex;
    }
    
    /**
     * Find the species with smallest population (most endangered)
     */
    public int getMostEndangeredIndex() {
        //TODO
        int minPopIndex = 0;
        for(int i = 0; i<speciesCount; i++){
            if(this.species[minPopIndex].getPopulation() > this.species[i].getPopulation()){
                minPopIndex = i;
            }
        }
        return minPopIndex;
    }
    
    public int getSpeciesCount() {
        return speciesCount;
    }
    
    /**
     * Get array of all species
     */
    public Species[] getSpeciesArray() {
        return species;
    }
}
