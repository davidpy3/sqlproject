/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Maurinho
 */
import java.sql.*;
public class MtoUsuarios {
    Connection cn;
    int codigo;
    String nombre;
    String apellido;
    String usuario;
    String contraseña;
    
    public MtoUsuarios()
    {
        Conexion con = new Conexion();
        cn = con.conectar();
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public boolean guardarUsuario()
    {
        boolean resp = false;
        try
        {
            String sql = "INSERT INTO tbusuarios(nombre, apellido, usuario, contraseña) VALUES(?, ?, ?, ?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, nombre);
            cmd.setString(2, apellido);
            cmd.setString(3, usuario);
            cmd.setString(4, contraseña);
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
    
    public boolean consultarUsuario()
    {
        boolean resp = false;
        try
        {
            String sql = "SELECT id_cargo,nombres,ap_paterno,ap_materno,nomb_comp FROM personal WHERE codigo = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, codigo);
            ResultSet rs = cmd.executeQuery();
            if(rs.next())
            {
                resp = true;
                codigo = rs.getInt(1);
                nombre = rs.getString(2);
                apellido = rs.getString(3);
                usuario = rs.getString(4);
                contraseña = rs.getString(5);
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
    public boolean eliminarUsuario()
    {
        boolean resp = false;
        try
        {
            String sql = "DELETE FROM tbusuarios WHERE codigo = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, codigo);
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
    public boolean modificarUsuario()
    {
        boolean resp = false;
        try
        {
            String sql = "UPDATE tbusuarios SET nombre = ?, apellido = ?, "
                    + "usuario = ?, contraseña = ? WHERE codigo = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1, nombre);
            cmd.setString(2, apellido);
            cmd.setString(3, usuario);
            cmd.setString(4, contraseña);
            cmd.setInt(5, codigo);
            if(!cmd.execute())
            {
                resp = true;
            }
            cmd.close();
            cn.close();
        }
        catch(Exception ex)
        {
          System.out.println("Error: " + ex.getMessage());
        }
        return resp;
    }
}
