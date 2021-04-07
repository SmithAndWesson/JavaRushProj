package com.javarush.task.task35.task3513;

import java.util.*;
import java.util.stream.Collectors;

public class Model {

    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    private Stack<Tile[][]>  previousStates = new Stack();
    private Stack<Integer>  previousScores = new Stack();
    private boolean isSaveNeeded = true;
    int score = 0;
     int maxTile = 0;

    public Model() {
        resetGameTiles();
        score = 0;
        maxTile = 0;
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        if(n == 0) left();
        if(n == 1) right();
        if(n == 2) up();
        if(n == 3) down();
    }

    private List getEmptyTiles(){
//        List<Tile> list = new ArrayList<>();
//
//        for(int i = 0; i < FIELD_WIDTH; i ++){
//            for(int j = 0; j < FIELD_WIDTH; j ++){
//                if(gameTiles[j][i].isEmpty()) list.add(gameTiles[j][i]);
//            }
//        }
        return Arrays.stream(gameTiles).flatMap(Arrays::stream)
                .filter(Tile::isEmpty).collect(Collectors.toList());
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile(){
        List<Tile> list = getEmptyTiles();
        if(list.size() > 0) {
            Tile tile = list.get((int) (list.size() * Math.random()));
            tile.value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

     void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for(int i = 0; i < FIELD_WIDTH; i ++){
            for(int j = 0; j < FIELD_WIDTH; j ++){
                gameTiles[j][i] = new Tile();
            }
        }
        addTile();
        addTile();

    }

    private boolean compressTiles(Tile[] tiles){
        boolean isChanged = false;
        Tile temp;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tiles[j].value == 0 && tiles[j + 1].value != 0) {
                    temp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = temp;
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean isChanged = false;

        for(int i = 0; i < tiles.length -1 ; i++){
            if(tiles[i].value != 0 && tiles[i].value == tiles[i+1].value){

                if (tiles[i].value + tiles[i + 1].value > maxTile) {
                    maxTile = tiles[i].value + tiles[i + 1].value;
                }
                tiles[i].value = tiles[i].value + tiles[i + 1].value;
                score += tiles[i].value;
                tiles[i + 1].value = 0;
                isChanged = true;

            }
        }
        compressTiles(tiles);

        return isChanged;
    }

    public void left(){
        boolean isChanged = false;
        if(isSaveNeeded)         saveState(gameTiles);

        for(int i = 0; i < FIELD_WIDTH; i ++){
            if(compressTiles(gameTiles[i]) || mergeTiles(gameTiles[i]))
                isChanged = true;
        }

        if(isChanged) addTile();
        isSaveNeeded = true;
    }

    private void rotate(){
//        Tile[][] resultArray = new Tile[FIELD_WIDTH][FIELD_WIDTH];
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int j = 0; j < gameTiles[i].length; j++) {
//                resultArray[gameTiles[i].length - j - 1][i] = gameTiles[i][j];
//            }
//        }
//        return resultArray;

        Tile tmp;
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH-j-1][i];
                gameTiles[FIELD_WIDTH-j-1][i] = gameTiles[FIELD_WIDTH-i-1][FIELD_WIDTH-j-1];
                gameTiles[FIELD_WIDTH-i-1][FIELD_WIDTH-j-1] = gameTiles[j][FIELD_WIDTH-i-1];
                gameTiles[j][FIELD_WIDTH-i-1] = tmp;
            }
        }
    }

    public void right(){
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void up(){
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void down(){
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public boolean canMove(){
        if(!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j-1][i]. value)return true;
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles){
        Tile[][] resultArray = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Tile nTile = new Tile();
                nTile.value = tiles[i][j].value;
                resultArray[i][j] = nTile;
            }
        }
        previousStates.push(resultArray);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback(){
        if(!previousScores.isEmpty() && !previousStates.isEmpty()){
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    private boolean hasBoardChanged(){
        if (previousStates.isEmpty()) return false;

        Tile[][] tiles = previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if(tiles[i][j].value != gameTiles[i][j].value) return true;
            }
        }

        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency;
        move.move();
        if(hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);

        rollback();
        return moveEfficiency;
    }

    // реализация выбора эффективного хода из возможных
    public void autoMove() {

//        queue.offer(getMoveEfficiency(new Move() {
//            @Override
//            public void move() {
//                left();
//            }
//        }));
//
//        queue.offer(getMoveEfficiency(new Move() {
//            @Override
//            public void move() {
//                right();
//            }
//        }));
//
//        queue.offer(getMoveEfficiency(new Move() {
//            @Override
//            public void move() {
//                up();
//            }
//        }));
//
//        queue.offer(getMoveEfficiency(new Move() {
//            @Override
//            public void move() {
//                down();
//            }
//        }));

        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        Move move = queue.peek().getMove();
        move.move();
    }
}
