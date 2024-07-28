package main.Controller.gestionDeSesionUsuario;

import main.View.gestionDeSesionUsuario.VistaError;
import main.View.gestionDeSesionUsuario.VistaInicioSesion;
import main.View.gestionDeSesionUsuario.VistaRegistro;
import main.View.gestionDeSesionUsuario.VistaDashboard;
import javax.swing.*;
import main.Model.gestionDeSesionUsuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorDeSesion implements ActionListener{

        // instancias de las clases que vista y modelo
        private VistaRegistro vistaRegistro;
        private VistaInicioSesion vistaInicioSesion;
        private VistaDashboard vistaDashboard;
        private VistaError error;
        private Usuario usuario1;

        // constructor deL controlador
        public GestorDeSesion(VistaInicioSesion vistaInicioSesion, VistaRegistro vistaRegistro, VistaDashboard vistaDashboard ) {
           // Inicializacion de las instancias
            this.vistaRegistro = vistaRegistro;
            this.vistaInicioSesion = vistaInicioSesion;
            this.vistaDashboard = vistaDashboard;

            this.vistaRegistro.setControlador((ActionListener) this); // Asigna el controlador a la vista de registro
            this.vistaInicioSesion.setControlador((ActionListener) this); // Asigna el controlador a la vista de inicio de sesión
        }

        // se encarga de desplegar el dashboard que corresponde segun el usuario
        public void seleccionarDashboard(String tipoUsuario) {

            switch (tipoUsuario) {
                case "Administrador":// Despliega el dashboard del usuario Administrador
                    vistaDashboard.mostrarDashboardAdministrador(this);
                    break;

                case "Proponente": // Despliega el dashboard del usuario Proponente
                    vistaDashboard.mostrarDashboardProponente(this);
                    break;

                case "Aliado": // Despliega el dashboard del usuario Aliado
                    vistaDashboard.mostrarDashboardAliado(this);
                    break;

                default:
                    break;
            }
        }


        @Override
        public void actionPerformed( ActionEvent e) {
            String comando = e.getActionCommand();

            switch (comando) {
                case "REGISTRARME":
                    // Retorna los datos que se ingresaron en la interfaz
                    String usuario = vistaRegistro.getUsuario();
                    String clave = vistaRegistro.getClave();
                    String tipoUsuario = vistaRegistro.getTipoUsuario();

                    // Lógica de registro

                    // Crea una instancia de Usuario y registra los datos
                    usuario1 = new Usuario(usuario, clave);
                    usuario1.setTipoUsuario(tipoUsuario);
                    if(usuario1.datosCompletos()){ // Evalua si los datos de usuario y clave estan cmpletos
                        if(usuario1.registrarDatos()){ // si el registro se realiza de forma correcta entonces retorna true
                            seleccionarDashboard(usuario1.getTipoUsuario()); // llama a la funcion que despliega el dashboard que le corresponde al usuario
                            vistaRegistro.limpiarCampos(); // elimina lis datos que quedaron en los campos de registro para cuando se vayan a volver a usar con otro usuario
                            vistaRegistro.setVisible(false); // cierra la ventana de registro
                        }else{
                            // DESPLIEGA la interfaz de error con su repectivo mensaje
                            error = new VistaError("Nombre De usuario ya existente. Por favor, intente de nuevo.");
                        }
                    }else{
                        // DESPLIEGA la interfaz de error con su repectivo mensaje
                         error = new VistaError("Datos incompletos. Por favor, intente de nuevo.");
                    }

                    break;

                case "INICIAR_SESION":
                    // Retorna los datos que se ingresaron en la interfaz
                    String usuarioSesion = vistaInicioSesion.getUsuario();
                    String claveSesion = vistaInicioSesion.getClave();

                    // Lógica de inicio de sesión
                    // Crea una instancia de Usuario y Inicia sesion
                    usuario1 = new Usuario(usuarioSesion, claveSesion);
                    if(usuario1.verificarDatos()){ // valida que los datos esten correctos (completos y que correspondan al usuario)
                        // limpia los datos de los campos de la interfaz de inicio y cierra la ventana
                        vistaInicioSesion.limpiarCampos();
                        vistaInicioSesion.setVisible(false);
                        // selecciona el dashboard correspondiente
                        seleccionarDashboard(usuario1.getTipoUsuario());
                    }else{
                        // DESPLIEGA la interfaz de error con su repectivo mensaje
                        error = new VistaError("Datos incorrectos. Por favor, intente de Nuevo");
                    }
                    break;

                case "IR_A_REGISTRO":
                    // Navegar a la vista de registro desde la vista de Inicio de sesion
                    vistaInicioSesion.setVisible(false);
                    vistaInicioSesion.limpiarCampos();
                    vistaRegistro.setVisible(true);
                    break;

                case "IR_A_INICIO_SESION":
                    // Navegar a la vista de inicio de sesión desde la vista de registro
                    vistaRegistro.setVisible(false);
                    vistaRegistro.limpiarCampos();
                    vistaInicioSesion.setVisible(true);
                    break;

                case "CERRAR_SESION":
                    // Navegar a la vista de inicio de sesion y cierra la vista de dashboard correspondiente
                    usuario1.agregarDatosRegistroDeHora("Fin");
                    vistaDashboard.setVisible(false);
                    vistaInicioSesion.setVisible(true);
                    break;
                case "CARGAR_FORMULACION":
                        // MOSTRAR LA PANTALLA CORRESPONDIENTE
                    vistaDashboard.mostrarMensaje("SELECCIONO Cargar Formulacion"); // SE PUEDE BORRAR CAUNDO SE AGREGE LA ACCION CORRESPONDIENTE
                    break;

                case "VER_CURSOS":
                        // MOSTRAR LA PANTALLA CORRESPONDIENTE
                    vistaDashboard.mostrarMensaje("SELECCIONO Ver Cursos"); // SE PUEDE BORRAR CAUNDO SE AGREGE LA ACCION CORRESPONDIENTE
                    break;

                case "VER_EXPEDIENTE":
                        // MOSTRAR LA PANTALLA CORRESPONDIENTE
                    vistaDashboard.mostrarMensaje("SELECCIONO Ver Expediente"); // SE PUEDE BORRAR CAUNDO SE AGREGE LA ACCION CORRESPONDIENTE
                    break;
                case "REGISTRAR_RECUADOS":
                        // MOSTRAR LA PANTALLA CORRESPONDIENTE
                    vistaDashboard.mostrarMensaje("SELECCIONO Registrar Recaudos"); // SE PUEDE BORRAR CAUNDO SE AGREGE LA ACCION CORRESPONDIENTE
                    break;

                case "VER_PROPUESTAS":
                        // MOSTRAR LA PANTALLA CORRESPONDIENTE
                    vistaDashboard.mostrarMensaje("SELECCIONO Ver Propustas"); // SE PUEDE BORRAR CAUNDO SE AGREGE LA ACCION CORRESPONDIENTE
                    break;
                default:
                    break;
            }
        }


}



