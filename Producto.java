/*
 * Este es el FUCKING TRABAJO AMIGOS WEEEEEEEEEeeee
 * 
 * Pero tuve un problemita :$ ....
 * 
 * Pense que era con otra base de datos ahce que trabaje con una data de:
 * 
 * Name, Surname,Address,Phone...
 * En una base de datos llamada AddresBook.mdb :D
 * 
 * La idea era colocar tambien internacuionalizacion ... pero ya fue .. .por eso los nombre estan en ingles :D
 * 
 * 
 * Estoy ahora terminando algo ..
 * 
 * No me sale el visualizregistros ...lo voya terminar 
 * 
 * Dialogos tambien me faltan :D
 * 
 * 11/08/2005 03:00 am
 * - Corregida Conxion a Tablas :D. 
 * - Agregado señales de dos dialogos ShowGlg, HelpDlg.
 * 
 * 11/08/2005 19:45 pm
 * - Agregando correciones para Windows
 * 
 * 12/08/2005 02:15 am
 * - Termine de hacer la Presentacin de las Tablas.
 * - Agregue un fondo al app.
 * - Terminado el About
 * - Empieza el Testing y Optimización
 * 
 * 12/08/2005 05:30 am
 * - Terminado :D
 * - Por FIN 
 * 
 * 
 * 
 */

import java.awt.*;
import java.awt.event.*;
//import java.awt.image.ColorModel;
import java.sql.*;
import java.sql.Statement;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;

// Los Frames y Menus :D
public class Producto extends Frame {
    
    public Producto() {
      
        initComponents();
        
    }
        
    public void initComponents() {
           
        menubar = new MenuBar();
        setMenuBar(menubar);
        
        Menu file = new Menu("Archivo");
        MenuItem item1;
        file.add(item1 = new MenuItem("Salir"));
        menubar.add(file);
         
        Menu names = new Menu("Tareas");

        MenuItem item2,item3,item4,item5, item6;
        names.add(item2 = new MenuItem("Agregar..."));
        names.add(item3 = new MenuItem("Editar..."));
        names.add(item4 = new MenuItem("Borrar..."));
        names.add(item5 = new MenuItem("Buscar..."));        
        names.add(item6 = new MenuItem("Mostrar..."));

        menubar.add(names);
       
        Menu about = new Menu("Acerca de...");

        MenuItem item7, item8;
        about.add(item7 = new MenuItem("¡¡¡Ayuda!!!..."));
        about.add(item8 = new MenuItem("Acerca de..."));
        menubar.add(about);
        
        
        myWindowAdapter adapter = new myWindowAdapter(this);
        addWindowListener(adapter);
         
        
        myMenuHandler handler = new myMenuHandler(this);
        
        
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item5.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
      }

        private Menu menu;
        private MenuBar menubar;
///*
  
        	  



      //*/  
        
// Clase Principal        
 public static void main (String args[]){
//	  public static void main(String[] args) {
     	SplashScreen splash = new SplashScreen(3000);
     	splash.showSplashAndExit();

       Producto appProducto =  new Producto();
       appProducto.setIconImage(new ImageIcon("tunkyico.gif").getImage());
       appProducto.setTitle("Los Productos");
       ImageIcon grafic  = new ImageIcon("fondo.gif");
       JLabel l1= new JLabel (grafic);       
       appProducto.setSize(600, 400);
       appProducto.setBackground(Color.CYAN);
       appProducto.add(l1);
       appProducto.setVisible(true);        
       
    }
}


class myWindowAdapter extends WindowAdapter {
    Producto appProducto;
     public myWindowAdapter(Producto appProducto) {
        this.appProducto = appProducto;
     }
    public void windowClosing(WindowEvent we) {
        appProducto.setVisible(false);
        appProducto.dispose();
    }
}

// Dialogo del About ... Terminado
// Seria interesante agregar un Scroll para que las letras pasen abajo de hacia arriba  :D  
class AboutDlg extends Dialog implements ActionListener {
    AboutDlg(Producto parent,String title) {
        super (parent, title, true);        
        setSize(200,250);
        setFont(new Font("Arial", Font.BOLD, 10));
        setLocation(100,50);
        JLabel cy1 = new JLabel("        TUNKY.NET      ");        
        ImageIcon grafico  = new ImageIcon("tunkyab.gif");
        JLabel label1 = new JLabel(grafico);
        JLabel cy2 = new JLabel("Developer's Hacker's");
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
        p1.add(cy1);        
        p1.add(label1);
        p1.add(cy2);        
        JPanel p2 = new JPanel();
        Button close = new Button("Cerrar");
        p2.add(close);
        p1.add(p2);
        close.addActionListener(this);       
        add(p1);

    }
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Cerrar")) {
            dispose();
       }
   }
}

