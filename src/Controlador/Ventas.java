package Controlador;

import Modelo.Conexion;
import static Modelo.Conexion.Conectar;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventas {
    public void llenartabla(String tabla, JTable TabVenta){
        String sql = "Select * from "+ tabla;
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conectar();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No_Factura");
        model.addColumn("Cod_Producto");
        model.addColumn("Descripcion");
        model.addColumn("Precio_Galon");
        model.addColumn("Cantidad_Galones");
        model.addColumn("Total");
        TabVenta.setModel(model);
        
        String [] datos = new String [6];
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);  
            while(rs.next()){
                datos[0] = rs.getString(1);//1 hace referencia a columna 1 
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*public void NuevaVenta(JComboBox CodProducto, JComboBox Descripcion, JTextField cantidad, JTextField precio, JTextField Total){
        try {
            Connection conn = Conectar();
            CallableStatement conx = conn.prepareCall("");
            conx.setString(1, (String) CodProducto.getSelectedItem());
            conx.setString(2, (String) Descripcion.getSelectedItem());
            conx.setString(3, cantidad.getText());
            conx.setString(4, precio.getText());
            conx.setString(5, Total.getText());
            conx.execute();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
    public int Eliminar(String id){
        String sql = "DELETE from ventas WHERE No_ventas = "+id;
        int rs=0;
        Statement s;
        Connection conexion = Conectar();
        int con = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar esta venta ?");
        try{
            s = conexion.createStatement();
            rs = s.executeUpdate(sql);
            
            if(con==0){
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se elimino");
            }  
        }catch(Exception e){
            System.out.println(e);
        }return rs;
    }
    
}
