class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for( int i=0;i<position.length;i++){
            cars[i] = new Car();
            cars[i].position = position[i];
            cars[i].speed = speed[i];
        }

        Arrays.sort(cars, (a,b) -> Integer.compare(b.position,a.position));

        Deque<Car> stack = new ArrayDeque();
        stack.push(cars[0]);
        for(int i=1;i<cars.length;i++){
            Car top = stack.peek();
            if(((target-top.position)*(long)cars[i].speed) < ((target-cars[i].position)*(long)top.speed)){
                stack.push(cars[i]);
            }
        }

        return stack.size();

    }


    private class Car{
        int position;
        int speed;
    }
}
