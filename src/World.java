public class World {
    static boolean paused = true;
    static int numWidth = 150;
    static int numHeight = 60;
    static boolean [][]grid = new boolean[numHeight][numWidth];
    public static void createCrasher(){
        int rad = (int)(Math.random() * (numWidth - 5) + 2);
        int rad2 = (int)(Math.random() * (numHeight - 5)+ 2);
        grid[rad2][rad] = true;
        grid[rad2][rad + 1] = true;
        grid[rad2][rad + 2] = true;
        grid[rad2 - 1][rad + 2] = true;
        grid[rad2 - 2][rad + 1] = true;

    }
    public static void randomize(){
        for(int y =0; y < numHeight; y++){
            for(int x =0; x < numWidth; x++){
             int ran = (int)((Math.random() * 1) + 1);
             grid[y][x] = ran == 1;
            }
        }
    }
    public static void update(){
         boolean [][]newGrid = new boolean[numHeight][numWidth];
        for(int y = 0; y < numHeight;y++){
            for(int x = 0; x < numWidth; x++){
                newGrid[y][x] = updateSquare(y,x);
            }
        }
        grid = newGrid;
    }
    public static void toggle(int x, int y){
        paused = true;
        grid[y][x] = !grid[y][x];
    }
    public static int liveNeighbors(int z, int t){
        int live = 0;
        for (int y = -1; y <= 1; y++) {
            for (int x = -1; x <= 1; x++) {
                if (y + z < numHeight && x + t < numWidth && y + z >= 0 && x + t >= 0) {
                    if (!(x == 0 && y ==0)) {
                        if (grid[y + z][x + t]) {
                            live++;
                        }
                    }
                }
            }
        }
        return live;
    }
    public static boolean updateSquare(int y, int x){
        //Any live cell with fewer than two live neighbours dies (referred to as underpopulation or exposure[1]).
        //Any live cell with more than three live neighbours dies (referred to as overpopulation or overcrowding).
        //Any live cell with two or three live neighbours lives, unchanged, to the next generation.
        // dead cell with exactly three live neighbours will come to life.
        int ln = liveNeighbors(y, x);
        if(grid[y][x] && 2 <= ln && ln <= 3) {
            return true;
        }
        else return !grid[y][x] && ln == 3;
    }
}
