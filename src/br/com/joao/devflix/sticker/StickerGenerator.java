package br.com.joao.devflix.sticker;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickerGenerator extends Exception {

    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {

        // leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        // -> Teste para ver se o inputStram funcionava nesse caso
        // InputStream inputStream =
        // new
        // URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg")
        // .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream); // Para o imageIo não importa qual o formato original
                                                                  // desse inputStream pois ele vai pegar em bytes
        // cria nova imagem em memoria com transparencia e com novo tamanho
        int widht = imagemOriginal.getWidth();
        int height = imagemOriginal.getHeight();
        int newHeight = height + 200;
        BufferedImage novaImagem = new BufferedImage(widht, newHeight, BufferedImage.TRANSLUCENT);
        // copiar a imagem original em memoria para a nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        // configurar fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        String text = "TOPZERA";
        var center = widht /2 - (text.length() * 20);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);
        // escrever uma frase em uma nova imagem
        graphics.drawString(text, center , newHeight - 100);
        // escrever a nova imagem em um arquivo
        File dir = new File("StickersReady");
        dir.mkdir();
        ImageIO.write(novaImagem, "png", new File(dir, nomeArquivo));
    }

    // public static void main(String[] args) throws IOException {
    // var generator = new StickerGenerator();
    // generator.cria();
    // System.out.println(generator);
    // }

}
