	import java.math.BigDecimal;
	import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
	import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.Slider;
	import javafx.scene.control.TextField;

public class mortgageCalculatorController {

	   private static DecimalFormat df = new DecimalFormat("$0.00");
	   private double interestPercentage = (1.5); //1.5% default
	   private double loanDuration = (10); //10 years
	   private String s;
	   private String t;
	   private String u;
	   private double p;
	   private double r;
	   private double n;
	   private double a;
	   private double b;
	   private double c;
	   private double d;
	   private double e;
	   private double f;
	   private String g;
	   
	   // GUI controls defined in FXML and used by the controller's code
	   @FXML
	    private TextField downPaymentTextField;

	    @FXML
	    private TextField monthlyPaymentTextField;

	    @FXML
	    private Button calculateButton;

	    @FXML
	    private TextField purchasePriceTextField;

	    @FXML
	    private Label loadDurationLabel;

	    @FXML
	    private Slider loanDurationSlider;

	    @FXML
	    private Slider interestRateSlider;

	    @FXML
	    private Label interestRateLabel;
	    

	    @FXML
	    void calculateButtonPressed(ActionEvent event) {
	 	   
	    	

	    	try {
	    		String purchaseAmount = purchasePriceTextField.getText();
	    		String dPayment = downPaymentTextField.getText();
	    		
	    		
	    		double pNum = Double.parseDouble(purchaseAmount);
	    		double dNum = Double.parseDouble(dPayment);
	    		double iNum = Double.parseDouble(s);
	    		double lNum = Double.parseDouble(t);
	    		
	    		p = pNum - dNum; //purchase - downpayment
	    		r = ((iNum/100)/12); //monthly interest rate
	    		n = lNum * 12; //number of months for loan
	    		
	    		a = Math.pow((1+r), n); //(1+r)^n
	    		b = a -1; //(1+r)^n -1
	    		c = a * r; //r(1+r)^n
	    		d = c/b; 
	    		e = p * d;
	    		
	    	    f = Math.round(e);
	    
	    	 
	    	    u = Double.toString(f);
	    	    g = df.format(e);
	    		monthlyPaymentTextField.setText(g);
	    	
	    		
	    	}
	    	catch(NumberFormatException ex) {
	    		purchasePriceTextField.setText("Enter Amount");
	    		purchasePriceTextField.selectAll();
	    		purchasePriceTextField.requestFocus();
	    		downPaymentTextField.setText("Enter Amount");
	    		downPaymentTextField.selectAll();
	    		downPaymentTextField.requestFocus();
	    	}
	    }
	    

		public void initialize() {
	          // listener for changes to interestRateSlider value
	        interestRateSlider.valueProperty().addListener(
	           new ChangeListener<Number>() {
	              @Override
	              public void changed(ObservableValue<? extends Number> ov, 
	                 Number oldValue, Number newValue) {
	            	  interestPercentage = newValue.intValue();
	            	   s = Double.toString(interestPercentage);
	            	  interestRateLabel.setText(s);
	              }
	           }
	        );
	        // listener for changes to interestRateSlider value
	        loanDurationSlider.valueProperty().addListener(
	           new ChangeListener<Number>() {
	              @Override
	              public void changed(ObservableValue<? extends Number> ov, 
	                 Number oldValue, Number newValue) {
	            	  loanDuration = newValue.intValue();
	            	   t = Double.toString(loanDuration);
	            	  loadDurationLabel.setText(t);
	            	 
	              }
	           }
	        );

	        
	     } 
	    
	    
	   
	}


