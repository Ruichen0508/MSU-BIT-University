package car;

public class Position {
    public final int row;
    public final int col;
    public Position(int row, int col){
        this.row = row; this.col = col;
    };
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public Position move(CarServer.Direction direction) {
        switch(direction){
            case UP: return new Position(row - 1,col);
            case DOWN: return new Position(row + 1,col);
            case LEFT: return new Position(row ,col - 1);
            case RIGHT: return new Position(row ,col + 1);
            default:throw new RuntimeException("Position move error");
        }
    }
    @Override
    public String toString(){
        return "[Position: col="+col+" row="+row+"]";
    }
}
