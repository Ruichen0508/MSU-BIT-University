package car;

public class Position {
    public final int row;
    public final int col;
    public Position(int row, int col){
        this.row = row; this.col = col;
    };

    public Position move(CarServer.Direction direction) {
        switch(direction){
            case UP: return new Position(row - 1,col);
            case DOWN: return new Position(row + 1,col);
            case LEFT: return new Position(row ,col - 1);
            case RIGHT: return new Position(row ,col + 1);
            case UP_LEFT: return new Position(row - 1,col - 1);//返回一个新的Position对象，行数减1，列数减1，表示汽车向左上方斜移。
            case UP_RIGHT: return new Position(row - 1,col + 1);// 返回一个新的Position对象，行数减1，列数加1，表示汽车向右上方斜移。
            case DOWN_LEFT: return new Position(row + 1,col - 1);//返回一个新的Position对象，行数加1，列数减1，表示汽车向左下方斜移。
            case DOWN_RIGHT: return new Position(row + 1,col + 1);//返回一个新的Position对象，行数加1，列数加1，表示汽车向右下方斜移。

            default:throw new RuntimeException("Position move error");
        }
    }
    public Position moveToNewPosition(Position position){
        return new Position(position.row,position.col);
    }
    @Override
    public String toString(){
        return "[Position: col="+col+" row="+row+"]";
    }
}
