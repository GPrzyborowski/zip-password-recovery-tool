package org.example;

import java.awt.*;
import javax.swing.*;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class zipPasswordRecovery {
    public static void main(String[] args) {
        char[] standard = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        char[] standardUpper = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        char[] standardUpperSpecial = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+',
                '[', ']', '{', '}', ';', ':', '\'', '"', '<', '>', ',', '.', '?', '/'
        };

        JFrame window = new JFrame("Zip password recovery");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 400);
        window.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        window.add(mainPanel);

        JLabel headingLabel = new JLabel("Zip password recovery");
        headingLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(headingLabel, gbc);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JRadioButton radioStandard = new JRadioButton("Standard");
        JRadioButton radioStandardUpper = new JRadioButton("Upper");
        JRadioButton radioStandardSpecial = new JRadioButton("Special");
        radioStandard.setFocusPainted(false);
        radioStandardUpper.setFocusPainted(false);
        radioStandardSpecial.setFocusPainted(false);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioStandard);
        buttonGroup.add(radioStandardUpper);
        buttonGroup.add(radioStandardSpecial);
        radioStandard.setSelected(true);
        radioPanel.add(radioStandard);
        radioPanel.add(radioStandardUpper);
        radioPanel.add(radioStandardSpecial);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(radioPanel, gbc);

        JLabel passwordLengthLabel = new JLabel("Password length:");
        passwordLengthLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(passwordLengthLabel, gbc);

        JTextField passwordLengthTextField = new JTextField(5);
        passwordLengthTextField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(passwordLengthTextField, gbc);

        JButton chooseFileButton = new JButton("Choose file");
        chooseFileButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(chooseFileButton, gbc);

        JLabel chooseFileLabel = new JLabel();
        chooseFileLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(chooseFileLabel, gbc);

        JLabel actionLabel = new JLabel();
        actionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(actionLabel, gbc);

        JButton actionButton = new JButton("Break password");
        actionButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(actionButton, gbc);

        JFrame legalUseWindow = new JFrame("Please confirm the lawful intent of using the software");
        legalUseWindow.setSize(600, 300);

        JPanel legalUseMainPanel = new JPanel();
        legalUseMainPanel.setLayout(new BorderLayout());
        legalUseMainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        legalUseWindow.add(legalUseMainPanel);

        JTextArea legalUseLabel = new JTextArea();
        legalUseLabel.setText("By clicking 'Confirm,' I declare that the software will be used for lawful purposes only.\n" +
                "I acknowledge and accept full legal responsibility for the use of the software, and I agree that the author of the software bears no liability for its use.");
        legalUseLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        legalUseLabel.setLineWrap(true);
        legalUseLabel.setWrapStyleWord(true);
        legalUseLabel.setEditable(false);
        legalUseLabel.setOpaque(false);
        legalUseLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton legalUseButton = new JButton("Confirm");
        legalUseButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        legalUseButton.setPreferredSize(new Dimension(120, 40));

        legalUseMainPanel.add(legalUseLabel, BorderLayout.CENTER);
        legalUseMainPanel.add(legalUseButton, BorderLayout.SOUTH);

        legalUseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        legalUseWindow.setLocationRelativeTo(null);
        legalUseWindow.setVisible(true);

        legalUseButton.addActionListener(e -> {
            legalUseWindow.setVisible(false);
            window.setVisible(true);
        });

        chooseFileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                String selectedFilePath = fileChooser.getSelectedFile().getPath();
                chooseFileLabel.setText(selectedFilePath);
            }
        });

        actionButton.addActionListener(e -> new Thread(() -> {
            try {
                String filePath = chooseFileLabel.getText();
                if (filePath == null || filePath.isEmpty()) {
                    actionLabel.setText("No file selected");
                    return;
                }

                char[] charactersTestingSet = {};

                if(radioStandardUpper.isSelected()) {
                    charactersTestingSet = standardUpper;
                } else if(radioStandardSpecial.isSelected()) {
                    charactersTestingSet = standardUpperSpecial;
                } else {
                    charactersTestingSet = standard;
                }

                int passwordLength = Integer.parseInt(passwordLengthTextField.getText());
                generateCombinations(charactersTestingSet, passwordLength, filePath, actionLabel);
            } catch (NumberFormatException ex) {
                actionLabel.setText("Invalid password length");
            }
        }).start());
    }

    public static boolean checkPassword(String combination, String filePath, JLabel actionLabel) {
        try {
            actionLabel.setText("Testing combination: " + combination);
            ZipFile zipFile = new ZipFile(filePath, combination.toCharArray());

            String outputDir = "output";
            new File(outputDir).mkdirs();
            zipFile.extractAll(outputDir);

            JFrame resultWindow = new JFrame("Result");
            resultWindow.setSize(300, 150);
            resultWindow.setLocationRelativeTo(null);
            JLabel resultLabel = new JLabel("Password found: " + combination, SwingConstants.CENTER);
            resultLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            resultWindow.add(resultLabel);
            resultWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            resultWindow.setVisible(true);

            return true;
        } catch (ZipException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void generateCombinations(char[] characterSet, int maxLength, String filePath, JLabel actionLabel) {
        boolean passwordFound = false;

        List<String> currentCombinations = new ArrayList<>();

        for (int length = 1; length <= maxLength && !passwordFound; length++) {
            if (length == 1) {
                for (char c : characterSet) {
                    String singleChar = String.valueOf(c);
                    if (checkPassword(singleChar, filePath, actionLabel)) {
                        passwordFound = true;
                        return;
                    }
                    currentCombinations.add(singleChar);
                }
            } else {
                List<String> newCombinations = new ArrayList<>();
                for (String combination : currentCombinations) {
                    for (char c : characterSet) {
                        String newCombination = combination + c;
                        if (checkPassword(newCombination, filePath, actionLabel)) {
                            passwordFound = true;
                            return;
                        }
                        newCombinations.add(newCombination);
                    }
                }
                currentCombinations = newCombinations;
            }
        }

        if (!passwordFound) {
            actionLabel.setText("Password not found");
        }
    }
}
