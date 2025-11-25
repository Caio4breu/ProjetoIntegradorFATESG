package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsuarioAdm {
    private static String ARQUIVO = "usuairos.txt";
    
    // Registrando: Nome, User, Email e Senha
    public static boolean registrarUsuario(String nome, String usuario, String email, String senha) throws IOException {
        
        FileWriter fw = new FileWriter(ARQUIVO, true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        // Salva: Nome;Usuario;Email;Senha
        bw.write(nome + ";" + usuario + ";" + email + ";" + senha);
        bw.newLine();
        bw.close();
        return true;
    }
    
    // Validação de Login
    public static boolean validarLogin(String usuarioDigitado, String senhaDigitada) throws IOException {
        File file = new File(ARQUIVO);
        if(!file.exists()) return false;
        
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha;
        
        while((linha = br.readLine()) != null) {
            String[] partes = linha.split(";");
            
            // Agora temos 4 partes: 0=Nome, 1=Usuario, 2=Email, 3=Senha
            if (partes.length >= 4) {
                String usuarioNoArquivo = partes[1]; // O usuário está na posição 1
                String senhaNoArquivo = partes[3];   // A senha está na posição 3
                
                if (usuarioNoArquivo.equalsIgnoreCase(usuarioDigitado) && senhaNoArquivo.equals(senhaDigitada)) {
                    br.close();
                    return true;
                }
            }
        }
        return false;
    }
}
