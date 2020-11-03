package View;

import Database.CreateDatabase;
import calculadora.Calculator;
import calculadora.ControllerHistoric;
import java.text.DecimalFormat;

/**
 *
 * @author Heric
 */
public final class Screen extends javax.swing.JFrame {
    private final Calculator calculator;
    private final ControllerHistoric controllerHistoric;
    private final ListHistoric listHistoric;
    private final String[] operators = {"/", "*", "-", "+", "(", ","};
    private final String[] resets = {"0", "0,0", "Inválido"};
    
    private boolean inOperator(String value) {
        for (String operator : this.operators) {
            if (value.equals(operator)) return true;
        }
       return false;
    }
    
    private boolean inReset(String value) {
        for (String reset : this.resets) {
            if (value.equals(reset)) return true;
        }
        return false;
    }
    
    private void insertPreviewNumber(String str) {
        String value = this.previewTextField.getText();
        if (this.inReset(value)) {
            this.previewTextField.setText(str);
        } else {
            String last = value.substring(value.length()-1);
            if (!last.equals(")")) this.previewTextField.setText(value + str);
        }
    }
    
    private void insertPreviewOperator(String str) {
        String value = this.previewTextField.getText();
        if (!this.inReset(value)) {
            String last = value.substring(value.length()-1);
            if (!this.inOperator(last) || (last.equals("(") && str.equals("-"))) {
                this.previewTextField.setText(value + str);
            } else if (!"(,".contains(last) && (value.length() > 1 && !value.substring(value.length()-2).equals("(-"))) {
                    this.previewTextField.setText(value.substring(0, value.length()-1) + str);
            }
        } else if (str.equals("-")) {
            this.previewTextField.setText(str);
        }
    }

