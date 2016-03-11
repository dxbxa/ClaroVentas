/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaVisual;

import javax.swing.UIManager;
import CapaLogica.GestorLogico;
import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

/**
 *
 * @author david.barrantes
 */
public class VOutBound extends javax.swing.JFrame {

    GestorLogico GL_Principal;
    
    String[][] Clientes_Asignados,llamadas_cliente;
    
    String [] Cliente_Selected;
    
    /**
     * Creates new form VOutBound
     */
    
    public VOutBound(GestorLogico pPrincipal) {
        GL_Principal=pPrincipal;
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
        } catch (Exception ex) { 
            System.out.println(ex); 
        }
        initComponents();
        
        jLabel1.setText(": ");
        jLabel2.setText(": ");
        jLabel3.setText(": ");
        jLabel4.setText(": ");
        jLabel5.setText(": ");
        jLabel6.setText(": ");
        jLabel7.setText(": ");
        jLabel11.setText(": ");
        jLabel10.setText(": ");
        jLabel9.setText(": ");
        jLabel8.setText(": ");
        jLabel16.setText(": ");
        jLabel17.setText(": ");
        
        jTable1.setAutoCreateRowSorter(true);
        
        
        GraphicsEnvironment env =GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        //llena_Basics();
        
        llenar_lista_todos_primer_vez();
        
    }
    
    private void llenar_lista_todos_primer_vez (){
        try{
            Clientes_Asignados=GL_Principal.consulta_Outbound_Asignado(GL_Principal.Usuario[0]);
            //llena_Basics();
            String[] encabezadoA={"ID_Contacto","Nombre_Contacto","Teléfono","Nombre_Base","Status","Fecha Llamada","Resultado"};

            jTable1.setModel(new javax.swing.table.DefaultTableModel(Clientes_Asignados,encabezadoA));
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex, "VENTANA OUT_BOUND", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
        private void llenar_lista_todos_segundas (){
            java.util.Date date_u= new java.util.Date();
            jTable1.setValueAt(jComboBox1.getSelectedItem().toString(), jTable1.getSelectedRow(), 6);
            jTable1.setValueAt(new Timestamp(date_u.getTime()), jTable1.getSelectedRow(), 5);
            
        
        
    }
    
        private void llenar_lista_Historial (){
        try{
            String Nombre_Contacto=Cliente_Selected[1];
            String Telefono=Cliente_Selected[2];
            llamadas_cliente=GL_Principal.Buscar_Outbound_Historial(Nombre_Contacto,Telefono);
            //llena_Basics();
            String[] encabezadoA={"Fecha Llamada","Resultado","Comentario","Gestionado por"};

            jTable2.setModel(new javax.swing.table.DefaultTableModel(llamadas_cliente,encabezadoA));
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(120);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex, "VENTANA OUT_BOUND", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    
    private void llenar_Datos (String pNombre,String pTelefono,String pBase){
    try{
        Cliente_Selected=GL_Principal.consulta_OutBound(pNombre, pTelefono, pBase);
        
        jLabel1.setText("Id Contacto: "+Cliente_Selected[0]);
        jLabel2.setText("Nombre Contacto: "+Cliente_Selected[1]);
        jLabel3.setText("Teléfono: "+Cliente_Selected[2]);
        jLabel4.setText("Base de Datos: "+Cliente_Selected[3]);
        jLabel5.setText(Cliente_Selected[4]+": "+Cliente_Selected[5]);
        jLabel6.setText(Cliente_Selected[6]+": "+Cliente_Selected[7]);
        jLabel7.setText(Cliente_Selected[8]+": "+Cliente_Selected[9]);
        jLabel11.setText(Cliente_Selected[10]+": "+Cliente_Selected[11]);
        jLabel10.setText(Cliente_Selected[12]+": "+Cliente_Selected[13]);
        jLabel9.setText(Cliente_Selected[14]+": "+Cliente_Selected[15]);
        jLabel8.setText(Cliente_Selected[16]+": "+Cliente_Selected[17]);
        jLabel16.setText(Cliente_Selected[18]+": "+Cliente_Selected[19]);
        jLabel17.setText(Cliente_Selected[20]+": "+Cliente_Selected[21]);

    }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex, "VENTANA OUT_BOUND", JOptionPane.WARNING_MESSAGE);
        }
}
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nombre", "Ciudad", "Teléfono", "Fecha llamada", "Resultado"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(204, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Categoría:");

        jLabel2.setText("ID Cliente:");

        jLabel3.setText("Nombre Completo:");

        jLabel4.setText("e-mail:");

        jLabel5.setText("Ciudad:");

        jLabel6.setText("Contrato:");

        jLabel7.setText("Teléfono:");

        jLabel8.setText("Fecha Vence:");

        jLabel9.setText("Fecha Activado:");

        jLabel10.setText("Modalidad:");

        jLabel11.setText("Tipo Producto:");

        jLabel12.setText("Comentarios llamada:");

        jLabel13.setText("Resultado de Llamada:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(2);
        jScrollPane2.setViewportView(jTextArea1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VENTA", "SEGUIMIENTO", "EQUIVOCADO", "TRANSFERENCIA", "RENOVACIÓN", "VENTA CON REFERIDO", "NO APLICA", "SERVICIO POST-VENTA", "Buzón de voz ", "Numero equivocado", "No Interesa", "Malas referencias", "Asesor devuelve llamada ", "Titular o cliente no se encuentra", "Tiene contrato con la competencia ", "Problemas de comunicación ", "Problema de señal en el sitio", "No tiene documento de indentificacion ", "Se encuentra cerca de la agencia ", "Cliente solicita que no se le llame ", "Cliente no tiene capacidad de compra", "Cliente lo va a pensar", "Precio elevado", "No quiere dar datos ", "Fallas de Internet o sistemas ", "No desea esperar", "Fallecido " }));

        jButton1.setText("Guardar Información");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Buscar por:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre_Contacto", "Telefono" }));

        jLabel15.setText("Criterio de Búsqueda:");

        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha Llamada", "Resultado", "Comentario", "Gestionado por"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jLabel18.setText("Historial");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel15)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton4)
                            .addGap(29, 29, 29)
                            .addComponent(jButton3))
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18)))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGap(30, 30, 30)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2))))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
       
        int selectedRowIndex =  jTable1.convertRowIndexToModel(jTable1.getSelectedRow());
        System.out.println(selectedRowIndex+"");
        String selectedNombre = (String) jTable1.getModel().getValueAt(selectedRowIndex, 1);
        String selectedTelefono = (String) jTable1.getModel().getValueAt(selectedRowIndex, 2);
        String selectedBase = (String) jTable1.getModel().getValueAt(selectedRowIndex, 3);
        System.out.println(selectedNombre+selectedTelefono+selectedBase);
        llenar_Datos(selectedNombre,selectedTelefono,selectedBase);
        llenar_lista_Historial ();
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        GL_Principal.Regresar_Outbound();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.util.Date date_u= new java.util.Date();
	 System.out.println("\n \n"+new Timestamp(date_u.getTime()));
