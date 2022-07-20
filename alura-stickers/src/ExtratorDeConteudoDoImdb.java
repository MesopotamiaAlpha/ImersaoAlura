import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImdb implements ExtratorDeConteudo{
    
    public List<Conteudo> extraiConteudos(String json) {
        // extrair somente os dados que interessam (titulo,poster,classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();

        //popular lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;

    }

}