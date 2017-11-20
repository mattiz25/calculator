/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;

/**
 *
 * @author PC
 */
public class GUI extends
        javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form GUI
     */
    public GUI() {

        initComponents();
        txtZespolona1.setVisible(false);
        txtZespolona2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel2.setVisible(false);
        butPAMIECLEFT.setVisible(false);
        butPAMIECRIGHT.setVisible(false);

        //  if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner().getName() == "txtOKNO") ;
    }
    List<String> lista_pamiec = new ArrayList<String>();

    int aktualny_indeks = 0;

    float wynik;
    float dzial1;
    float dzial2;
    int poziom = 0;
    int dzialanie;
    boolean zespolona = false;
    int poziom_zespolona = 0;
    int poziom_wynik = 0;
    int re1 = 0;
    int im1 = 0;
    int re2 = 0;
    int im2 = 0;
    int reW = 0;
    int imW = 0;
    boolean liczba_ujemna = true; //na początku liczba jest true po kliknieciu innego przycisku niz - zmienia sie na false 

    public void lvlINSTERTCALC() {
        txtZespolona1.setVisible(false);
        txtZespolona2.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        butSUMA.setVisible(true);
        butILOCZYN.setVisible(true);
    }

    public void lvlINSTERTNUMB() {
        txtZespolona1.setVisible(true);
        txtZespolona2.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        butSUMA.setVisible(false);
        butILOCZYN.setVisible(false);
    }

    public void listaADD(String x) {
        lista_pamiec.add(x);
        aktualny_indeks++;
    }

    void listGETLEFT() {

        aktualny_indeks--;

        try {
            pamiec.setText(lista_pamiec.get(aktualny_indeks));

        } catch (Exception e) {
            aktualny_indeks++;

            lista_pamiec.get(0);
        }
        System.out.println("aktulany_indeks= " + aktualny_indeks);

    }

    void listGETRIGHT() {

        aktualny_indeks++;

        try {
            pamiec.setText(lista_pamiec.get(aktualny_indeks));

        } catch (Exception e) {
            aktualny_indeks--;
            pamiec.setText(lista_pamiec.get(aktualny_indeks));

        }
        System.out.println("aktulany_indeks= " + aktualny_indeks);

    }

    public String getText() {
        return txtOKNO.getText();
    }

    public String getZespolona1() {
        return txtZespolona1.getText();
    }

    public String getZespolona2() {
        return txtZespolona2.getText();
    }

    public void setText(String t) {
        txtOKNO.setText(t);
    }

    public void setZespolona1(String t) {
        txtZespolona1.setText(t);

    }

    public void setZespolona2(String t) {
        txtZespolona2.setText(t);

    }

    public void setDzialanie(int i) {
        if (zespolona == true) {
            if (poziom_wynik == 2) {
                dzialanie = Integer.valueOf(i);

                switch (dzialanie) {
                    case 0:
                        zesp_suma(re1, im1, re2, im2);
                        setText("[" + re1 + " + " + im1 + "i" + "]" + " + " + "[" + re2 + " + " + im2 + "i " + "]" + " = ");
                        break;
                    case 1:
                        zesp_różnica(re1, im1, re2, im2);
                        setText("[" + re1 + " + " + im1 + "i" + "]" + " - " + "[" + re2 + " + " + im2 + "i " + "]" + " = ");
                        break;
                    case 2:
                        zesp_iloczyn(re1, im1, re2, im2);
                        setText("[" + re1 + " + " + im1 + "i" + "]" + " * " + "[" + re2 + " + " + im2 + "i " + "]" + " = ");
                }
                if (imW < 0) {
                    setText(getText() + reW + " - " + Math.abs(imW) + "i");
                } else {
                    setText(getText() + reW + " + " + imW + "i");
                }
                butEQUALS.setText("NASTĘPNA");

            } else {

                switch (poziom_zespolona) {
                    default:
                        setText(getText() + String.valueOf(i));
                        break;
                    case 1:
                        setZespolona1("-");

                        break;
                    case 2:
                        setZespolona2("-");

                }

            }
        } else {

            if (i == 1 && liczba_ujemna == true) {
                poziom = 0;

                try {
                    setText("-");

                } catch (Exception e) {

                }
            } else {
                dzial1 = Float.valueOf(getText());
                setText("");
                dzialanie = i;
                liczba_ujemna = true;

            }
        }
    }

    void setDZIAL(String i) {

        if (zespolona == true) {

            switch (poziom_zespolona) {
                default:
                    setText("Wprowadz ponizej");
                    break;
                case 1:
                    setZespolona1(getZespolona1() + String.valueOf(i));

                    break;
                case 2:
                    setZespolona2(getZespolona2() + String.valueOf(i));

            }
        } else {

            switch (poziom) {
                default:
                    System.out.println("poziom default");
                    setText(getText() + String.valueOf(i));
                    break;
                case 1:
                    System.out.println("poziom 1");

                    if (liczba_ujemna == true) {
                        setText(String.valueOf(i));
                    } else {
                        setText(String.valueOf(i));
                    }

                    break;
                case 2:
                    System.out.println("poziom 2");

                    if (liczba_ujemna == true) {
                        setText(String.valueOf(i));
                    } else {
                        setText(String.valueOf(i));
                    }
            }
        }

        poziom = 0;
        System.out.println("zmiana na poziom default");

        liczba_ujemna = false;

    }

    float suma(float dzial1, float dzial2) {
        return wynik = dzial1 + dzial2;
    }

    float różnica(float dzial1, float dzial2) {
        return wynik = dzial1 - dzial2;
    }

    float iloczyn(float dzial1, float dzial2) {
        return wynik = dzial1 * dzial2;
    }

    float iloraz(float dzial1, float dzial2) {
        return wynik = dzial1 / dzial2;
    }

    void zesp_suma(int re1, int re2, int im1, int im2) {
        re1 = this.re1;
        re2 = this.re2;
        im1 = this.im1;
        im2 = this.im2;

        reW = re1 + re2;
        imW = im1 + im2;
    }

    void zesp_różnica(int re1, int re2, int im1, int im2) {
        re1 = this.re1;
        re2 = this.re2;
        im1 = this.im1;
        im2 = this.im2;
        reW = re1 - re2;
        imW = im1 - im2;
    }

    void zesp_iloczyn(int re1, int re2, int im1, int im2) {
        re1 = this.re1;
        re2 = this.re2;
        im1 = this.im1;
        im2 = this.im2;
        reW = re1 * re2 - im1 * im2;
        imW = re2 * im1 + re1 * im2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        but9 = new javax.swing.JButton();
        txtOKNO = new javax.swing.JTextField();
        but7 = new javax.swing.JButton();
        but8 = new javax.swing.JButton();
        but4 = new javax.swing.JButton();
        but1 = new javax.swing.JButton();
        but5 = new javax.swing.JButton();
        but2 = new javax.swing.JButton();
        but6 = new javax.swing.JButton();
        butSUMA = new javax.swing.JButton();
        but0 = new javax.swing.JButton();
        butPRZECINEK = new javax.swing.JButton();
        butEQUALS = new javax.swing.JButton();
        but3 = new javax.swing.JButton();
        butILOCZYN = new javax.swing.JButton();
        butILORAZ = new javax.swing.JButton();
        butROZNICA = new javax.swing.JButton();
        butSUMA1 = new javax.swing.JButton();
        pamiec = new javax.swing.JLabel();
        butZESPOLONA = new javax.swing.JToggleButton();
        txtZespolona1 = new javax.swing.JTextField();
        txtZespolona2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        butPAMIECRIGHT = new javax.swing.JButton();
        butPAMIECLEFT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KALKULATOR ZESPOLONE ");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                none(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        but9.setText("9");
        but9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but9ActionPerformed(evt);
            }
        });

        txtOKNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOKNOActionPerformed(evt);
            }
        });

        but7.setText("7");
        but7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but7ActionPerformed(evt);
            }
        });

        but8.setText("8");
        but8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but8ActionPerformed(evt);
            }
        });

        but4.setText("4");
        but4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but4ActionPerformed(evt);
            }
        });

        but1.setText("1");
        but1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but1ActionPerformed(evt);
            }
        });

        but5.setText("5");
        but5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but5ActionPerformed(evt);
            }
        });

        but2.setText("2");
        but2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but2ActionPerformed(evt);
            }
        });

        but6.setText("6");
        but6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but6ActionPerformed(evt);
            }
        });

        butSUMA.setText("+");
        butSUMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSUMAActionPerformed(evt);
            }
        });
        butSUMA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                butSUMAKeyPressed(evt);
            }
        });

        but0.setText("0");
        but0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but0ActionPerformed(evt);
            }
        });

        butPRZECINEK.setText(".");
        butPRZECINEK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPRZECINEKActionPerformed(evt);
            }
        });

        butEQUALS.setText("=");
        butEQUALS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEQUALSActionPerformed(evt);
            }
        });

        but3.setText("3");
        but3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but3ActionPerformed(evt);
            }
        });

        butILOCZYN.setText("*");
        butILOCZYN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butILOCZYNActionPerformed(evt);
            }
        });

        butILORAZ.setText("/");
        butILORAZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butILORAZActionPerformed(evt);
            }
        });

        butROZNICA.setText("-");
        butROZNICA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butROZNICAActionPerformed(evt);
            }
        });

        butSUMA1.setText("DEL");
        butSUMA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSUMA1ActionPerformed(evt);
            }
        });

        pamiec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pamiec.setForeground(new java.awt.Color(255, 51, 51));

        butZESPOLONA.setText("ZESPOLONE");
        butZESPOLONA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butZESPOLONAActionPerformed(evt);
            }
        });

        txtZespolona1.setText("cz.rzeczywista");
        txtZespolona1.setToolTipText("");
        txtZespolona1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtZespolona1MouseClicked(evt);
            }
        });
        txtZespolona1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZespolona1ActionPerformed(evt);
            }
        });

        txtZespolona2.setText("cz.urojona");
        txtZespolona2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtZespolona2MouseClicked(evt);
            }
        });
        txtZespolona2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZespolona2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("i");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("+");

        butPAMIECRIGHT.setText(">");
        butPAMIECRIGHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPAMIECRIGHTActionPerformed(evt);
            }
        });

        butPAMIECLEFT.setText("<");
        butPAMIECLEFT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPAMIECLEFTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtZespolona1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(but7)
                                    .addComponent(but4)
                                    .addComponent(but1)
                                    .addComponent(but0))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(butPRZECINEK)
                                    .addComponent(but8)
                                    .addComponent(but2)
                                    .addComponent(but5))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(but6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(but3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(but9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                                .addComponent(butZESPOLONA)
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(butSUMA, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(butROZNICA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butILOCZYN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butILORAZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(butSUMA1)
                                .addGap(162, 162, 162))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtZespolona2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(butEQUALS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(pamiec, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(txtOKNO, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butPAMIECLEFT)
                        .addGap(18, 18, 18)
                        .addComponent(butPAMIECRIGHT)
                        .addGap(114, 114, 114))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(pamiec, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOKNO, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(butPAMIECRIGHT)
                        .addComponent(butPAMIECLEFT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtZespolona2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(txtZespolona1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butSUMA)
                    .addComponent(butSUMA1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but9)
                    .addComponent(but7)
                    .addComponent(but8)
                    .addComponent(butROZNICA))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but4)
                    .addComponent(but5)
                    .addComponent(but6)
                    .addComponent(butILOCZYN))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but1)
                    .addComponent(but2)
                    .addComponent(but3)
                    .addComponent(butILORAZ)
                    .addComponent(butZESPOLONA))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but0)
                    .addComponent(butPRZECINEK)
                    .addComponent(butEQUALS))
                .addGap(51, 51, 51))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butILORAZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butILORAZActionPerformed

        setDzialanie(3);
    }//GEN-LAST:event_butILORAZActionPerformed

    private void txtOKNOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOKNOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOKNOActionPerformed

    private void butROZNICAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butROZNICAActionPerformed

        setDzialanie(1);


    }//GEN-LAST:event_butROZNICAActionPerformed

    private void butEQUALSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEQUALSActionPerformed
        if (zespolona == true) {
            switch (poziom_wynik) {
                case 0:
                    try {
                        re1 = Integer.valueOf(getZespolona1());

                    } catch (Exception e) {
                        setText("poprawnie!");
                    }
                    try {
                        im1 = Integer.valueOf(getZespolona2());

                    } catch (Exception e) {
                        setText("poprawnie!");

                    }

                    setText("Wprowadź drugą (-) X + (-) X i");
                    setZespolona1("cz.rzeczywista");
                    setZespolona2("cz.rzeczywista");
                    poziom_wynik = 1;
                    poziom_zespolona = 0;

                    break;
                case 1:
                    try {
                        re2 = Integer.valueOf(getZespolona1());

                    } catch (Exception e) {
                        setText("poprawnie!");
                    }
                    try {
                        im2 = Integer.valueOf(getZespolona2());

                    } catch (Exception e) {
                        setText("poprawnie!");

                    }
                    setText("Wybierz działanie");
                    butEQUALS.setText("Wybierz działanie");
                    setZespolona1("cz.rzeczywista");
                    setZespolona2("cz.rzeczywista");
                    poziom_wynik = 2;
                    lvlINSTERTCALC();

                    break;
                case 2:
                    setZespolona1("cz.rzeczywista");
                    setZespolona2("cz.rzeczywista");
                    pamiec.setText(getText());

                    listaADD(pamiec.getText());
                    butPAMIECLEFT.setVisible(true);
                    butPAMIECRIGHT.setVisible(true);
                    setText("");
                    poziom_zespolona = 0;
                    butEQUALS.setText("ZATWIERDŹ");
                    setText("Wprowadź pierwszą i zatwierdź");
                    re1 = 0;
                    im1 = 0;
                    re2 = 0;
                    im2 = 0;
                    reW = 0;
                    imW = 0;
                    lvlINSTERTNUMB();
                    poziom_wynik = 0;
            }

        } else {
            dzial2 = Float.valueOf(getText());
            switch (dzialanie) {
                case 0:
                    suma(dzial1, dzial2);
                    pamiec.setText(dzial1 + "+" + dzial2 + " =" + wynik);
                    listaADD(pamiec.getText());

                    break;
                case 1:
                    różnica(dzial1, dzial2);
                    pamiec.setText(dzial1 + "-" + dzial2 + " =" + wynik);
                    listaADD(pamiec.getText());

                    break;
                case 2:
                    iloczyn(dzial1, dzial2);
                    pamiec.setText(dzial1 + "*" + dzial2 + " =" + wynik);
                    listaADD(pamiec.getText());

                    break;
                case 3:
                    iloraz(dzial1, dzial2);
                    pamiec.setText(dzial1 + "/" + dzial2 + " =" + wynik);
                    listaADD(pamiec.getText());

            }
            setText(String.valueOf(wynik));
            liczba_ujemna = true;
            butPAMIECLEFT.setVisible(true);
            butPAMIECRIGHT.setVisible(true);
        }
        poziom = 2;
        System.out.println("zmiana na poziom default");

        liczba_ujemna = true;

