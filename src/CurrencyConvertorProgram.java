import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConvertorProgram extends JFrame implements ActionListener {
    // components
    // JButtons
    private final JButton convertButton= new JButton("convert");
    private final JLabel inputLabel = new JLabel("enter the money");
    private final JLabel resultLabel = new JLabel("enter the money");
    private final JTextField inputTextField = new JTextField();
    private final JTextField resultTextField = new JTextField();

    public CurrencyConvertorProgram() {
        // title
        super("Currency Convertor V1.0");

        // init
        convertButton.setEnabled(false);
        resultTextField.setEditable(false);

        // adding components to the frame

        // setup
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 400);
//        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {

        }
    }
}