//CLase Para Dialogo de Mostrar los Registros Completos    
class ShowDlg extends Dialog implements ActionListener {
	ShowDlg(Producto parent,String title) {
        super (parent, title, true);
        GetData();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(500,400);
        setFont(new Font("Arial", Font.BOLD, 10));
        setLocation(70,30);
        Label company = new Label("Vizualizando Registros");
        Button close = new Button("Cerrar");
        
        //String [][] data1 = {s1,s2,s3,s4,s5,s6,s7,s8,s9 };
               
      //  Object[][] cells = {
      	//	  {s1,s2,s3,s4,s5,s6,s7,s8,s9 } };
        //colNames = { "Número","Descripcion", "Marca", "Pais de Origen", "Año Fabricacion","Años Garantia", "Precio de Costo","Precio de Venta","Estado" };
        
        colum.addElement("Descripcion");
        colum.addElement("Marca");
        colum.addElement("Pais de Origen");
        colum.addElement("Año Fabricacion");
        colum.addElement("Años Garantia");
        colum.addElement("Precio de Costo");
        colum.addElement("Precio de Venta");
        colum.addElement("Estado");
                
        DefaultTableModel model = new DefaultTableModel(rows, colum);
        JTable table = new JTable(model);
        //table.se
      table.setPreferredScrollableViewportSize(new Dimension(450, 290));
        JScrollBar hbar = new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 450);
        JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 450);

        hbar.setUnitIncrement(2);
        hbar.setBlockIncrement(1);
        
        JScrollPane scrollPane = new JScrollPane(table);
       table.setPreferredSize(new Dimension(490, 290));
        

        //hbar.addAdjustmentListener(new MyAdjustmentListener());
        //vbar.addAdjustmentListener(new MyAdjustmentListener());
        
        scrollPane.setVerticalScrollBar(new JScrollBar());
		scrollPane.setHorizontalScrollBar(hbar);
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
		
        //scrollPane.setSize(500,400);
        close.addActionListener(this);
        add(company);
        add(scrollPane);
        //add(scrollPane, BorderLayout.CENTER);
        add(close);
        
    } 

	private Vector colum = new Vector(8);
	
	//
		
	private Vector rows = new Vector();
	
	
	String s2,s3,s4,s5,s6,s7,s8,s9;

public void GetData() {
    
    String dbuser = " ";
    String dbpasswd = " ";
    String DriverPrefix = "jdbc:odbc:";
    String DataSource = "Producto";
         
    String SQL = "SELECT * FROM Producto" ;
    
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    } catch (Exception e) {
       JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en el Driver de JDBC",JOptionPane.WARNING_MESSAGE);
    }
    Statement stmt = null;
    Connection con = null;
    
    try {
        con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser,dbpasswd);
        stmt = con.createStatement();
    } catch (Exception e) {
       JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en la Conección ",JOptionPane.WARNING_MESSAGE);  
    }
    ResultSet rs = null;
       
    try {
        rs = stmt.executeQuery(SQL);
      
        	
        while(rs.next()){
      
        //s1 = rs.getString("codigo");
      	s2= rs.getString("descripcion");
      	s3 =  rs.getString("marca");
      	s4 = rs.getString("pais_origen");
      	s5 = rs.getString("anhio_fabricacion");
      	s6 = rs.getString("anhios_garantia");
      	s7 = rs.getString("precio_costo");
      	s8 = rs.getString("precio_venta");
      	s9 = rs.getString("estado");      	
      	
      	Vector row = new Vector();
      	//row.addElement(s1);
      	row.addElement(s2);
      	row.addElement(s3);
      	row.addElement(s4);
      	row.addElement(s5);      
      	row.addElement(s6);
      	row.addElement(s7);
      	row.addElement(s8);
      	row.addElement(s9);
      	
      	rows.addElement(row);
      	
        }             
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en la Comunicación Error",JOptionPane.WARNING_MESSAGE);
    }
    try {
       con.close();
   } catch (Exception e) {
       JOptionPane.showMessageDialog(null,""+e.getMessage(),"Cuidado",JOptionPane.WARNING_MESSAGE);
   }
}

    
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Cerrar")) {
            dispose();
       }
   }
}


