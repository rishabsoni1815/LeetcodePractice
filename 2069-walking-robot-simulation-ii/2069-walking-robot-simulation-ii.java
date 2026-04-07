class Robot {
    int x = 0, y = 0, dir = 0, r = 0, c = 0, p = 0;

    // nwse->0123 (anticlokwise)
    public Robot(int r, int c) {
        x = 0;
        this.r = r - 1;
        this.c = c - 1;
        p = (2 * this.r + 2 * this.c);
        y = 0;
        dir = 3;
    }

    public void step(int a) {
        if (a > p) {
            //optimise if a>permiter
            // If a is a multiple of the perimeter, we must still run ONE full loop 
        // so the robot correctly updates its facing direction to initial direction when step was called for (x,y),dir since startung with east robot after p will facr south in end not east
            a %= p;
            if (a == 0)
                a = p;
        }
        // System.out.println(x + " " + y + " " + dir+" "+(y+a));
        dir %= 4;
        if (dir == 0) {
            if (y + a > c) {
                int diff = (y + a) - c;
                y = c;
                dir++;
                step(diff);
            } else {
                y += a;
            }
        } else if (dir == 1) {
            if (x - a < 0) {
                int diff = (int) Math.abs(x - a);
                x = 0;
                dir++;
                step(diff);
            } else {
                x -= a;
            }
        } else if (dir == 2) {
            if (y - a < 0) {
                int diff = (int) Math.abs(y - a);
                dir++;
                y = 0;
                step(diff);
            } else {
                y -= a;
            }
        } else {
            if (x + a > r) {
                int diff = (x + a) - r;
                x = r;
                dir++;
                step(diff);
            } else {
                x += a;
            }
        }
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    public String getDir() {
        switch (dir) {
            case 0:
                return "North";
            case 1:
                return "West";
            case 2:
                return "South";
            default:
                return "East";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */