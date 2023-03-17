import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterProgram extends JFrame implements ActionListener {
    // components
    private final JButton convertButton= new JButton("convert");
    private final JTextField inputTextField = new JTextField();
    private final JTextField resultTextField = new JTextField();
    private final JComboBox<CurrencyConverterClass>  comboBox = new JComboBox<>(new CurrencyConverterClass[] {
            new CurrencyConverterClass("dinarTunisien->euro", 0.3),
            new CurrencyConverterClass("euro->dinarTunisien", 3),
            new CurrencyConverterClass("dinarTunisien->dinarKoweitien", 0.098),
            new CurrencyConverterClass("dinarKoweitien->dinarTunisien", 10.21),
            new CurrencyConverterClass("dinarTunisien->dollarAméricain", 0.32),
            new CurrencyConverterClass("dollarAméricain->dinarTunisien", 3.13)
    });

    public CurrencyConverterProgram() {
        // title
        super("Currency Convertor V1.0");
        this.setLayout(new GridLayout(3, 2, 5, 5));

        // local variables
        JLabel inputLabel = new JLabel("enter the money:");
        JLabel resultLabel = new JLabel("result:");

        // init
        convertButton.setFocusable(false);
        resultTextField.setEditable(false);

        // adding ActionListeners to the components
        convertButton.addActionListener(this);

        // adding components to the frame
        this.add(inputLabel);
        this.add(inputTextField);
        this.add(resultLabel);
        this.add(resultTextField);
        this.add(comboBox);
        this.add(convertButton);

        // setup
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 150);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            resultTextField.setText("");

            CurrencyConverterClass selectedItem = (CurrencyConverterClass) comboBox.getSelectedItem();

            if (selectedItem != null) {
                String[] units = selectedItem.getFromTo().split("->");
                String c2 = units[1];

                try {
                    double input = Double.parseDouble(inputTextField.getText());

                    input = selectedItem.convertFromTo(input);

                    resultTextField.setText(String.format("%.3f %s", input, c2));
                    inputTextField.setText("");
                } catch (NumberFormatException ne) {
                    JOptionPane.showMessageDialog(this,
                            "error\n" + ne.getMessage(),
                            "error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
