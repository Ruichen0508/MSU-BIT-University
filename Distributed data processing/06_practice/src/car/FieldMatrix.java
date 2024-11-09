package car;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class FieldMatrix {
    public enum CellState{
        EMPTY,CAR,WALL
    }

    public final CellState[][] cells;

    public final int rows;
    public final int cols;

    public FieldMatrix(int rows, int cols){
        this.rows = rows; this.cols = cols;
        cells = new CellState[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = CellState.EMPTY;
    }
    public static FieldMatrix load(InputStreamReader isr){
        try (Scanner scanner = new Scanner(isr)){
            int rows = 0;
            int cols = 0;
            if (scanner.hasNextInt()) rows = scanner.nextInt();
            if (scanner.hasNextInt()) cols = scanner.nextInt();

            FieldMatrix fm = new FieldMatrix(rows,cols);
            scanner.nextLine();

            for (int i = 0; i < rows; i++) {
                String line = "";
                if (scanner.hasNext()) line = scanner.nextLine();
                try {
                    for (int j = 0; j < cols; j++) {
                        //System.out.println("line=" + line + " i=" + i + " j=" + j);
                        switch (line.charAt(j)) {
                            case '*':
                                fm.cells[i][j] = CellState.WALL;
                        }
                    }
                }catch(StringIndexOutOfBoundsException e){}
            }
            return fm;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public CellState getCellState(int row, int col){
        return cells[row][col];
    }

    public synchronized Position occupyFirstFreeCellByCar(){
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (cells[i][j] == CellState.EMPTY) {
                    cells[i][j] = CellState.CAR;
                    return new Position(i, j);
                }

        throw new RuntimeException("No empty fields!");
    }

    public boolean moveCarTo(int fromrow, int fromcol, int torow, int tocol){
        CellState cellState = cells[torow][tocol];
        synchronized (cellState){
            if (cellState == CellState.EMPTY){
                cells[fromrow][fromcol] = CellState.EMPTY;
                cells[torow][tocol] = CellState.CAR;
                return true;
            }else{
                return false;
            }
        }

    }
    // 添加墙壁

    public synchronized void addRandomWall() {
        Random random = new Random();
        int row = random.nextInt(rows);
        int col = random.nextInt(cols);
        if (cells[row][col] == CellState.EMPTY) {
            cells[row][col] = CellState.WALL;
        }
    }

    public synchronized void removeRandomWall() {
        Random random = new Random();
        int row = random.nextInt(rows);
        int col = random.nextInt(cols);
        if (cells[row][col] == CellState.WALL) {
            cells[row][col] = CellState.EMPTY;
        }
    }




}
