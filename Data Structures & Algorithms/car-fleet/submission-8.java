class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
         int n = speed.length;
         Car[] cars = new Car[n];
         for(int i=0 ; i<n ; i++) {
            cars[i] = new Car(position[i], speed[i]);
         }
         Arrays.sort(cars, (a,b) -> a.pos - b.pos);
         Stream.of(cars).forEach( a -> System.out.print(a));

         Deque<Car> stack= new ArrayDeque<>();
         stack.push(cars[0]);
         for(int i=1; i<n ; i++) {
            if(cars[i].speed >= stack.peek().speed ) {
                stack.push(cars[i]);
                System.out.println("here1");
            } else {
                while(!stack.isEmpty()){
                Car prev = stack.peek();
                System.out.println("prev = " + prev);
                System.out.println("c[i] = " + cars[i]);
                System.out.println((target - cars[i].pos)*prev.speed +"<="+(target-prev.pos)*cars[i].speed);
                if((target - cars[i].pos)*prev.speed >= (target-prev.pos)*cars[i].speed) {
                    stack.pop();
                    System.out.println("here2");
                } else {
                    break;
                }
                }
                stack.push(cars[i]);
                System.out.println("here3");
            }
         }

         
        stack.stream().forEach( a -> System.out.print(a));
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
