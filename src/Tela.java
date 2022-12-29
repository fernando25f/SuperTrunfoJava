import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;


@SuppressWarnings("serial")
public class Tela extends JFrame {
	
	private int qJogadores;
	private int qAtributos;
	private final int WIDTH = 1000;
	private final int HEIGHT = 600;
	private final int WIDTH_CARTA = 250;
	private final int HEIGHT_CARTA = 350;
	private int rodada = 0;
	private JButton comparar = new JButton();
	private JButton continuar = new JButton();
	private JComboBox<String> escolherAtributo = new JComboBox<String>();
	private JPanel[] cartas;
	private JLabel[] label;
	private JLabel titulo;
	private JLabel round;
	private JLabel[] atributos;
	
	public Tela() {
		qJogadores = Jogo.getJogadores().length;
		qAtributos = Carta.getAtributos().size();
		cartas = new JPanel[qJogadores];
		label = new JLabel[3];
		atributos = new JLabel[qAtributos];
		setTitle("Supertrunfo");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		carregarCartas();
		
		for (int i = 0; i < qAtributos; i++) 
			escolherAtributo.addItem(Carta.getAtributos().get(i));
		
		titulo = new JLabel("SUPERTRUNFO - " + Baralho.getTema());
		titulo.setBounds(WIDTH/2 - 90, 20, 180,30);
		add(titulo);
		round = new JLabel("Rodada: " + rodada);
		round.setBounds(WIDTH/2 - 50, 70 + HEIGHT_CARTA, 100,30);
		add(round);
		escolherAtributo.setBounds(WIDTH/2-320,HEIGHT-90,120,30);
		add(escolherAtributo);
		comparar.setText("COMPARAR");
		comparar.setBounds(WIDTH/2-160,HEIGHT-100,150,50);
		add(comparar);
		comparar.addActionListener(this::comparar); 
		continuar.setText("CONTINUAR");
		continuar.setBounds(WIDTH/2+10,HEIGHT-100,150,50);
		add(continuar);
		continuar.addActionListener(this::continuar);
		setVisible(true);
	}
	
	public void carregarCartas(int num) {
		for (int i = 0; i < qJogadores; i++) {
			cartas[i] = new JPanel();
			cartas[i].setBounds(WIDTH/2 - WIDTH_CARTA*qJogadores/2 - WIDTH_CARTA*5/100*qJogadores + WIDTH_CARTA * i + WIDTH_CARTA*5/100*i,50, WIDTH_CARTA, HEIGHT_CARTA);
			cartas[i].setBackground(new Color(139,100,180));
			cartas[i].setLayout(null);
			label[0] = new JLabel("Jogador " + (i+1));
			label[0].setBounds(WIDTH_CARTA/2 - label[0].getText().length()*4, 0 , label[0].getText().length()*8,30);
			if(Jogo.getJogadordavez() == i) {
				label[0].setForeground(new Color(255,180,255));
			}
			label[1] = new JLabel(Jogo.getJogadores()[i].getMonte().pegarTopo().getCodigo() + " - " + Jogo.getJogadores()[i].getMonte().pegarTopo().getNome());
			label[1].setBounds(10,70,200,30);
			label[2] = new JLabel(Jogo.getJogadores()[i].getMonte().pegarTopo().getExtra());
			label[2].setBounds(10,85,200,30);
			for (int j = 0; j < 3; j++) 
				cartas[i].add(label[j]);
			for (int j = 0; j < qAtributos; j++) {
				String texto = Carta.getAtributos().get(j) + ": " +
				Jogo.getJogadores()[i].getMonte().pegarTopo().getValor().getValor().get(j) + " " +
				Carta.getUnidade().get(j);
				atributos[j] = new JLabel(texto);
				atributos[j].setBounds(10,HEIGHT_CARTA - 100 - 15*qAtributos + 15 * j, 200, 30);
				if (num == j) {
					atributos[j].setForeground(new Color(255,255,255));
				}
				cartas[i].add(atributos[j]);
			}
			
			JLabel restantes = new JLabel();
			restantes.setText("Cartas restantes: " + Jogo.getJogadores()[i].getMonte().size());
			restantes.getText().length();
			restantes.setBounds(WIDTH_CARTA/2 - restantes.getText().length()*3, HEIGHT_CARTA - 30, restantes.getText().length()*6,30);
			cartas[i].add(restantes);
			add(cartas[i]);
		}
	}
	
