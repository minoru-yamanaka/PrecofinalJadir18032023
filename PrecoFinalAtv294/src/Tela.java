import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPreoFinalDa;
	private JTextField txtValor;
	private JTextField txtResultado;
	private JRadioButton btnDinheiro;
	private final ButtonGroup btnTipo = new ButtonGroup();
	private JRadioButton btnCartao;
	private JRadioButton btnCheque;
	private JButton btnCalcular;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setTitle("Preço Final");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Entre com o valor da venda ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(21, 10, 175, 13);
		contentPane.add(lblNewLabel);
		
		lblPreoFinalDa = new JLabel("Preço final da compra");
		lblPreoFinalDa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPreoFinalDa.setBounds(21, 59, 175, 13);
		contentPane.add(lblPreoFinalDa);
		
		txtValor = new JTextField();
		txtValor.setBounds(206, 8, 96, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtResultado = new JTextField();
		txtResultado.setColumns(10);
		txtResultado.setBounds(206, 57, 96, 19);
		contentPane.add(txtResultado);
		
		btnDinheiro = new JRadioButton("Dinheiro");
		btnTipo.add(btnDinheiro);
		btnDinheiro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDinheiro.setBounds(46, 32, 86, 21);
		contentPane.add(btnDinheiro);
		
		btnCartao = new JRadioButton("Cartão");
		btnCartao.setHorizontalAlignment(SwingConstants.TRAILING);
		btnCartao.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCartao.setBounds(134, 32, 80, 21);
		contentPane.add(btnCartao);
		
		btnCheque = new JRadioButton("Cheque");
		btnCheque.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCheque.setBounds(226, 33, 103, 21);
		contentPane.add(btnCheque);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				double v1, r = 0;
				v1 = Double.parseDouble(txtValor.getText());
				//v1 = Double.parseDouble(txtValor.getText());
				
				//RadioButton
				if(btnDinheiro.isSelected()) {
					r =((v1*5/100)-v1)* -1;//(v1-5);//-5%
					
				}
				else if(btnCartao.isSelected()) {
					r = (v1*10/100)+v1;//+10%
				}	
				else if(btnCheque.isSelected()) {
					r = (v1*5/100)+v1; //+5%
				}
				
				//r = Double.parseDouble(txtValor.getText().replaceAll(".", ",") );
			
				String.valueOf(r);
				//txtResultado.setText("R$ " + r );
				txtResultado.setText(String.format("R$" + "%.2f",r));
				
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCalcular.setBounds(46, 95, 85, 21);
		contentPane.add(btnCalcular);
		
		btnLimpar = new JButton("Limpar");
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtValor.setText(null);
				txtResultado.setText(null);
					
				//RadioButton
				if(btnDinheiro.isSelected( )) {
					btnDinheiro.setSelected( false);
				}
				else if(btnCartao.isSelected()) {
					btnCartao.setSelected(false);
				}	
				else if(btnCheque.isSelected()) {
					btnCheque.setSelected(false);
				}
			
			}
		});
		
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLimpar.setBounds(141, 95, 85, 21);
		contentPane.add(btnLimpar);
	}
}
