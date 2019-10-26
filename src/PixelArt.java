import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;


/**
 *
 * @author JeffGeo
 */
public class PixelArt extends javax.swing.JFrame {

    private ArrayList<Object> Coordenadas;
    static final int Filas = 16;
    static final int Columnas = 8;  
    private JLabel[][] Matrix = new JLabel[Filas][Columnas]; 
    
    public PixelArt() {
        initComponents();
        this.Coordenadas = new ArrayList();
        Cargar_Imagenes();
        Cargar_Matriz();
        Evento_Mouse();
    }
    
    public PixelArt(ArrayList Coordenadas){
        initComponents();
        this.Coordenadas = Coordenadas;
        Cargar_Imagenes();
    }

    private void Parser(ArrayList Limpio, ArrayList Separadas){
        boolean x = false, y = false;
        int cx = 0, cy = 0;

        for(Object item:Separadas){
            Tipo t = (Tipo)item;
            if(t.getLex().equalsIgnoreCase("x")){
                x = true;
            }
            if(x){
                if(t.getgTipo()==Tipo.Numero){
                    cx = Integer.parseInt(t.getLex());
                }
            }
        }
    }
    
    private void Cargar_Imagenes(){
        
        Image imgcuadrado = new ImageIcon(getClass().getResource("Imagenes/cuadrado.png")).getImage();
        Image newimagcuadrado = imgcuadrado.getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon iconcuadrado = new ImageIcon(newimagcuadrado);
        cuadrado.setIcon(iconcuadrado);
        
        Image imgcirculo = new ImageIcon(getClass().getResource("Imagenes/circulo.png")).getImage();
        Image newimagcirculo = imgcirculo.getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon iconcirculo = new ImageIcon(newimagcirculo);
        circulo.setIcon(iconcirculo);
        
        Image imgtriangulo = new ImageIcon(getClass().getResource("Imagenes/triangulo.png")).getImage();
        Image newimgtriangulo = imgtriangulo.getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon icontriangulo = new ImageIcon(newimgtriangulo);
        triangulo.setIcon(icontriangulo);
        
        
        Image imglinea = new ImageIcon(getClass().getResource("Imagenes/linea.png")).getImage();
        Image newimaglinea = imglinea.getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon iconlinea = new ImageIcon(newimaglinea);
        linea.setIcon(iconlinea);
        
        Image imgestrella = new ImageIcon(getClass().getResource("Imagenes/estrella.png")).getImage();
        Image newimgestrella = imgestrella.getScaledInstance(cuadrado.getWidth(), cuadrado.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon iconestrella = new ImageIcon(newimgestrella);
        estrella.setIcon(iconestrella);
    }
    
    private void Cargar_Matriz(){
        if(!Coordenadas.isEmpty()){
            
        }else{
            int alto = panel.getWidth()/Filas;
            int ancho = panel.getHeight()/Columnas;
            
            for(int i = 0; i<Filas; i++){
                for(int j = 0; j<Columnas; j++){
                    Matrix[i][j] = new JLabel();
                    Matrix[i][j].setBounds(j*ancho, i*alto, ancho, alto);
                    Border border =  BorderFactory.createLineBorder(Color.BLACK,1);
                    Matrix[i][j].setBorder(border);
                    panel.add(Matrix[i][j]);
                }
            }
        }
    }
    
    
    private void Evento_Mouse(){
        MouseListener e = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JLabel aux = new JLabel();                  //Creamos un JLabel Auxiliar
                        aux = (JLabel)e.getSource();                //Usamos getSource para Saber que Label esta siendo Clickeado
                        aux.setText("1");
                        aux.setHorizontalAlignment(JLabel.CENTER);  //Mandamos 1 si se clickeo
                        aux.setForeground(Color.WHITE);     
                        aux.setOpaque(true);                        //Quitamos el diseño por defecto
                        aux.setBackground(Color.BLACK);             //Pintamos el Label
                        aux.repaint();                              //Actualizamos       
                    } 

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                };
        
        for(int i = 0; i<Filas; i++){
            for(int j = 0; j<Columnas;j++){
                Matrix[i][j].addMouseListener(e);
                Matrix[i][j].setName(i+","+j);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        cuadrado = new javax.swing.JLabel();
        triangulo = new javax.swing.JLabel();
        linea = new javax.swing.JLabel();
        estrella = new javax.swing.JLabel();
        circulo = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Menu = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pixel Art 1.0");

        jLabel1.setText("Figuras");

        cuadrado.setText("Cuadrado");

        triangulo.setText("Triangulo");

        linea.setText("Linea Recta");

        estrella.setText("Estrella");

        circulo.setText("Circulo");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PixelArt", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Archivo.setText("Archivo");

        jMenuItem1.setText("Exportar Imagen a  .draw");
        Archivo.add(jMenuItem1);

        jMenuItem2.setText("Imprimir");
        Archivo.add(jMenuItem2);

        Menu.add(Archivo);

        Ayuda.setText("   Ayuda   ");
        Menu.add(Ayuda);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(triangulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(circulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuadrado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estrella, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(cuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(circulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(triangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(linea, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(estrella, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JLabel circulo;
    private javax.swing.JLabel cuadrado;
    private javax.swing.JLabel estrella;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel linea;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel triangulo;
    // End of variables declaration//GEN-END:variables
}