	public void carregarCartas() {
		for (int i = 0; i < qJogadores; i++) {
			cartas[i] = new JPanel();
			cartas[i].setBounds(WIDTH/2 - WIDTH_CARTA*qJogadores/2 - WIDTH_CARTA*5/100*qJogadores + WIDTH_CARTA * i + WIDTH_CARTA*5/100*i,50, WIDTH_CARTA, HEIGHT_CARTA);
			cartas[i].setBackground(new Color(139,100,180));
			cartas[i].setLayout(null);
			if (i == Jogo.getJogadordavez()) {
				label[0] = new JLabel("Jogador " + (i+1));
				label[0].setBounds(WIDTH_CARTA/2 - label[0].getText().length()*4, 0 , label[0].getText().length()*8,30);
				label[1] = new JLabel(Jogo.getJogadores()[i].getMonte().pegarTopo().getCodigo() + " - " + Jogo.getJogadores()[i].getMonte().pegarTopo().getNome());
				label[1].setBounds(10,70,200,30);
				label[2] = new JLabel(Jogo.getJogadores()[i].getMonte().pegarTopo().getExtra());
				label[2].setBounds(10,85,200,30);
				for (int j = 0; j < 3; j++) 
					cartas[i].add(label[j]);
				for (int j = 0; j < qAtributos; j++) {
					String texto = Carta.getAtributos().get(j) + ": " +
					Jogo.getJogadores()[i].getMonte().pegarTopo().getValor().getValor().get(j) + " " +
					Carta.getUnidade().get(j);
					atributos[j] = new JLabel(texto);
					atributos[j].setBounds(10,HEIGHT_CARTA - 100 - 15*qAtributos + 15 * j, 200, 30);
					cartas[i].add(atributos[j]);
				}
			}
			JLabel restantes = new JLabel();
			restantes.setText("Cartas restantes: " + Jogo.getJogadores()[i].getMonte().size());
			restantes.getText().length();
			restantes.setBounds(WIDTH_CARTA/2 - restantes.getText().length()*3, HEIGHT_CARTA - 30, restantes.getText().length()*6,30);
			cartas[i].add(restantes);
			add(cartas[i]);
		}
	}
	private void iterar() {
		if (Jogo.getJogadores()[Jogo.getJogadordavez()] instanceof JogadorReal) {
			int num = escolherAtributo.getSelectedIndex();
			int vencedor = Jogo.comparar(num);
			carregarCartas(num);
			repaint();
			Jogo.passarCarta(vencedor);
		}
		else {
			Random gerador = new Random();
			int num = gerador.nextInt(Carta.getAtributos().size());
			int vencedor = Jogo.comparar(num);
			carregarCartas(num);
			repaint();
			Jogo.passarCarta(vencedor);
		}
	}

	private void comparar(ActionEvent actionEvent) {
		rodada++;
		for (int i = 0; i < qJogadores; i++) {
			cartas[i].setVisible(false);
		}
		round.setVisible(false);
		repaint();
		round = new JLabel("Rodada: " + (rodada));
		round.setBounds(WIDTH/2 - 50, 70 + HEIGHT_CARTA, 100,30);
		add(round);
		if (Jogo.identificarTrunfo() == false) {
			iterar();
		}
		else {
			if(Jogo.identificarCartaA() == true)
				iterar();
			else {
				int num = Jogo.procurarTrunfo();
				Jogo.setJogadordavez(num);
				carregarCartas(num);
				repaint();
				Jogo.passarCarta(num);
			}
		}
	}
	private void continuar(ActionEvent actionEvent) {
		if (Jogo.ganhador() == false) {
			for (int i = 0; i < qJogadores; i++) {
				cartas[i].setVisible(false);
			}
			repaint();
			carregarCartas();
			repaint();
		}
		else {
			JOptionPane.showMessageDialog(null,"O vencedor da partida foi o Jogador " + (Jogo.getJogadordavez()+1));
			dispose();
		}
	}
}
