package dominio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vitória
 */
public class DaoUsuario {
    
    public static Connection conexao(){
        // Informações de conexão
        String url = "jdbc:mysql://localhost:3306/trabalho_mod?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "root";
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
    
    public void inserir(String nome, String email, String telefone, String cpf)  throws ClassNotFoundException {
    String query = "INSERT INTO usuarios (nome, email, telefone, cpf) VALUES('" 
            + nome + "','" + email + "','" + telefone + "','" + cpf + "')";
    try {
            Connection connection = conexao();
            PreparedStatement include = connection.prepareStatement(query);
            System.out.println(nome);
            //Executa a query
            include.execute();
        } catch (SQLException e){
            System.out.println("Não foi possível acessar o banco de dados" + e);
        }
    }
    
    public static List<Usuario> consultar()  throws ClassNotFoundException {
    String query = "SELECT * FROM usuarios";
    ResultSet resultSet = null;
    List<Usuario> lu = new ArrayList<Usuario>();
    try {
            Connection connection = conexao();
            PreparedStatement consulte = connection.prepareStatement(query);
            //Executa a query
            resultSet = consulte.executeQuery();
            while (resultSet.next()){
                Usuario usu = new Usuario();
                usu.setNome(resultSet.getString("nome"));
                usu.setEmail(resultSet.getString("email"));
                usu.setTelefone(resultSet.getString("telefone"));
                usu.setCpf(resultSet.getString("cpf"));
                lu.add(usu);
            }
            
        } catch (SQLException e){
            System.out.println("Não foi possível acessar o banco de dados" + e);
        }
    return lu;
    }
    
    public static void excluir(String cpf) throws ClassNotFoundException {
        String query = "DELETE FROM usuarios WHERE cpf = '" + cpf + "'";
        try{
            Connection connection = conexao();
            PreparedStatement delete = connection.prepareStatement(query);
            delete.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Usuario selecionarPorCpf(String cpf){
        Usuario usu = null;
        String query = "SELECT * FROM usuarios WHERE cpf = '" + cpf + "'";
        try{
            Connection connection = conexao();
            PreparedStatement seleciona = connection.prepareStatement(query);
            ResultSet result = seleciona.executeQuery();
            while (result.next()){
                usu = new Usuario();
                usu.setNome(result.getString("nome"));
                usu.setEmail(result.getString("email"));
                usu.setTelefone(result.getString("telefone"));
                usu.setCpf(result.getString("cpf"));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return usu;
    }
    
    public static void atualizar(Usuario u){
        String query = "UPDATE usuarios SET nome = ?, email = ?, telefone = ? WHERE cpf=?";
        //int status = 0;
        try{
            Connection connection = conexao();
            PreparedStatement atualiza = connection.prepareStatement(query);
            atualiza.setString(1, u.getNome());
            atualiza.setString(2, u.getEmail());
            atualiza.setString(3, u.getTelefone());
            atualiza.setString(4, u.getCpf());
            atualiza.executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
        //return status;
    }
}