if(jTable1.getSelectedRow()<0){
    JOptionPane.showMessageDialog(rootPane, "SELECCIONE UNA LÍNEA DE LA TABLA", "VENTANA IN_BOUND", JOptionPane.WARNING_MESSAGE);
}else{
        
    
        String 
                ID_Contacto=Cliente_Selected[0],
                Nombre_Contacto=Cliente_Selected[1],
                Telefono=Cliente_Selected[2],
                Nombre_Base=Cliente_Selected[3],
                Identificador1_Nombre=Cliente_Selected[4],
                Identificador1_Contenido=Cliente_Selected[5],
                Identificador2_Nombre=Cliente_Selected[6],
                Identificador2_Contenido=Cliente_Selected[7],
                Identificador3_Nombre=Cliente_Selected[8],
                Identificador3_Contenido=Cliente_Selected[9],
                Identificador4_Nombre=Cliente_Selected[10],
                Identificador4_Contenido=Cliente_Selected[11],
                Identificador5_Nombre=Cliente_Selected[12],
                Identificador5_Contenido=Cliente_Selected[13],
                Identificador6_Nombre=Cliente_Selected[14],
                Identificador6_Contenido=Cliente_Selected[15],
                Identificador7_Nombre=Cliente_Selected[16],
                Identificador7_Contenido=Cliente_Selected[17],
                Identificador8_Nombre=Cliente_Selected[18],
                Identificador8_Contenido=Cliente_Selected[19],
                Identificador9_Nombre=Cliente_Selected[20],
                Identificador9_Contenido=Cliente_Selected[21],
                Status="Activo",
                ID_Usuario_Asignado=GL_Principal.Usuario[0],
                //Fecha_Llamada,
                Comentario=jTextArea1.getText(),
                Resultado=jComboBox1.getSelectedItem().toString(),
                ID_Usuario_Gestion=GL_Principal.Usuario[0];
        System.out.println(ID_Contacto+"\n"+Nombre_Contacto+"\n"+Telefono+"\n"+Nombre_Base+"\n"+Identificador1_Nombre+"\n"+Identificador1_Contenido+"\n"+Identificador2_Nombre+"\n"+Identificador2_Contenido+"\n"+Identificador3_Nombre+"\n"+Identificador3_Contenido+"\n"+Identificador4_Nombre+"\n"+Identificador4_Contenido+"\n"+Identificador5_Nombre+"\n"+Identificador5_Contenido+"\n"+Identificador6_Nombre+"\n"+Identificador6_Contenido+"\n"+Identificador7_Nombre+"\n"+Identificador7_Contenido+"\n"+Identificador8_Nombre+"\n"+Identificador8_Contenido+"\n"+Identificador9_Nombre+"\n"+Identificador9_Contenido+"\n"+Status+"\n"+ID_Usuario_Asignado+"\n"+"Fecha_Llamada"+"\n"+Comentario+"\n"+Resultado+"\n"+ID_Usuario_Gestion);
        try{
            GL_Principal.Insertar_Outbound(ID_Contacto,Nombre_Contacto,Telefono,Nombre_Base,Identificador1_Nombre,Identificador1_Contenido,Identificador2_Nombre,Identificador2_Contenido,Identificador3_Nombre,Identificador3_Contenido,Identificador4_Nombre,Identificador4_Contenido,Identificador5_Nombre,Identificador5_Contenido,Identificador6_Nombre,Identificador6_Contenido,Identificador7_Nombre,Identificador7_Contenido,Identificador8_Nombre,Identificador8_Contenido,Identificador9_Nombre,Identificador9_Contenido,Status,ID_Usuario_Asignado,Comentario,Resultado,ID_Usuario_Gestion);
            llenar_lista_todos_segundas();
            llenar_lista_Historial ();
            
            if(jComboBox1.getSelectedItem().toString().equals("VENTA")){
                GL_Principal.VVenta(GL_Principal, 2,ID_Contacto,Nombre_Contacto,Telefono,1,0,Nombre_Base);
            }
            
            if(jComboBox1.getSelectedItem().toString().equals("RENOVACIÓN")){
                GL_Principal.VVenta(GL_Principal, 2,ID_Contacto,Nombre_Contacto,Telefono,1,0,Nombre_Base);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex, "VENTANA IN_BOUND", JOptionPane.WARNING_MESSAGE);
        }
      }
         java.util.Date date_d= new java.util.Date();
	 System.out.println("\n \n"+new Timestamp(date_d.getTime()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        llenar_lista_todos_segundas ();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        
    llenar_lista_x_Criterio ( jComboBox2.getSelectedItem().toString(),  jTextField1.getText());



// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
private void llenar_lista_x_Criterio (String pCriterio, String pValor){
        try{
            Clientes_Asignados=GL_Principal.consulta_Outbound_Criterio(pCriterio,pValor,GL_Principal.Usuario[0]);
            //llena_Basics();
            String[] encabezadoA={"ID_Contacto","Nombre_Contacto","Teléfono","Nombre_Base","Status","Fecha Llamada","Resultado"};

            jTable1.setModel(new javax.swing.table.DefaultTableModel(Clientes_Asignados,encabezadoA));
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex, "VENTANA OUT_BOUND", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