// TODO add your handling code here:
    }//GEN-LAST:event_butEQUALSActionPerformed

    private void but1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but1ActionPerformed
        setDZIAL("1");
        // TODO add your handling code here:
    }//GEN-LAST:event_but1ActionPerformed

    private void but2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but2ActionPerformed
        setDZIAL("2");
        // TODO add your handling code here:
    }//GEN-LAST:event_but2ActionPerformed

    private void but3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but3ActionPerformed
        setDZIAL("3");
        // TODO add your handling code here:
    }//GEN-LAST:event_but3ActionPerformed

    private void but4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but4ActionPerformed
        setDZIAL("4");
        // TODO add your handling code here:
    }//GEN-LAST:event_but4ActionPerformed

    private void but5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but5ActionPerformed
        setDZIAL("5");
        // TODO add your handling code here:
    }//GEN-LAST:event_but5ActionPerformed

    private void but6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but6ActionPerformed
        setDZIAL("6");
        // TODO add your handling code here:
    }//GEN-LAST:event_but6ActionPerformed

    private void but7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but7ActionPerformed
        setDZIAL("7");
        // TODO add your handling code here:
    }//GEN-LAST:event_but7ActionPerformed

    private void but8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but8ActionPerformed
        setDZIAL("8");
        // TODO add your handling code here:
    }//GEN-LAST:event_but8ActionPerformed

    private void but9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but9ActionPerformed
        setDZIAL("9");
        // TODO add your handling code here:
    }//GEN-LAST:event_but9ActionPerformed

    private void but0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but0ActionPerformed
        setDZIAL("0");
        // TODO add your handling code here:
    }//GEN-LAST:event_but0ActionPerformed

    private void butPRZECINEKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPRZECINEKActionPerformed
        setDZIAL(".");
        // TODO add your handling code here:
    }//GEN-LAST:event_butPRZECINEKActionPerformed

    private void butILOCZYNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butILOCZYNActionPerformed
        setDzialanie(2);
        // TODO add your handling code here:
    }//GEN-LAST:event_butILOCZYNActionPerformed

    private void butSUMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSUMAActionPerformed
        setDzialanie(0);