// Clase Para el Dialogo de Ayuda
class HelpDlg extends Dialog implements ActionListener {
	HelpDlg(Producto parent,String title) {
            super (parent, title, true);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setSize(200,200);
            setFont(new Font("Arial", Font.BOLD, 10));
            setLocation(70,30);
            Label company = new Label("¿Quiere Ayuda?");
            Button close = new Button("Cerrar");
            close.addActionListener(this);
            add(company);
            add(close);
        } 

    
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Cerrar")) {
            dispose();
       }
   }
}

//Para Agregar Datos 

class AddDlg extends Dialog implements ActionListener {
    
    TextField Descripcion1, Marca1, Pais_origen1,	Anhio_fabricacion1,	Anhios_garantia1, Precio_costo1, Precio_venta1;
    JComboBox Estado1;
    Button BtnOK,BtnCn;
    
    public AddDlg(Producto parent, String title) {
       
        super(parent, title, true);
        setLayout(new GridLayout(9,2,6,5));
        setSize(350,400);
        setResizable(false);
        
        Label Descripcion, Marca, Pais_origen,	Anhio_fabricacion,	Anhios_garantia, Precio_costo, Precio_venta, Estado;
                     
        Descripcion = new Label("Descripcion: ");
        Marca = new Label("Marca: ");
        Pais_origen = new Label("Pais de Origen: ");
        Anhio_fabricacion = new Label("Año de Fabricacion: ");
        Anhios_garantia = new Label("Años de Garantia: ");
        Precio_costo = new Label("Precio de Costo: ");
        Precio_venta = new Label("Precio de Venta: ");
        Estado = new Label("En Almacen: ");
        
        
        
        Descripcion1 = new TextField(20);
        Marca1 = new TextField(20);
        Pais_origen1 = new TextField(20);
        Anhio_fabricacion1 = new TextField(6);
        Anhios_garantia1 = new TextField(6);
        Precio_costo1= new TextField(10);
        Precio_venta1= new TextField(10);
        String[] est = { "Si", "No" };
        Estado1 = new JComboBox(est);
        
                        
        BtnOK = new Button("OK");
        BtnCn = new Button("Cancelar");
       
        BtnOK.addActionListener(this);
        BtnCn.addActionListener(this);
        
        Label space1,space2,space3,space4,space5,space6,space7,space8,space9;
        
        space1 = new Label(" ");
        space2 = new Label(" ");
        space3 = new Label(" ");
        space4 = new Label(" ");
        space5 = new Label(" ");
        space6 = new Label(" ");
        space7 = new Label(" ");
        space8 = new Label(" ");
        space9 = new Label(" ");

        add(Descripcion);
        add(Descripcion1);
        //add(space1);
        add(Marca);
        add(Marca1);
        //add(space2);
        add(Pais_origen);
        add(Pais_origen1);
        //add(space3);
        add(Anhio_fabricacion);
        add(Anhio_fabricacion1);
        //add(space4);
        add(Anhios_garantia);
        add(Anhios_garantia1);
        //add(space5);
        add(Precio_costo);
        add(Precio_costo1);
        //add(space6);
        add(Precio_venta);
        add(Precio_venta1);
        //add(space7);
        add(Estado);
        add(Estado1);        
        //add(space8);
        //add(space9);
        add(BtnOK);
        add(BtnCn);
   }
    
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
           if (str.equals("OK")){
              ToDataBase();             
            }          
           if (str.equals("Cancelar")) {
             dispose();
            }
    }
    
    
    public void ToDataBase()  {
       
    	String Descripcion = Descripcion1.getText();
    	String Marca = Marca1.getText(); 
    	String Pais_origen = Pais_origen1.getText(); 
    	String Anhio_fabricacion = Anhio_fabricacion1.getText(); 
    	String Anhios_garantia = Anhios_garantia1.getText(); 
    	String Precio_costo = Precio_costo1.getText(); 
    	String Precio_venta = Precio_venta1.getText();
    	String Estado;
    	//Estado1.getSelectedItem(Estado); 		
             
        String dbuser = "";
        String dbpasswd = "";
        String DriverPrefix = "jdbc:odbc:";
        String DataSource ="Producto";
        
        if ( Estado1.getSelectedItem().equals("Si") ){
        	Estado = "1" ;
        }
        else{
        	Estado = "0" ;
        }
        
        
        //String SQLString = "INSERT INTO Producto (codigo,descripcion,Marca,pais_origen,anhio_fabricacion,anhios_garantia,precio_costo,precio_venta,estado)VALUES('" +Descripcion+"','"+Marca+"','"+Pais_origen+"','"+Anhio_fabricacion+"','"+Anhios_garantia+"','"+Precio_costo+"','"+Precio_venta+"','"+Estado+"')";
        
        /*stmt.executeUpdate(
                "INSERT INTO autoIncTutorial (dataField) "
                + "values ('Can I Get the Auto Increment Field?')",
                );*/
        
        String SQLString = "INSERT INTO Producto (descripcion,Marca,pais_origen,anhio_fabricacion,anhios_garantia,precio_costo,precio_venta,estado)VALUES('"+Descripcion+"','"+Marca+"','"+Pais_origen+"','"+Anhio_fabricacion+"','"+Anhios_garantia+"','"+Precio_costo+"','"+Precio_venta+"','"+Estado+"')";
        //String SQLString = "INSERT INTO Producto (descripcion,Marca,pais_origen,anhio_fabricacion,anhios_garantia,precio_costo,precio_venta,estado)VALUES('" +Descripcion+"','"+Marca+"','"+Pais_origen+"','"+Anhio_fabricacion+"','"+Anhios_garantia+"','"+Precio_costo+"','"+Precio_venta+"')";
                

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en el Driver JDBC",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Statement stmt = null;
        Connection con = null;
       
        try {
              con = DriverManager.getConnection(DriverPrefix+DataSource,
              dbuser, dbpasswd);
              stmt = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Conneccion",JOptionPane.WARNING_MESSAGE);
        }
       
        try {
            //stmt.executeUpdate(SQLString,Statement.RETURN_GENERATED_KEYS);          
        	stmt.executeUpdate(SQLString);
            con.close();
            this.dispose();
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Verificar todas las Entradas de Textoxt por completar.\n"+e.getMessage(),"Error de Comunicación",JOptionPane.WARNING_MESSAGE);
        }    
    } 
}


