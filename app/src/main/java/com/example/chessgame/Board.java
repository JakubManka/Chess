package com.example.chessgame;

import com.example.chessgame.figures.Bishop;
import com.example.chessgame.figures.Figure;
import com.example.chessgame.figures.King;
import com.example.chessgame.figures.Knight;
import com.example.chessgame.figures.Pawn;
import com.example.chessgame.figures.Queen;
import com.example.chessgame.figures.Rook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.chessgame.FigureColor.BLACK;
import static com.example.chessgame.FigureColor.WHITE;
import static com.example.chessgame.FigureName.*;

public class Board {

    private Map<Coordinate, Figure> boardStatus = new HashMap<>();
    private Player whitePlayer = new Player(WHITE);
    private Player blackPlayer = new Player(BLACK);
    private List<Map<Coordinate, Figure>> allMoves = new ArrayList<>(); // all done moves from start
    private Map<Coordinate, List<Coordinate>> possibleMoves = new HashMap<>(); // all moves that can be done
    private boolean checkWhite = false;
    private boolean checkBlack = false;
    private List<Coordinate> kingMoves = new ArrayList<>(); // list of places where King can move
    private List<Coordinate> whoCheck = new ArrayList<>(); // list of places from where is check
    Coordinate kingCoordinates;  // Coordinates of king


    public Board() {
        resetBoard();
        whitePlayer.setMyMove(true);
        blackPlayer.setMyMove(false);
        addMove();

    }


    void resetBoard() {
        boardStatus = new HashMap<>();

        // x = [A-H] [1-8]
        // y = [1-8] [1-8]


        boardStatus.put(new Coordinate(1, 1), new Rook(WHITE));
        boardStatus.put(new Coordinate(1, 2), new Knight(WHITE));
        boardStatus.put(new Coordinate(1, 3), new Bishop(WHITE));
        boardStatus.put(new Coordinate(1, 4), new Queen(WHITE));
        boardStatus.put(new Coordinate(1, 5), new King(WHITE));
        boardStatus.put(new Coordinate(1, 6), new Bishop(WHITE));
        boardStatus.put(new Coordinate(1, 7), new Knight(WHITE));
        boardStatus.put(new Coordinate(1, 8), new Rook(WHITE));

        boardStatus.put(new Coordinate(2, 1), new Pawn(WHITE));
        boardStatus.put(new Coordinate(2, 2), new Pawn(WHITE));
        boardStatus.put(new Coordinate(2, 3), new Pawn(WHITE));
        boardStatus.put(new Coordinate(2, 4), new Pawn(WHITE));
        boardStatus.put(new Coordinate(2, 5), new Pawn(WHITE));
        boardStatus.put(new Coordinate(2, 6), new Pawn(WHITE));
        boardStatus.put(new Coordinate(2, 7), new Pawn(WHITE));
        boardStatus.put(new Coordinate(2, 8), new Pawn(WHITE));

        boardStatus.put(new Coordinate(7, 1), new Pawn(BLACK));
        boardStatus.put(new Coordinate(7, 2), new Pawn(BLACK));
        boardStatus.put(new Coordinate(7, 3), new Pawn(BLACK));
        boardStatus.put(new Coordinate(7, 4), new Pawn(BLACK));
        boardStatus.put(new Coordinate(7, 5), new Pawn(BLACK));
        boardStatus.put(new Coordinate(7, 6), new Pawn(BLACK));
        boardStatus.put(new Coordinate(7, 7), new Pawn(BLACK));
        boardStatus.put(new Coordinate(7, 8), new Pawn(BLACK));

        boardStatus.put(new Coordinate(8, 1), new Rook(BLACK));
        boardStatus.put(new Coordinate(8, 2), new Knight(BLACK));
        boardStatus.put(new Coordinate(8, 3), new Bishop(BLACK));
        boardStatus.put(new Coordinate(8, 4), new Queen(BLACK));
        boardStatus.put(new Coordinate(8, 5), new King(BLACK));
        boardStatus.put(new Coordinate(8, 6), new Bishop(BLACK));
        boardStatus.put(new Coordinate(8, 7), new Knight(BLACK));
        boardStatus.put(new Coordinate(8, 8), new Rook(BLACK));


    }


    public Map<Coordinate, Figure> getBoardStatus() {
        return boardStatus;
    }


    public void setBoardStatus(Map<Coordinate, Figure> boardStatus) {
        this.boardStatus = boardStatus;
    }

    FigureColor whichPlayer() {
        if (whitePlayer.getMyMove()) return WHITE;
        else return BLACK;
    }

