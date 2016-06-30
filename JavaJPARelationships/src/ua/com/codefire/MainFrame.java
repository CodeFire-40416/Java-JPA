/*
 * Copyright (C) 2016 CodeFireUA <edu@codefire.com.ua>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ua.com.codefire;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ua.com.codefire.entity.Article;
import ua.com.codefire.entity.Category;

/**
 *
 * @author CodeFireUA <edu@codefire.com.ua>
 */
public class MainFrame extends javax.swing.JFrame {

    private EntityManagerFactory factory;
    private Article selectedArticle;
    CreateArcticleFrame createArcticleFrame = new CreateArcticleFrame();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        factory = Persistence.createEntityManagerFactory("MainPU");

        refreshCategories();

        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlCategories = new javax.swing.JList<>();
        jbCategoriesAdd = new javax.swing.JButton();
        jbCategoriesDel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbArtcles = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaArticleContent = new javax.swing.JTextArea();
        jlArticleStatus = new javax.swing.JLabel();
        jmbMain = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiExit = new javax.swing.JMenuItem();
        jmArticle = new javax.swing.JMenu();
        jmiArticleAddNew = new javax.swing.JMenuItem();
        jmiArticleDeleteSelected = new javax.swing.JMenuItem();
        jmiArticleSave = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCategoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlCategories);

        jbCategoriesAdd.setText("+");
        jbCategoriesAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCategoriesAddActionPerformed(evt);
            }
        });

        jbCategoriesDel.setText("-");
        jbCategoriesDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCategoriesDelActionPerformed(evt);
            }
        });

        jLabel1.setText("Category:");

        jcbArtcles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbArtclesActionPerformed(evt);
            }
        });

        jLabel2.setText("Article:");

        jtaArticleContent.setColumns(20);
        jtaArticleContent.setLineWrap(true);
        jtaArticleContent.setRows(5);
        jtaArticleContent.setAutoscrolls(false);
        jtaArticleContent.setEnabled(false);
        jScrollPane2.setViewportView(jtaArticleContent);

        jlArticleStatus.setText(" ");

        jmFile.setText("File");

        jmiExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jmiExit.setText("Exit");
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmFile.add(jmiExit);

        jmbMain.add(jmFile);

        jmArticle.setText("Article");
        jmArticle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmArticleActionPerformed(evt);
            }
        });

        jmiArticleAddNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiArticleAddNew.setText("Add new...");
        jmiArticleAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiArticleAddNewActionPerformed(evt);
            }
        });
        jmArticle.add(jmiArticleAddNew);

        jmiArticleDeleteSelected.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jmiArticleDeleteSelected.setText("Delete selected");
        jmiArticleDeleteSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiArticleDeleteSelectedActionPerformed(evt);
            }
        });
        jmArticle.add(jmiArticleDeleteSelected);

        jmiArticleSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiArticleSave.setText("Save selected");
        jmiArticleSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiArticleSaveActionPerformed(evt);
            }
        });
        jmArticle.add(jmiArticleSave);

        jmbMain.add(jmArticle);

        setJMenuBar(jmbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCategoriesAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCategoriesDel))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addComponent(jcbArtcles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlArticleStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbArtcles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCategoriesAdd)
                    .addComponent(jbCategoriesDel)
                    .addComponent(jlArticleStatus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshCategories() {
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Category> query = manager.createQuery("SELECT u FROM Category u", Category.class);
        List<Category> CategoriesList = query.getResultList();

        DefaultListModel dlm = new DefaultListModel();
//        for (Category category : CategoriesList) {
//            System.out.printf("#%d %s\n", category.getId(), category.getName());
//        }

        for (Category category : CategoriesList) {
            createArcticleFrame.dcbm1.addElement(category);
            dlm.addElement(category);

        }

        jlCategories.setModel(dlm);

        manager.close();
    }
    private void jmiArticleDeleteSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiArticleDeleteSelectedActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "You are sure want delete selected article?", "DELETE",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (response == JFileChooser.APPROVE_OPTION) {

            if (selectedArticle != null) {
                EntityManager manager = factory.createEntityManager();
                Article toDel = manager.merge(selectedArticle);
                manager.getTransaction().begin();
                manager.remove(toDel);
                manager.getTransaction().commit();
                manager.close();
                String deletedStatus = String.format("Aricle %s whith id = %s DELETED", selectedArticle.getTitle(), selectedArticle.getId());
                jlArticleStatus.setText(deletedStatus);
                refreshCategories();
            }
    }//GEN-LAST:event_jmiArticleDeleteSelectedActionPerformed
    }

    private void jlCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCategoriesMouseClicked

        if (evt.getClickCount() == 2) {
            evt.consume();
//            EntityManager manager = factory.createEntityManager();

            if (jlCategories.getSelectedIndex() >= 0) {

                Category category = jlCategories.getSelectedValue();

                List<Article> selectedArticles = category.getArticles();

                DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

                for (Article article : selectedArticles) {
                    dcbm.addElement(article);
                }

                jcbArtcles.setModel(dcbm);

//                manager.close();
            }
        }

    }//GEN-LAST:event_jlCategoriesMouseClicked

    private void jcbArtclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbArtclesActionPerformed

//        EntityManager manager = factory.createEntityManager();
//        
        selectedArticle = (Article) jcbArtcles.getSelectedItem();
//            jtaArticleContent.setLineWrap(true);

        jtaArticleContent.setText(selectedArticle.getContent());
        jtaArticleContent.setEnabled(true);
    }//GEN-LAST:event_jcbArtclesActionPerformed

    private void jmiArticleAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiArticleAddNewActionPerformed

        createArcticleFrame.setLocationRelativeTo(this);
        createArcticleFrame.setVisible(true);
    }//GEN-LAST:event_jmiArticleAddNewActionPerformed

    private void jmiArticleSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiArticleSaveActionPerformed
        if (selectedArticle != null) {
            EntityManager manager = factory.createEntityManager();
            selectedArticle.setContent(jtaArticleContent.getText());
            manager.getTransaction().begin();
            manager.merge(selectedArticle);
            manager.getTransaction().commit();
            manager.close();
            String savedStatus = String.format("Aricle %s whith id = %s SAVED", selectedArticle.getTitle(), selectedArticle.getId());
            jlArticleStatus.setText(savedStatus);
            refreshCategories();
        }
    }//GEN-LAST:event_jmiArticleSaveActionPerformed

    private void jmArticleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmArticleActionPerformed

    }//GEN-LAST:event_jmArticleActionPerformed

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "You are sure want exit?", "Exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JFileChooser.APPROVE_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jmiExitActionPerformed

    private void jbCategoriesAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCategoriesAddActionPerformed
        Category newCategory = new Category();
        newCategory.setName(JOptionPane.showInputDialog("Enter new Category"));

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.persist(newCategory);

        manager.getTransaction().commit();

        manager.close();

        refreshCategories();
    }//GEN-LAST:event_jbCategoriesAddActionPerformed

    private void jbCategoriesDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCategoriesDelActionPerformed
        if (jlCategories.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nothing to Delete");
        } else {
            Category selectedCategory = jlCategories.getSelectedValue();
            EntityManager manager = factory.createEntityManager();
            
            Category delCategory = manager.merge(selectedCategory);

            manager.getTransaction().begin();

            manager.remove(delCategory);

            manager.getTransaction().commit();

            manager.close();

            refreshCategories();
        }
    }//GEN-LAST:event_jbCategoriesDelActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCategoriesAdd;
    private javax.swing.JButton jbCategoriesDel;
    private javax.swing.JComboBox<Article> jcbArtcles;
    private javax.swing.JLabel jlArticleStatus;
    private javax.swing.JList<Category> jlCategories;
    private javax.swing.JMenu jmArticle;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuBar jmbMain;
    private javax.swing.JMenuItem jmiArticleAddNew;
    private javax.swing.JMenuItem jmiArticleDeleteSelected;
    private javax.swing.JMenuItem jmiArticleSave;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JTextArea jtaArticleContent;
    // End of variables declaration//GEN-END:variables
}