class EditDlg extends Dialog implements ActionListener, ItemListener {
    

    TextField MarcaField,Pais_origenField,Anhio_fabricacionField,Anhios_garantiaField,Precio_costoField,Precio_ventaField;
    
    JComboBox EstadoField;   
    
    Choice DescripcionList;
    
    public EditDlg(Producto parent, String title) {

        super(parent, title, true);
        setLayout (new GridLayout(9,2,6,5));
        setSize(350, 400);
        setResizable(false);

        Label Descripcion, Marca, Pais_origen,	Anhio_fabricacion,	Anhios_garantia, Precio_costo, Precio_venta, Estado;
        
        Descripcion = new Label("Descripcion: ");
        Marca = new Label("Marca: ");
        Pais_origen = new Label("Pais de Origen: ");
        Anhio_fabricacion = new Label("Año de Fabricacion: ");
        Anhios_garantia = new Label("Años de Garantia: ");
        Precio_costo = new Label("Precio de Costo: ");
        Precio_venta = new Label("Precio de Venta: ");
        Estado = new Label("Estado: ");

        DescripcionList = new Choice();
      
        MarcaField = new TextField(20);
        Pais_origenField = new TextField(20);
        Anhio_fabricacionField = new TextField(6);
        Anhios_garantiaField = new TextField(6);
        Precio_costoField = new TextField(10);
        Precio_ventaField = new TextField(10);
        String[] est = { "Si", "No" };
        EstadoField = new JComboBox(est);
        
        Button BtnUpdate, BtnCn;
        
        BtnUpdate = new Button("Actualizar");
        BtnCn = new Button("Cancelar");
        
        BtnUpdate.addActionListener(this);
        BtnCn.addActionListener(this);
        DescripcionList.addItemListener(this);
        
        
        Label space1,space2,space3,space4,space5,space6,space7,space8,space9;
        
        space1 = new Label(" ");
        space2 = new Label(" ");
        space3 = new Label(" ");
        space4 = new Label(" ");
        space5 = new Label(" ");
        space6 = new Label(" ");
        space7 = new Label(" ");
        space8 = new Label(" ");
        space9 = new Label(" ");

        add(Descripcion);
        add(DescripcionList);
        //add(space1);
        add(Marca);
        add(MarcaField);
        //add(space2);
        add(Pais_origen);
        add(Pais_origenField);
        //add(space3);
        add(Anhio_fabricacion);
        add(Anhio_fabricacionField);
        //add(space4);
        add(Anhios_garantia);
        add(Anhios_garantiaField);
        //add(space5);
        add(Precio_costo);
        add(Precio_costoField);
        //add(space6);
        add(Precio_venta);
        add(Precio_ventaField);
        //add(space7);
        add(Estado);
        add(EstadoField);        
        //add(space8);
        //add(space9);
        
        add(BtnUpdate);
        add(BtnCn);
        GetData();
    }
   
    
    public void actionPerformed(ActionEvent e) {
      String str = e.getActionCommand();
        if (str.equals("Actualizar")){
           DataUpdate();
        }
        if (str.equals("Cancelar")) {
            dispose();
        }
    }
    
