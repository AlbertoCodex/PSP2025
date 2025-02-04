package org.example;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class Main {
    private FTPClient clienteFTP;
    private static final String SERVIDOR="localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "Alberto";
    private static final String PASSWORD = "1234";
    private static final String DOWNLOAD_DIR = "C:\\Users\\Alberto\\Desktop\\descargasFilezilla\\";
    private static final String FICHERO_TXT = "C:\\Users\\Alberto\\Desktop\\fichero.txt";

    public Main() {
        clienteFTP = new FTPClient();
    }

    private void conectar() throws IOException {
        clienteFTP.connect(SERVIDOR, PUERTO);
        int respuesta = clienteFTP.getReplyCode();
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");
        }
        boolean credencialesOK = clienteFTP.login(USUARIO, PASSWORD);
        if (!credencialesOK) {
            throw new IOException("Error al conectar con el servidor FTP. credenciales incorrectar");
        }
        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
        clienteFTP.enterLocalPassiveMode();
    }
    private void desconectar() throws IOException {
        clienteFTP.disconnect();
    }

    private boolean subirFichero(String path) throws IOException {
        File ficherolocal = new File(path);
        if (!ficherolocal.exists()) {
            System.err.println("El fichero no existe: " + path);
            return false;
        }

        InputStream is = new FileInputStream(ficherolocal);
        boolean enviado = clienteFTP.storeFile(ficherolocal.getName(), is);
        is.close();
        return enviado;
    }

    private boolean descargarFichero(String ficheroRemoto, String pathLocal) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(pathLocal));
        boolean recibido = clienteFTP.retrieveFile(ficheroRemoto, os);
        os.close();
        return recibido;
    }

    private void descargarTodo() throws IOException {
        FTPFile[] files = clienteFTP.listFiles();

        if (files.length == 0) {
            System.out.println("No hay archivos en el servidor FTP.");
        } else {
            System.out.println("Descargando archivos...");
            for (FTPFile file : files) {
                if (file.isFile()) {
                    String remoteFile = file.getName();
                    String localFile = DOWNLOAD_DIR + remoteFile;

                    try (FileOutputStream outputStream = new FileOutputStream(localFile)) {
                        boolean success = clienteFTP.retrieveFile(remoteFile, outputStream);
                        if (success) {
                            System.out.println("Descargado: " + remoteFile);
                        } else {
                            System.out.println("Error al descargar: " + remoteFile);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main gestorFTP = new Main();
        try {
            gestorFTP.conectar();
            System.out.println("conectado");
            System.out.println("Subiendo fichero de prueba || Si ya está subido da error");
        /*
            boolean subido = gestorFTP.subirFichero(FICHERO_TXT);
            if (subido) {
                System.out.println("Fichero subido a Filezilla correctamente");
            } else {
                System.err.println("Ha ocurrido un error al intentar subir el fichero");
            }
        */
            gestorFTP.descargarTodo();
            gestorFTP.desconectar();
            System.out.println("Desconectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}