class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;


        // sort cars by positon closest to the finish line
        Car[] cars = new Car[n];
        for(int i=0 ; i< n ; i++){
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (a, b) -> b.position - a.position);
        // if a car can catchup with the car in front if it, remove the car in front and add this one to the stack. at the end the size of stack will tell the number of fleet.
        Deque<Car> stack = new ArrayDeque<>();

        for(int i=0 ; i<n ; i++){
            if(stack.isEmpty() ||  ((double)(target - stack.peek().position)/(stack.peek().speed)) < ((target - cars[i].position)/(double)(cars[i].speed))){
            
            stack.push(cars[i]);
            }

        }

        return stack.size();

    }
    class Car{
        int position;
        int speed;
        Car(int position, int speed){
            this.position = position;
            this.speed = speed;
        }
    }
}