    public void itemStateChanged(ItemEvent ie) {
        String dbuser = " ";
        String dbpasswd = " ";
        String DriverPrefix = "jdbc:odbc:";
        String DataSource = "Producto";
        
        String myChoice = DescripcionList.getSelectedItem();
               
        String SQL = "SELECT descripcion,marca,pais_origen,anhio_fabricacion,anhios_garantia,precio_costo,precio_venta,estado FROM Producto WHERE descripcion ='" +myChoice+ "'";
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en el  Driver de JDBC ",JOptionPane.WARNING_MESSAGE);
        }
        Statement stmt = null;
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser,dbpasswd);
            stmt = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en la Conneccion",JOptionPane.WARNING_MESSAGE);
        }
        
        ResultSet rs = null;
       
        try {
            rs = stmt.executeQuery(SQL);
            rs.next();
                        
            //Codigo.setText(rs.getString(1));
            //Descripcion.setText(rs.getString(1));
            
            MarcaField.setText(rs.getString("marca"));
            Pais_origenField.setText(rs.getString("pais_origen"));
            Anhio_fabricacionField.setText(rs.getString("anhio_fabricacion"));
            Anhios_garantiaField.setText(rs.getString("anhios_garantia"));
            Precio_costoField.setText(rs.getString("precio_costo"));
            Precio_ventaField.setText(rs.getString("precio_venta"));
                                 
            if (rs.getString("estado")=="1" ){
            	EstadoField.getSelectedItem().equals("Si");
            }
            else{
            	EstadoField.getSelectedItem().equals("No");
            }
            
            con.close();
            
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Comunicación",JOptionPane.WARNING_MESSAGE);
    }
}
   
    
    public void GetData() {
        
        String dbuser = " ";
        String dbpasswd = " ";
        String DriverPrefix = "jdbc:odbc:";
        String DataSource = "Producto";
             
        String SQL = "SELECT * FROM Producto" ;
        
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error del Driver JDBC",JOptionPane.WARNING_MESSAGE);
        }
        Statement stmt = null;
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser,dbpasswd);
            stmt = con.createStatement();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Conección ",JOptionPane.WARNING_MESSAGE);  
        }
        ResultSet rs = null;
           
        try {
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
               DescripcionList.add(rs.getString("descripcion"));
            }             
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Comunicacion",JOptionPane.WARNING_MESSAGE);
        }
        try {
           con.close();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Cuidado",JOptionPane.WARNING_MESSAGE);
       }
    }

    
    public void DataUpdate() {
       
        String dbuser = " ";
        String dbpasswd = " ";
        String DriverPrefix = "jdbc:odbc:";
        String DataSource = "Producto";
        

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en el Driver de JDBC",JOptionPane.WARNING_MESSAGE);
        }
        
       Statement stmt = null;
       Connection con = null;
        

        try {
            con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser,dbpasswd);
            stmt = con.createStatement();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Comunicación",JOptionPane.WARNING_MESSAGE);
        }
        
        
        String upMarca = MarcaField.getText();
        String upPais_origen = Pais_origenField.getText();
        String upAnhio_fabricacion = Anhio_fabricacionField.getText();
        String upAnhios_garantia = Anhios_garantiaField.getText();
        String upPrecio_costo = Precio_costoField.getText();
        String upPrecio_venta = Precio_ventaField.getText();
        String upEstado; 
        
        if ( EstadoField.getSelectedItem().equals("Si") ){
        	upEstado = "1" ;
        }
        else{
        	upEstado = "0" ;
        } 
        
        String SQL = "UPDATE Producto SET marca = '"+upMarca+"',pais_origen = '"+upPais_origen+"',anhio_fabricacion = '"+upAnhio_fabricacion+"',anhios_garantia = '"+upAnhios_garantia+"',precio_costo = '"+upPrecio_costo+"',precio_venta = '"+upPrecio_venta+"',estado = '"+upEstado+"' WHERE descripcion = '"+DescripcionList.getSelectedItem()+"'"; 

       try {
            stmt.executeUpdate(SQL);
            con.close();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Comunicacion",JOptionPane.WARNING_MESSAGE);
        } 
     }
   }


