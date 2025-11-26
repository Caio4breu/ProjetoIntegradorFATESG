package view;

import java.awt.Color;
import util.Registro;

public class TelaRegistroPrejuizo extends javax.swing.JFrame {

    public TelaRegistroPrejuizo() {
        initComponents();
        adicionarPlaceholders();
    }
    
    // Metodos de Placeholder -------------------------------------------------------------
    private void aplicarPlaceholder(javax.swing.JTextField campo, String placeholder) {
        campo.setText(placeholder);
        campo.setForeground(Color.GRAY);

        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (campo.getText().equals(placeholder)) {
                    campo.setText("");
                    campo.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (campo.getText().isEmpty()) {
                    campo.setText(placeholder);
                    campo.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void adicionarPlaceholders() {
        aplicarPlaceholder(jTFEncontrarID, "Digite o ID do veículo");
        aplicarPlaceholder(jTFEncontrarPlaca, "Placa do veículo");
        aplicarPlaceholder(jTFEncontrarData, "Data do registro");
        aplicarPlaceholder(jTFEncontrarMarca, "Marca do veículo");
        aplicarPlaceholder(jTFEncontrarModelo, "Marca do veículo");
        aplicarPlaceholder(jTFEncontrarIdRegistro, "ID do Registro");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupEscolhaClasse = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFEncontrarID = new javax.swing.JTextField();
        jTFEncontrarPlaca = new javax.swing.JTextField();
        jTFEncontrarData = new javax.swing.JTextField();
        jTFEncontrarIdRegistro = new javax.swing.JTextField();
        jTFEncontrarModelo = new javax.swing.JTextField();
        jTFEncontrarMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTFComponenteQuebrado1 = new javax.swing.JTextField();
        jTFValor1 = new javax.swing.JTextField();
        jTFDescricao1 = new javax.swing.JTextField();
        jTFComponenteQuebrado2 = new javax.swing.JTextField();
        jTFValor2 = new javax.swing.JTextField();
        jTFDescricao2 = new javax.swing.JTextField();
        jTFValor3 = new javax.swing.JTextField();
        jTFComponenteQuebrado3 = new javax.swing.JTextField();
        jTFDescricao3 = new javax.swing.JTextField();
        jTFComponenteQuebrado4 = new javax.swing.JTextField();
        jTFValor4 = new javax.swing.JTextField();
        jTFDescricao4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTFData4 = new javax.swing.JTextField();
        jTFData3 = new javax.swing.JTextField();
        jTFData2 = new javax.swing.JTextField();
        jTFData1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GynLog");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Relatorio de Avarias");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Relatório de Aravias para Classificação de Danos em Veículos Registrados");

        jTFEncontrarID.setText("Veículo Id");
        jTFEncontrarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEncontrarIDActionPerformed(evt);
            }
        });

