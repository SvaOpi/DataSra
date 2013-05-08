package fachada;

import entidad.Usuario;
import servicio.UsuarioServicio;

public class UsuarioFachada extends Fachada {

    private UsuarioServicio usuarioServicio;

    public UsuarioFachada() {
        usuarioServicio = new UsuarioServicio();
    }

    public String crearUsuario(Usuario vo) {
        String resultado = "";
        try {
            abrirConexion();
            if (usuarioServicio.buscarUsuarioPorCorreo(vo.getCorreo(), em) != null) {
                resultado = "Correo ya registrado";
            } else {
                usuarioServicio.crearUsuario(vo, em);
                resultado = "Creado";
                et.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            hacerRollback();
            resultado = "Error";
        } finally {
            cerrarConexion();
            return resultado;
        }

    }

    public Usuario buscarUsuarioPorCorreo(String correo) {
        Usuario usuarioVO = null;
        try {
            abrirConexion();
            usuarioVO = usuarioServicio.buscarUsuarioPorCorreo(correo, em);
            et.commit();
        } catch (Exception e) {
            hacerRollback();
        } finally {
            cerrarConexion();
            return usuarioVO;
        }
    }

    public Usuario buscarUsuarioPorCedula(Long cedula) {
        Usuario usuarioVO = null;
        try {
            abrirConexion();
            usuarioVO = usuarioServicio.buscarUsuarioPorCedula(cedula, em);
            et.commit();
        } catch (Exception e) {
            hacerRollback();
        } finally {
            cerrarConexion();
            return usuarioVO;
        }
    }
    public String actualizarUsuario(Usuario vo) {
        String resultado = "";
        try {
            abrirConexion();
            if (usuarioServicio.buscarUsuarioPorCorreo(vo.getCorreo(), em) == null) {
                resultado = "Usuario no encontrado";
            } else {
                usuarioServicio.actualizarUsuario(vo, em);
                et.commit();
                resultado = "Actualizado";
            }
        } catch (Exception e) {
            hacerRollback();
            resultado = "Error";
        } finally {
            cerrarConexion();
            return resultado;
        }
    }

    public String eliminarUsuario(String correo) {
        String resultado = "";
        try {
            abrirConexion();
            Usuario usuarioVO = usuarioServicio.buscarUsuarioPorCorreo(correo, em);
            if (usuarioVO == null) {
                resultado = "Usuario no encontrado";
            } else {
                usuarioServicio.eliminarUsuario(usuarioVO, em);
                et.commit();
                resultado = "Eliminado";
            }
        } catch (Exception e) {
            hacerRollback();
            resultado = "Error";
        } finally {
            cerrarConexion();
            return resultado;
        }
    }
}