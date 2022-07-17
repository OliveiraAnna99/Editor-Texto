import javax.swing.*;
import javafx.scene.control.MenuItem;
import javax.swing.JScrollPane;
import java.io.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class EditorTexto extends JFrame
{
    /*
     construir editor de texto completo que pega o texto e cria um arquivo com ele
     alem de implementar as funções de copiar, colar, detre outras coisas que um
     editor convencional faz
    */
    private JMenuBar barra;
    private JMenu menuArquivo;
    private JMenu menuEditar;
    private JMenuItem itemNovo;
    private JMenuItem itemAbrir;
    private JMenuItem itemSalvar;
    private JMenuItem itemRecortar;
    private JMenuItem itemCopiar;
    private JMenuItem itemColar;
    private JMenuItem itemSubstituirTudo;
    private JMenuItem itemLocalizar;
    private JTextArea editor;
    private JScrollPane scroll;
    
    public EditorTexto(){
        
        barra = new JMenuBar();
        menuArquivo = new JMenu("Arquivo");
        menuEditar = new JMenu("Editar");
        itemNovo = new JMenuItem("Novo");
        itemAbrir = new JMenuItem("Abrir");
        itemSalvar = new JMenuItem("Salvar");
        itemRecortar = new JMenuItem("Recortar");
        itemCopiar = new JMenuItem("Copiar");
        itemColar = new JMenuItem("Colar");
        itemSubstituirTudo = new JMenuItem("Substituir Tudo");
        itemLocalizar = new JMenuItem("Localizar");
        editor = new JTextArea();
        editor.setEditable(true);
        editor.setLineWrap(true);
        scroll = new JScrollPane(editor);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        menuArquivo.add(itemNovo);
        menuArquivo.add(itemAbrir);
        menuArquivo.add(itemSalvar);
        menuEditar.add(itemRecortar);
        menuEditar.add(itemCopiar);
        menuEditar.add(itemColar);
        menuEditar.add(itemSubstituirTudo);
        menuEditar.add(itemLocalizar);
        barra.add(menuArquivo);
        barra.add(menuEditar);
        
        itemCopiar.addActionListener(
          new ActionListener(){
             public void actionPerformed(ActionEvent e){
               copiar();
             }
          }
        );
        itemRecortar.addActionListener(
          new ActionListener(){
             public void actionPerformed(ActionEvent e){
               recortar();
             }
          }
        );
        itemColar.addActionListener(
          new ActionListener(){
             public void actionPerformed(ActionEvent e){
               colar();
             }
          }
        );
    
        itemSubstituirTudo.addActionListener(
          new ActionListener(){
             public void actionPerformed(ActionEvent e){
               substituirTudo();
             }
          }
        );
        itemLocalizar.addActionListener(
          new ActionListener(){
             public void actionPerformed(ActionEvent e){
               localizar();
             }
          }
        );
        super.setJMenuBar(barra);
        super.getContentPane().add(scroll);  
        
    }
    
  
    public void copiar(){
        editor.copy();
        JOptionPane.showMessageDialog(null, 
            "Copiado");
    }
    public void recortar(){
        editor.cut();
        JOptionPane.showMessageDialog(null, 
            "Recortado");
    }
    public void colar(){
        editor.paste();
        JOptionPane.showMessageDialog(null, 
            "Colado");
    }
    
    public void substituirTudo(){
      JPanel tSubs = new JPanel(new GridLayout(3, 4));
      tSubs.setSize(400, 200);
      JTextField nome = new JTextField(10);
      JTextField sNome = new JTextField(10);
      tSubs.add(nome);
      tSubs.add(sNome);
    
      JOptionPane.showMessageDialog(null, tSubs);
    
      String text = editor.getText();
      //System.out.printf("Text: %s", text);
      if(text.contains(nome.getText())){
          nome.cut();
          editor.setText(text.replaceAll(nome.getText(), sNome.getText()));
      }else{
          JOptionPane.showMessageDialog(null, ("Não é possivel encontrar " + '"'+nome.getText()+'"'));
           
      }
   
    }
    
    public void localizar(){
      JPanel tLoc = new JPanel(new GridLayout(3, 4));
      tLoc.setSize(400, 200);
      JTextField nomeL = new JTextField(10);
      tLoc.add(nomeL);
      JOptionPane.showMessageDialog(null, tLoc);
      UIManager.put("MessagePane.okButtonText", "Localizar");
      String text = editor.getText();
      //System.out.printf("Text: %s", text);
      if(text.contains(nomeL.getText())){
          nomeL.selectAll();
      }else{
          JOptionPane.showMessageDialog(null, ("Não é possivel encontrar " + '"'+nomeL.getText()+'"'));
           UIManager.put("MessagePane.okButtonText", "OK");
      }
     
    }
    /*public String getTexto(){
        String texto = editor.getText();
        return texto;
    }
    public void createFile(){
        try{
            FileOutputStream fos = new FileOutputStream("meu texto.txt");
            PrintStream ps = new PrintStream(fos);
            ps.println(getTexto());
            
        }catch(Exception e){
            System.out.printf("Error");
        }
    }*/
  
}
