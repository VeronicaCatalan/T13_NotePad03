package vcatdisseny.t13_notpad03;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotePad extends javax.swing.JFrame {

    public NotePad() {
        initComponents();
        
        setTitle("NOTEPAD");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea = new java.awt.TextArea();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        AbirArchivo = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JPopupMenu.Separator();
        Salir = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        mCopy = new javax.swing.JMenuItem();
        mPegar = new javax.swing.JMenuItem();
        mCortar = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        File.setText("File");

        New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        New.setIcon(new javax.swing.ImageIcon("F:\\D. Vero\\Trabajos\\CS. Aplicaciones desarrollo Web\\Programación\\2º año\\13\\iconos\\16ModernXP-26-Filetype-New-icon.png")); // NOI18N
        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        File.add(New);

        AbirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vcatdisseny/t13_notpad03/16Actions-document-open-icon.png"))); // NOI18N
        AbirArchivo.setText("Abrir Archivo");
        AbirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbirArchivoActionPerformed(evt);
            }
        });
        File.add(AbirArchivo);

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vcatdisseny/t13_notpad03/16floppy-icon.png"))); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        File.add(Guardar);
        File.add(jSeparator);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        File.add(Salir);

        MenuBar.add(File);

        Edit.setText("Edit");

        mCopy.setText("Copy");
        mCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCopyActionPerformed(evt);
            }
        });
        Edit.add(mCopy);

        mPegar.setText("Pegar");
        mPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPegarActionPerformed(evt);
            }
        });
        Edit.add(mPegar);

        mCortar.setText("Cortar");
        mCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCortarActionPerformed(evt);
            }
        });
        Edit.add(mCortar);

        MenuBar.add(Edit);

        aboutMenu.setText("About");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });

        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        aboutMenu.add(jMenuItem4);

        MenuBar.add(aboutMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textArea, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// MENU FILE    
    //new archivo

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this,
                "Do you want to delete the current text?",
                "Remove test?",
                JOptionPane.YES_NO_OPTION);

        if (n == 0) {
            textArea.setText("");
        }
    }//GEN-LAST:event_NewActionPerformed
    //abir archivo

    private void AbirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbirArchivoActionPerformed
        JFileChooser fileopen = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("c files", "c");
        fileopen.addChoosableFileFilter(filter);

        int ret = fileopen.showDialog(this, "Abir archivo");

        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            try {
                String text = readFile(file);

            } catch (FileNotFoundException readFile) {

            }
            textArea.setText("");
        }
    }//GEN-LAST:event_AbirArchivoActionPerformed
    //leer Archivo

    private String readFile(File file) throws FileNotFoundException {
        StringBuffer fileBuffer = null;
        String fileString = null;
        String linea = null;

        try {
            FileReader in;
            in = new FileReader(file);
            BufferedReader bufRd;
            bufRd = new BufferedReader(in);
            fileBuffer = new StringBuffer();

            while ((linea = bufRd.readLine()) != null) {
                fileBuffer.append(linea).append(System.getProperty("line.separator"));
            }
            in.close();
            fileString = fileBuffer.toString();

        } catch (IOException e) {
            return null;
        }
        return fileString;
    }
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(this);
        File file = fileChooser.getSelectedFile();

        if (file != null) {
            try {
                String fileName = file.getAbsolutePath();

                if (file.exists()) {
                    int response = JOptionPane.showConfirmDialog(null,
                            "Do you want to replace the existing file?",
                            "Confirm", JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (response != JOptionPane.YES_NO_CANCEL_OPTION) {
                        return;
                    }
                }
                saveFile(fileName);

            } catch (IOException ex) {
                Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_GuardarActionPerformed
    //COMPROVAR SI EXISTE EL ARCHIVO Y SOBREESCRIBIR  

    private void saveFile(String fileName) throws IOException {
        PrintWriter writer;
        writer = null;

        try {
            writer = new PrintWriter(fileName);
            writer.print(textArea.getText());

        } finally {
            if (null != writer) {
                writer.close();
            }
        }

    }
    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed
  
 //MENU ABOUT   
    
    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
   
    }//GEN-LAST:event_aboutMenuActionPerformed
       
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        AboutDialog about = new AboutDialog (this, true); // true: la ventana se bloquea para el usuario y no puede usar nada hasta q la cierre//    falsae: lo opuesto
        about.pack();
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    
    
// MENU EDIT         
    
    
    private void mCopyActionPerformed(ActionEvent evt) {//GEN-FIRST:event_mCopyActionPerformed
        //textArea.copy();

        String selection = textArea.getSelectedText();
        if (selection == null)
            return;
        StringSelection clipString =new StringSelection(selection);
        Cboard.setContents(clipString,clipString);

    }//GEN-LAST:event_mCopyActionPerformed

    private void mPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPegarActionPerformed
        //textArea.paste();

        Transferable clipData = Cboard.getContents(this);
        try {
            String clipString = (String)clipData.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(clipString,textArea.getSelectionStart(),textArea.getSelectionEnd());
        }
        catch(Exception ex) {
            System.err.println("Not Working");
        }
             
    }//GEN-LAST:event_mPegarActionPerformed

    private void mCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCortarActionPerformed
        //textArea.cut();

        String selection = textArea.getSelectedText();
        if (selection == null)
            return;
        StringSelection clipString = new StringSelection(selection);
        Cboard.setContents(clipString, clipString);
        textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());

    }//GEN-LAST:event_mCortarActionPerformed


    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotePad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbirArchivo;
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu.Separator jSeparator;
    private javax.swing.JMenuItem mCopy;
    private javax.swing.JMenuItem mCortar;
    private javax.swing.JMenuItem mPegar;
    private java.awt.TextArea textArea;
    // End of variables declaration//GEN-END:variables

Clipboard Cboard = getToolkit().getSystemClipboard();    

}