    /**
     * Creates new form Screen
     */
    public Screen() {
        CreateDatabase.initComponents();
        this.calculator = Calculator.getInstance();
        this.controllerHistoric = ControllerHistoric.getInstance();
        this.listHistoric = new ListHistoric(); 
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        number1Button = new javax.swing.JButton();
        number2Button = new javax.swing.JButton();
        number3Button = new javax.swing.JButton();
        number4Button = new javax.swing.JButton();
        number5Button = new javax.swing.JButton();
        number6Button = new javax.swing.JButton();
        number7Button = new javax.swing.JButton();
        number8Button = new javax.swing.JButton();
        number9Button = new javax.swing.JButton();
        number0 = new javax.swing.JButton();
        clearCButton = new javax.swing.JButton();
        resultButton = new javax.swing.JButton();
        sumButton = new javax.swing.JButton();
        subtractButton = new javax.swing.JButton();
        multiplyButton = new javax.swing.JButton();
        shareButton = new javax.swing.JButton();
        openParenthesisButton = new javax.swing.JButton();
        closeParenthesisButton = new javax.swing.JButton();
        previewTextField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        historicButton = new javax.swing.JButton();
        commaButton = new javax.swing.JButton();
        clearXButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        number1Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number1Button.setText("1");
        number1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number1ButtonMouseClicked(evt);
            }
        });

        number2Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number2Button.setText("2");
        number2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number2ButtonMouseClicked(evt);
            }
        });

        number3Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number3Button.setText("3");
        number3Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number3ButtonMouseClicked(evt);
            }
        });

        number4Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number4Button.setText("4");
        number4Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number4Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number4ButtonMouseClicked(evt);
            }
        });

        number5Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number5Button.setText("5");
        number5Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number5Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number5ButtonMouseClicked(evt);
            }
        });

        number6Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number6Button.setText("6");
        number6Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number6Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number6ButtonMouseClicked(evt);
            }
        });

        number7Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number7Button.setText("7");
        number7Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number7Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number7ButtonMouseClicked(evt);
            }
        });

        number8Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number8Button.setText("8");
        number8Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number8Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number8ButtonMouseClicked(evt);
            }
        });

        number9Button.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number9Button.setText("9");
        number9Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number9Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number9ButtonMouseClicked(evt);
            }
        });

        number0.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        number0.setText("0");
        number0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        number0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number0MouseClicked(evt);
            }
        });

        clearCButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        clearCButton.setText("C");
        clearCButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearCButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearCButtonMouseClicked(evt);
            }
        });

        resultButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        resultButton.setText("=");
        resultButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resultButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultButtonMouseClicked(evt);
            }
        });

        sumButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        sumButton.setText("+");
        sumButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sumButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sumButtonMouseClicked(evt);
            }
        });

        subtractButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        subtractButton.setText("-");
        subtractButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subtractButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subtractButtonMouseClicked(evt);
            }
        });

        multiplyButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        multiplyButton.setText("*");
        multiplyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        multiplyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                multiplyButtonMouseClicked(evt);
            }
        });

        shareButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        shareButton.setText("/");
        shareButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shareButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shareButtonMouseClicked(evt);
            }
        });

        openParenthesisButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        openParenthesisButton.setText("(");
        openParenthesisButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openParenthesisButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openParenthesisButtonMouseClicked(evt);
            }
        });

        closeParenthesisButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        closeParenthesisButton.setText(")");
        closeParenthesisButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeParenthesisButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeParenthesisButtonMouseClicked(evt);
            }
        });

        previewTextField.setEditable(false);
        previewTextField.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        previewTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        previewTextField.setText("0");
        previewTextField.setToolTipText("");

        titleLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        titleLabel.setText("Calculadora");

        historicButton.setFont(new java.awt.Font("Unispace", 0, 14)); // NOI18N
        historicButton.setText("@");
        historicButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historicButtonMouseClicked(evt);
            }
        });

        commaButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        commaButton.setText(",");
        commaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        commaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commaButtonMouseClicked(evt);
            }
        });

        clearXButton.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        clearXButton.setText("<");
        clearXButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearXButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearXButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(previewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(number7Button, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(number4Button, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(number1Button, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(number0, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(clearCButton, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(number8Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(number5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearXButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(number2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(commaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(number6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(number3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(openParenthesisButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addComponent(number9Button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(shareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(multiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(closeParenthesisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sumButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subtractButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(historicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(previewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearCButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openParenthesisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeParenthesisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearXButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number7Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number8Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number9Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shareButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number6Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(multiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtractButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sumButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void number1ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number1ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("1");
    }//GEN-LAST:event_number1ButtonMouseClicked

    private void number2ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number2ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("2");
    }//GEN-LAST:event_number2ButtonMouseClicked

    private void number3ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number3ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("3");
    }//GEN-LAST:event_number3ButtonMouseClicked

    private void number4ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number4ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("4");
    }//GEN-LAST:event_number4ButtonMouseClicked

    private void number5ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number5ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("5");
    }//GEN-LAST:event_number5ButtonMouseClicked

    private void number6ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number6ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("6");
    }//GEN-LAST:event_number6ButtonMouseClicked

    private void number7ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number7ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("7");
    }//GEN-LAST:event_number7ButtonMouseClicked

    private void number8ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number8ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("8");
    }//GEN-LAST:event_number8ButtonMouseClicked

    private void number9ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number9ButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("9");
    }//GEN-LAST:event_number9ButtonMouseClicked

    private void number0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number0MouseClicked
        // TODO add your handling code here:
        this.insertPreviewNumber("0");
    }//GEN-LAST:event_number0MouseClicked

    private void clearCButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearCButtonMouseClicked
        // TODO add your handling code here:
        this.previewTextField.setText("0");
    }//GEN-LAST:event_clearCButtonMouseClicked

    private void resultButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultButtonMouseClicked
        // TODO add your handling code here:
        try {
            String value = this.previewTextField.getText();
            String result = this.calculator.calculate(value);
            
            DecimalFormat nf = new DecimalFormat("#0.####");
            result = nf.format(Double.parseDouble(result));

            this.previewTextField.setText(result);

            String[] historic = {value, result};
            this.controllerHistoric.insert(historic);
            
            this.listHistoric.update();
        } catch(Exception ex) {
            this.previewTextField.setText("Inválido");
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_resultButtonMouseClicked

    private void sumButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewOperator("+");
    }//GEN-LAST:event_sumButtonMouseClicked

    private void subtractButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subtractButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewOperator("-");
    }//GEN-LAST:event_subtractButtonMouseClicked

    private void multiplyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiplyButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewOperator("*");
    }//GEN-LAST:event_multiplyButtonMouseClicked

    private void shareButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shareButtonMouseClicked
        // TODO add your handling code here:
        this.insertPreviewOperator("/");
    }//GEN-LAST:event_shareButtonMouseClicked

    private void openParenthesisButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openParenthesisButtonMouseClicked
        // TODO add your handling code here:
        String value = this.previewTextField.getText();
        String last = value.substring(value.length()-1);
        
        if (this.inReset(value)) {
            this.previewTextField.setText("(");
        } else if (!last.equals(",") && this.inOperator(last) && (!last.equals("-") || (value.length() > 1 && !value.substring(value.length()-2).equals("(-")))) {
            this.previewTextField.setText(value + "(");
        }
    }//GEN-LAST:event_openParenthesisButtonMouseClicked

    private void closeParenthesisButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeParenthesisButtonMouseClicked
        // TODO add your handling code here:
        String value = this.previewTextField.getText();
        String last = value.substring(value.length()-1);
        
        if (!this.inReset(value) && !this.inOperator(last))
            this.previewTextField.setText(value + ")");
    }//GEN-LAST:event_closeParenthesisButtonMouseClicked

    private void historicButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historicButtonMouseClicked
        // TODO add your handling code here:
        listHistoric.dispose();
        listHistoric.setVisible(true);
    }//GEN-LAST:event_historicButtonMouseClicked

    private void commaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commaButtonMouseClicked
        // TODO add your handling code here:
        String value = this.previewTextField.getText();
        String last = value.substring(value.length()-1);
        
        if (!last.equals(")") && !this.inOperator(last))
            this.previewTextField.setText(value + ",");
    }//GEN-LAST:event_commaButtonMouseClicked

    private void clearXButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearXButtonMouseClicked
        // TODO add your handling code here:
        String value = this.previewTextField.getText();
        
        if (value.length() == 1) {
            this.previewTextField.setText("0");
        } else {
            this.previewTextField.setText(value.substring(0, value.length()-1));
        }
    }//GEN-LAST:event_clearXButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Screen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearCButton;
    private javax.swing.JButton clearXButton;
    private javax.swing.JButton closeParenthesisButton;
    private javax.swing.JButton commaButton;
    private javax.swing.JButton historicButton;
    private javax.swing.JButton multiplyButton;
    private javax.swing.JButton number0;
    private javax.swing.JButton number1Button;
    private javax.swing.JButton number2Button;
    private javax.swing.JButton number3Button;
    private javax.swing.JButton number4Button;
    private javax.swing.JButton number5Button;
    private javax.swing.JButton number6Button;
    private javax.swing.JButton number7Button;
    private javax.swing.JButton number8Button;
    private javax.swing.JButton number9Button;
    private javax.swing.JButton openParenthesisButton;
    private javax.swing.JTextField previewTextField;
    private javax.swing.JButton resultButton;
    private javax.swing.JButton shareButton;
    private javax.swing.JButton subtractButton;
    private javax.swing.JButton sumButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}