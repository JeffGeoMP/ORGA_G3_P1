import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
/**
/**
 *
 * @author JeffGeo
 */
public class Main extends javax.swing.JFrame {
    
    public static String Direccion_File; 
    
    JFileChooser Eleccion = new JFileChooser();
    FileNameExtensionFilter Extension = new FileNameExtensionFilter("Documentos .draw","draw");
    File file;
    
    FileOutputStream Salida;
    
    FileInputStream entrada;
    InputStreamReader lector;
    BufferedReader br1;
    
    public Main() {
        initComponents();
        Editar.setEnabled(false);
        Guardar.setEnabled(false);
        Guardarcomo.setEnabled(false);
  
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        Menu = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        Abrir = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        Guardarcomo = new javax.swing.JMenuItem();
        Pixelart = new javax.swing.JMenu();
        pixel = new javax.swing.JMenuItem();
        Convertir = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicacion G3 ORGA");

        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane1.setViewportView(txt);

        Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Principal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Archivo.setText("   Archivo   ");

        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        Archivo.add(Abrir);

        Editar.setText("Editar");
        Archivo.add(Editar);

        Guardar.setText("Guardar");
        Archivo.add(Guardar);

        Guardarcomo.setText("Guardar Como...");
        Archivo.add(Guardarcomo);

        Menu.add(Archivo);

        Pixelart.setText("  PixelArt   ");

        pixel.setText("Ingresar a PixelArt");
        pixel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pixelActionPerformed(evt);
            }
        });
        Pixelart.add(pixel);

        Convertir.setText("Convertir .draw a PixelArt");
        Convertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvertirActionPerformed(evt);
            }
        });
        Pixelart.add(Convertir);

        Menu.add(Pixelart);

        Ayuda.setText("   Ayuda   ");
        Menu.add(Ayuda);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
       Eleccion.setFileFilter(Extension);
        if(Eleccion.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            file = Eleccion.getSelectedFile();
            if(file.canRead()){
                if(file.getName().endsWith("draw")){
                    Direccion_File = file.getAbsolutePath();
                    String documento = Abrir(file);
                    txt.setText (documento);
                }else{
                    JOptionPane.showMessageDialog(null,"Archivo No Compatible");
                }
            }
        }
    }//GEN-LAST:event_AbrirActionPerformed

    private void pixelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pixelActionPerformed
        if(!txt.getText().equalsIgnoreCase("")){
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Texto y continuar a PixelArt?");     
            if(resp==JOptionPane.YES_OPTION){
                PixelArt pixel =  new PixelArt();
                pixel.setVisible(true);
            }
        }else{
            PixelArt pixel =  new PixelArt();
            pixel.setVisible(true);
        }
    }//GEN-LAST:event_pixelActionPerformed

    private void ConvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvertirActionPerformed
        if(txt.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "No Hay Nada en el Area de Texto");
        }
    }//GEN-LAST:event_ConvertirActionPerformed

    public String Abrir(File Archivo){
        String doc = "";
        try{
            entrada = new FileInputStream(Archivo);
            lector = new InputStreamReader(entrada,"ISO-8859-1");
            br1 = new BufferedReader(lector);
            int ascci;
            while((ascci=br1.read())!=-1){
                char caracter = (char)ascci;
                doc += caracter;
            }
        }catch(Exception e){
        }
        return doc;
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenuItem Convertir;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem Guardarcomo;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu Pixelart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem pixel;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}