        jTFEncontrarPlaca.setText("Placa");
        jTFEncontrarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEncontrarPlacaActionPerformed(evt);
            }
        });

        jTFEncontrarData.setText("Data");
        jTFEncontrarData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEncontrarDataActionPerformed(evt);
            }
        });

        jTFEncontrarIdRegistro.setText("Id Registro");
        jTFEncontrarIdRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEncontrarIdRegistroActionPerformed(evt);
            }
        });

        jTFEncontrarModelo.setText("Modelo");
        jTFEncontrarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEncontrarModeloActionPerformed(evt);
            }
        });

        jTFEncontrarMarca.setText("Marca");
        jTFEncontrarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEncontrarMarcaActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Automóveis, caminhonetas, caminhonetes e utilitários com estrutura em monobloco");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Componentes peças estruturais/segurança passiva avariadas no acidente");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("COMPONENTE AVARIADO");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("VALOR");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DESCRIÇÃO");

        jTFComponenteQuebrado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFComponenteQuebrado1ActionPerformed(evt);
            }
        });

        jTFValor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFValor1ActionPerformed(evt);
            }
        });

        jTFDescricao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDescricao1ActionPerformed(evt);
            }
        });

        jTFComponenteQuebrado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFComponenteQuebrado2ActionPerformed(evt);
            }
        });

        jTFValor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFValor2ActionPerformed(evt);
            }
        });

        jTFDescricao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDescricao2ActionPerformed(evt);
            }
        });

        jTFValor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFValor3ActionPerformed(evt);
            }
        });

        jTFComponenteQuebrado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFComponenteQuebrado3ActionPerformed(evt);
            }
        });

        jTFDescricao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDescricao3ActionPerformed(evt);
            }
        });

        jTFComponenteQuebrado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFComponenteQuebrado4ActionPerformed(evt);
            }
        });

        jTFValor4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFValor4ActionPerformed(evt);
            }
        });

        jTFDescricao4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDescricao4ActionPerformed(evt);
            }
        });

        jButton1.setText("Enviar Registro");

        jTFData4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFData4ActionPerformed(evt);
            }
        });

        jTFData3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFData3ActionPerformed(evt);
            }
        });

        jTFData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFData2ActionPerformed(evt);
            }
        });

        jTFData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFData1ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATA");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("R$:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("R$:");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("R$:");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("R$:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTFEncontrarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFEncontrarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFEncontrarIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTFEncontrarID, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFEncontrarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFEncontrarData, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFComponenteQuebrado3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTFComponenteQuebrado2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFComponenteQuebrado1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTFComponenteQuebrado4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTFValor2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(jTFValor1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFValor3)
                                    .addComponent(jTFValor4)))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFDescricao4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDescricao3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDescricao2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDescricao1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFData4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFData3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFData2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFData1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jButton1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEncontrarID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEncontrarPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEncontrarData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEncontrarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEncontrarModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEncontrarIdRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFComponenteQuebrado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFComponenteQuebrado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFValor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFComponenteQuebrado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFValor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFComponenteQuebrado4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFValor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDescricao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDescricao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDescricao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFDescricao4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFData2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFData3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFData4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFComponenteQuebrado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFComponenteQuebrado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFComponenteQuebrado1ActionPerformed

    private void jTFComponenteQuebrado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFComponenteQuebrado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFComponenteQuebrado2ActionPerformed

    private void jTFComponenteQuebrado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFComponenteQuebrado3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFComponenteQuebrado3ActionPerformed

    private void jTFComponenteQuebrado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFComponenteQuebrado4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFComponenteQuebrado4ActionPerformed

    private void jTFValor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFValor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFValor1ActionPerformed

    private void jTFValor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFValor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFValor2ActionPerformed

    private void jTFValor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFValor3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFValor3ActionPerformed

    private void jTFValor4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFValor4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFValor4ActionPerformed

    private void jTFDescricao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDescricao1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDescricao1ActionPerformed

    private void jTFDescricao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDescricao2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDescricao2ActionPerformed

    private void jTFDescricao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDescricao3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDescricao3ActionPerformed

    private void jTFDescricao4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDescricao4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFDescricao4ActionPerformed

    private void jTFData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFData1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFData1ActionPerformed

    private void jTFData2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFData2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFData2ActionPerformed

    private void jTFData3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFData3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFData3ActionPerformed

    private void jTFData4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFData4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFData4ActionPerformed

    private void jTFEncontrarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEncontrarIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEncontrarIDActionPerformed

    private void jTFEncontrarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEncontrarPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEncontrarPlacaActionPerformed

    private void jTFEncontrarDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEncontrarDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEncontrarDataActionPerformed

    private void jTFEncontrarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEncontrarMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEncontrarMarcaActionPerformed

    private void jTFEncontrarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEncontrarModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEncontrarModeloActionPerformed

    private void jTFEncontrarIdRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEncontrarIdRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEncontrarIdRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRegistroPrejuizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPrejuizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPrejuizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroPrejuizo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistroPrejuizo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupEscolhaClasse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFComponenteQuebrado1;
    private javax.swing.JTextField jTFComponenteQuebrado2;
    private javax.swing.JTextField jTFComponenteQuebrado3;
    private javax.swing.JTextField jTFComponenteQuebrado4;
    private javax.swing.JTextField jTFData1;
    private javax.swing.JTextField jTFData2;
    private javax.swing.JTextField jTFData3;
    private javax.swing.JTextField jTFData4;
    private javax.swing.JTextField jTFDescricao1;
    private javax.swing.JTextField jTFDescricao2;
    private javax.swing.JTextField jTFDescricao3;
    private javax.swing.JTextField jTFDescricao4;
    private javax.swing.JTextField jTFEncontrarData;
    private javax.swing.JTextField jTFEncontrarID;
    private javax.swing.JTextField jTFEncontrarIdRegistro;
    private javax.swing.JTextField jTFEncontrarMarca;
    private javax.swing.JTextField jTFEncontrarModelo;
    private javax.swing.JTextField jTFEncontrarPlaca;
    private javax.swing.JTextField jTFValor1;
    private javax.swing.JTextField jTFValor2;
    private javax.swing.JTextField jTFValor3;
    private javax.swing.JTextField jTFValor4;
    // End of variables declaration//GEN-END:variables
}
