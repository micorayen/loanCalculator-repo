import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class frm_loanCalculator {

	private JFrame frame;
	private static JTextField txt1, txt2, txt3;
	private static JButton btn1, btn2;
	private static JLabel lbl_loanAmount,lbl_annualInterest,lbl_mPayment,lbl_loanPeriod,lbl_installmentsNumber;
	private static JLabel lbl_totalInterest,lbl_totalPrincipal,lbl_totalRepayment,lbl_interestOverCapital;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_loanCalculator window = new frm_loanCalculator();
					window.frame.setVisible(true);
					txt1.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frm_loanCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Loan Calculator");
		frame.getContentPane().setBackground(SystemColor.window);
		frame.setBounds(100, 100, 495, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl2 = new JLabel("Enter relevant information:");
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lbl2.setBounds(191, 15, 150, 14);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Loan amount: Php");
		lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lbl3.setBounds(232, 45, 99, 14);
		frame.getContentPane().add(lbl3);
		
		txt1 = new JTextField();
		txt1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if ((((e.getKeyChar() >= 48) && (e.getKeyChar() <= 57)) || ((e.getKeyChar() == 46)|| ((e.getKeyChar() == 8) || (e.getKeyCode() == KeyEvent.VK_ENTER) || (e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_RIGHT))))) {
				    String a = txt1.getText().trim();
				    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				    	if(a.equals("") || a.equals(".")) {
				    		JOptionPane.showMessageDialog(frame, "enter loan amount first!", "Message", JOptionPane.ERROR_MESSAGE);
				    		txt2.enable(false);
				    		txt1.requestFocus();
				    	}
				    	else {
				    		txt2.enable(true);
				    		txt2.requestFocus();		
				    	}
				    }
				}
				else {
					e.setKeyCode(KeyEvent.VK_BACK_SPACE);
					JOptionPane.showMessageDialog(frame, "Please enter valid number", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		txt1.setHorizontalAlignment(SwingConstants.RIGHT);
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txt1.setColumns(10);
		txt1.setBounds(333, 43, 102, 18);
		frame.getContentPane().add(txt1);
		
		JLabel lbl4 = new JLabel("Annual interest rate");
		lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lbl4.setBounds(232, 65, 99, 14);
		frame.getContentPane().add(lbl4);
		
		txt2 = new JTextField();
		txt2.setEnabled(false);
		txt2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if ((((e.getKeyChar() >= 48) && (e.getKeyChar() <= 57)) || ((e.getKeyChar() == 46)|| ((e.getKeyChar() == 8) || (e.getKeyCode() == KeyEvent.VK_ENTER) || (e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_RIGHT))))) {
				    String a = txt2.getText().trim();
				    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				    	if(a.equals("") || a.equals(".")) {
				    		JOptionPane.showMessageDialog(frame, "enter annual interest rate, first!", "Message", JOptionPane.ERROR_MESSAGE);
				    		txt3.enable(false);
				    		txt2.requestFocus();
				    	}
				    	else {
				    		txt3.enable(true);
				    		txt3.requestFocus();		
				    	}
				    }
				}
				else {
					e.setKeyCode(KeyEvent.VK_BACK_SPACE);
					JOptionPane.showMessageDialog(frame, "Please enter valid number", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}); 
		txt2.setHorizontalAlignment(SwingConstants.RIGHT);
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txt2.setColumns(10);
		txt2.setBounds(333, 62, 102, 18);
		frame.getContentPane().add(txt2);
		
		JLabel lbl5 = new JLabel("%");
		lbl5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lbl5.setBounds(438, 65, 40, 14);
		frame.getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel("Monthly payment");
		lbl6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lbl6.setBounds(232, 85, 99, 14);
		frame.getContentPane().add(lbl6);
		
		JLabel lbl7 = new JLabel("Loan period");
		lbl7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lbl7.setBounds(232, 105, 99, 14);
		frame.getContentPane().add(lbl7);
		
		txt3 = new JTextField();
		txt3.setEnabled(false);
		txt3.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if ((((e.getKeyChar() >= 48) && (e.getKeyChar() <= 57)) || ((e.getKeyChar() == 46)|| ((e.getKeyChar() == 8) || (e.getKeyCode() == KeyEvent.VK_ENTER) || (e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_RIGHT))))) {
				    String a = txt3.getText().trim();
				    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				    	if(a.equals("") || a.equals(".")) {
				    		JOptionPane.showMessageDialog(frame, "enter loan period first!", "Message", JOptionPane.ERROR_MESSAGE);
				    		btn1.setEnabled(false);
				    		txt3.requestFocus();
				    	}
				    	else {
				    		btn1.setEnabled(true);
				    		btn1.requestFocus();		
				    	}
				    }
				}
				else {
					e.setKeyCode(KeyEvent.VK_BACK_SPACE);
					JOptionPane.showMessageDialog(frame, "Please enter valid number", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		}); 
		txt3.setHorizontalAlignment(SwingConstants.RIGHT);
		txt3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txt3.setColumns(10);
		txt3.setBounds(333, 103, 102, 18);
		frame.getContentPane().add(txt3);
		
		JLabel lbl8 = new JLabel("years");
		lbl8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		lbl8.setBounds(438, 105, 40, 14);
		frame.getContentPane().add(lbl8);
		
		JLabel lbl1 = new JLabel("Action:");
		lbl1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lbl1.setBounds(20, 15, 50, 14);
		frame.getContentPane().add(lbl1);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Calculate?", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		buttonPanel.setBounds(15, 40, 142, 83);
		frame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		// button "Monthly Payment"
		btn1 = new JButton("Monthly Payment");
		btn1.setEnabled(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateResult();
			}
		});
		btn1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					calculateResult();
				}
			}
		}); 
		btn1.setBackground(new Color(203, 208, 246));
		btn1.setBounds(6, 16, 130, 28);
		buttonPanel.add(btn1);
		btn1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		// button "Clear"
		btn2 = new JButton("Clear");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearLoanCalculator();
			}
		});
		btn2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					clearLoanCalculator();
				}
			}
		}); 
		btn2.setBackground(new Color(203, 208, 246));
		btn2.setBounds(6, 47, 130, 28);
		buttonPanel.add(btn2);
		btn2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JPanel loanReportPanel = new JPanel();
		loanReportPanel.setBackground(SystemColor.inactiveCaptionBorder);
		loanReportPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		loanReportPanel.setBounds(9, 140, 459, 257);
		frame.getContentPane().add(loanReportPanel);
		loanReportPanel.setLayout(null);
		
		JLabel lbl9 = new JLabel("Loan Report:");
		lbl9.setBounds(6, 16, 99, 15);
		loanReportPanel.add(lbl9);
		lbl9.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl10 = new JLabel("Loan amount");
		lbl10.setBounds(44, 43, 120, 14);
		loanReportPanel.add(lbl10);
		lbl10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		
		JLabel lbl11 = new JLabel("Annual interest rate");
		lbl11.setBounds(44, 63, 120, 14);
		loanReportPanel.add(lbl11);
		lbl11.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		
		JLabel lbl12 = new JLabel("Monthly payment");
		lbl12.setBounds(44, 83, 120, 14);
		loanReportPanel.add(lbl12);
		lbl12.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		
		JLabel lbl13 = new JLabel("Loan period (years)");
		lbl13.setBounds(44, 103, 120, 14);
		loanReportPanel.add(lbl13);
		lbl13.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		
		JLabel lbl14 = new JLabel("Number of installments");
		lbl14.setBounds(44, 123, 120, 14);
		loanReportPanel.add(lbl14);
		lbl14.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		
		lbl_loanAmount = new JLabel("-");
		lbl_loanAmount.setBounds(306, 43, 120, 14);
		loanReportPanel.add(lbl_loanAmount);
		lbl_loanAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_loanAmount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_annualInterest = new JLabel("-");
		lbl_annualInterest.setBounds(306, 63, 120, 14);
		loanReportPanel.add(lbl_annualInterest);
		lbl_annualInterest.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_annualInterest.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_mPayment = new JLabel("-");
		lbl_mPayment.setBounds(306, 83, 120, 14);
		loanReportPanel.add(lbl_mPayment);
		lbl_mPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lbl_loanPeriod = new JLabel("-");
		lbl_loanPeriod.setBounds(306, 103, 120, 14);
		loanReportPanel.add(lbl_loanPeriod);
		lbl_loanPeriod.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_loanPeriod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_installmentsNumber = new JLabel("-");
		lbl_installmentsNumber.setBounds(306, 123, 120, 14);
		loanReportPanel.add(lbl_installmentsNumber);
		lbl_installmentsNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_installmentsNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbl15 = new JLabel("Total interest");
		lbl15.setBounds(44, 163, 120, 14);
		loanReportPanel.add(lbl15);
		lbl15.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		
		JLabel lbl16 = new JLabel("Total principal");
		lbl16.setBounds(44, 183, 120, 14);
		loanReportPanel.add(lbl16);
		lbl16.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		
		JLabel lbl17 = new JLabel("Total repayment amount");
		lbl17.setBounds(44, 203, 120, 14);
		loanReportPanel.add(lbl17);
		lbl17.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 11));
		
		JLabel lbl18 = new JLabel("% interest over capital");
		lbl18.setBounds(44, 223, 120, 14);
		loanReportPanel.add(lbl18);
		lbl18.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_totalInterest = new JLabel("-");
		lbl_totalInterest.setBounds(306, 163, 120, 14);
		loanReportPanel.add(lbl_totalInterest);
		lbl_totalInterest.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_totalInterest.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_totalPrincipal = new JLabel("-");
		lbl_totalPrincipal.setBounds(306, 183, 120, 14);
		loanReportPanel.add(lbl_totalPrincipal);
		lbl_totalPrincipal.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_totalPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		lbl_totalRepayment = new JLabel("-");
		lbl_totalRepayment.setBounds(306, 203, 120, 14);
		loanReportPanel.add(lbl_totalRepayment);
		lbl_totalRepayment.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_totalRepayment.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lbl_interestOverCapital = new JLabel("-");
		lbl_interestOverCapital.setBounds(306, 223, 120, 14);
		loanReportPanel.add(lbl_interestOverCapital);
		lbl_interestOverCapital.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_interestOverCapital.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(345, 98, 88, 1);
		loanReportPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(345, 218, 88, 1);
		loanReportPanel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(345, 220, 88, 1);
		loanReportPanel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(345, 200, 88, 1);
		loanReportPanel.add(separator_4);
		
		
	}
		// Put action on button "Monthly Payment"
		public static void calculateResult(){
			String result;
			double loanAmount,annualInterest,monthlyPayment,loanPeriod,installmentsNumber;
			double totalInterest,totalPrincipal,totalRepayment,interestOverCapital;
			
			try {		
				// loan Report (1st group)
				loanAmount = Double.parseDouble(txt1.getText().trim());
				result = String.valueOf(new DecimalFormat("#,###").format(loanAmount));	
				lbl_loanAmount.setText("Php "+result);
				lbl_annualInterest.setText(txt2.getText().trim()+"%");
				lbl_loanPeriod.setText(txt3.getText().trim()+" years");
				
				// calculate number of installments
				loanPeriod = Double.parseDouble(txt3.getText().trim());
				installmentsNumber = loanPeriod * 12;
				result = String.valueOf(new DecimalFormat("#,###").format(installmentsNumber));	
				lbl_installmentsNumber.setText(result);
				
				// calculate monthly payment
				annualInterest = Double.parseDouble(txt2.getText().trim());
				double monthlyInterest = annualInterest/12; 
				monthlyPayment = ((loanAmount/installmentsNumber)*monthlyInterest) + (loanAmount/installmentsNumber);
				result = String.valueOf(new DecimalFormat("#,###.00").format(monthlyPayment));			
				lbl_mPayment.setText("***     Php "+result);
				
				// loan Report (2nd group)
				totalPrincipal = Double.parseDouble(txt1.getText().trim());
				result = String.valueOf(new DecimalFormat("#,###.00").format(totalPrincipal));	
				lbl_totalPrincipal.setText(result);
				
				// calculate total interest
				totalInterest = ((loanAmount/installmentsNumber)*monthlyInterest) * (installmentsNumber);
				result = String.valueOf(new DecimalFormat("#,###.00").format(totalInterest));	
				lbl_totalInterest.setText(result);
				
				// calculate total repayments amount
				totalRepayment = (totalPrincipal) + (totalInterest);
				result = String.valueOf(new DecimalFormat("#,###.00").format(totalRepayment));	
				lbl_totalRepayment.setText(result);
				
				// calculate % interest over capital
				interestOverCapital = (totalInterest) / (totalPrincipal / 100);
				result = String.valueOf(new DecimalFormat("#,###.00").format(interestOverCapital));	
				lbl_interestOverCapital.setText(result+"%");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, e+": Re-entered needed info.", "Message", JOptionPane.ERROR_MESSAGE);
				clearLoanCalculator();
			}
		}
		
		// Put action on button "Clear"
		public static void clearLoanCalculator(){
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			
			lbl_loanAmount.setText("-");
			lbl_annualInterest.setText("-");
			lbl_mPayment.setText("-");
			lbl_loanPeriod.setText("-");
			lbl_installmentsNumber.setText("-");
			
			lbl_totalInterest.setText("-");
			lbl_totalPrincipal.setText("-");
			lbl_totalRepayment.setText("-");
			lbl_interestOverCapital.setText("-");
			
			txt2.enable(false);
			txt3.enable(false);
			btn1.setEnabled(false);
			txt1.requestFocus();
		}
}
