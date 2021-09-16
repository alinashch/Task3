package com.company;
import com.util.ArrayUtils;
import com.util.JTableUtils;
import com.util.SwingUtils;
import javax.swing.*;


import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.*;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

public class FrameMain extends JFrame {
    private JTable tableInput;
    private JButton ResultJavaQueue;
    private JButton resultLinkedListQueueButton;
    private JButton loadInputFromFileButton;
    private JButton SaveOutputIntoFile;
    private JPanel panelMain;
    private JTable tableOutput;
    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("Sum");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, true, true, true, true);
        //tableOutput.setEnabled(false);
        tableInput.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(tableInput, new int[]{1, 2, 3, 4, 5, 6});


        this.pack();
        ResultJavaQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int numbers1[] = JTableUtils.readIntArrayFromJTable(tableInput);
                    ArrayDeque<Integer> JavaQueue = new ArrayDeque<>();
                    for (int i = 0; i < numbers1.length; i++) {
                        JavaQueue.add(numbers1[i]);
                    }
                    Logic.SolutionForJavaQ(JavaQueue);
                    int k=0;
                    for( int i: JavaQueue){
                        numbers1[k]=i;
                        k++;
                    }
                    JTableUtils.writeArrayToJTable(tableOutput,numbers1);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        resultLinkedListQueueButton.addComponentListener(new ComponentAdapter() {
        });
        resultLinkedListQueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int numbers1[] = JTableUtils.readIntArrayFromJTable(tableInput);
                    SimpleQueue<Integer> LinkedQueue = new SimpleLinkedListQueue<>();
                    for (int i = 0; i < numbers1.length; i++) {
                        LinkedQueue.add(numbers1[i]);
                    }
                    Logic.SolutionForSimpleQ(LinkedQueue);
                    for( int i=0; i<LinkedQueue.size(); i++){
                        numbers1[i]=LinkedQueue.GetIndex(i);
                    }
                    JTableUtils.writeArrayToJTable(tableOutput,numbers1);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        loadInputFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        SaveOutputIntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] fin = JTableUtils.readIntArrayFromJTable(tableOutput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, fin);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}