class DelRec extends Dialog implements ActionListener, ItemListener {
    
    TextField MarcaField,Pais_origenField,Anhio_fabricacionField,Anhios_garantiaField,Precio_costoField,Precio_ventaField,EstadoField;   
    
    Choice DescripcionList;
    
    public DelRec (Producto parent, String title) {
      
        super (parent, title, true);
        setLayout(new GridLayout(9,2,6,5));
        setSize(350, 400);
        setResizable(false);
        

        Label Descripcion, Marca, Pais_origen,	Anhio_fabricacion,	Anhios_garantia, Precio_costo, Precio_venta, Estado;
        
        Descripcion = new Label("Descripci?n: ");
        Marca = new Label("Marca: ");
        Pais_origen = new Label("Pais de Origen: ");
        Anhio_fabricacion = new Label("Año de Fabricacion: ");
        Anhios_garantia = new Label("Años de Garantia: ");
        Precio_costo = new Label("Precio de Costo: ");
        Precio_venta = new Label("Precio de Venta: ");
        Estado = new Label("Estado: ");            

        Label space1, space2, space3, space4, space5;
        

        space1 = new Label(" ");
        space2 = new Label(" ");
        space3 = new Label(" ");
        space4 = new Label(" ");
        space5 = new Label(" ");
        

        Button BtnDel = new Button("Borrar");
        Button BtnCn = new Button("Cancelar");
        

        DescripcionList = new Choice();
        
        
        BtnDel.addActionListener(this);
        BtnCn.addActionListener(this);
        DescripcionList.addItemListener(this);
        

        MarcaField = new TextField(20);
        Pais_origenField = new TextField(20);
        Anhio_fabricacionField = new TextField(6);
        Anhios_garantiaField = new TextField(6);
        Precio_costoField = new TextField(10);
        Precio_ventaField = new TextField(10);
        EstadoField = new TextField(1);

        add(Descripcion);
        add(DescripcionList);
        //add(space1);
        add(Marca);
        add(MarcaField);
        //add(space2);
        add(Pais_origen);
        add(Pais_origenField);
        //add(space3);
        add(Anhio_fabricacion);
        add(Anhio_fabricacionField);
        //add(space4);
        add(Anhios_garantia);
        add(Anhios_garantiaField);
        //add(space5);
        add(Precio_costo);
        add(Precio_costoField);
        //add(space6);
        add(Precio_venta);
        add(Precio_ventaField);
        //add(space7);
        add(Estado);
        add(EstadoField);        
        //add(space8);
        //add(space9);
                
        add(BtnDel);
        add(BtnCn);
        GetData();
    }

    
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Borrar")) {
            DelCurRec();
        }
        if (str.equals("Cancelar")) {
            dispose();
        }
   }    
    
    
    public void itemStateChanged(ItemEvent e) {
        
        String dbuser = " ";
        String dbpasswd = " ";
        String DriverPrefix = "jdbc:odbc:";
        String DataSource = "Producto";
        

        String myChoice = DescripcionList.getSelectedItem();
        

        String SQL = "SELECT descripcion,marca,pais_origen,anhio_fabricacion,anhios_garantia,precio_costo,precio_venta,estado FROM Producto WHERE descripcion ='" +myChoice+ "'";
        

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,""+ex.getMessage(),"JDBC Driver Error",JOptionPane.WARNING_MESSAGE);
        }
        Statement stmt = null;
        Connection con = null;
        

        try {
            con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser,dbpasswd);
            stmt = con.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,""+ex.getMessage(),"Connection Error",JOptionPane.WARNING_MESSAGE);
        }
        
        ResultSet rs = null;
       

        try {
            rs = stmt.executeQuery(SQL);
            rs.next();
            
            MarcaField.setText(rs.getString("marca"));
            Pais_origenField.setText(rs.getString("pais_origen"));
            Anhio_fabricacionField.setText(rs.getString("anhio_fabricacion"));
            Anhios_garantiaField.setText(rs.getString("anhios_garantia"));
            Precio_costoField.setText(rs.getString("precio_costo"));
            Precio_ventaField.setText(rs.getString("precio_venta"));
            EstadoField.setText(rs.getString("estado"));
            
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,""+ex.getMessage(),"Error de Comunicacion ",JOptionPane.WARNING_MESSAGE);
        }
 }    

    
    public void GetData() {
       
       String dbuser = " ";
       String dbpasswd = " ";
       String DriverPrefix = "jdbc:odbc:";
       String DataSource = "Producto";
       
       String SQL = "SELECT * FROM Producto";
       
       try {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }  catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en el Driver de JDBC",JOptionPane.WARNING_MESSAGE);
       }
       
       Statement stmt = null;
       Connection con = null;
       
       try {
            con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser, dbpasswd);
            stmt = con.createStatement();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Conexión",JOptionPane.WARNING_MESSAGE);
       }
       
       ResultSet rs = null;
       
       try {
           rs = stmt.executeQuery(SQL);
           
           while (rs.next()) {
               DescripcionList.add(rs.getString("descripcion"));
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Problema de Comunicacion",JOptionPane.WARNING_MESSAGE);
       }
    }
    
    public void DelCurRec() {
        
        String dbuser = " ";
        String dbpasswd = " ";
        String DriverPrefix = "jdbc:odbc:";
        String DataSource = "Producto";
        

        String myChoice = DescripcionList.getSelectedItem();
        

        String SQL = "DELETE FROM Producto WHERE descripcion = '" +myChoice+ "'";
    
        try {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
       }  catch (Exception e) {
           JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error del Driver de JDBC",JOptionPane.WARNING_MESSAGE);
       }
        
        Statement stmt = null;
        Connection con = null;
        

        try {
            con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser,dbpasswd);
            stmt = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Conexion",JOptionPane.WARNING_MESSAGE);
        }
        

        try {
            stmt.executeUpdate(SQL);

            con.close();

            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Comunicación",JOptionPane.WARNING_MESSAGE);
        }
    }
}