// TODO add your handling code here:
    }//GEN-LAST:event_butSUMAActionPerformed

    private void butSUMA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSUMA1ActionPerformed
        if (zespolona = true) {
            switch (poziom_zespolona) {
                default:
                    break;
                case 1:
                    String b = getZespolona1();
                    try {
                        setZespolona1(b.substring(0, b.length() - 1));

                    } catch (Exception e) {
                        if (b == " ") {
                            setZespolona1("cz.rzeczywista");
                        }
                    }

                    break;
                case 2:
                    String c = getZespolona2();
                    try {
                        setZespolona2(c.substring(0, c.length() - 1));

                    } catch (Exception e) {
                        if (getZespolona2() == "") {
                            setZespolona2("cz.urojona");
                        }

                    }

            }
        } else {
            String x = getText();
            try {
                setText(x.substring(0, x.length() - 1));

            } catch (Exception e) {

            }
        }
        //    poziom = 0;
    }//GEN-LAST:event_butSUMA1ActionPerformed

    private void butSUMAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_butSUMAKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_butSUMAKeyPressed

    private void butZESPOLONAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butZESPOLONAActionPerformed
        butILORAZ.setVisible(false);

        if (butZESPOLONA.isSelected()) {
            butSUMA.setVisible(false);
            butILOCZYN.setVisible(false);
            setText("Wprowadz pierwszą i zatwierdź");
            zespolona = true;
            butEQUALS.setText("ZATWIERDŹ");
            butILORAZ.setVisible(false);
            txtZespolona1.setVisible(true);
            txtZespolona2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel2.setVisible(true);
            setZespolona2("cz.urojona");
            setZespolona1("cz.rzeczywista");

        } else {

            txtZespolona1.setHorizontalAlignment(SwingConstants.LEFT);

            zespolona = false;
            poziom_zespolona = 0;

            butEQUALS.setText("=");
            butSUMA.setVisible(true);
            butILOCZYN.setVisible(true);
            butILORAZ.setVisible(true);
            txtZespolona1.setVisible(false);
            txtZespolona2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel2.setVisible(false);
            setText("");
            butILORAZ.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_butZESPOLONAActionPerformed

    private void txtZespolona1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZespolona1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZespolona1ActionPerformed

    private void txtZespolona1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtZespolona1MouseClicked
        txtZespolona1.setText("");
        poziom_zespolona = 1;
        txtZespolona1.setHorizontalAlignment(SwingConstants.RIGHT);

        // TODO add your handling code here:
    }//GEN-LAST:event_txtZespolona1MouseClicked

    private void txtZespolona2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtZespolona2MouseClicked
        txtZespolona2.setHorizontalAlignment(SwingConstants.LEFT);

        txtZespolona2.setText("");
        poziom_zespolona = 2;

        // TODO add your handling code here:;
    }//GEN-LAST:event_txtZespolona2MouseClicked

    private void none(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyReleased

    private void txtZespolona2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZespolona2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZespolona2ActionPerformed

    private void butPAMIECRIGHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPAMIECRIGHTActionPerformed
        listGETRIGHT();     // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_butPAMIECRIGHTActionPerformed

    private void butPAMIECLEFTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPAMIECLEFTActionPerformed

        listGETLEFT();

        // TODO add your handling code here:
    }//GEN-LAST:event_butPAMIECLEFTActionPerformed

    // TODO add your
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton but0;
    private javax.swing.JButton but1;
    private javax.swing.JButton but2;
    private javax.swing.JButton but3;
    private javax.swing.JButton but4;
    private javax.swing.JButton but5;
    private javax.swing.JButton but6;
    private javax.swing.JButton but7;
    private javax.swing.JButton but8;
    private javax.swing.JButton but9;
    private javax.swing.JButton butEQUALS;
    private javax.swing.JButton butILOCZYN;
    private javax.swing.JButton butILORAZ;
    private javax.swing.JButton butPAMIECLEFT;
    private javax.swing.JButton butPAMIECRIGHT;
    private javax.swing.JButton butPRZECINEK;
    private javax.swing.JButton butROZNICA;
    private javax.swing.JButton butSUMA;
    private javax.swing.JButton butSUMA1;
    private javax.swing.JToggleButton butZESPOLONA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel pamiec;
    private javax.swing.JTextField txtOKNO;
    private javax.swing.JTextField txtZespolona1;
    private javax.swing.JTextField txtZespolona2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
