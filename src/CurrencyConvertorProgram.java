import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConvertorProgram extends JFrame implements ActionListener {
    // components
    private final JButton convertButton= new JButton("convert");
    private final JTextField inputTextField = new JTextField();
    private final JTextField resultTextField = new JTextField();
    private final JComboBox<CurrencyConvertorClass>  comboBox = new JComboBox<>(new CurrencyConvertorClass[] {
            new CurrencyConvertorClass("dinarTunisien->euro", 0.3),
            new CurrencyConvertorClass("euro->dinarTunisien", 3),
            new CurrencyConvertorClass("dinarTunisien->dinarKoweitien", 0.098),
            new CurrencyConvertorClass("dinarKoweitien->dinarTunisien", 10.21),
            new CurrencyConvertorClass("dinarTunisien->dollarAméricain", 0.32),
            new CurrencyConvertorClass("dollarAméricain->dinarTunisien", 3.13)
    });

    public CurrencyConvertorProgram() {
        // title
        super("Currency Convertor V1.0");

        // local variables
        JLabel inputLabel = new JLabel("enter the money:");
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        JLabel resultLabel = new JLabel("result:");

        // init
        convertButton.setFocusable(false);
        resultTextField.setEditable(false);

        // adding components to the panel
        panel.add(inputLabel);
        panel.add(inputTextField);
        panel.add(resultLabel);
        panel.add(resultTextField);
        panel.add(comboBox);
        panel.add(convertButton);

        // adding ActionListeners to the components
        convertButton.addActionListener(this);

        // adding components to the frame
        this.add(panel);

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

            CurrencyConvertorClass selectedItem = (CurrencyConvertorClass) comboBox.getSelectedItem();

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