class SearchDlg extends Dialog implements ActionListener, ItemListener {
    
        TextField Descripcion;

        Button BtnGo, BtnCn;

        Checkbox option1 = new Checkbox("Por Marca");
        Checkbox option2 = new Checkbox("Por Pais");
    
        public SearchDlg (Producto parent, String title) {
        
        super(parent,title,false);
        setSize(300, 150);
        setLayout(new GridLayout(3,2,1,2));
        setResizable(false);
        setLocation(300,50);
        
        Label Srch = new Label("Buscar para :");
        
        Descripcion = new TextField(10);
           
        BtnGo = new Button("Buscar");
        BtnCn = new Button("Cancelar");      

        BtnGo.setEnabled(false);
        
        BtnGo.addActionListener(this);
        BtnCn.addActionListener(this);
        
        option1.addItemListener(this);
        option2.addItemListener(this);
        
        Label space1, space2, space3;
        
        space1 = new Label(" ");
        space2 = new Label(" ");
        space3 = new Label(" ");
        
        add(Srch);
        add(Descripcion);
        //add(space1);
        add(option1);
        add(option2);
        //add(space2);
        //add(space3);
        add(BtnGo);
        add(BtnCn);
    }
    
        
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
            if (str.equals("Buscar")) {
                GoSrch();
            }
            if (str.equals("Cancelar")) {
                dispose();
            }
       }
      
    
    public void itemStateChanged(ItemEvent e) {
        if (option1.getState() == true) {
            option2.setEnabled(false); 
            BtnGo.setEnabled(true);
        } else {
            option2.setEnabled(true);
            BtnGo.setEnabled(false);
        }
        if (option2.getState() == true) {
            option1.setEnabled(false);
            BtnGo.setEnabled(true);
        } else {
            option1.setEnabled(true);
        }
    }
    
    
    public void GoSrch() {
              
       if (option1.getState() == true) {
           Srch1();
       }
       if (option2.getState() == true) {
           Srch2();
       }
    }


    
    public void Srch1()  {
        
         String dbuser = " ";
         String dbpasswd = " ";
         String DriverPrefix = "jdbc:odbc:";
         String DataSource = "Producto";
                  
         String mySearch = Descripcion.getText();
         

         String SQL = "SELECT descripcion,marca,pais_origen,anhio_fabricacion,anhios_garantia,precio_costo,precio_venta,estado FROM Producto WHERE descripcion = '" +mySearch+"'";
         

         try {
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error de Driver de JDBC", JOptionPane.WARNING_MESSAGE);
         }
         
         Statement stmt = null;
         Connection con = null;
         

         try {
             con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser, dbpasswd);
             stmt = con.createStatement();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " "+e.getMessage(),"No se puede conectar a la Base de Datos",JOptionPane.WARNING_MESSAGE);
         }
         
         ResultSet rs = null;
         

         try {
             rs = stmt.executeQuery(SQL);
             rs.next(); 
             String Result = rs.getString(1) + " " + rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(4);
             

             JOptionPane.showMessageDialog(null,Result,"Registro Encontrado", JOptionPane.INFORMATION_MESSAGE);
            

             con.close();
             this.dispose();
         
         } catch (Exception e) {

             JOptionPane.showMessageDialog(null ,"Registro no Hallado","Cuidado", JOptionPane.INFORMATION_MESSAGE);
         }
    }

    public void Srch2() {
            
         String dbuser = " ";
         String dbpasswd = " ";
         String DriverPrefix = "jdbc:odbc:";
         String DataSource = "Producto";

         String mySearch = Descripcion.getText();

         String SQL = "SELECT descripcion,marca,pais_origen,anhio_fabricacion,anhios_garantia,precio_costo,precio_venta,estado FROM Producto WHERE marca = '" +mySearch+"'";

         try {
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,""+e.getMessage(),"Error en el Driver de la Base de Datos", JOptionPane.WARNING_MESSAGE);
         }
         
         Statement stmt = null;
         Connection con = null;

         try {
             con = DriverManager.getConnection(DriverPrefix+DataSource,dbuser, dbpasswd);
             stmt = con.createStatement();
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, " "+e.getMessage(),"No se puede Conectar a la Base de Datos ",JOptionPane.WARNING_MESSAGE);
         }
         
         ResultSet rs = null;

         try {
             rs = stmt.executeQuery(SQL);
             rs.next(); 
             String Result = rs.getString(1) + " " + rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(4);

             JOptionPane.showMessageDialog(null,Result,"Registro Encontrado", JOptionPane.INFORMATION_MESSAGE);

             con.close();
             this.dispose();
         
         } catch (Exception e) {

             JOptionPane.showMessageDialog(null ,"Registro no Encontrado","Cuidado", JOptionPane.INFORMATION_MESSAGE);
         }
   }
}


