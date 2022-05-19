
package vcatdisseny.t13_notpad03;

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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextArea = new java.awt.TextArea();
        MenuBar = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        AbirArchivo = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        jSeparator = new javax.swing.JPopupMenu.Separator();
        Salir = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        File.setText("File");
        File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileActionPerformed(evt);
            }
        });

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        File.add(New);

        AbirArchivo.setText("Abrir Archivo");
        AbirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbirArchivoActionPerformed(evt);
            }
        });
        File.add(AbirArchivo);

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

        jMenuItem1.setText("jMenuItem1");
        Edit.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        Edit.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        Edit.add(jMenuItem3);

        MenuBar.add(Edit);

        Help.setText("Help");
        MenuBar.add(Help);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
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
           TextArea.setText(""); 
        }
    }//GEN-LAST:event_NewActionPerformed
    //abir archivo
    
    private void AbirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbirArchivoActionPerformed
      JFileChooser fileopen =new JFileChooser();  
      FileFilter filter = new FileNameExtensionFilter("c files", "c"); 
      fileopen.addChoosableFileFilter(filter);
      
      int ret = fileopen.showDialog(this, "Abir archivo");
      
      if(ret == JFileChooser.APPROVE_OPTION){
          File file = fileopen.getSelectedFile();
            try{
                String text = readFile(file);
                
            }catch(FileNotFoundException readFile){
                
            }
          TextArea.setText("");
      }      
    }//GEN-LAST:event_AbirArchivoActionPerformed
  //leer Archivo
    private String readFile(File file) throws FileNotFoundException {
        StringBuffer fileBuffer = null;
        String fileString =null;
        String linea = null;

        try{
            FileReader in;
                in = new FileReader(file);
            BufferedReader bufRd;
                bufRd = new BufferedReader(in);
            fileBuffer = new StringBuffer();

            while ((linea = bufRd.readLine()) != null) {
                fileBuffer.append(linea).append( System.getProperty("line.separator"));
            }
            in.close();
            fileString = fileBuffer.toString();

        }catch (IOException e){
            return null;
        }
    return fileString;      
}
    private void FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.showSaveDialog(this);
       File file = fileChooser.getSelectedFile();
       
       if (file != null){
           try{
               String fileName = file.getAbsolutePath();
               
               if(file.exists()){
                   int response = JOptionPane.showConfirmDialog(null,
                           "Do ypu wnat to replace the existing file?",
                           "Confirm",JOptionPane.YES_NO_CANCEL_OPTION,
                           JOptionPane.QUESTION_MESSAGE);
                   if(response != JOptionPane.YES_NO_CANCEL_OPTION){
                       return;
                   }
               }
               saveFile(fileName);
               
               
           }catch (IOException ex){
               Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
     //COMPROVAR SI EXISTE EL ARCHIVO Y SOBREESCRIBIR  
       private void saveFile(String fileName) throws IOException {
        PrintWriter writer;
        writer = null;

            try{
                writer = new PrintWriter(fileName);
                writer.print(TextArea.getText());

            }finally{
                if (null != writer) {
                    writer.close();
                }
            }
        
        }
         
    }//GEN-LAST:event_GuardarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

      
    
    
       
    
    
    
    
    
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
    private javax.swing.JMenu Help;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Salir;
    private java.awt.TextArea TextArea;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator;
    // End of variables declaration//GEN-END:variables

    

   
}