    void changePlayer() {
        if (whitePlayer.getMyMove()) {
            whitePlayer.setMyMove(false);
            blackPlayer.setMyMove(true);
        } else {
            whitePlayer.setMyMove(true);
            blackPlayer.setMyMove(false);
        }
    }

    void whereKingCanMove() {
        Figure king = whatFigureIsThere(kingCoordinates);
        kingMoves = king.whereCanIMove(boardStatus, kingCoordinates, whichPlayer());
        List<Coordinate> temp = new ArrayList<>(kingMoves);
        Map<Coordinate, Figure> board = boardStatus.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(e -> !e.getValue().getColor().equals(whichPlayer()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<Coordinate, Figure> boardS = new HashMap<>(boardStatus);
        boardS.remove(king);

        for (Coordinate coordinate : temp) {
            for (Map.Entry<Coordinate, Figure> entry : board.entrySet()) {
                Figure figure = whatFigureIsThere(coordinate);
                if (entry.getValue().whereCanIMove(boardS, entry.getKey(), whichPlayer()).contains(coordinate)) {
                    kingMoves.remove(coordinate);
                }
                if (figure != null) {
                    List<Coordinate> figureMoves = figure.whereCanIMove(boardS, coordinate, whichPlayer());
                    for (Coordinate coordinate1 : figureMoves) {
                        kingMoves.remove(coordinate1);
                        if(amICovered(figure)) kingMoves.remove(whereIsThatFigure(figure));
                    }
                }
            }
        }
    }

    boolean amICovered(Figure figure) {
        boolean cover = false;
        Coordinate coordinate = whereIsThatFigure(figure);
        Map<Coordinate, Figure> board = boardStatus.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(e -> e.getValue().getColor().equals(figure.getColor()))
                .filter(e -> !e.getValue().equals(figure))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (Map.Entry<Coordinate, Figure> entry : board.entrySet()) {
            if (entry.getValue().whereCanIMove(board, entry.getKey(), whichPlayer()).contains(coordinate))
                cover = true;
        }
        return cover;
    }


    boolean check() {
        checkWhite = false;
        checkBlack = false;

        boardStatus.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .filter(e -> !e.getValue().whereCanIMove(boardStatus, e.getKey(), whichPlayer()).isEmpty())
                .filter(e -> !e.getValue().getColor().equals(whichPlayer()))
                .forEach(e -> possibleMoves.put(e.getKey(), e.getValue().whereCanIMove(boardStatus, e.getKey(), whichPlayer())));

        possibleMoves.entrySet().forEach(list -> {
            list.getValue().forEach(coordinate -> {
                Figure king = whatFigureIsThere(coordinate);
                Figure figure = whatFigureIsThere(list.getKey());
                if (king != null && king.getName() == KING) {
                    if (king.getColor() == WHITE && figure.getColor() == BLACK) {
                        checkWhite = true;
                        whoCheck.add(list.getKey());
                    } else if (king.getColor() == BLACK && figure.getColor() == WHITE) {
                        checkBlack = true;
                        whoCheck.add(list.getKey());
                    }
                    kingCoordinates = coordinate;
                }
            });
        });
        possibleMoves.clear();
        return checkBlack || checkWhite;
    }

    Figure whatFigureIsThere(Coordinate coordinate) {  // check what figure is in the coordinates
        Map<Coordinate, Figure> temp = boardStatus.entrySet().stream()
                .filter(c -> c.getKey().equals(coordinate))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return temp.get(coordinate);
    }

    Coordinate whereIsThatFigure(Figure figure) {
        for (Map.Entry<Coordinate, Figure> e : boardStatus.entrySet()) {
            if (e.getValue().equals(figure)) {
                return e.getKey();
            }
        }
        return null;
    }


    void addMove() {

        Map<Coordinate, Figure> oldFigures = new HashMap<>(boardStatus);
        allMoves.add(oldFigures);
    }

    List<Map<Coordinate, Figure>> getAllMoves() {
        return allMoves;
    }

    void undoLastMove() {
        allMoves.remove(allMoves.size() - 1);
        boardStatus = allMoves.get(allMoves.size() - 1);
    }

    public boolean isCheckWhite() {
        return checkWhite;
    }

    public boolean isCheckBlack() {
        return checkBlack;
    }

    List<Coordinate> getWhoCheck() {
        return whoCheck;
    }

    void resetWhoCheck() {
        whoCheck.clear();
    }

    public List<Coordinate> getKingMoves() {
        whereKingCanMove();
        return kingMoves;
    }
}

