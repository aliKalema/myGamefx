package com.phenomenal.mygamefx.test;

import com.phenomenal.mygamefx.IO.MyCompressorOutputStream;
import com.phenomenal.mygamefx.IO.MyDecompressorInputStream;
import com.phenomenal.mygamefx.algorithms.mazeGenerators.*;

import java.io.*;
import java.util.Arrays;

public class RunCompressDecompressMaze {
    public static void main(String[] args) {
        String mazeFileName = "savedMaze.maze";
        AMazeGenerator mazeGenerator = new SimpleMazeGenerator();
        Maze maze = mazeGenerator.generate(2, 3); //Generate new maze
        try { // save maze to a file
            OutputStream out = new MyCompressorOutputStream(new FileOutputStream(mazeFileName));
            out.write(maze.toByteArray());
            out.flush(); out.close();
        } catch (IOException e) {
    e.printStackTrace();
        }
        byte savedMazeBytes[] = new byte[0];
        try { //read maze from file
            InputStream in = new MyDecompressorInputStream(new FileInputStream(mazeFileName));
            savedMazeBytes = new byte[maze.toByteArray().length];
            in.read(savedMazeBytes); in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Maze loadedMaze = new Maze(savedMazeBytes);
        boolean areMazesEquals = Arrays.equals(loadedMaze.toByteArray(),maze.toByteArray());
        System.out.println(String.format("Mazes equal: %s",areMazesEquals)); //maze should be equal to loadedMaze
    }
}