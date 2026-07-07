class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         int n = speed.length;
         Car[] cars = new Car[n];
         for(int i=0 ; i<n ; i++) {
            cars[i] = new Car(position[i], speed[i]);
         }
         Arrays.sort(cars, (a,b) -> a.pos - b.pos);


         Deque<Car> stack= new ArrayDeque<>();
         stack.push(cars[0]);
         for(int i=1; i<n ; i++) {
            if(cars[i].speed >= stack.peek().speed ) {
                stack.push(cars[i]);
            } else {
                while(!stack.isEmpty()){
                Car prev = stack.peek();
                if((target - cars[i].pos)*(long)prev.speed >= (target-prev.pos)*(long)cars[i].speed) {
                    stack.pop();
                } else {
                    break;
                }
                }
                stack.push(cars[i]);
            }
         }
         return stack.size();
    }
    class Car{
        int pos;
        int speed;

        Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        public String toString() {
            return this.pos + "-" + this.speed + ",";
        }
    }
}
