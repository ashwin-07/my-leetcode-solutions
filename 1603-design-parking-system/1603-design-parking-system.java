class ParkingSystem {
    
    int[] parkingCapacity;

    public ParkingSystem(int big, int medium, int small) {
         parkingCapacity = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        return --parkingCapacity[carType - 1] >= 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */