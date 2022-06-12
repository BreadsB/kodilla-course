package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {

    @Test
    void testToString() {
        TaskList listToDo = new TaskList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To do Task number " + n)));

        TaskList listInProgress = new TaskList("In progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In progress task number " + n)));

        TaskList listDone = new TaskList("Done Tasks");
        IntStream.iterate(1, n->n+1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done task number " + n)));

        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        Board cloneBoard = null;
        try {
            cloneBoard = board.shallowCopy();
            cloneBoard.setName("Project number 2 - shallow clone");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Board deepCloneBoard = null;
        try {
            deepCloneBoard = board.deepCopy();
            deepCloneBoard.setName("Project number 3 - Deep clone");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(board);
        System.out.println(cloneBoard);
        System.out.println(deepCloneBoard);

        board.getLists().remove(listToDo);

        Assertions.assertEquals(2, board.getLists().size());
        Assertions.assertEquals(2, cloneBoard.getLists().size());
        Assertions.assertEquals(3, deepCloneBoard.getLists().size());
        Assertions.assertEquals(cloneBoard.getLists(), board.getLists());
        Assertions.assertNotEquals(deepCloneBoard.getLists(), board.getLists());
    }
}