class myMenuHandler implements ActionListener {
    Producto appProducto;
    public myMenuHandler(Producto appProducto) {
        this.appProducto = appProducto;
    }
    
 
    public void actionPerformed(ActionEvent ae) {
        String arg = (String)ae.getActionCommand();

         if (arg.equals("Salir")) {
           appProducto.dispose();
        }      
        
        if (arg.equals("Agregar...")) {
            AddDlg Adlg = new AddDlg(appProducto, "Agregar Nueva Direccion");
            Adlg.setVisible(true);
        }
        
        if (arg.equals("Editar...")) {
            EditDlg Edlg = new EditDlg(appProducto, "Editar Registros");
            Edlg.setVisible(true);
        }
                      
        if (arg.equals("Borrar...")) {
            DelRec dlg = new DelRec(appProducto, "Borrar Registros");
            dlg.setVisible(true);
        }        
        
        if (arg.equals("Buscar...")) {
            SearchDlg schDlg = new SearchDlg(appProducto, "Buscar Registros");
            schDlg.setVisible(true);
        }
        
        if (arg.equals("Mostrar...")) {
            ShowDlg showr = new ShowDlg(appProducto, "Vizualizar Registros");
            showr.setVisible(true);
        }
        
        if (arg.equals("¡¡¡Ayuda!!!...")) {
            HelpDlg d = new HelpDlg(appProducto, "Ayuda");
            d.setVisible(true);
        }
        
        if (arg.equals("Acerca de...")) {
           AboutDlg d = new AboutDlg(appProducto, "Acerca");
           d.setVisible(true);
       }
    }
  }
